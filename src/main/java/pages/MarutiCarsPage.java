package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BasePage;

public class MarutiCarsPage extends BasePage{

	
	
	public MarutiCarsPage(WebDriver driver) {
		super(driver);
		
	}

	public void getCarTitle() {
		WebElement title = driver.findElement(By.xpath("//h1"));
		System.out.println("Car Title is: "+ title.getText());
	}
}
