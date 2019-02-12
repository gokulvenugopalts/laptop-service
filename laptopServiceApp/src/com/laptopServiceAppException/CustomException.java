package com.laptopServiceAppException;

public class CustomException extends Exception{
	String message;
	public CustomException(String message)
	{
		this.message = message;
	}
	public String toString()
	{
		return message;
	}
	
}
