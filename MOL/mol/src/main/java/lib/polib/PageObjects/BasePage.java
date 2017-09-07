package lib.polib.PageObjects;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	public static  WebDriver driver;
	public PropertyReader prop ;
	
	public BasePage(WebDriver driver)
	{
	BasePage.driver = driver;	
	}
	
	public void initialiseObjects()
	{
		int i = 1;
	}
	
	public boolean clickme()
	{
		System.out.println("Clicked Me ");
		
		
		return true;
 
		
	}
	
	
	public boolean type()
	{
		// find element , check precondition type in it { 
		
		return true;
		
		// else return false ;
		
		
	}
}
