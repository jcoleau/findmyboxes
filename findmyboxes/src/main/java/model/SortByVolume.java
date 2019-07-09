package model;

import java.util.Comparator;

class SortByVolume implements Comparator<Box> 
{ 
 
	@Override
	public int compare(Box o1, Box o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getVolume() - o2.getVolume());
	} 
}