package model;

public class Box {

	private double length;
	private double width;
	private double height;
	private boolean padding = false;
	private int priceInCents;
	private String supplier;
	

	public Box(double length, double width, double height) {

		double a = Math.max(length, width);
		this.length = Math.max(a, height); // stores the max value passed to the constructor as the box length
		double b = Math.min(length, width);
		this.height = Math.min(b, height); // stores the min value passed to the constructor as the box height
		// retrieve the middle value and store it as the box width.
		this.width = (length + width + height) -(this.length + this.height); 
		
	}

	@Override
	public String toString() {
		return "Length: " + this.length + "\", Width: " + this.width + "\", Height: " + this.height + "\"";
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public boolean isPadding() {
		return padding;
	}

	public void setPadding(boolean padding) {
		this.padding = padding;
	}
	public int getPriceInCents() {
		return priceInCents;
	}

	public void setPriceInCents(int priceInCents) {
		this.priceInCents = priceInCents;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	public double getVolume() {
		return this.length * this.width * this.height;
	}

}
