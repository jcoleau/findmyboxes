package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class FindMyBoxesController {

	@RequestMapping("/greeting")
	public String displayGreeting() {
		
		return "greeting";
	}
}
