package Com.W2a.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.ExcelReader;
import utilities.ExtentManager;
import utilities.Utilities1;

public class Page {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\Com\\W2a\\Excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static TopMenu menu;
	
	public Page() {
		if (driver==null) 
		

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Com\\W2a\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Com\\W2a\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//This is for Jenkins browser configuration 
if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){
				
				browser = System.getenv("browser");
			}else{
				
				browser = config.getProperty("browser");
				
			}
			
			config.setProperty("browser", browser);
			

			if (config.getProperty("browser").equals("firefox")) {

				// System.setProperty("webdriver.gecko.driver", "gecko.exe");
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\Com\\W2a\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("Chrome Launched !!!");
		
		System.setProperty("webdriver.chrome.driver","C://Users//Abhishek//Desktop//Selenium project//New Sel//chromedriver.exe");
		driver=new ChromeDriver();
		

		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to : " + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 5);
		menu=new TopMenu(driver);
			}
		}
	
		public static void Quit() {
			driver.quit();
		}

	
		public void click(String locator) {

			if (locator.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
			} else if (locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locator))).click();
			} else if (locator.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(locator))).click();
			}
			log.debug("clicking on an Elmenet on locator");
			test.log(LogStatus.INFO, "Clicking on : " + locator);
		}

		public void type(String locator, String value) {

			if (locator.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
			}
			log.debug("Typing in an Elemnet : "+locator+" entred Value as : +Value");

			test.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + value);

		}
		
		static WebElement dropdown;

		public void select(String locator, String value) {

			if (locator.endsWith("_CSS")) {
				dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
			} else if (locator.endsWith("_XPATH")) {
				dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
			} else if (locator.endsWith("_ID")) {
				dropdown = driver.findElement(By.id(OR.getProperty(locator)));
			}
			
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);
			log.debug("Select  in an Elemnet : "+locator+" entred Value as : +Value");

			test.log(LogStatus.INFO, "Selecting from dropdown : " + locator + " value as " + value);

		}

		public boolean isElementPresent(By by) {

			try {

				driver.findElement(by);
				return true;

			} catch (NoSuchElementException e) {

				return false;

			}

		}

		public static void verifyEquals(String expected, String actual) throws Exception  {

			try {

				Assert.assertEquals(actual, expected);

			} catch (Throwable t) {
				
				Utilities1.captureScreenshot();
				// ReportNG
				Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + Utilities1.screenshotName + "><img src=" + Utilities1.screenshotName
						+ " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");
				// Extent Reports
				test.log(LogStatus.FAIL, " Verification failed with exception : " + t.getMessage());
				test.log(LogStatus.FAIL, test.addScreenCapture(Utilities1.screenshotName));

			}

		
	}
}
	

