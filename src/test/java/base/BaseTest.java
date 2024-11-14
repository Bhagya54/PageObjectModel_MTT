package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import extentlisteners.ExtentListeners;
import utility.ExcelReader;

public class BaseTest {

	/*
	 * WebDriver
	 * implicit 
	 * explicit 
	 * TestNG
	 * log4j
	 * properties
	 * apache poi
	 * screenshot
	 * keyword
	 * extent reports
	 * 
	 * Sequencial Approach
	 * Open browser
	 * testcase1
	 * testcase2
	 * .
	 * .
	 * tesctcase4
	 * close browser
	 * 
	 * End to End Approach
	 * open browser
	 * testcase1
	 * close browser
	 * 
	 * open browser
	 * testcase2
	 * close browser
	 */
	
	public static  WebDriver driver;
	public  FileInputStream fis;
	public  Properties config = new Properties();
	public  Properties or = new Properties();
	public  ExcelReader excel = new ExcelReader("./src/test/resources/excel/testData.xlsx");
	public  Logger log=Logger.getLogger(BaseTest.class);
	public  WebDriverWait wait;
	
	public void setUp(String browser) {
		
		try {
			fis=new FileInputStream(".//src//test//resources//properties//log4j.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PropertyConfigurator.configure(fis);
		
		try {
			fis = new FileInputStream("./src/test/resources/properties/config.properties");
			config.load(fis);
			log.info("Config properties file has been loaded");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fis = new FileInputStream("./src/test/resources/properties/or.properties");
			or.load(fis);
			log.info("OR properties file has been loaded");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			log.info("Chrome Browser has been launched");
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			log.info("Firefox Browser has been launched");
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			log.info("Edge Browser has been launched");
		}
		
		driver.manage().window().maximize();
		log.info("Maximized the browser");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		wait=new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
		driver.get(config.getProperty("testsiteurl"));
		log.info("Opened the site url " + config.getProperty("testsiteurl"));
		
		
		
		
	}
	
	public void click(String keyword) {
		try {
		getWebElement(keyword).click();
		log.info("Clicked on : " + keyword);
		ExtentListeners.test.info("Clicked on : " + keyword);
		}
		catch (Exception e) {
			log.error(e.getMessage());
			log.error("Unable to click on " + keyword);
			ExtentListeners.test.fail(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	public void type(String keyword, String value) {
		try {
		getWebElement(keyword).clear();
		getWebElement(keyword).sendKeys(value);
		log.info("Typed in the textbox: " + keyword + " with value as : " + value);
		ExtentListeners.test.info("Typed in the textbox: " + keyword + " with value as : " + value);
		}
		catch (Exception e) {
			log.error(e.getMessage());
			log.error("Unable to type on " + keyword);
			ExtentListeners.test.fail(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	public void select(String keyword, String value) {
		try {
			WebElement ele = getWebElement(keyword);
		Select s = new Select(ele);
		s.selectByVisibleText(value);
		
		log.info("Selected the dropdown: " + keyword + " with visisble text as : " + value);
		ExtentListeners.test.info("Selected the dropdown: " + keyword + " with visisble text as : " + value);
		}
		catch (Exception e) {
			log.error(e.getMessage());
			log.error("Unable to select the value" + keyword);
			ExtentListeners.test.fail(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	public WebElement getWebElement(String keyword) {

		WebElement ele = null;
		if (keyword.endsWith("_ID")) {
			ele = driver.findElement(By.id(or.getProperty(keyword)));
		} else if (keyword.endsWith("_NAME")) {
			ele = driver.findElement(By.name(or.getProperty(keyword)));
		} else if (keyword.endsWith("_XPATH")) {
			ele = driver.findElement(By.xpath(or.getProperty(keyword)));
		} else if (keyword.endsWith("_CSS")) {
			ele = driver.findElement(By.name(or.getProperty(keyword)));
		} else if (keyword.endsWith("_CLASS")) {
			ele = driver.findElement(By.className(or.getProperty(keyword)));
		}
		
		return ele;
	}
	
	public boolean isElementPresent(String keyword) {
		
		try {
			getWebElement(keyword);
			return true;
		}
		catch (Exception e) {
			log.error(e.getMessage());
			log.error("Unable to locate the element " + keyword);
			ExtentListeners.test.fail(e.getMessage());
			//Assert.fail(e.getMessage());
			return false;
		}
	}
	
	
	  @AfterMethod 
	  public void tearDown() {
		  
		  driver.quit();
	  
	  }
	 
}
