package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[text()='NEW CARS']")
	WebElement newCars;

	@FindBy(xpath="//div[text()='Find New Cars']")
	WebElement findNewCars;
	
	public NewCarsPage findNewCars() {
		//WebElement newCars = driver.findElement(By.xpath("//div[text()='NEW CARS']"));
		Actions act = new Actions(driver);
		act.moveToElement(newCars).perform();
		findNewCars.click();
		return new NewCarsPage(driver);
		
	}

	public void searchCars() {
		driver.findElement(By.xpath("//input[@placeholder='Type to select car name, e.g. Jeep Meridian']")).sendKeys("Maruti");
	}

	public void popularCars() {
		driver.findElement(By.xpath("//span[text()='Popular']")).click();
	}
}
