package tacos.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.PersistentEntityResourceProcessor;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import tacos.Taco;
import tacos.data.TacoRepository;

@RepositoryRestController
public class RecentTacosController {

	private TacoRepository tacoRepo;
	
	@Autowired
	public RecentTacosController(TacoRepository tacoRepo) {
		this.tacoRepo = tacoRepo;
	}
	/*
	@GetMapping(path = "/tacos/recent", produces = "application/hal+json")
	public ResponseEntity<Resources<TacoResource>> recentTacos(){
		PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
		
		List<Taco> tacos = tacoRepo.findAll(page).getContent();
		List<TacoResource> tacoResources = new TacoResourceAssembler().toResources(tacos);
		
		Resources<TacoResource> recentResources = new Resources<TacoResource>(tacoRessources);
		recentResources.add(linkTo.(methodOn(RecentTacosController.class).recentTacos()).withRel("recents"));
		
		return new ResponseEntity<>(recentResources, HttpStatus.OK);
	}
	
	
	@Bean
	public ResourceProcessor<PagedResources<Resource<Taco>>> tacoProcessor(EntityLinks links){
		return new ResourceProcessor<PagedResources<Resource<Taco>>>() {
			@Override
			public PagedResources<Resource<Taco>> process(PagedResources<Resource<Taco>> resource){
				resource.add(links.linkFor(Taco.class).slash("recent").withRel("recents"));
				return resource;
			}
		}
	}
	*/
}
