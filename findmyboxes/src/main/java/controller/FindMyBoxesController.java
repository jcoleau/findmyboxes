package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Box;



@Controller 
public class FindMyBoxesController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String displayHomepage() {
	return "homepage";
	}
	

	//add modelHolder to be loaded with boxes that fit.
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public String displayHomepageForm(@Valid @ModelAttribute("boxParameters") Box boxFormValues, 
			BindingResult result, RedirectAttributes flash) {
	if(result.hasErrors()) {
		flash.addFlashAttribute("boxParameters",boxFormValues);
		flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "boxParameters", result);
		return "redirect:/homePage";
	}
	Box userItem = new Box();
	userItem.arrangeDimensions();
	
	return "homepage";
	}

	@RequestMapping(path = "/**", method = RequestMethod.GET)
	public String displayCatchAll() {	
	return "catchAll";
	}
	
}
