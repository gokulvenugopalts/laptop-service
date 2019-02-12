package com.laptopServiceAppInputFunc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class inputFunc {
	public int getIntValue(String s)
	{
		Scanner scn= new Scanner(System.in);
		int numb;
		System.out.println(s);
		try
		{
			numb=scn.nextInt();			
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid Input.Please re-enter(Digits are only accepted).");
			numb = getIntValue(s);
		}
		return numb;
	}
	public String getStringValue(String s)
	{
		Scanner scn= new Scanner(System.in);
		String value;
		System.out.println(s);
		value = scn.nextLine();
		return value;
	}
	public double getDoubleValue(String s)
	{
	Scanner scn= new Scanner(System.in);
	double value;
	System.out.println(s);
	try
	{
		value=scn.nextDouble();
	}
	catch(InputMismatchException e)
	{
		System.out.println("Invalid input. Please re-enter(Digits are only accapeeted)");
		value = getDoubleValue(s);
	}
	return value;
	}
	public String getStringValue(String s, String chk)
	{
		Scanner scn2= new Scanner(System.in);
		String value;
		System.out.println(s);
		value = scn2.nextLine();
		if((value.matches(chk)))
		{
			return value;
		}
		else
		{
			System.out.println("Invalid input. Please re-enter(Characters are only accepted).");
			value = getStringValue(s,chk);
		}
		return value;
	}
}
