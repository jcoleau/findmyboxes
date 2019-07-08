package view;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserInput {

	private Scanner userInput = new Scanner(System.in);
	
	public String collectUserInput() {
		String scannerInput = userInput.nextLine();
		return scannerInput;
	}
	
	public BigDecimal extractDimension(String userInput) {
		try {
			double choice = Double.valueOf(userInput);
			BigDecimal dimension = BigDecimal.valueOf(choice);
			return dimension;
		} catch (Exception e) {
			return null;
		}
	}
	
}
