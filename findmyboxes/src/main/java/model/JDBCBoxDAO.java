package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCBoxDAO implements BoxDAO {

	//static list of boxes hardcoded with helper method at the bottom
	//To be replaced by a JdbcTemplate
	private static List<Box> boxList;
	public JDBCBoxDAO(DataSource dataSource) {
		/* For future database connection
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		*/
	}

	public List<Box> getAllBoxes() {
		return boxList;

	}
	public List<Box> getListOfFittingBoxes(Box item) {
		List<Box> fittingBoxes = new ArrayList<Box>();
		boxList = boxLoader();
		for (Box b : boxList) {
			System.out.println(b);
			if (b.getLength() >= item.getLength()) {
				if (b.getWidth() >= item.getWidth()) {
					if (b.getHeight() >= item.getHeight()) {
						fittingBoxes.add(b);
					}
				}
			}
		}
		Collections.sort(fittingBoxes, new SortByVolume());
		return fittingBoxes;
	}

	public Box getSmallestVolumeOfList(List<Box> fittingBoxList) {

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
		double[] fedexboxArray = new double[] {18, 12.5, 3, 17, 17, 7, 12, 9, 6, 20,
				20, 12, 13, 9, 11, 23, 17, 12, 12, 12, 18, 8, 8, 8, 20, 20, 20,
				11, 11, 11, 24, 24, 24, 14, 14, 14, 28, 28, 28, 16, 16, 16, 50,
				20, 8 };

		for (int i = 0; i < fedexboxArray.length - 2; i += 3) {
			Box box = new Box(fedexboxArray[i], fedexboxArray[i + 1], fedexboxArray[i + 2]);
			box.setSupplier("fedex");
			box.setSupplierLogo("fedex-logo.png");
			boxList.add(box);
		}
		
		// Hard coded boxes Array from UPS
		double[] upsBoxArray = new double[] {1,2,3};

		for (int i = 0; i < upsBoxArray.length - 2; i += 3) {
			Box box = new Box(upsBoxArray[i], upsBoxArray[i + 1], upsBoxArray[i + 2]);
			box.setSupplier("ups");
			box.setSupplierLogo("ups-logo.png");
			boxList.add(box);
		}
		

		return boxList;
	}

}
