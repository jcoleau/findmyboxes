package model;

import java.util.List;

public interface BoxDAO {

	/**
	 * Get all boxes from the database (Length, Width, Height in inches, supplier name and price in cents.)
	 * @return a list of Box Items
	 *
	 */
	public List<Box> getAllBoxes();
	
	
	/**
	 * Finds the smallest volume of all boxes passed in the List
	 * DO NOT CALL BEST FIT WITH BOXES THAT ARE NOT A FIT
	 * @param fittingBoxList
	 * @return a Box Object that has the smallest volume of all boxes passed.
	 */
	public Box bestFit(List<Box> fittingBoxList);
	
	
	/**
	 * TO BE REFACTORED INTO ONE SINGLE METHOD
	 * @param item
	 * @param boxList
	 * @return
	 */
	public List<Box> isAFit(Box item, List<Box> boxList);

}
