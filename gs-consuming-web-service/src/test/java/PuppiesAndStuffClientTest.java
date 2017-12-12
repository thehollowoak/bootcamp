import javax.xml.transform.Source;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.client.MockWebServiceServer;
import org.springframework.xml.transform.StringSource;

import static org.springframework.ws.test.client.RequestMatchers.payload;
import static org.springframework.ws.test.client.ResponseCreators.withPayload;

import hello.PuppiesAndStuffClient;
import hello.PuppiesAndStuffConfiguration;
import puppiesAndStuff.wsdl.GetPuppiesAndStuffResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PuppiesAndStuffConfiguration.class)
public class PuppiesAndStuffClientTest {
	 @Autowired
	    private PuppiesAndStuffClient client;

    private MockWebServiceServer mockServer;

    @Before
    public void init(){
        mockServer = MockWebServiceServer.createServer(client);
    }


	@Test
	public void test() {
		 Source requestPayload = new StringSource(
	                "<gs:getPuppiesAndStuff xmlns:gs=\"http://spring.io/guides/gs-producing-web-service\">" +
	                		"<gs:cuteAnimalName>pig</gs:cuteAnimalName>"+
	                "</gs:getPuppiesAndStuff>");
		 

	        Source responsePayload = new StringSource(
	        		"<ns2:getPuppiesAndStuffResponse xmlns:ns2=\"http://spring.io/guides/gs-producing-web-service\"> <ns2:imageLink>http://en.rocketnews24.com/2014/04/22/japanese-pig-farmer-shows-the-world-how-pigs-should-be-treated/</ns2:imageLink> <ns2:author>Omniclusterfck</ns2:author> <ns2:title>Japanese man shows the world how pigs SHOULD be treated</ns2:title> </ns2:getPuppiesAndStuffResponse>"
	                + "");

	        mockServer
	                .expect(payload(requestPayload))
	                .andRespond(withPayload(responsePayload));
		
		PuppiesAndStuffClient client = new PuppiesAndStuffClient();
		GetPuppiesAndStuffResponse result = client.getAPuppyOrSomething("pig");
		assert(result.getTitle()).equals("test");
	}

}
