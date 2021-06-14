package tacos;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.jgroups.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Flux;
import tacos.data.TacoRepository;
import tacos.web.DesignTacoController;
/*
public class DesignTacoControllerTest {

	@Test
	public void shouldReturnRecentTacos() {
		Taco[] tacos = {
				testTaco(1L), testTaco(2L),
				testTaco(3L), testTaco(4L),
				testTaco(5L), testTaco(6L),
				testTaco(7L), testTaco(8L),
				testTaco(9L), testTaco(10L),
				testTaco(11L), testTaco(12L),
				testTaco(13L), testTaco(14L),
				testTaco(15L), testTaco(16L)
		};
		Flux<Taco> tacoFlux = Flux.just(tacos);
		
		TacoRepository tacoRepository = Mockito.mock(TacoRepository.class);
		when(tacoRepository.findAll().thenReturn(tacoFlux));
		
		WebTestClient testClient = WebTestClient.bindToController(new DesignTacoController(tacoRepository)).build();
		
		testClient.get().uri("/design/recent").exchange().expectStatus().isOk().expectBody().jsonPath("$").isArray()
		.jsonPath("$").isNotEmpty().jsonPath("$[0].id").isEqualTo(tacos[0].getId().toString())
		.jsonPath("$[0].name").isEqualTo("Taco 1").jsonPath("$[1].id").isEqualTo(tacos[1].getId().toString())
		.jsonPath("$[1].name").isEqualTo("Taco 2").jsonPath("%[11].id").isEqualTo(tacos[11].getId().toString()).doesNotExist();
	}
	
	private Taco testTaco(Long number) {
		Taco taco = new Taco();
		taco.setId(UUID.randomUUID());
		taco.setName("Taco "+number);
		List<IngredientUDT> ingredients = new ArrayList<>();
		ingredients.add(
				new IngredientUDT("INGA", "Ingredient A", Ingredient.Type.WRAP)
				);
		ingredients.add(
				new IngredientUDT("INGB", "Ingredient B", Ingredient.Type.PROTEIN)
				);
		taco.setIngredients(ingredients);
		return taco;
	}
}
*/