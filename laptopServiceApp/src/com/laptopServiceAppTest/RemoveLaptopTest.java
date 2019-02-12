package com.laptopServiceAppTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.laptopServiceAppImpl.ServiceAppImpl;
import com.laptopServiceAppLaptop.Laptop;
import static org.mockito.Mockito.when;

public class RemoveLaptopTest {

	ServiceAppImpl mockObj;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Starting add Laptop entry feature.");
		mockObj = Mockito.mock(ServiceAppImpl.class);
		Laptop lapOb = new Laptop();
		lapOb.setBrand("abcdef");
		lapOb.setModel("123456abcd");
		when(mockObj.addLaptop(lapOb)).thenReturn(true);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Execution complete.");
	}

	@Test
	public void test() {
		Laptop lapOb = new Laptop();
		lapOb.setBrand("Dell");
		lapOb.setModel("m123034d32");
		try{
			assertTrue(mockObj.removeLaptop(lapOb));
			System.out.println("Test case: removing laptop successfull.");
		}
		catch(AssertionError e)
		{
			System.out.println("Test case failed.");
			fail();
		}
	}


}
