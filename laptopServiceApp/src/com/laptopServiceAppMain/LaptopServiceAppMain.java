package com.laptopServiceAppMain;

import com.laptopServiceApp.LaptopServiceAppInter;
import com.laptopServiceAppImpl.ServiceAppImpl;

public class LaptopServiceAppMain {

	public static void main(String[] args) {
		LaptopServiceAppInter obj = new ServiceAppImpl();
		obj.menuDisp();

	}

}
