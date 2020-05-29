package org.guru99.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass1 {
	
	@Test
	public void m1()
	{
		System.out.println("TestClass1");
		
	}
	
	@Test
	public void m2()
	{
		System.out.println("TestClass1");
		Assert.assertTrue(true);
	}
	
	@Test
	public void m3()
	{
		System.out.println("TestClass1");
	}
	
	@Test
	public void m4()
	{
		System.out.println("TestClass1");
	}
}
