package sia5;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.MessageChannel;

@Configuration
public class FileWriterInegrationConfig {

	/*
	 * Usando la configurazione Java
	 * 
	 * @Bean
	 * 
	 * @Transformer(inputChannel = "textInChannel", outputChannel =
	 * "fileWriterChannel") public GenericTransformer<String, String>
	 * upperCaseTransformer() { return text -> text.toUpperCase(); }
	 * 
	 * @Bean
	 * 
	 * @ServiceActivator(inputChannel = "fileWriterChannel") public
	 * FileWritingMessageHandler fileWriter() { FileWritingMessageHandler handler =
	 * new FileWritingMessageHandler(new File("/tmp/sia5/files"));
	 * handler.setExpectReply(false);
	 * handler.setFileExistsMode(FileExistsMode.APPEND);
	 * handler.setAppendNewLine(true); return handler; }
	 */

	/*
	 * Nel caso si voglia più controllo sui bean questi possono essere dichiarati
	 * esplicitamente così
	 * 
	 * 
	 * @Bean public MessageChannel textInChannel() { return new DirectChannel(); }
	 * 
	 * @Bean public MessageChannel fileWriterChannel() { return new DirectChannel();
	 * }
	 */

	/*
	 * Usando lo Spring Integration DSL
	 */
	@Bean
	public IntegrationFlow fileWriterFlow() {
		return IntegrationFlows.from(MessageChannels.direct("textInChannel"))
				.<String, String>transform(t -> t.toUpperCase())
				.handle(Files.outboundAdapter(new File("/tmp/sia5/files")).fileExistsMode(FileExistsMode.APPEND)
						.appendNewLine(true))
				.get();
	}

	/*
	 * Dichiarazione di un filtro
	 */
	@Filter(inputChannel = "numberChannel", outputChannel = "evenNumberChannel")
	public boolean evenNumberFilter(Integer number) {
		return number % 2 == 0;
	}

}
