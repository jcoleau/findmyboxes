package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCBoxDAO implements BoxDAO {

	// static list of boxes hardcoded with helper method at the bottom
	// To be replaced by a JdbcTemplate
	private static List<Box> boxList;

	public JDBCBoxDAO(DataSource dataSource) {
		/*
		 * For future database connection this.jdbcTemplate = new
		 * JdbcTemplate(dataSource);
		 */
	}

	public List<Box> getAllBoxes() {
		return boxList;

	}

	public List<Box> getListOfFittingBoxes(Box item) {
		List<Box> fittingBoxes = new ArrayList<Box>();

		boxList = boxLoader();
		for (Box b : boxList) {

			if (b.getLength() >= item.getLength()) {
				if (b.getWidth() >= item.getWidth()) {
					if (b.getHeight() >= item.getHeight()) {
						fittingBoxes.add(b);
					}
				}
			}
		}
		fittingBoxes.sort(Comparator.comparing(Box::getVolume));

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

	private static List<Box> boxLoader() {
		List<Box> boxList = new LinkedList<Box>();

		// Hard coded boxes Array from Fedex
		double[] fedexboxArray = new double[] { 18, 12.5, 3,245, 17, 17, 7,235, 12, 9, 6,125, 20, 20, 12,254, 13, 9, 11,189, 23, 17, 12,286, 12,
				12, 18,225, 8, 8, 8,115, 20, 20, 20,325, 11, 11, 11,135, 24, 24, 24,365, 14, 14, 14,275, 28, 28, 28,425, 16, 16, 16,285, 50, 20, 8,565 };

		for (int i = 0; i < fedexboxArray.length - 3; i += 4) {
			Box box = new Box(fedexboxArray[i], fedexboxArray[i + 1], fedexboxArray[i + 2], (int)fedexboxArray[i + 3]);
			box.setSupplier("fedex");
			box.setSupplierLogo("fedex-logo.png");
			boxList.add(box);
		}

		// Hard coded boxes Array from UPS
		double[] upsBoxArray = new double[] { 13, 11, 2,125,16,11,3,135,18,13,3,205 };

		for (int i = 0; i < upsBoxArray.length - 3; i += 4) {
			Box box = new Box(upsBoxArray[i], upsBoxArray[i + 1], upsBoxArray[i + 2], (int)upsBoxArray[i+3]);
			box.setSupplier("ups");
			box.setSupplierLogo("ups-logo.png");
			boxList.add(box);
		}
		
		double[] homeDepotBoxArray = new double[] {22,16,15,144,18,18,24,171,16,12,12,90,22,22,22,243,15,12,
				10,75,6,6,6,54,24,24,44,1798,18,18,16,147,24,24,34,1293 ,30,5,24,2386,36,6,42,9170};

		for (int i = 0; i < homeDepotBoxArray.length - 3; i += 4) {
			Box box = new Box(homeDepotBoxArray[i], homeDepotBoxArray[i + 1], homeDepotBoxArray[i + 2], (int)homeDepotBoxArray[i+3]);
			box.setSupplier("The Home Depot");
			box.setSupplierLogo("home-depot-logo.png");
			boxList.add(box);
		}
		
		double[] lowesBoxArray = new double[] {24,18,18,178,18,16,18,147,16,12,12,88,24.8125,35.8125,24,375,1293,22,22,21.5,258,24,
				24,25,1698};

		for (int i = 0; i < homeDepotBoxArray.length - 3; i += 4) {
			Box box = new Box(homeDepotBoxArray[i], homeDepotBoxArray[i + 1], homeDepotBoxArray[i + 2], (int)homeDepotBoxArray[i+3]);
			box.setSupplier("Lowes");
			box.setSupplierLogo("lowes-logo.png");
			boxList.add(box);
		}

		return boxList;
	}

}
