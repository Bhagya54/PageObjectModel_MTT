package base;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarBase {
	WebDriver driver;

	@FindBy(xpath="//h1")
	WebElement title;
	
	@FindBy(xpath="//h3")
	List<WebElement> carModels;
	
	@FindBy(xpath="//span[@class='o-cJrNdO o-byFsZJ o-bkmzIL o-bVSleT ']")
	List<WebElement> carPrices;
	
	public CarBase(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getCarTitle() {
		//WebElement title = driver.findElement(By.xpath("//h1"));
		System.out.println("Car Title is: "+ title.getText());
		return title.getText();
	}
	
	public void getCarModelAndPrice() {
		
		for(int i=0;i<carPrices.size();i++) {
			System.out.println("Car Model: " + carModels.get(i).getText());
			System.out.println("Car Price: " + carPrices.get(i).getText());
		}
	}
}
