package model;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class JDBCBoxDAOTest {
	
	private JDBCBoxDAO JdbcBoxDao = new JDBCBoxDAO(null);
	
	@Test
	public void boxes_should_be_sorted_out_by_volume() {
		double[] testArray = {1,2,3,1,2,2};
		List<Box> boxList = boxLoader(testArray);
		Box b = new Box();
		JdbcBoxDao.getListOfFittingBoxes(b);
		assertEquals(4,boxList.get(0).getVolume(),2);
		
	}
	
	

	private static List<Box> boxLoader(double[] boxArray){
		List<Box> boxList = new LinkedList<Box>();


		for (int i = 0; i < boxArray.length - 2; i += 3) {
			Box box = new Box(boxArray[i], boxArray[i + 1], boxArray[i + 2]);
			box.setSupplier("fedex");
			boxList.add(box);
		}

		return boxList;
	}

}
