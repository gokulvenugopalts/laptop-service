package com.laptopServiceAppImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.laptopServiceApp.LaptopServiceAppInter;
import com.laptopServiceAppInputFunc.inputFunc;
import com.laptopServiceAppLaptop.Laptop;

public class ServiceAppImpl implements LaptopServiceAppInter{
	Laptop lapOb = new Laptop();
	HashMap<Integer, Laptop> lapMap = new HashMap();
	inputFunc inp = new inputFunc();

	public void menuDisp()
	{
		System.out.println("Menu");
		System.out.println("1. Add a new Laptop.");
		System.out.println("2. Remove a record");
		System.out.println("3. View list of records.");
		switch(inp.getIntValue("Enter your choice:"))
		{
			case 1:
			{
				boolean flag=false;
				lapOb=getInput(lapOb);
				flag=addLaptop(lapOb);
				printMessage(flag,1);
			}break;
			case 2:
			{
				
				boolean flag = false;
				if(lapMap.isEmpty())
				{
					System.out.println("No laptop entry has been made.");
				}
				else
				{
					lapOb = getInput(lapOb);
					flag =removeLaptop(lapOb);
					printMessage(flag,2);
				}
				
			}break;
			case 3:
			{
				dispList();
				menuContinue();
			}break;
		}
	}
	public Laptop getInput(Laptop lapOb)
	{
		inputFunc inp = new inputFunc();
		lapOb = new Laptop();
		String brand = inp.getStringValue("Enter brand", "[a-z A-Z]+");
		String model = inp.getStringValue("Enter model", "[a-z A-Z0-9]+");
		lapOb.setBrand(brand);
		lapOb.setModel(model);
		return lapOb;
	}
	public boolean addLaptop(Laptop lapOb)
	{
		if(!lapMap.isEmpty())
		{
			for(Entry<Integer, Laptop> entry : lapMap.entrySet())
			{
				int key = entry.getKey();
				Laptop value = entry.getValue();
				if(value.getModel().equals(lapOb.getModel()))
				{
					System.out.println("Entry already exists.");
					return false;
				}
				else
				{
					lapMap.put(key, lapOb);
				}
			}
		}
		else
		{
			int key = lapOb.getKey();
			lapMap.put(key,lapOb);
		}
		return true;
	}
	public boolean removeLaptop(Laptop lapOb)
	{
		if(!lapMap.isEmpty())
		{
			for(Entry<Integer, Laptop> entry : lapMap.entrySet())
			{
				int key = entry.getKey();
				Laptop value = entry.getValue();
				if(value.getModel().equals(lapOb.getModel()) && value.getBrand().equals(lapOb.getBrand()))
				{
					lapMap.remove(value.getKey());
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		return false;
	}
	public void printMessage(boolean flag,int i)
	{
		String s;
		if(i == 1 && flag == true)
		{
			if(flag) System.out.println("Laptop successfully added.");
			else System.out.println("Operation failed.");
		}
		else
		{
			if(flag) System.out.println("Laptop entry successfully removed.");
			else System.out.println("Laptop entry not found.");
		}
			menuContinue();
	}
	public void menuContinue()
	{
		System.out.println("Do you want to continue?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		switch(inp.getIntValue("Enter a choice."))
		{
			case 1:
			{
				menuDisp();
			}break;
			case 2:
			{
				System.exit(0);
			}break;
			default:
			{
				System.out.println("Invalid choice.");
			}break;
		}
	}
	public void dispList()
	{
		if(!lapMap.isEmpty())
		{
			for(Entry<Integer, Laptop> entry : lapMap.entrySet())
			{
				int key = entry.getKey();
				Laptop value = entry.getValue();
				System.out.println(key + " "+ value.getBrand()+" "+value.getModel());
			}
		}
		else System.out.println("No more entries to be displayed.");
	}
}