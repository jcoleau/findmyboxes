package model;

import java.util.ArrayList;
import java.util.List;

import view.UserInterface;

public class App {

	public static void main(String[] args) {
		// Instantiate a UserInterface Object for every I/O's
		UserInterface user = new UserInterface(System.in, System.out);
		List<Box> fittingBoxList = new ArrayList<Box>();
		Box bestFit;

		// Loading the list with available boxes
		List<Box> boxList = new ArrayList<Box>();
		double[] boxArray = new double[] { 18, 12.5, 3, 17, 17, 7, 12, 9, 6, 20, 20, 12, 13, 9, 11, 23, 17, 12, 12, 12,
				18, 8, 8, 8, 20, 20, 20, 11, 11, 11, 24, 24, 24, 14, 14, 14, 28, 28, 28, 16, 16, 16, 50,20,8};

		for (int i = 0; i < boxArray.length - 2; i += 3) {
			Box box = new Box(boxArray[i], boxArray[i + 1], boxArray[i + 2]);
			boxList.add(box);
		}

		// Getting 3 Measurements from the user (0.0 < x < 200.0)
	
		double measure1 = user.getUserInput("Enter Item Length: ");
		double measure2 = user.getUserInput("Enter Item Width: ");
		double measure3 = user.getUserInput("Enter Item Height: ");
		Box item = new Box(measure1, measure2, measure3);

		// Select Applicable boxes and add them to a list

		fittingBoxList = isAFit(item, boxList);

		if (!(fittingBoxList.isEmpty())) {
			bestFit = bestFit(fittingBoxList);
			user.displayString("Best fit for your item: " + bestFit);
		} else {
			user.displayString("I am afraid there is no fit for your item dimensions.");
		}

	}

	private static List<Box> isAFit(Box item, List<Box> boxList) {
		List<Box> fittingBoxes = new ArrayList<Box>();
		for (Box b : boxList) {
			if (b.getLength() >= item.getLength()) {
				if (b.getWidth() >= item.getWidth()) {
					if (b.getHeight() >= item.getHeight()) {
						fittingBoxes.add(b);
					}
				}
			}
		}
		return fittingBoxes;
	}

	private static Box bestFit(List<Box> fittingBoxList) {

		double smallestVolume = fittingBoxList.get(0).getVolume();
		Box theBox = fittingBoxList.get(0);
		
		for (Box b : fittingBoxList) {
			if (b.getVolume() < smallestVolume) {
				smallestVolume = b.getVolume();
				theBox = b;
			}
		}
		return theBox;
	}

}
