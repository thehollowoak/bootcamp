package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import puppiesAndStuff.wsdl.GetPuppiesAndStuffResponse;

@RestController
public class CuteThingController {
@Autowired
public PuppiesAndStuffClient puppiesAndStuffClient;

    @RequestMapping("/cutething")
    public CuteThing cuteThing(@RequestParam(value="name") String name) {
        if (name == null){
        	name = "puppy";
        }
    	GetPuppiesAndStuffResponse response = puppiesAndStuffClient.getAPuppyOrSomething(name);
    	return new CuteThing(response.getAuthor(), response.getTitle(), response.getImageLink());
    }
}
