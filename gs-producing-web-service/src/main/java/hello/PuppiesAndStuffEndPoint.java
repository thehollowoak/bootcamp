package hello;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetPuppiesAndStuffRequest;
import io.spring.guides.gs_producing_web_service.GetPuppiesAndStuffResponse;

@Endpoint
public class PuppiesAndStuffEndPoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";


	@Autowired
	public PuppiesAndStuffEndPoint() {
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPuppiesAndStuffRequest")
	@ResponsePayload
	public GetPuppiesAndStuffResponse getCountry(@RequestPayload GetPuppiesAndStuffRequest request) {
		GetPuppiesAndStuffResponse response = new GetPuppiesAndStuffResponse();
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set("User-Agent", "yourUserAgentString");
		HttpEntity requestEntity = new HttpEntity<MultiValueMap>(requestHeaders);
		ResponseEntity<RedditResponse> awwList = restTemplate.exchange("https://www.reddit.com/r/aww/search.json?q="+request.getCuteAnimalName()+"&restrict_sr=on&sort=hot&t=all",  HttpMethod.GET, requestEntity, RedditResponse.class);
		List<Child> childList = awwList.getBody().getData().getChildren();
		Random rand = new Random();
		int num = rand.nextInt(15);
		System.out.print(awwList.toString());
		response.setImageLink(childList.get(num).getData().getUrl());
		response.setAuthor(childList.get(num).getData().getAuthor());
		response.setTitle(childList.get(num).getData().getTitle());
		
		return response;
	}
}
