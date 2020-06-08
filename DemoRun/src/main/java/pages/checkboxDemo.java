package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkboxDemo

{

	WebDriver driver;

	By checkboxPage = By.linkText("Checkbox Demo");
	By checkbox = By.id("isAgeSelected");
	By checkstatus = By.id("txtAge");
	By checkallbutton = By.id("check1");

	public checkboxDemo(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement checkboxpage() {
		return driver.findElement(checkboxPage);
	}

	public WebElement checkbox() {
		return driver.findElement(checkbox);
	}

	public WebElement checkboxstatus() {
		return driver.findElement(checkstatus);
	}

	public WebElement checkall() {
		return driver.findElement(checkallbutton);
	}

}
