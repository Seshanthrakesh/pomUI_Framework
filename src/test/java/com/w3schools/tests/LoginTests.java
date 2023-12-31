package com.w3schools.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w3schools.utils.Reports;
import com.w3schools.utils.Sewrappers;
import com.w3schools.utils.w3wrappers;

public class LoginTests extends Sewrappers{
	w3wrappers w3= new w3wrappers();
	Reports report = new Reports();
	@Test
	public void loginWithValidCredentials()
	{
		try
		{
			report.setTCDesc("Validating login in W3 schools with valid credentials");
			launchFirefoxBrowser("https://profile.w3schools.com/");
			w3.loginW3Schools("seshanthrakesh1901@gmail.com","Seshanth@9852");

			WebElement mylearning=driver.findElement(By.xpath("//div[text()='My learning']"));
			waitForElement(mylearning,20);
			//validation for checking the title
			System.out.println(driver.getTitle());
			System.out.println(driver.getTitle().equals("My learning | W3Schools"));
			Assert.assertTrue(driver.getTitle().equals("My learning | W3Schools"));
			
			//System.out.println("Assertion Passed");
			Reports.reportstep("INFO", "Assertion passed by title");

		}
		catch(Exception ex)
		{
			System.out.println("Problem while logging with valid credentials");
			ex.printStackTrace();
		}
	}
}
