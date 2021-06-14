package tacos.email;

import org.springframework.amqp.core.Message;
import org.springframework.integration.support.AbstractIntegrationMessageBuilder;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

/*
@Component
public class EmailToOrderTransformer extends AbstractMailMessageTransformer<Order> {

	protected AbstractIntegrationMessageBuilder<Order> doTransform(Message mailMessage) throws Exception {
		Order tacoOrder = processPayload(mailMessage);
		return MessageBuilder.withPayload(tacoOrder);
	}
}
*/