using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Unity.MLAgents;
using Unity.MLAgents.Sensors;

public class PlayerAgent : Agent
{
    
    [SerializeField] private float speed = 10;
    [SerializeField] private float distanceRequired = 1.5f;

    [SerializeField] private GameObject target;
    
    [SerializeField]private Material successMaterial;
    [SerializeField]private Material failureMaterial;
    [SerializeField]private Material defaultMaterial;
    
    [SerializeField]private MeshRenderer groundMeshRenderer;
    
    private Rigidbody playerRigidbody;
    
    private Vector3 originalPosition;
    private Vector3 originalTargetPosition;

    
    
    public override void Initialize()
    {
        playerRigidbody = GetComponent<Rigidbody>();
        
        originalPosition = transform.localPosition;
        originalTargetPosition = target.transform.localPosition;
    }

    public override void OnEpisodeBegin()
    {
        transform.LookAt(target.transform);
        target.transform.localPosition = originalTargetPosition;
        transform.localPosition = originalTargetPosition;
        transform.localPosition = new Vector3(Random.Range(-4, 4), originalTargetPosition.y, Random.Range(-4, 4));
        
    }
    
    public override void CollectObservations(VectorSensor sensor)
    {
        //3 observation - x, y, z
        sensor.AddObservation(transform.localPosition);
        //3 observation - x, y, z
        sensor.AddObservation(target.transform.localPosition);

        //1 observation - x
        sensor.AddObservation(playerRigidbody.velocity.x);
        //1 observation - x
        sensor.AddObservation(playerRigidbody.velocity.z);

    }

    public override void OnActionReceived(float[] vectorAction)
    {
        var vectorForce = new Vector3();
        
        vectorForce.x = vectorAction[0];
        vectorForce.z = vectorAction[1];
        
        
        playerRigidbody.AddForce(vectorForce * speed);

        var distanceFromTarget = Vector3.Distance(transform.localPosition, target.transform.localPosition);
        
        //rewarding
        if (distanceFromTarget <= distanceRequired)
        {
            SetReward(1.0f);
            EndEpisode();
            
            StartCoroutine(SwapGroundMaterial(successMaterial, 0.5f));
        }
        //not rewarding
        if (transform.localPosition.y < 0)
        {
            EndEpisode();

            StartCoroutine(SwapGroundMaterial(failureMaterial, 0.5f));
        }
    }

    public override void Heuristic(float[] actionsOut)
    {
        actionsOut[0] = Input.GetAxis("Horizontal");  //x
        actionsOut[1] = Input.GetAxis("Vertical");  //z
    }

    private IEnumerator SwapGroundMaterial(Material mat, float time)
    {
        groundMeshRenderer.material = mat;
        yield return new WaitForSeconds(time);
        groundMeshRenderer.material = defaultMaterial;
    }
}
