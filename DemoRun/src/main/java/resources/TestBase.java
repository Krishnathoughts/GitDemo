package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase 
{
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver browseropen() throws IOException
	{
		 prop = new Properties();
		String path = System.getProperty("user.dir")+("//src//main//java//resources//data.properties");
		FileInputStream file = new FileInputStream(path);
		prop.load(file);
		String browsername=System.getProperty("browser");
		//String browsername = prop.getProperty("browser");
		String chromedriver= System.getProperty("user.dir")+"\\chromedriver.exe";
		String firefoxdriver = System.getProperty("user.dir")+"\\geckodriver.exe";
		String iedriver = System.getProperty("user.dir")+"\\IEDriverServer.exe";
		
		if(browsername.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", chromedriver);
			ChromeOptions option = new ChromeOptions();
			if(browsername.contains("headless"))
			{
			option.addArguments("--headless"); 
			}
			
			driver = new ChromeDriver(option);
		}			
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", firefoxdriver);
			 driver = new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",iedriver);
			 driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
}
	public String getscreenshot(String testcasename, WebDriver driver) throws IOException
	{
	TakesScreenshot screenshot = (TakesScreenshot) driver;
	File source = screenshot.getScreenshotAs(OutputType.FILE);
	String Destination = System.getProperty("user.dir")+ "\\reports\\"+testcasename+".png";
	FileUtils.copyFile(source, new File(Destination));	
	return Destination;
	
		
		
		
	}
}
