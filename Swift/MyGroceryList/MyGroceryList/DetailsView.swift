//
//  DetailsView.swift
//  MyGroceryList
//
//  Created by Andrea Claro on 05/02/2020.
//  Copyright © 2020 Andrea Claro. All rights reserved.
//

import UIKit

class DetailsView: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func viewWillAppear(_ animated: Bool) {
        insertedDescription.text = currentItem!.des!
        insertedDate.text = currentItem!.data!.description
        insertedQuantity.text = String(currentItem!.quantity!)
        insertedName.text = currentItem!.name!
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        
        currentItem!.name = insertedName.text!
        currentItem!.des = insertedDescription.text
        currentItem!.quantity = Int(insertedQuantity.text!)
    }
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    @IBOutlet weak var insertedName: UITextField!
    @IBOutlet weak var insertedDescription: UITextField!
    @IBOutlet weak var insertedQuantity: UITextField!
    @IBOutlet weak var insertedDate: UILabel!
    
    var currentItem: Item?
}
