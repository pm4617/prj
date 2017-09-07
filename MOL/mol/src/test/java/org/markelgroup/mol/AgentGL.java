package org.markelgroup.mol;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AgentGL {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
		 
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\moltest02\\Desktop\\Workspace\\mol\\src\\webdrivers\\gecko\\geckodriver.exe");
		driver =new FirefoxDriver();
    baseUrl = "https://external-molv2-int.test.mkltestna.com/quickquote";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAgentGL() throws Exception {
    driver.get("https://external-molv2-int.test.mkltestna.com/_layouts/Mkl.WB.Mol.FBA/Login.aspx?ReturnUrl=%2fquickquote%2f_layouts%2fAuthenticate.aspx%3fSource%3d%252Fquickquote&Source=%2Fquickquote");
    driver.findElement(By.id("ctl00_PlaceHolderMain_myLogin_Login1_UserName")).clear();
    driver.findElement(By.id("ctl00_PlaceHolderMain_myLogin_Login1_UserName")).sendKeys("efagan@210065_jimcor.com");
    driver.findElement(By.id("ctl00_PlaceHolderMain_myLogin_Login1_Password")).clear();
    driver.findElement(By.id("ctl00_PlaceHolderMain_myLogin_Login1_Password")).sendKeys("Markel19!");
    driver.findElement(By.id("ctl00_PlaceHolderMain_myLogin_Login1_LoginButton")).click();
    driver.get(baseUrl + "/quickquote");
    driver.findElement(By.id("search-box")).sendKeys("10060");
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.linkText("10060 - Army and Navy Stores")).isDisplayed()) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.linkText("10060 - Army and Navy Stores")).click();
    driver.findElement(By.cssSelector("strong")).click();
    driver.findElement(By.id("zip-code")).clear();
    driver.findElement(By.id("zip-code")).sendKeys("80103");
    driver.findElement(By.id("quickQuoteSubmit")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    driver.findElement(By.id("GlLine_RiskUnits_1__Exposure")).clear();
    driver.findElement(By.id("GlLine_RiskUnits_1__Exposure")).sendKeys("500");
    driver.findElement(By.cssSelector("div.ftWrapper.ftDot > div.ftOption")).click();
    driver.findElement(By.xpath("//form[@id='quickQuoteForm']/div[5]/div/div[2]/div/div/div/div/div")).click();
    driver.findElement(By.xpath("//form[@id='quickQuoteForm']/div[5]/div/div[2]/div/div/div/div[2]/div")).click();
    driver.findElement(By.cssSelector("div.input-column > div.check-row > div.ftWrapper.ftDot")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[7]")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.id("AccountName"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.id("AccountName")).clear();
    driver.findElement(By.id("AccountName")).sendKeys("Smoke Test GL Agent");
    driver.findElement(By.id("StreetAddress_Line1")).clear();
    driver.findElement(By.id("StreetAddress_Line1")).sendKeys("add");
    driver.findElement(By.id("StreetAddress_City")).clear();
    driver.findElement(By.id("StreetAddress_City")).sendKeys("city");
    new Select(driver.findElement(By.id("StreetAddress_StateCode"))).selectByVisibleText("Colorado");
    driver.findElement(By.id("StreetAddress_ZipCode")).clear();
    driver.findElement(By.id("StreetAddress_ZipCode")).sendKeys("80103");
    driver.findElement(By.xpath("//div[@id='contact-info']/div/div/div[12]/div/div")).click();
    driver.findElement(By.id("MailingAddress_StateCode")).click();
    driver.findElement(By.id("bind-quote")).click();
    try {
      assertEquals(driver.findElement(By.cssSelector("span.featured-value-amount")).getText(), "$500");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals(driver.findElement(By.cssSelector("span.policy-label")).getText(), "Policy Number:");
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
