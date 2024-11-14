package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class NewCarsPage extends BasePage {

	
	
	public NewCarsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//div[text()='Maruti Suzuki']")
	WebElement maruti;
	
	@FindBy(xpath="//div[text()='Tata']")
	WebElement tata;
	
	@FindBy(xpath="//div[text()='Audi']")
	WebElement audi;
	
	@FindBy(xpath="//div[text()='Toyota']")
	WebElement toyota;
	
	@FindBy(xpath="//div[text()='BMW']")
	WebElement bmw;

	public MarutiCarsPage goToMaruti() {
		//WebElement maruti = driver.findElement(By.xpath("//div[text()='Maruti Suzuki']"));
		maruti.click();
		return new MarutiCarsPage(driver);
	}
	
	public TataCarsPage goToTata() {
		WebElement tata = driver.findElement(By.xpath("//div[text()='Tata']"));
		tata.click();
		return new TataCarsPage(driver);
	}
	
	public AudiCarsPage goToAudi() {
		WebElement audi = driver.findElement(By.xpath("//div[text()='Audi']"));
		audi.click();
		return new AudiCarsPage(driver);
	}
	
	public ToyotaCarsPage goToToyota() {
		WebElement toyota = driver.findElement(By.xpath("//div[text()='Toyota']"));
		toyota.click();
		return new ToyotaCarsPage(driver);
	}
	
	public BMWCarsPage goToBMW() {
		WebElement bmw = driver.findElement(By.xpath("//div[text()='BMW']"));
		bmw.click();
		return new BMWCarsPage(driver);
	}
	
	
}
