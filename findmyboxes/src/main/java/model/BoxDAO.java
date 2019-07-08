package model;

import java.util.List;

public interface BoxDAO {

	/**
	 * Get all boxes from the database (Length, Width, Height in inches, supplier name and price in cents.)
	 * @return a list of Box Items
	 *
	 */
	public List<Box> getAllBoxes();

}
