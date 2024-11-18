package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import pages.AudiCarsPage;
import pages.BMWCarsPage;
import pages.HomePage;
import pages.MarutiCarsPage;
import pages.NewCarsPage;
import pages.TataCarsPage;
import pages.ToyotaCarsPage;
import utility.DataUtils;

public class CarModelAndPricesTest extends BaseTest {

	@Test(dataProviderClass = DataUtils.class,dataProvider = "Data")
	public void carModelAndPrice(String browser,String run,String carBrand) {
		if(run.equals("N")) {
			throw new SkipException("Skipping the test as runmode is N");
		}
		setUp(browser);
		
		HomePage home = new HomePage(driver);
		NewCarsPage newCar = home.findNewCars();
		
		if(carBrand.equals("maruti")) {
			MarutiCarsPage maruti=newCar.goToMaruti();
			
		}
		
		else if(carBrand.equals("bmw")) {
			BMWCarsPage bmw=newCar.goToBMW();
			
		}
		
		else if(carBrand.equals("toyota")) {
			ToyotaCarsPage toyota=newCar.goToToyota();
			
		}
		else if(carBrand.equals("tata")) {
			TataCarsPage tata=newCar.goToTata();
			
		}
		else if(carBrand.equals("audi")) {
			AudiCarsPage audi=newCar.goToAudi();
			
		}
		
		BasePage.carBase.getCarModelAndPrice();
		
		
	}
}
