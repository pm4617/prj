package lib.polib.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.FindsByXPath;

public class CustomLocator extends By {

	@Override
	public List<WebElement> findElements(SearchContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	public static By byLabel(final String label)
	{
	  return new By() {
	    @Override
	    public List<WebElement> findElements(final SearchContext context)
	    {
	      final String xpath =
	         "//*[@id = //label[text() = \"" + label + "\"]/@for]";
	      return ((FindsByXPath) context).findElementsByXPath(xpath);
	    }
	 
	    @Override
	    public WebElement findElement(final SearchContext context)
	    {
	      String xpath =
	        "id(//label[text() = \"" + label + "\"]/@for)";
	      return ((FindsByXPath) context).findElementByXPath(xpath);
	    }
	 
	    @Override
	    public String toString()
	    {
	      return "ByLabel: " + label;
	    }
	  };
	}
	
}
