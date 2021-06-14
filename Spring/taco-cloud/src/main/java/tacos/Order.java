package tacos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
//@Entity
//@Table("tacoorders")
@Document
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * public Order() { this.tacos = new ArrayList<Taco>(); }
	 */

	// @ManyToOne
	// private User user;

	//@Column("user")
	@Field("customer")
	private UserUDT user;

	@NotBlank(message = "Name is required")
	private String deliveryName;

	@NotBlank(message = "Street is required")
	private String deliveryStreet;

	@NotBlank(message = "City is required")
	private String deliveryCity;

	@NotBlank(message = "State is required")
	private String deliveryState;

	@NotBlank(message = "Zip is required")
	private String deliveryZip;

	// @CreditCardNumber(message="Not a valid credit card number")
	private String ccNumber;

	@Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
	private String ccExpiration;

	@Digits(integer = 3, fraction = 0, message = "Invalid CVV")
	private String ccCVV;

	@Id // @GeneratedValue(strategy = GenerationType.AUTO)
	// private Long id;
	//@PrimaryKey
	//private UUID id = Uuids.timeBased();
	private String id;

	private Date placedAt = new Date();

	// @ManyToMany(targetEntity = Taco.class)
	// private List<Taco> tacos;

	//@Column("tacos")
	private List<TacoUDT> tacos = new ArrayList<>();

	public void addTaco(TacoUDT taco) {
		this.tacos.add(taco);
	}

	/*
	 * @PrePersist void placedAt() { this.placedAt = new Date(); }
	 */
}
