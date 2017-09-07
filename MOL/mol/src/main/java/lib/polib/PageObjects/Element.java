/**
 * 
 */
package lib.polib.PageObjects;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;

/**
 * @author pmahajan
 *
 */
public interface Element extends WebElement,WrapsElement, Locatable , SearchContext {
//boolean elementWired();
	void DoubleClick();
}
