package tacos.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.EnableWebFlux;

import reactor.core.publisher.Mono;
import tacos.User;
import tacos.data.UserRepository;

@Configuration
@EnableWebSecurity
@EnableWebFluxSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * private static final String DEF_USERS_BY_USERNAME_QUERY =
	 * "select username, password, enabled from Users where username=?"; private
	 * static final String DEF_AUTHORITIES_BY_USERNAME_QUERY =
	 * "select username, authority from User_Authorities where username=?"; private
	 * static final String DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY =
	 * "select g.id, g.group_name, ga.authority from groups g, group_members gm, group_authorities ga where gm.username=? and g.id=ga.group_id and g.id=gm.group_id"
	 * ;
	 * 
	 * @Autowired DataSource dataSource;
	 * 
	 */

	private UserDetailsService userDetailService;

	@Autowired
	public SecurityConfig(UserDetailsService userDetailService) {
		this.userDetailService = userDetailService;
	}

	@Bean
	public PasswordEncoder encoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * Questo metodo serve alla creazione di utenti in memory
		 * 
		 * auth.inMemoryAuthentication().withUser("pippo").password("{noop}password").
		 * authorities(USER).and()
		 * .withUser("pippotto").password("{noop}password").authorities(USER);
		 */

		/*
		 * Questo metodo serve all'utilizzo di utenti su database
		 * 
		 * auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
		 * DEF_USERS_BY_USERNAME_QUERY)
		 * .authoritiesByUsernameQuery(DEF_AUTHORITIES_BY_USERNAME_QUERY)
		 * .passwordEncoder(new BCryptPasswordEncoder());
		 */

		/*
		 * Metodo usato per utenti su ldap
		 * 
		 * auth.ldapAuthentication().userSearchBase("ou=people").userSearchFilter(
		 * "(uid={0})").groupSearchBase("ou=groups")
		 * .groupSearchFilter("member={0}").passwordCompare().passwordEncoder(new
		 * BCryptPasswordEncoder()) .passwordAttribute("passCode"); //
		 * .contextSource().root("dc=tacocloud, //
		 * dc=com").ldif("classpath:users.ldif");
		 */

		auth.userDetailsService(userDetailService).passwordEncoder(encoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/design", "/orders").hasRole(User.USER).antMatchers("/", "/**")
				.permitAll().and().formLogin().loginPage("/login").defaultSuccessUrl("/design", true)
				.loginProcessingUrl("/logon").usernameParameter("user").passwordParameter("pwd").and().logout()
				.logoutSuccessUrl("/");
	}
	/*
	 * Copia del metodo configure(HttpSecurity http) utilizzando le Spring Security
	 * Extensions sulle Spring Expression Language
	 * http.authorizeRequests().antMatchers("/design",
	 * "/orders").access("hasRole('User.USER')").antMatchers("/",
	 * "/**").access("permitAll");
	 */

	@Bean
	public SecurityWebFilterChain securityWebFilterChanin(ServerHttpSecurity http) {
		return http.authorizeExchange().pathMatchers("/design", "/orders").hasAuthority("USER").anyExchange()
				.permitAll().and().build();
	}
/*
	@Bean
	public ReactiveUserDetailsService userDetailsService(UserRepository userRepo) {
		return new ReactiveUserDetailsService() {
			@Override
			public Mono<UserDetails> findByUsername(String username) {
				return userRepo.findByUsername(username).map(user -> {
					return user.toUserDetails();
				});
			}
		};
	}
*/
}
