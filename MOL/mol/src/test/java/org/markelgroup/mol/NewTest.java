package org.markelgroup.mol;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import lib.polib.PageObjects.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.jetty.util.URI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

public class NewTest extends BaseTest {

	// public static FirefoxDriver driver ;
	
	@Parameters({"testdata"})
	@Test(dataProvider = "testdata")
	public void logintest( String sUsername, String sPassword  ) {
		driver.get(URL1);
		//loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		stepone = new StepOne(driver);
		//LoginPage.action_login( sUsername,   sPassword);
		HomePage.createqq("10060","80103");
		stepone.effectiveDate().setDate("02012017");
		stepone.region().selectByVisibleText("Northeast");
		stepone.prod_search().sendKeys("210065");
		
		stepone.prod_contact().selectByVisibleText("Ellen Fagan");
		stepone.account_name().sendKeys("Paresh");
		stepone.SeondaryAccount().sendKeys("SecondaryAccountName");
		stepone.homestate().selectByVisibleText("Colorado");
	}
	
}
