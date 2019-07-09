package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
public class FindMyBoxesController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String displayHomepage() {
		
		return "homepage";
	}

	@RequestMapping(path = "/**", method = RequestMethod.GET)
	public String displayCatchAll() {
		
		return "catchAll";
	}
	
}
