package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage

{
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	WebDriver driver;

	By close = By.cssSelector("#at-cv-lightbox-close");
	By Inputforms = By.xpath("//div[@id='navbar-brand-centered']/ul[1]/li[1]");
	By checkboxPage = By.linkText("Checkbox Demo");

	By home = By.linkText("Demo Home");

	public WebElement closing() {
		return driver.findElement(close);
	}

	public WebElement forms() {
		return driver.findElement(Inputforms);
	}

	public WebElement homepage() {
		return driver.findElement(home);
	}
	
	public LandingPage checkboxpage()
	{
		driver.findElement(checkboxPage).click();
		LandingPage lp= new LandingPage(driver);
		return lp;
		
	}

}
