package controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Box;
import model.JDBCBoxDAO;

@Controller
public class FindMyBoxesController {

	private JDBCBoxDAO JdbcBoxDao = new JDBCBoxDAO(null);

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String displayHomepage(ModelMap modelHolder) {
		if (!modelHolder.containsAttribute("boxParamaters")) {
			modelHolder.addAttribute("boxParamaters", new Box());
		}

		return "homepage";
	}

	// add modelHolder to be loaded with boxes that fit.
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public String displayHomepageForm(@Valid @ModelAttribute("boxParameters") Box boxFormValues, BindingResult result,
			RedirectAttributes flash, ModelMap modelHolder) {

		flash.addFlashAttribute("boxParameters",boxFormValues);
		if (result.hasErrors()) {

			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "boxParameters", result);
			return "redirect:/";
		}

		boxFormValues.arrangeDimensions();

		List<Box> fittedBoxes = new ArrayList<Box>();
		fittedBoxes = JdbcBoxDao.getListOfFittingBoxes(boxFormValues);
		modelHolder.put("boxes", fittedBoxes);
		

		return "homepage";
	}

	@RequestMapping(path = "/**", method = RequestMethod.GET)
	public String displayCatchAll() {
		return "catchAll";
	}

}
