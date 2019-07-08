package view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class UserInterface {

	private PrintWriter out;
	private Scanner in;

	public UserInterface(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public double getUserInput(String s) {

		double measurement = 0;
		boolean flag = true;

		while (flag == true) {
			displayString(s);
			String userInput = in.nextLine();
			try {
				double choice = Double.valueOf(userInput);
				if (choice <= 0 || choice > 100) {
					throw new NumberFormatException();
				}
				measurement = choice;
				flag = false;
			} catch (NumberFormatException e) {
				// eat the exception, an error message will be displayed below
			}
			if (measurement == 0) {
				out.println("\n*** " + userInput + " is not a valid option ***\n");
			}
		}
		return measurement;
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print("\nPlease choose an option >>> ");
		out.flush();
	}

	public void displayString(String s) {
		out.println(s);
		out.flush();
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will
			// be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

}
