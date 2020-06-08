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
import pages.checkboxDemo;
import resources.TestBase;



public class SinglecheckboxTest extends TestBase
{

	public WebDriver driver;
	checkboxDemo check;
	private static Logger log = LogManager.getLogger(SinglecheckboxTest.class.getName());

	@BeforeTest
	public void launchbrowser() throws IOException {

		driver = browseropen();
		log.info("The browser is opened succesfully");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		LandingPage lp = new LandingPage(driver);
		log.info("The pop will be closed");
		lp.closing().click();
		log.info("The pop is closed succesfully");
		lp.forms().click();
		log.info("Input Forms is selected");
		lp.checkboxpage();
	}

	@AfterTest
	public void closebrowser() {
		driver.close();

	}

	@Test
	public void Singlecheckboxform() {
		check = new checkboxDemo(driver);
		Assert.assertFalse(check.checkbox().isSelected());
		check.checkbox().click();
		String successmessage = check.checkboxstatus().getText();
		Assert.assertTrue(check.checkbox().isSelected());
		log.info(successmessage);

	}
	
	@Test
	public void multiplecheckbox()
	{
		 
		String beforestatus = check.checkall().getAttribute("value");
		Assert.assertEquals(beforestatus, "Check All");
		check.checkall().click();
		String afterstatus = check.checkall().getAttribute("value");
		Assert.assertEquals(afterstatus, "Uncheck All");
	}
}
