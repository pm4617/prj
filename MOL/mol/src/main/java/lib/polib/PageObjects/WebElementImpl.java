package lib.polib.PageObjects;

import java.util.List;

import lib.polib.PageObjects.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.markelgroup.mol.BaseTest.driver;

import java.lang.annotation.*;

public class WebElementImpl implements Element   {
 
	public  final WebElement element;
	public WebDriverWait wait;
 	
	public WebElementImpl( final WebElement element){
		this.element =element;
	}
	
	public WebElementImpl( final By by){
		this.element = findElement(by);
		
	}
	
	
 /* (non-Javadoc)
	 * @see org.openqa.selenium.internal.Locatable#getCoordinates()
	 */
	public Coordinates getCoordinates() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openqa.selenium.internal.WrapsElement#getWrappedElement()
	 */
	public WebElement getWrappedElement() {
		// TODO Auto-generated method stub
		return null;
	}

 public void click() {
		// TODO Auto-generated method stub
		element.click();
		System.out.println("Clicked from the WebElementImpl");
 
		 
	}

	public void submit() {
		// TODO Auto-generated method stub

	}

	public void sendKeys(CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		element.sendKeys(keysToSend);
		
		System.out.println("keysToSend from the WebElementImpl");
	 
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public String getTagName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return driver.findElements(by);	}

	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		
		 wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		System.out.println("findElement from the WebElementImpl");
		//flash(driver.findElement(by));
		return driver.findElement(by);
		
		 
	}

	//*******- To be moved to helper *///////
	public static void flash(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor  = element.getCssValue("backgroundColor");
        for (int i = 0; i <  3; i++) {
            changeColor("rgb(0,200,0)", element, js);
            changeColor(bgcolor, element, js);
        }
    }
    public static void changeColor(String color, WebElement element,  JavascriptExecutor js) {
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);
        js.executeScript("arguments[0].style.border = '3px solid "+color+"'",  element);
        //js.executeScript("arguments[0].style.border = '3px solid red'",  element);
        js.executeScript("arguments[0].style.borderColor = '"+color+"'",  element);
        try {
            Thread.sleep(200);
        }  catch (InterruptedException e) {
        }
     }
	
	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCssValue(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean elementWired() {
		// TODO Auto-generated method stub
		return false;
	}


	public void DoubleClick() {
		// TODO Auto-generated method stub
		
	}

}
