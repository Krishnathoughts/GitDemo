package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimpleFormDemo {

	WebDriver driver;
	By SimpleFormDemo = By.xpath("//div[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[1]");
	By Inputfield1 = By.id("user-message");
	By showmessage = By.cssSelector("button[onclick='showInput();']");
	By usermessage = By.id("display");
	By Firstnumber = By.cssSelector("input[id='sum1']");
	By Secondnumber = By.cssSelector("input[id='sum2']");
	By addition = By.cssSelector("button[onclick='return total()']");
	By getTotal = By.id("displayvalue");

	public WebElement formdemo() {
		return driver.findElement(SimpleFormDemo);
	}

	public SimpleFormDemo(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement Input1() {
		return driver.findElement(Inputfield1);

	}

	public WebElement message() {
		return driver.findElement(showmessage);
	}

	public WebElement messageconfirmation() {
		return driver.findElement(usermessage);
	}

	public WebElement Firstnum() {
		return driver.findElement(Firstnumber);
	}

	public WebElement Secondnum() {
		return driver.findElement(Secondnumber);

	}

	public WebElement add() {
		return driver.findElement(addition);
	}

	public WebElement gettotal() {
		return driver.findElement(getTotal);
	}
}
