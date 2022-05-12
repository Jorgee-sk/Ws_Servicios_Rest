package controller;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dtos.CredentialsDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@CrossOrigin("*")
@RestController
public class AuthController {
	@Value("${clave}")
	private String CLAVE;
	
	private static long TIEMPO_VIDA=87_000_000; //un dia y algo
	AuthenticationManager authManager;
	public AuthController(@Autowired AuthenticationManager authManager) {
		this.authManager=authManager;
	}
	
	@PostMapping(value="login",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.TEXT_PLAIN_VALUE)
	public String login(@RequestBody CredentialsDto credentials) {
		Authentication autentication=authManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUser(),credentials.getPwd()));
		//si el usuario está autenticado, se genera el token
		if(autentication.isAuthenticated()) {
			return getToken(autentication);
		}else {
			return "no autenticado";
		}
	}
	
	private String getToken(Authentication autentication) {
		//en el body del token se incluye el usuario 
		//y los roles a los que pertenece, además
		//de la fecha de caducidad y los datos de la firma
		String token = Jwts.builder()
				.setIssuedAt(new Date()) //fecha creación
				.setSubject(autentication.getName()) //usuario
				.claim("authorities",autentication.getAuthorities().stream() //roles
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setExpiration(new Date(System.currentTimeMillis() + TIEMPO_VIDA)) //fecha caducidad
				.signWith(SignatureAlgorithm.HS512, CLAVE)//clave y algoritmo para firma
				.compact(); //generación del token
		return token;
	}
	
	
}
