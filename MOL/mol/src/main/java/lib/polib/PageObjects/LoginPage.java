package lib.polib.PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends BasePage {

	//public static WebDriver driver;
	// @FindBy(how=How.CSS, using="#lst-ib")
	//public static WebElement searchtextbox1;
	
	public static WebElementImpl login , password ,loginbutton;
		
	static String Llogin , Lpassword , Lloginbutton;  
	
	static By Bylogin , Bypassword , Byloginbutton  ;

 

	static By Lsearchtextbox = By.cssSelector("#lst-ib");
	// static By Luserid = By.id("username");
	// static By Lpassword = By.id("password");
	// static By Lloginbutton = By.id("submit");
	
	 
	public LoginPage(WebDriver driver) {
		super(driver);
		BasePage.driver = driver;
		try {
			prop = new PropertyReader("src/main/java/lib/polib/PageObjectProperties/LoginPage.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialiseObjects();
		//searchtextbox1= driver.findElement(Lsearchtextbox);
		//searchtextbox1.click();
			
	}
	
	@Override
	public void initialiseObjects()
	{
		Llogin = prop.getProperty("mol.login.id");
	 	Lpassword =  prop.getProperty("mol.password.id");
		Lloginbutton = prop.getProperty("mol.loginbutton.id");
		
		
		Bylogin = By.id(Llogin);
		Bypassword = By.id(Lpassword);
		Byloginbutton = By.id(Lloginbutton);
		
	}

	 	
	public static WebElementImpl txt_loginid() {
		login = new WebElementImpl(Bylogin);
		return login;

	}

	public static WebElementImpl txt_password() {
		password = new WebElementImpl(Bypassword);
		return password;

	}
	
	public static WebElementImpl btn_login() {
		loginbutton = new WebElementImpl( Byloginbutton);
		return loginbutton;

	}
	
	public static HomePage action_login(String sUsername, String sPassword){
		txt_loginid().sendKeys(sUsername);
		txt_password().sendKeys(sPassword);
		btn_login().click();
		
		return new HomePage(driver);
	}
 

}