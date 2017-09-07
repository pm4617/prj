package lib.polib.PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.markelgroup.mol.BaseTest.driver;

public class smartLookup extends WebElementImpl {
	WebElementImpl FirstLookupRes;
	PropertyReader prop;
	By Bylink_typeahead_list;
	String Llink_typeahead_list ;
	
	public smartLookup(WebElement element) {
		super(element);
		// TODO Auto-generated constructor stub
		try {
			  prop = new PropertyReader("src/main/java/lib/polib/PageObjectProperties/typeaheadList.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  Llink_typeahead_list = prop.getProperty("mol.Llink_typeahead_list.xpath");
		
		  Bylink_typeahead_list = By.xpath(Llink_typeahead_list);
	}

		
	
	public smartLookup(By by) {
		super(by);
		try {
			  prop = new PropertyReader("src/main/java/lib/polib/PageObjectProperties/typeaheadList.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  Llink_typeahead_list = prop.getProperty("mol.link_typeahead_list.xpath");
		  Bylink_typeahead_list = By.xpath(Llink_typeahead_list);
	}

	public void sendKeys(String str) {

		sendKeys((CharSequence) str);
		 

		
		
		// 
		List <WebElement> LookupResults;
	
		WebDriverWait wt = new WebDriverWait(driver, 30);
		wt.until(ExpectedConditions.presenceOfElementLocated(Bylink_typeahead_list));
		
		
		LookupResults = driver.findElement(Bylink_typeahead_list).findElements(By.tagName("li"));
		if ( LookupResults.size() != 0)
		for (WebElement element1: LookupResults) {
				System.out.print(element1.getAttribute("data-value")+ "\n");
				element1.click();
				break;
				
		}
		else {
			System.out.println("No Result from Smart Lookup");

		}

		System.out.println("keysToSend from the smartLookup");

	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		element.sendKeys(keysToSend);
		// String l = "glob:" + keysToSend.toString()+"*";

	}
}
