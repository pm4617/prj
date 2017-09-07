package lib.polib.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class StepOne extends BasePage  {
	//public WebDriver driver;
	public static WebElementImpl account_name , HomeState,region, Secondary_acct_name;
	public static Select ddHomeState,ddregion,ddprod_contact;
	static calendarControl Cal_eff_date,Cal_exp_date;
	public static smartLookup prod_search;
	static String L_account_name , L_HomeState,L_region , L_secondary_acct_name,L_eff_date,
	L_exp_date,L_prod_search,L_prod_contact;
	
	static By Byaccount_name , ByHomeState, Byregion, BySecondary_acct_name,Byeff_date, Byexp_date,By_prod_search,By_prod_contact;

	public StepOne(WebDriver driver) {
		super(driver);
		BasePage.driver = driver;
		try {
			prop = new PropertyReader("src/main/java/lib/polib/PageObjectProperties/StepOne.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialiseObjects();
	}
	
	
	@Override
	public void initialiseObjects()
		{
		
		L_account_name = prop.getProperty("mol.L_account_name.id");
	 	Byaccount_name = By.id(L_account_name);
	 	
	 	L_HomeState = prop.getProperty("mol.L_HomeState.id");
	 	ByHomeState = By.id(L_HomeState);
	 	
	 	L_region= prop.getProperty("mol.L_region.id");
	 	Byregion = By.id(L_region);
	 	
	 	L_secondary_acct_name = prop.getProperty("mol.L_secondary_acct_name.id");
	 	BySecondary_acct_name = By.id(L_secondary_acct_name);
	 	

	 	L_eff_date = prop.getProperty("mol.L_eff_date.id");
	 	Byeff_date = By.id(L_eff_date);
	 	

	 	L_exp_date = prop.getProperty("mol.L_exp_date.id");
	 	Byexp_date = By.id(L_exp_date);
	 	

	 	L_prod_search = prop.getProperty("mol.L_prod_search.id");
	 	By_prod_search = By.id(L_prod_search);
	 	
	 	L_prod_contact =  prop.getProperty("mol.L_prod_contact.id");
	 	By_prod_contact = By.id(L_prod_contact);
	 	
	 	
	}
	
 	
public static WebElementImpl account_name() {
	account_name = new WebElementImpl(Byaccount_name);
	return account_name;

}

public static Select homestate() {
	//HomeState = new WebElementImpl(ByHomeState);
	Select ddHomeState = new Select(driver.findElement(ByHomeState));
	return ddHomeState;
}



public static Select region() {
	//HomeState = new WebElementImpl(ByHomeState);
	Select ddRegion = new Select(driver.findElement(Byregion));
	return ddRegion;
}

public static Select prod_contact() {
	//HomeState = new WebElementImpl(ByHomeState);
	Select ddprod_contact = new Select(driver.findElement(By_prod_contact));
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ddprod_contact;
}


public static WebElementImpl SeondaryAccount() {
	Secondary_acct_name = new WebElementImpl(BySecondary_acct_name);
	return Secondary_acct_name;

}


public static calendarControl effectiveDate() {
	Cal_eff_date = new calendarControl(Byeff_date);
	return  Cal_eff_date;

}


public static calendarControl expiryDate() {
	Cal_exp_date = new calendarControl(Byexp_date);
	return  Cal_exp_date;

}

public static smartLookup prod_search() {
	prod_search = new smartLookup(By_prod_search);
	return prod_search;

}


}
