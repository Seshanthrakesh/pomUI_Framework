package com.w3schools.utils;

import org.openqa.selenium.support.PageFactory;
import com.w3schools.pages.HomePage;
import com.w3schools.pages.LoginPage;

/*
 * This class is going to contain all the reusable methods from W3 schools application
 */
public class w3wrappers extends Sewrappers{
	public void loginW3Schools(String username,String password)
	{
		
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
		HomePage homePage= PageFactory.initElements(driver, HomePage.class);
		
		//loginPage.setusername("seshanthrakesh1901@gmail.com");
		loginPage.setusername(username);
		//loginPage.setpassword("Seshanth9852");
		loginPage.setpassword(password);
		loginPage.clicklogin();
				
		homePage.waitForLearning();
		

		
	}
}
