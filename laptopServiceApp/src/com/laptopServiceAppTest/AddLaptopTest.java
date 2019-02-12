package com.laptopServiceAppTest;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import com.laptopServiceAppImpl.ServiceAppImpl;
import com.laptopServiceAppLaptop.Laptop;

public class AddLaptopTest {
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
			assertFalse(mockObj.addLaptop(lapOb));
			System.out.println("Test case: adding laptop successfull.");
		}
		catch(AssertionError e)
		{
			System.out.println("Test case failed.");
			fail();
		}
	}

}
