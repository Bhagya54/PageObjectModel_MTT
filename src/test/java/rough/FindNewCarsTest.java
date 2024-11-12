package rough;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;
import pages.MarutiCarsPage;
import pages.NewCarsPage;

public class FindNewCarsTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.carwale.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		HomePage home = new HomePage(driver);
		home.findNewCars();
		
		
		NewCarsPage newCar = new NewCarsPage(driver);
		newCar.goToMaruti();
		
		
		MarutiCarsPage maruti = new MarutiCarsPage(driver);
		maruti.getCarTitle();
		
		
	}

}
