package model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BoxTest {
	
	Box box = new Box();
	
	
	@Test
	public void default_box_should_be_0() {
		assertEquals(0, box.getLength(), 1);
		assertEquals(0, box.getWidth(), 1);
		assertEquals(0, box.getHeight(), 1);
	}
	
	@Test
	public void box_should_have_sorted_dimensions() {
		setBox(1,2,3);
		box.arrangeDimensions();
		assertEquals(3, box.getLength(), 1);
		assertEquals(2, box.getWidth(), 1);
		assertEquals(1, box.getHeight(), 1);
		
	}
	
	@Test
	public void box_should_have_sorted_dimensions_2() {
		setBox(1,2,-1);
		box.arrangeDimensions();
		assertEquals(2, box.getLength(), 1);
		assertEquals(1, box.getWidth(), 1);
		assertEquals(-1, box.getHeight(), 1);
	}
	
	@Test
	public void box_should_have_sorted_dimensions_3() {
		setBox(1,1,0);
		box.arrangeDimensions();
		assertEquals(1, box.getLength(), 1);
		assertEquals(1, box.getWidth(), 1);
		assertEquals(0, box.getHeight(), 1);
	}
	
	@Test
	public void box_should_have_sorted_dimensions_4() {
		setBox(0,0,0);
		box.arrangeDimensions();
		assertEquals(0, box.getLength(), 1);
		assertEquals(0, box.getWidth(), 1);
		assertEquals(0, box.getHeight(), 1);
	}
	
	@Test
	public void box_should_have_sorted_dimensions_5() {
		setBox(4,6,3);
		box.arrangeDimensions();
		assertEquals(6, box.getLength(), 1);
		assertEquals(4, box.getWidth(), 1);
		assertEquals(3, box.getHeight(), 1);
	}
	
	
	
	
	
	
	private Box setBox(double d1, double d2, double d3) {
		box.setLength(d1);
		box.setWidth(d2);
		box.setHeight(d3);
		
		return box;
	}

}
