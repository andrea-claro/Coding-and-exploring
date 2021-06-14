package tacos;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Destination;
import javax.print.attribute.HashAttributeSet;

import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ImportResource("classpath:/filewriter-config.xml")
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public Traverson traverson() {
		return new Traverson(URI.create("http://localhost:9090/api"), MediaTypes.HAL_JSON);
	}

	@Bean
	public Destination orderQueue() {
		return new ActiveMQQueue("tacocloud.order.queue");
	}
	/*
	 * @Bean public MappingJackson2CborHttpMessageConverter messageConverter() {
	 * MappingJackson2CborHttpMessageConverter messageConverter = new
	 * MappingJackson2CborHttpMessageConverter();
	 * messageConverter.setTypeIdPropertyName("_typeId");
	 * 
	 * Map<String, Class<?>> typeIdMappings = new HashMap<String, Class<?>>();
	 * typeIdMappings.put("order", Order.class);
	 * messageConverter.setTypeIdMappings(typeIdMappings);
	 * 
	 * return messageConverter; }
	 */
}
