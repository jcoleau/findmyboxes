package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCBoxDAO implements BoxDAO {

	/* For future database connection
	private JdbcTemplate jdbcTemplate;
	*/
	private static List<Box> boxList = boxLoader();
	
	public JDBCBoxDAO(DataSource dataSource) {
		/* For future database connection
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		*/
	}

	public List<Box> getAllBoxes() {
		return boxList;

	}
	public List<Box> isAFit(Box item, List<Box> boxList) {
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

	public Box bestFit(List<Box> fittingBoxList) {

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
	
	private static List<Box> boxLoader(){
		List<Box> boxList = new LinkedList<Box>();

		// Hard coded boxes Array from Fedex
		double[] boxArray = new double[] {18, 12.5, 3, 17, 17, 7, 12, 9, 6, 20,
				20, 12, 13, 9, 11, 23, 17, 12, 12, 12, 18, 8, 8, 8, 20, 20, 20,
				11, 11, 11, 24, 24, 24, 14, 14, 14, 28, 28, 28, 16, 16, 16, 50,
				20, 8 };

		for (int i = 0; i < boxArray.length - 2; i += 3) {
			Box box = new Box(boxArray[i], boxArray[i + 1], boxArray[i + 2]);
			boxList.add(box);
		}

		return boxList;
	}

}
