package SeleniumEasy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.SimpleFormDemo;
import resources.TestBase;


public class AdditionTest extends TestBase
{

	public WebDriver driver;
	SimpleFormDemo demo;

	private static Logger Logs = LogManager.getLogger(AdditionTest.class.getName());

	@BeforeTest
	public void launchbrowser() throws IOException {

		driver = browseropen();

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		LandingPage lp = new LandingPage(driver);
		Logs.info("Browser is opened");
		lp.closing().click();
		Logs.debug("Input form is clicked");
		lp.forms().click();
		Logs.warn("Navigating to new page");
		Logs.fatal("New page is loading");
		Logs.error("Please wait");



	}

	@Test
	public void Additionoftwonumbers() {
		demo = new SimpleFormDemo(driver);
		demo.formdemo().click();
		String firstvalue = prop.getProperty("firstvalue");
		String secondvalue = prop.getProperty("secondvalue");
		int output = Integer.parseInt(firstvalue) + Integer.parseInt(secondvalue);
		demo.Firstnum().sendKeys(firstvalue);
		demo.Secondnum().sendKeys(secondvalue);
		demo.add().click();
		String actualresult = demo.gettotal().getText();
		int actualvalue = Integer.parseInt(actualresult);

		Assert.assertEquals(actualvalue, output);
	}

	
	@Test
	public void Messageverified()
	{
	
		Logs.info("Enter the message");
		demo.Input1().sendKeys(prop.getProperty("FirstInput"));
		demo.message().click();
		String textmessge = demo.messageconfirmation().getText();
		Logs.info("Verify whether the message is as expected");
		Assert.assertEquals(textmessge, prop.getProperty("FirstInput"));
	}
	@AfterTest
	public void closebrowser() {
		driver.close();

	}
}
