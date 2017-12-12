
package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import puppiesAndStuff.wsdl.GetPuppiesAndStuffResponse;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	CommandLineRunner lookup(PuppiesAndStuffClient client) {
		return args -> {
			
			GetPuppiesAndStuffResponse response = client.getAPuppyOrSomething("puppy");
			System.err.println(response.getTitle());
		};
	}

}
