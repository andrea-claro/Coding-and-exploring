package tacos.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import tacos.User;

@Data
@Slf4j
public class RegistrationForm {

	private String username;
	private String password;
	private String fullname;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String phone;

	public User toUser(PasswordEncoder encoder) {
		log.info("Password registrata: "+this.password+" per utente: "+this.username);
		User user = new User(this.username, encoder.encode(this.password), this.fullname, this.street, this.city,
				this.state, this.zip, this.phone);
		return user;
	}
}
