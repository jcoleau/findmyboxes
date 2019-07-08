package view;

import java.util.List;

public class DisplayOutput {
	
	public String displayInvalidOptionError (String userInput) {
		return "\n" + userInput + "is not a valid option.";
	}
	
	public String displayMenuOptions (String introducingText, List<String> menuOptions) {
		String output = introducingText;
		for (String string : menuOptions) {
			output += "\n" + string;
		}
		return output;
	}
	
}
