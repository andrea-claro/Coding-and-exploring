package tacos.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

import tacos.EmailProperties;

/*
@Configuration
public class TacosOrderEmailIntegrationConfig {

	@Bean
	public IntegrationFlow tacoOrderEmailFlow(EmailProperties emailProps,
			EmailToOrderTransformer emailToOrderTransformer, OrderSubmitMessageHandler orderSubmitMessageHandler) {

		return IntegrationFlows
				.from(Mail.imampInboundAdapter(emailProps.getImapUrl()),
						e -> e.poller(Pollers.fixedDelay(emailProps.getPollRate())))
				.transform(emailToOrderTransformer).handle(orderSubmitMessageHandler).get();
	}
}
*/