package tacos.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import tacos.Order;

/*
@Service
public class KafkaOrderMessagingService implements OrderMessagingService{

	private KafkaTemplate<String, Order> kafkaTemplate;
	
	@Autowired
	public KafkaOrderMessagingService(KafkaTemplate<String, Order> template) {
		this.kafkaTemplate = template;
	}
	
	public void sendOrder(Order order) {
		kafkaTemplate.sendDefault(order);
	}
}
*/