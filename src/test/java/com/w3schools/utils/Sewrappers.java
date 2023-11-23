package com.w3schools.utils;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;

/*
 * This class is going to contain customized methods for all selenium default methods
 */

public class Sewrappers {

	public static WebDriver driver=null;


	//method to launch the chrome browser with the given url
	public void launchBrowser(String url)
	{
		try
		{
			driver= new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			//to capture logs in the report
			Reports.reportstep("PASS","Chrome browser launched successfully");

		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Problem while launching the browser");
			ex.printStackTrace();

		}
	}

	//method to close the current browser window
	public void closeCurrentBrowser()
	{
		try
		{
			driver.close();
			Reports.reportstep("PASS", "Current Browser Window Closed Successfully");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL", "Problem while closing the current browser");
			ex.printStackTrace();
		}
	}

	//method to close all the browsers
	public void closeAllBrowsers()
	{
		try
		{
			driver.quit();
			Reports.reportstep("PASS", "All browsers closed successfully");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL", "Problem while closing the browsers");
			ex.printStackTrace();
		}
	}

	//method to type text in the web page
	public void typeText(WebElement ele, String text)
	{
		try
		{
			ele.clear();
			ele.sendKeys(text);
			Reports.reportstep("PASS","Successfully Typed  : "+text);
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL", "Problem While Typing : "+text);
			ex.printStackTrace();
		}
	}

	//method to click on the webelement in the web page
	public void clickElement(WebElement ele)
	{
		try
		{
			ele.click();
			Reports.reportstep("PASS",ele+ " is Clicked Successufully");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL", "Problem in Clicking :"+ele);
			ex.printStackTrace();
		}
	}

	//Select dropdown - by Index

	public void selectByindex(WebElement ele, int index)
	{
		try
		{
			Select sel = new Select(ele);
			sel.selectByIndex(index);
			Reports.reportstep("PASS", ele+" is Selected Successfully");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL", "Problem in Selecting : "+ele);
			ex.printStackTrace();
		}
	}


	//Select dropdown - By value

	public void selectByValue(WebElement ele, String value)
	{
		try
		{
			Reports.reportstep("PASS", ele+" is Selected Successfully");
			Select sel = new Select(ele);
			sel.selectByValue(value);
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL", "problem in Selecting : "+ele);
			ex.printStackTrace();
		}
	}

	//Select dropdown - By Visibletext

	public void selectByVisibleText(WebElement ele, String visibleText)
	{
		try
		{
			Select sel = new Select(ele);
			sel.selectByVisibleText(visibleText);
			Reports.reportstep("PASS", ele+" is Selected Successfully");
		}
		catch(Exception ex) {
			Reports.reportstep("FAIL", "problem in Selecting : "+ele);
			ex.printStackTrace();
		}
	}

	//Explicit wait

	public void waitForElement(WebElement ele, int timeout)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
			wait.until(ExpectedConditions.visibilityOf(ele));
			Reports.reportstep("PASS", "Wait for "+ele+" is successfully");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Wait for"+ele+" is failed");
			ex.printStackTrace();
		}
	}


	//fluent wait

	public void fluentWaitForElement(WebElement ele, int pollingFrequency,  int timeout)
	{
		try
		{
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.pollingEvery(Duration.ofSeconds(pollingFrequency))
					.withTimeout(Duration.ofSeconds(timeout));

			wait.until(ExpectedConditions.visibilityOf(ele));
			Reports.reportstep(":PASS","Wait for"+ele+" is successfully");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Wait for "+ele+"is failed");
			ex.printStackTrace();
		}
	}


	//action class - click, doubliclick, contextclick,


	public void actionsDoubleClick(WebElement ele)
	{
		try
		{
			Actions action = new Actions(driver);
			action.doubleClick(ele).build().perform();
			Reports.reportstep("PASS","Double Click "+ele+" is successfull");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL", "Double Click"+ele+" is Failed");
			ex.printStackTrace();;
		}
	}

	public void actionsRightClick(WebElement ele)
	{
		try
		{
			Actions action = new Actions(driver);
			action.contextClick(ele).build().perform();
			Reports.reportstep("PASS","Right Click "+ele+" is Successfull");

		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Right Click "+ele+" is Failed");
			ex.printStackTrace();
		}
	}

	public void actionsMoveToElement(WebElement ele)
	{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(ele).build().perform();
			Reports.reportstep("PASS","MoveToElement "+ele+" is Sucessfull");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","MoveToElement "+ele+" is Failed");
			ex.printStackTrace();
		}
	}


	public void actionsDragAndDrop(WebElement source,WebElement target)
	{
		try
		{
			Actions action = new Actions(driver);
			action.dragAndDrop(source,target).build().perform();
			Reports.reportstep("PASS","Drag and Drop "+source+" is Succesfull");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Drag and Drop "+source+" is Failed");
			ex.printStackTrace();
		}
	}

	public void actionsClick(WebElement ele)
	{
		try
		{
			Actions action = new Actions(driver);
			action.click(ele).build().perform();
			Reports.reportstep("PASS",ele+" Clicked Successfully");

		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL",ele+" Clicked Unsuccessfull");
			ex.printStackTrace();
		}
	}

	public void selectFrameByIndex(int index)
	{
		try
		{
			driver.switchTo().frame(index);
			Reports.reportstep("PASS","Switched Frame Successfully");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Switched Frame UnSuccessfully");
			ex.printStackTrace();
		}
	}


	public void selectFrameByNameOrId(String nameId)
	{
		try
		{
			driver.switchTo().frame(nameId);
			Reports.reportstep("PASS","Switched Frame Successfully");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Switched Frame UnSuccessfully");
			ex.printStackTrace();
		}
	}


	public void selectFrameByWebElement(WebElement ele)
	{
		try
		{
			driver.switchTo().frame(ele);
			Reports.reportstep("PASS","Switched Frame Successfully");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Switched Frame UnSuccessfully");
			ex.printStackTrace();
		}
	}

	//Windowhandling --> 

	public void windowHandlingswitchToNewWindow()
	{
		try
		{


			Set<String> allWindows = driver.getWindowHandles();

			for(String eachWindow:allWindows)
			{
				driver.switchTo().window(eachWindow);
			}
			Reports.reportstep("PASS","Switch to New window is Successfully");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Switch to New window is Failed");
			ex.printStackTrace();
		}
	}

	public void windowHandlingSwitchToParentWindow()
	{
		try
		{
			Reports.reportstep("PASS","Switch to Parent Window is Successfull");
			String parentWindow= driver.getWindowHandle();
			driver.switchTo().window(parentWindow);

		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Switch to Parent Window is Successfull");
			ex.printStackTrace();
		}
	}

	public void windowHandlingDefaultContent(String parentWindow)
	{
		try
		{
			driver.switchTo().defaultContent();
			Reports.reportstep("PASS","Switch To Default Content is Successfull");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Switch To Default Content is Failed");
			ex.printStackTrace();
		}
	}



	//JavascriptExecutor --> click, scrollUp, scrollDown , write for all actions we have seen

	public void javascriptExecutorScrollVertical(int scrolldownValue)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			//To ScrollDown
			js.executeScript("window.scrollBy(0,"+scrolldownValue+");");
			Reports.reportstep("PASS","Scroll vertical is Successfull");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Scroll vertical is Failed");
			ex.printStackTrace();
		}
	}



	public void javascriptExecutorScrollHorizontal(int scrollupValue)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;

			//To ScrollDown
			js.executeScript("window.scrollBy("+scrollupValue+",0);");
			Reports.reportstep("PASS","Scroll Horizontal is Successfull");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Scroll Horizontal is Failed");
			ex.printStackTrace();
		}
	}

	public void javascriptExecutorEndContent()
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;

			//To ScrollDown to the End of the Content
			js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
			Reports.reportstep("PASS","Scroll to End of the page is Successfull");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Scroll to End of the page is Failed");
			ex.printStackTrace();
		}
	}

	public void javascriptExecutorStartingContent()
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;

			//To ScrollUp to the Starting of the Content
			js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
			Reports.reportstep("PASS","Scroll to Start of the page is Successfull");
		}
		catch(Exception ex)
		{
			Reports.reportstep("PASS","Scroll to Start of the page is Failed");
			ex.printStackTrace();
		}
	}

	public void javascriptExecutorScrollRight()
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;

			//To ScrollRight to the End of the Content
			js.executeScript("window.scrollTo(document.body.scrollWidth,0);");
			Reports.reportstep("PASS","Scroll Right of the Web page is Successfull");

		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Scroll Right of the Web page is Failed");
			ex.printStackTrace();
		}
	}

	public void javascriptExecutorTitle()
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;

			//Getting the Title 
			//System.out.print(js.executeScript("return document.title;"));
			Reports.reportstep("PASS","");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Unable to get Title");
			ex.printStackTrace();
		}
	}

	public void javascriptExecutorScrollWebElement(WebElement ele)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;

			//to scroll until a particular webElement

			js.executeScript("arguments[0].scrollIntoView(true);",ele);
			Reports.reportstep("PASS","Scroll to "+ele+" is Successfull");		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Scroll to "+ele+" is Failed");
			ex.printStackTrace();
		}
	}


	public void javascriptExecutorClickWebElement(WebElement ele)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;

			//to click on a particular webElement

			js.executeScript("arguments[0].click();", ele);
			Reports.reportstep("PASS","Clicked on "+ele+" is Successfull");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Clicked on "+ele+" is Unsuccessfull");
			ex.printStackTrace();
		}
	}


	public void javascriptExecutorTypeText(WebElement ele, String value)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;

			//type in text in a input box
			js.executeScript("arguments[0].value='"+value+"';", ele);
			Reports.reportstep("PASS",ele+" is Typed Successfully");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL",ele+" is Type Unsuccessfull");
			ex.printStackTrace();
		}
	}


	public void acceptAlert()
	{
		try
		{
			Alert alert=driver.switchTo().alert();
			alert.accept();
			Reports.reportstep("PASS","Alert Accepted Successfully");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Alert Accept is Failed");
			ex.printStackTrace();
		}
	}


	public void dismissAlert()
	{
		try
		{
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
			Reports.reportstep("PASS","Dismiss Alert Successfull");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Dismiss Alert Unsuccessfull");
			ex.printStackTrace();
		}
	}

	public void typeInAlert(String value)
	{
		try
		{
			Alert alert=driver.switchTo().alert();
			alert.sendKeys(value);
			Reports.reportstep("PASS","Type "+value+" in the Alert is Successfull");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","type "+value+" in the Alert is Failed");
			ex.printStackTrace();
		}
	}


	public boolean verifySelected(WebElement ele)
	{
		boolean retVal=false;
		try
		{
			if(ele.isSelected())
			{
				retVal=true;
			}
			Reports.reportstep("PASS","Verified Selected "+ele+" is Successfull");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Verifying Selected "+ele+" is Failed");
			ex.printStackTrace();
		}
		return retVal;
	}


	public boolean verifyDisplayed(WebElement ele)
	{
		boolean retVal=false;
		try
		{
			if(ele.isDisplayed())
			{
				retVal=true;
			}
			Reports.reportstep("PASS","Verified Displayed "+ele+" is Successfull");
		}
		catch(Exception ex)
		{
			Reports.reportstep("FAIL","Verifing Displayed "+ele+" is Failed");
			ex.printStackTrace();
		}
		return retVal;
	}

	public boolean verifyEnabled(WebElement ele)
	{
		boolean retVal=false;
		try
		{
			if(ele.isEnabled())
			{
				retVal=true;
			}
			Reports.reportstep("PASS","Verified Enabled "+ele+" is Successfull");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return retVal;
	}

	//takes the screenshot of a specific page
	public void captureScreenshot(String screenshotName)
	{
		try
		{
			File src=( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest= new File(System.getProperty("user.dir")+"/screenshots/"+screenshotName+".png");
			FileUtils.copyFile(src, dest);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}




}
