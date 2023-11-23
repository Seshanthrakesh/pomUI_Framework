package com.w3schools.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.w3schools.utils.Sewrappers;

public class LoginPage extends Sewrappers {
	@FindBy(id="modalusername")
	public WebElement username;
	
	@FindBy(name="current-password")
	public WebElement password;
	
	@FindBy(xpath="//span[text()='Log in']")
	public WebElement login;
	
	public void setusername(String emailid) {
	waitForElement(username, 20);
	typeText(username, emailid);
	}
	public void setpassword(String pswd) {
		waitForElement(password,20);
		typeText(password, pswd);
	}
	public void clicklogin() {
		waitForElement(login,20);
		clickElement(login);
	}
}
