package model;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class JDBCBoxDAOTest {
	
	private JDBCBoxDAO JdbcBoxDao = new JDBCBoxDAO(null);
	
	@Test
	public void boxes_should_be_sorted_out_by_volume() {
		
		
		
		
	}
	
//	@Test
//	public void getListOfFittingBoxes_should_return_a_list_of_box() {
//		Box b = new Box(1,2,3);
//		List<Box> expectedBoxList = JdbcBoxDao.getListOfFittingBoxes(b);
//		Assert.assertNotNull(expectedBoxList);
//	}
	
	@Test
	public void getListOfFittingBoxes_of_50_20_8() {
		Box b = new Box(50,20,8);
		List<Box> expectedBoxList = JdbcBoxDao.getListOfFittingBoxes(b);
		System.out.println("I have been returned " + expectedBoxList.get(0));
		Assert.assertNotNull(expectedBoxList);
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
