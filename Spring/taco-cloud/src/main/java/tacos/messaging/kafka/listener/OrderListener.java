package tacos.messaging.kafka.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import tacos.Order;

/*
@Component
public class OrderListener {

	private KitchenUI ui;
	
	@Autowired
	public OrderListener(KitchenUI ui) {
		this.ui = ui;
	}
	
	@KafkaListener(topics = "tacocloud.orders.topic")
	public void handle(Order order) {
		ui.displayOrder(order);
	}
}
*/