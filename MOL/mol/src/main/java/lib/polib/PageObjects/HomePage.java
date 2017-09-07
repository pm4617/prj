package lib.polib.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lib.*;
 

public class HomePage extends BasePage {
	public static WebDriver driver;
	// @FindBy(how=How.CSS, using="#lst-ib")
	//public static WebElement searchtextbox1;
	
	public static WebElementImpl  txt_zip,btn_qqsubmit;
	public static smartLookup txt_search;
	static String  Ltxt_search , Ltxt_zip,Lbtn_qqsubmit;  
	
	static By  Bytxt_search , Bytxt_zip,Bybtn_qqsubmit;


	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		try {
			prop = new PropertyReader("src/main/java/lib/polib/PageObjectProperties/HomePage.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialiseObjects();
		//searchtextbox1= driver.findElement(Lsearchtextbox);
		//searchtextbox1.click();
			
	}
	

	public void initialiseObjects()
	{
		Ltxt_search = prop.getProperty("mol.txt_search.id");
		Ltxt_zip =  prop.getProperty("mol.txt_zip.id");
		Lbtn_qqsubmit = prop.getProperty("mol.btn_qqsubmit.id");
		
		Bytxt_search = By.id(Ltxt_search);
		Bytxt_zip = By.id(Ltxt_zip);
		Bybtn_qqsubmit = By.id(Lbtn_qqsubmit);
		
	}

	 	
	public static smartLookup txt_search() {
		txt_search = new smartLookup(Bytxt_search);
		return txt_search;

	}
	

 	
	public static WebElementImpl txt_zip() {
		txt_zip = new WebElementImpl(Bytxt_zip);
		return txt_zip;

	}
	
 	
	public static WebElementImpl btn_qqsubmit() {
		btn_qqsubmit = new WebElementImpl(Bybtn_qqsubmit);
		return btn_qqsubmit;

	}
	

	public static StepOne createqq (String sClasscode, String sZIP){
		txt_search().sendKeys(sClasscode);
		txt_zip().sendKeys(sZIP);
		btn_qqsubmit().click();
		
		return new StepOne(driver);
	}
 
	
	
	}
	 
 