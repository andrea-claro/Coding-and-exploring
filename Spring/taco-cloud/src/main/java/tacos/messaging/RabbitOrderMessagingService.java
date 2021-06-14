package tacos.messaging;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.MessageProperties;

import tacos.Order;

/*
@Service
public class RabbitOrderMessagingService implements OrderMessagingService {

	private RabbitTemplate rabbit;
	
	@Autowired
	public RabbitOrderMessagingService(RabbitTemplate rabbit) {
		this.rabbit = rabbit;
	}
	
	public void sendOrder(Order order) {
		MessageConverter converter = rabbit.getMessageConverter();
		MessageProperties properties = new MessageProperties();
		Message message = converter.toMessage(order, properties);
		
		rabbit.send("tacocloud.order", message);
	}
}
*/