package lib.polib.PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.markelgroup.mol.BaseTest.driver;

public class calendarControl extends WebElementImpl {
	//WebElementImpl element;
	PropertyReader prop;
	String L_date_switcher,L_month,L_Day,L_datepicker2;
	By By_date_switcher,By_month,By_Day,By_datepicker2;
	//String Llink_typeahead_list ;
	
	public calendarControl(WebElement element) {
		super(element);
		/*// TODO Auto-generated constructor stub
		try {
			  prop = new PropertyReader("src/main/java/lib/polib/PageObjectProperties/StepOne.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  Llink_typeahead_list = prop.getProperty("mol.Llink_typeahead_list.xpath");
		
		  Bylink_typeahead_list = By.xpath(Llink_typeahead_list);*/
	}

		
	
	public calendarControl(By by) {
		super(by);
		try {
			  prop = new PropertyReader("src/main/java/lib/polib/PageObjectProperties/calendarControl.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		L_date_switcher = prop.getProperty("mol.L_datepicker_switch.css");
		L_month =  prop.getProperty("mol.L_month.css");
		L_Day = prop.getProperty("mol.L_day.css");
		L_datepicker2 = prop.getProperty("mol.datepicker_switch.xpath");
		
		  
		By_date_switcher = By.cssSelector(L_date_switcher);
		By_month = By.cssSelector(L_month);
		By_Day = By.cssSelector(L_Day);
		By_datepicker2=By.xpath(L_datepicker2);	  		  
	}

	public void sendKeys(String str) {

		sendKeys((CharSequence) str);
		 

		/*for (int second = 0;; second++) {
			if (second >= 10)
				break;
			try {
				if (driver.findElement(Bylink_typeahead_list) != null)
					break;
			} catch (Exception e) {
			}
			try {
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("No Result from Smart Lookup");
				e.printStackTrace();
			}
		}*/
		
		// 
		

	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		element.sendKeys(keysToSend);
		// String l = "glob:" + keysToSend.toString()+"*";

	}
	
	
	public void setYear(String yr) {
		this.element.click();
		this.findElement(By_date_switcher).click();
		
		this.findElement(By_datepicker2).click();
		
		this.findElement(By.xpath("*//td/span[ .="+yr+"]")).click();;
		
		
	}
	
public void setMonth(String month) {
	
	if(month.substring(0,1)=="0") {
		month= month.substring(1,1);
		
	}
	this.findElement(By.xpath("//html/body/div[3]/div[2]/table/tbody/tr/td/span["+month+"]")).click();;
	
		
	}
	

public void setDay(String day) {
	if(day.substring(0,1)=="0") {
		day= day.substring(1,1);
		
	}
	this.findElement(By.xpath("//td[@class='day' and .="+day+"]")).click();; 
}
	
public void setDate(String mmddyyyy) {

	String yyyy = mmddyyyy.substring(4, 8);
	String dd = mmddyyyy.substring(2, 4);
	String mm = mmddyyyy.substring(0, 2);
	System.out.println("--------------------------");
	System.out.println(yyyy);
	System.out.println(dd);
	System.out.println(mm);
	setYear(yyyy);
	setMonth(mm);
	setDay(dd);
	
 }
	


}
