package com.laptopServiceAppLaptop;

import java.util.Comparator;


public class Laptop {
	private String model;
	private String brand;
	private double cost;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getKey() {
		return model.toLowerCase().hashCode()+brand.toLowerCase().hashCode();
	}
	@Override
	public boolean equals(Object obj) { 
	    if (this.getClass() == obj.getClass()){
	        Laptop other =(Laptop)obj;
	        if(this.model==other.model){
	            return true;
	        }
	    }
	    return false;
	}
	public class SortByid implements Comparator<Laptop>{
	    @Override
		public int compare(Laptop b1, Laptop b2) 
	    {
	    	return ((b1.getModel().toLowerCase()).compareTo(b2.getModel().toLowerCase()));
	    }
	}
}
