package init;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth
        .inMemoryAuthentication()
        .withUser("user1")
          .password("{noop}user1") //lo de {noop} se pone para no obligar a usar mecanismo de encriptación
          .roles("USER")
          .and()
        .withUser("admin")
          .password("{noop}admin")
          .roles("USER", "ADMIN")
          .and()
        .withUser("user2")
          .password("{noop}user2")
          .roles("OPERATOR");
		
		lo siguiente sería para el caso de que
		 * quisiéramos encriptar la password:
		String pw1=new BCryptPasswordEncoder().encode("user1");
		System.out.println(pw1);
		  auth
	        .inMemoryAuthentication()
	        .withUser("user1")
	          .password("{bcrypt}"+pw1)
	          //.password(pw1)
	          .roles("USER")
	          .and()
	        .withUser("admin")
	          .password("{bcrypt}"+new BCryptPasswordEncoder().encode("admin"))
	          .roles("USER", "ADMIN");
		 */
		/*la siguiente configuración será para el caso de 
		 * usuarios en una base de datos
		 */
		auth.jdbcAuthentication()
		  .passwordEncoder(new BCryptPasswordEncoder())
		  .dataSource(dataSource())
      	.usersByUsernameQuery("select user, pwd, enabled"
          	+ " from users where user=?")
      	.authoritiesByUsernameQuery("select user, rol "
          	+ "from roles where user=?");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		//solo los miembros del rol admin podrán realizar altas
		//y para acceder la lista de cursos, tendrán que estar autenticados
		.antMatchers(HttpMethod.GET,"/Reservas").hasRole("ADMIN")	
		.and()
		.httpBasic();
	}
	
	private DataSource dataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springsecurity?serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("");
		return ds;
	}


}

