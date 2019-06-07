package com.testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	SoftAssert softAssert = new SoftAssert();
	
	
  @Test(priority =1)
  public void homeTest() {
	  
	  System.out.println("I am in home test");
	  System.out.println("Before assertion");
	  Assert.assertTrue(4>3, "Verifying Element");

	  System.out.println("After Assertion");
	  Assert.assertEquals("abc", "abc");
  }
  
  @Test(priority=2, dependsOnMethods= {"homeTest"}, groups = "smoke")// or groups ={"smoke","sanity")
  //DependsOnMethods is very important as if that methods fail,this method will automatically skipped.
  public void mainTest() {
	  
	  System.out.println("I am in main test");
	  System.out.println("Before assertion");
	  softAssert.assertTrue(2>3, "Verifying Element");

	  System.out.println("After Assertion");
	 softAssert.assertAll();//similar to error collector
	 //if we dont put softAssert.assertAll() then test will be failed. it works as error collector in JUNIT
  }
  
  @Test(priority=3, dependsOnMethods= {"mainTest"})
  public void endTest() {
	  
	  System.out.println("I am in end test");
	  System.out.println("Before assertion");
	  softAssert.assertTrue(2>3, "Verifying Element");

	  System.out.println("After Assertion");
	  softAssert.assertEquals("abc", "abc");
	  System.out.println("after second asssertion");
	 softAssert.assertAll();//similar to error collector
  }
	/*
	 * //there are three types of testing 
	 * 1. smoke testing - main important function of each page-that is why we grouped as smoke so we can run easily
	 * 2. snaity testing - different diffferernt functionality including smoke
	 * 3.regression testing-each and every functions before release update
	 */
  
  
  
  
  
  
}




