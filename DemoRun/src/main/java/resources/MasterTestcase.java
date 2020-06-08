package resources;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.SimpleFormDemo;
import pages.checkboxDemo;
import resources.TestBase;



public class MasterTestcase extends TestBase
{
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(MasterTestcase.class.getName());
	
	
	@BeforeMethod
	public void launchbrowser() throws IOException
	{
		
		driver = browseropen();
		log.info("The browser is opened succesfully");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		LandingPage lp=new LandingPage(driver);
		log.info("The pop will be closed");
		lp.closing().click();
		log.info("The pop is closed succesfully");
		lp.forms().click();
		log.info("Input Forms is selected");
		}
	
	
	@Test
	public void SimpleformTest1()
	{
		SimpleFormDemo demo= new SimpleFormDemo(driver);
		demo.formdemo().click();
		log.info("Enter the message");
		demo.Input1().sendKeys(prop.getProperty("FirstInput"));
		demo.message().click();
		String textmessge = demo.messageconfirmation().getText();
		log.info("Verify whether the message is as expected");
		Assert.assertEquals(textmessge, prop.getProperty("FirstInput"));
			
	}
	
	
	@Test
	public void SimpleformTest2()
	{
		SimpleFormDemo demo= new SimpleFormDemo(driver);
		demo.formdemo().click();
		String firstvalue =prop.getProperty("firstvalue");
		log.info("Enter the second number");
		String secondvalue= prop.getProperty("secondvalue");
		int output = Integer.parseInt(firstvalue)+Integer.parseInt(secondvalue);
		System.out.println(output);
		demo.Firstnum().sendKeys(firstvalue);
		demo.Secondnum().sendKeys(secondvalue);
		demo.add().click();
		String actualresult =demo.gettotal().getText();
		int actualvalue = Integer.parseInt(actualresult);
		log.info("Verify whether the value is as expected");
		Assert.assertEquals(actualvalue, output);
	}
	
	@AfterMethod
	public void closebrowser()
	{
		driver.close();
		
	}
	
	
	@Test
	public void checkboxform()
	{
		checkboxDemo check = new checkboxDemo(driver);
		check.checkboxpage().click();
		
			Assert.assertFalse(check.checkbox().isSelected());
			check.checkbox().click();
			String successmessage = check.checkboxstatus().getText();
			Assert.assertTrue(check.checkbox().isSelected());
			log.info(successmessage);
				
	}
	
	@Test
	public void checkalltestcase()
	{
		checkboxDemo check = new checkboxDemo(driver);
		check.checkboxpage().click();
		String beforestatus = check.checkall().getAttribute("value");
		System.out.println(beforestatus);
		Assert.assertEquals(beforestatus, "Check All");
		check.checkall().click();
		String afterstatus = check.checkall().getAttribute("value");
		System.out.println(afterstatus);
		Assert.assertEquals(afterstatus, "Uncheck All");
		
	}

}
