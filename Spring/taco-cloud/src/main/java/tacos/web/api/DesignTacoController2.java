package tacos.web.api;

import java.util.Observable;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tacos.Taco;
import tacos.data.OrderRepository;
import tacos.data.TacoRepository;
import tacos.Order;

@Controller
@RequestMapping(path = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
@RestResource(rel = "tacos", path = "tacos")
public class DesignTacoController2 {

	private TacoRepository tacoRepo;
	private OrderRepository orderRepo;

	@Autowired
	public DesignTacoController2(TacoRepository tacoRepo, OrderRepository orderRepo) {
		this.tacoRepo = tacoRepo;
		this.orderRepo = orderRepo;
	}
/*
	@GetMapping("/recent")
	public Resources<TacoResource> recentTaco() {
		PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());

		List<Taco> tacos = (List<Taco>) tacoRepo.findAll();// page);
		List<TacoResource> tacoResources = new TacoResourceAssembler().toResource(tacos);
		Resources<TacoResource> recentResources = new Resources<TacoResource>(tacoResources);
		recentResources.add(linkTo(methodOn(DesignTacoController2.class)).recentTacos()).withRel("recents");// new
																											// Link("http://localhost:9090/design/recent",
																											// "recents"));

		return resentResources;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Taco> tacoById(@PathVariable("id") Long id) {
		Optional<Taco> optTaco = tacoRepo.findById(id);
		if (optTaco.isPresent())
			return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Taco postTaco(@RequestBody Taco taco) {
		return tacoRepo.save(taco);
	}
*/
	
	@PutMapping("/{orderId}")
	public Order putOrder(@RequestBody Order order) {
		return orderRepo.save(order);
	}

	@PatchMapping(path = "/{orderId}", consumes = "application/json")
	public Order patchOrder(@PathVariable("orderId") Long orderId, @RequestBody Order patch) {
		Order order = orderRepo.findById(orderId).get();

		if (patch.getDeliveryName() != null)
			order.setDeliveryName(patch.getDeliveryName());

		if (patch.getDeliveryCity() != null)
			order.setDeliveryCity(patch.getDeliveryCity());

		if (patch.getDeliveryState() != null)
			order.setDeliveryState(patch.getDeliveryState());

		if (patch.getDeliveryStreet() != null)
			order.setDeliveryStreet(patch.getDeliveryStreet());

		if (patch.getDeliveryZip() != null)
			order.setDeliveryZip(patch.getDeliveryZip());

		if (patch.getCcCVV() != null)
			order.setCcCVV(patch.getCcCVV());

		if (patch.getCcExpiration() != null)
			order.setCcExpiration(patch.getCcExpiration());

		if (patch.getCcNumber() != null)
			order.setCcNumber(patch.getCcNumber());

		return orderRepo.save(order);
	}

	@DeleteMapping("/{orderId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteOrder(@PathVariable("orderId") Long orderId) {
		try {
			orderRepo.deleteById(orderId);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 
	 
	@GetMapping("/recent")
	public Iterable<Taco> recentTacos(){
		PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
		return tacoRepo.findAll(page).getContent();
	}
	*/
	
	/*
	 * Nel caso nel repository non si ritorni direttamente un Flux
	 * 
	@GetMapping("/recent")
	public Flux<Taco> recentTacos(){
		return Flux.fromIterable(tacoRepo.findAll()).take(12);
	}
	*/
	
	@GetMapping("/recent")
	public Flux<Taco> recentTacos(){
		return tacoRepo.findAll().take(12);
	}
	
	@GetMapping("/{id}")
	public Mono<Taco> tacoById(@PathVariable("id") UUID id){
		return tacoRepo.findById(id);
	}
	
	/*
	 * Nel caso c'è un dealing con RxJava
	 * 
	@GetMapping("/recent")
	public Observable<Taco> recentTacos(){
		return tacoService.getRecentTacos();
	}
	
	@GetMapping("/{id}")
	public Single<Taco> tacoById(@PathVariable("id") Long id) {
	return tacoService.lookupTaco(id);
	}
	*/
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Taco> postTaco(@RequestBody Mono<Taco> tacoMono) {
		return tacoRepo.saveAll(tacoMono).next();
	}
}
