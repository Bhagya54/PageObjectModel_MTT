package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BasePage;

public class NewCarsPage extends BasePage {

	
	
	public NewCarsPage(WebDriver driver) {
		super(driver);
	}


	public void goToMaruti() {
		WebElement maruti = driver.findElement(By.xpath("//div[text()='Maruti Suzuki']"));
		maruti.click();
	}
	
	public void goToTata() {
		WebElement tata = driver.findElement(By.xpath("//div[text()='Tata']"));
		tata.click();
	}
	
	public void goToAudi() {
		WebElement audi = driver.findElement(By.xpath("//div[text()='Audi']"));
		audi.click();
	}
	
	public void goToToyota() {
		WebElement toyota = driver.findElement(By.xpath("//div[text()='Toyota']"));
		toyota.click();
	}
	
	public void goToBMW() {
		WebElement bmw = driver.findElement(By.xpath("//div[text()='BMW']"));
		bmw.click();
	}
	
	
}
