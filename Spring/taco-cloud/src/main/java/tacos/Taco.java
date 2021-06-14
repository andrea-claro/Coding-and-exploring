package tacos;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.RestResource;

import lombok.Data;

@Data
//@Entity
@RestResource(rel = "tacos", path="tacos")
//@Table("tacos")
@Document
public class Taco {
	
	@Id //@GeneratedValue(strategy = GenerationType.AUTO)
	//@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private String id;
	
	@NotNull @Size(min = 5, message = "Name must be at least 5 charachters long")
	private String name;
	
	//@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
	private Date createdAt;
	
	//@ManyToMany(targetEntity = Ingredient.class)
	//@Column("ingredients")
	@Size(min = 1, message = "You must chose at least 1 ingredient")
	private List<Ingredient> ingredients;
	
	/*
	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
	*/
}
