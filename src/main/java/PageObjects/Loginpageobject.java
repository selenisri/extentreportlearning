package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Loginpageobject {
 
	
	public static  WebDriver driver;
	public static WebDriverWait wait;
	
	
	@FindBy(name="email")
	public static WebElement emailw;
	
	@FindBy(name="password")
	public static WebElement passwordw;
	
	@FindBy(xpath="/html/body/div/div/div/form/div[4]/button")
	public static WebElement Buttonw;
	
	
	
	static int num=2;
	
	public static By email = By.name("email");
	public static By password = By.name("password");
	public static By Button = By.xpath("//button[contains(text(),'Login')]");
	public static By getEmail = By.xpath("//p[contains(text(),'teddy@mailinator.com')]");
	public static By EmailError = By.id("exampleInputEmail1-error");
	public static By PasswordError = By.id("exampleInputPass1-error");
	

	//int num = 123; // Replace 123 with your actual dynamic integer value
	static String xpath = String.format("//*[@id='billing_history_table_tbody']//tr[%d]//td[2]", num);
	
	public static By getLastRowDate = By.xpath(xpath);
	 
	
	public static void EnterText(WebDriver driver, String text) {
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
	    emailField.sendKeys(text);
	}
	
	public static void EnterPassword(WebDriver driver, String text) {
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
	    emailField.sendKeys(text);
	}

	
	public static void ClickSubmit(WebDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(Button));
	    emailField.click();
	}
	
	public static String getEmail(WebDriver driver)
	{
		
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(getEmail));
		    return emailField.getText();
		
	}
	
	
	public static String getEmailError(WebDriver driver)
	{
		
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(EmailError));
		    return emailField.getText();
		
	}
	
	public static String getPasswordError(WebDriver driver)
	{
		
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordError));
		    return emailField.getText();
		
	}
	
	public  void clearField(WebDriver driver , By element)
	{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
		 WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		 field.clear();
		
	}
	
	
	
	
	public static String getLastRowDate(WebDriver driver) throws InterruptedException
	{
		
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(getLastRowDate));
		    Thread.sleep(5000);;
		    return emailField.getText();
		
	}

	
	 public  void clearFields(WebDriver driver ,String value )
	    {
	    	if(value.equals("Password")) {
	    		this.clearField(driver,password);
	    	}else if(value.equals("email")) {
	    	this.clearField(driver,email);
	         }
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static WebElement Submit(WebDriver driver)
//	{
//	  return driver.findElement(By.xpath("/html/body/div/div/div/form/div[4]/button"));
//	}
//	
//	public static WebElement EnterPassword(WebDriver driver)
//	{
//	  return driver.findElement(By.name("password"));
//	}
//
//	public static WebElement EnterEmail(WebDriver driver) {
//	
//		
//		return driver.findElement(By.name("email"));
//		
//	}




	
	

}
