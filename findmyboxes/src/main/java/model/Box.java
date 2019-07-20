package model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class Box {
	

//	@NotBlank(message="Please enter a dimension in inches")
//	@Max(value=400, message="Maximum dimension value is 400 inches")
//	@Min(value=0, message="Minimum dimension value is 0.1 inches")
	private double length;
	
//	@NotBlank(message="Please enter a dimension in inches")
//	@Max(value=400, message="Maximum dimension value is 400 inches")
//	@Min(value=0, message="Minimum dimension value is 0.1 inches")
	private double width;
	
//	@NotBlank(message="Please enter a dimension in inches")
//	@Max(value=400, message="Maximum dimension value is 400 inches")
//	@Min(value=0, message="Minimum dimension value is 0.1 inches")
	private double height;
	
	private boolean padding = false;
	private double volume = this.length * this.width * this.height;
	private int priceInCents;
	private String supplier;
	private String supplierLogo;
	

	public Box() {
		this.length = 0;
		this.width = 0;
		this.height = 0;
	}
	
	public Box(double length, double width, double height) {

		double a = Math.max(length, width);
		this.length = Math.max(a, height); // stores the max value passed to the constructor as the box length
		double b = Math.min(length, width);
		this.height = Math.min(b, height); // stores the min value passed to the constructor as the box height
		// retrieve the middle value and store it as the box width.
		this.width = (length + width + height) -(this.length + this.height); 
		
	}
	
	public void arrangeDimensions() {
		
		double length = this.length;
		double width = this.width;
		double height = this.height;
		
		double a = Math.max(length, width);
		this.length = Math.max(a, height);
		double b = Math.min(length, width);
		this.height = Math.min(b, height);
		this.width = (length + width + height) -(this.length + this.height); 
		
	}
	

	@Override
	public String toString() {
		return "Length: " + this.length + "\", Width: " + this.width + "\", Height: " + this.height + "\"" + " V:" + this.getVolume();
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
	public String getSupplierLogo() {
		return supplierLogo;
	}

	public void setSupplierLogo(String supplierLogo) {
		this.supplierLogo = supplierLogo;
	}

}
