
package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class PuppiesAndStuffConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("puppiesAndStuff.wsdl");
		return marshaller;
	}

	@Bean
	public PuppiesAndStuffClient puppiesAndStuffClient(Jaxb2Marshaller marshaller) {
		PuppiesAndStuffClient client = new PuppiesAndStuffClient();
		client.setDefaultUri("http://localhost:8080/gogetit");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
