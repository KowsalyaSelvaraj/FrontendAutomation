package com.selenium.project.testng;

import org.testng.annotations.Test;

public class TestngPractise {

	//drive a car
	@Test(priority=0)
	public void startEngine()
	{
		System.out.println("Engine Started ");
	}

	@Test(priority=1)
	public void putFirstGear() {
		System.out.println("First Gear");
	}

	@Test(priority=2)
	public void putSecondGear() {
		System.out.println("Second Gear");

	}

	//go to college 
	@Test(priority = 3,enabled = true)// can change to false also
	public void goToSecondarySchool()
	{
		System.out.println("Go To 10th Standard");
	}

	@Test(dependsOnMethods = "goToSecondarySchool")
	public void goToHigherSchool()
	{
		System.out.println("Go To 12th Standard");
	}

	@Test(dependsOnMethods = "goToHigherSchool")
	public void goToCollege()
	{
		System.out.println("Go To College Standard");
	}


}
