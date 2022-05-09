package init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"service","controller"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		BasicAuthenticationInterceptor intercep = new BasicAuthenticationInterceptor("admin","admin");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(intercep);
		return restTemplate;
	}
}
