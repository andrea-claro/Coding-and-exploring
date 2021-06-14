package tacos.data;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;

import tacos.Order;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {//extends CrudRepository<Order, Long>{
	
	/*
	 * Commento dopo l'estensione della CrudRepository e quindi inutile
	 * 
	Order save(Order order);
	*/
	
	//List<Order> findByDeliveryZip(String deliveryZip);

	//List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
	
	/*
	List<Order> readOrdersByDeliveryZipAndPlaceBetween(String deliveryZip, Date startDate, Date endDate);
	
	List<Order> findByDeliveryToAndDeliveryCityAllIgnoresCase(String deliveryTo, String deliveryCity);
	
	List<Order> findByDeliveryCityOrderByDeliveryTo(String city);
	
	@Query("Order o where o.deliveryCity='Seattle'")
	List<Order> readOrdersDeliveredInSeattle();
	*/
}
