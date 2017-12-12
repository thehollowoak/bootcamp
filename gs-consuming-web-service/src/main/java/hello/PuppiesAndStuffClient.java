package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import puppiesAndStuff.wsdl.GetPuppiesAndStuffRequest;
import puppiesAndStuff.wsdl.GetPuppiesAndStuffResponse;

public class PuppiesAndStuffClient extends WebServiceGatewaySupport {
	private static final Logger log = LoggerFactory.getLogger(PuppiesAndStuffClient.class);
	
	public GetPuppiesAndStuffResponse getAPuppyOrSomething(String cutePuppyOrSomething){
			GetPuppiesAndStuffRequest request = new GetPuppiesAndStuffRequest();
			request.setCuteAnimalName(cutePuppyOrSomething);
			GetPuppiesAndStuffResponse response = (GetPuppiesAndStuffResponse) getWebServiceTemplate()
					.marshalSendAndReceive("http://localhost:8080/gogetit",
							 request,
							 new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/getPuppiesAndStuff"));
		
		return response;	
		}
	
}
