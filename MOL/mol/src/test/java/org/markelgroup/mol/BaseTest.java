package org.markelgroup.mol;

import java.io.IOException;

import lib.polib.PageObjects.HomePage;
import lib.polib.PageObjects.LoginPage;
import lib.polib.PageObjects.PropertyReader;
import lib.polib.PageObjects.StepOne;
import lib.polib.PageObjects.WebDriverImpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class BaseTest {
	
	public static WebDriver driver;
	public LoginPage loginpage;
	public HomePage homepage;
	public StepOne stepone;
	public String URL1, browser, webdriverpath;
	long  timeoutseconds;

	
	
	 @DataProvider(name = "testdata")
	  public static Object[][] credentials() {

	        // The number of times data is repeated, test will be executed the same no. of times

	        // Here it will execute two times

	        return new Object[][] { { "efagan@210065_jimcor.com", "Markel19!" }};

	  }
 
	
	 
	@BeforeTest
	public void beforeTest() {
		try {
			PropertyReader pr = new PropertyReader(
					"src/main/java/config/molconfig.properties");
			URL1 = pr.getProperty("uwurl");
			browser = pr.getProperty("browser");
			webdriverpath = pr.getProperty(browser + "webdriverpath");
			timeoutseconds = Integer.parseInt(pr.getProperty("explicitetimeoutseconds"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (browser.equalsIgnoreCase(new String("chrome"))) {
			System.setProperty("webdriver.chrome.driver", webdriverpath);
			System.out.print("in Chrome Function");
			driver =   new ChromeDriver();
		}
		
		if (browser.equalsIgnoreCase(new String("firefox")))  {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.out.print("in firefox Function");
			WebDriver webdriver;
			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\moltest02\\Desktop\\Workspace\\mol\\src\\webdrivers\\gecko\\geckodriver.exe");
			driver = new FirefoxDriver(capabilities);
			 

		}
		//driver.manage().timeouts().implicitlyWait(timeoutseconds, TimeUnit.SECONDS);
		System.out.print(URL1);

		
		
	}

}
