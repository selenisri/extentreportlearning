package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUserPage {
	
	static WebDriver  driver;
	

	By np = By.id("password");

	    public AddUserPage(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    public static void Sendkeys(By Element , String Text) {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, 20);
	 	    WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
	 	    emailField.sendKeys(Text);
	    }
	    
	    public static void Enter()
	    {
	    	driver.findElement(By.id("exampleInputEmail1")).sendKeys("Hello");
	    }
	    
	    
	    
	    
	    public void EnterText(String value)
	    {
	    	if(value.equals("NewPassword")) {
	    		this.Sendkeys(np, "Hello@123");
	    	}
	    	
	    }
	    
	    

}
