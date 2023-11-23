package com.w3schools.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.w3schools.utils.Sewrappers;

public class HomePage extends Sewrappers{

	@FindBy(xpath="//div[text()='My learning']")
	public WebElement myLearning;

	public void waitForLearning()
	{
		waitForElement(myLearning,20);
	}
}
