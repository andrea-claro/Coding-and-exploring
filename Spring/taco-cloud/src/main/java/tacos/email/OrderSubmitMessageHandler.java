package tacos.email;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/*
@Component
public class OrderSubmitMessageHandler implements GenericHandler<Order> {

	private RestTemplate rest;
	private ApiProperties apiProps;

	@Autowired
	public OrderSubmitMessageHandler(ApiProperties apiProps, RestTemplate rest) {
		this.apiProps = apiProps;
		this.rest = rest;
	}

	@Override
	public Object handle(Order order, Map<String, Object> headers) {
		rest.postForObject(apriProps.getUrl(), order, String.class);
		return null;
	}

}
*/