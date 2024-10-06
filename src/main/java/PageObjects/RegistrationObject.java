package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationObject {
	
	public static  WebDriver driver;
	public static WebDriverWait wait;
	
	public static By Registerhere = By.xpath("//a[text()=' Register here!']");
	public static By getRegisterText = By.xpath("//h2[text()='Register']");
	public static By getEmailError = By.xpath("//label[@id='zippy_register_form_email-error']");
	public static By getPasswordError = By.xpath("//label[@id='exampleInputPass1-error']");
	public static By getNameError = By.xpath("//label[@id='exampleInputText1-error']");
	public static By RegSubmit = By.xpath("//form[@id='zippy_register_form']//following::button[@type='submit' and text()='Submit']");
	public static By Dashboard = By.xpath("//a[text()='My Forms']");
	
	
	public static By logo = By.xpath("//title[text()='Zippy Form']//following::img[1]");
	public static By RegPage = By.xpath("//a[text()=' Login here!']");
	
	public static By Loginpage = By.xpath("//h2[text()='Login']");
	
	public static By emailF= By.id("zippy_register_form_email");
	public static By passwordF=By.id("exampleInputPass1");
	public static By nameF=By.id("exampleInputText1");
	
	public void RefreshPage(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(logo));
		driver.get(driver.getCurrentUrl());
	}
	
	
	
	
	public void clickme(WebDriver driver , By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(element));
		field.click();
	}
	
	public static void EnterText(WebDriver driver,By element ,String text) {
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	    emailField.clear();
	    emailField.sendKeys(text);
	}
	
	
	public String getText(WebDriver driver , By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(element));
		String text=field.getText();
		return text;
	}
	
	public void clickhere(WebDriver driver ,String value)
	{
		if(value.equals("Register")) {
    		this.clickme(driver,Registerhere);
    	}else if(value.equals("email")) {
    	this.clickme(driver,Registerhere);
         }else if(value.equals("clickSubmit"))
         {this.clickme(driver, RegSubmit);
         }else if(value.equals("RegClick"))
         { this.clickme(driver, RegPage); }
	}
	
	public String getValueText(WebDriver driver , String value)
	{
		String text="";
		if(value.equals("getRegisterText")) {
    		 text=this.getText(driver,getRegisterText);
    	}else if(value.equals("email")) {
    	 text=this.getText(driver,getRegisterText);
         }else if(value.equals("emailerror")) {
    	 text=this.getText(driver,getEmailError);
         }else if(value.equals("passworderror")) {
    	 text=this.getText(driver,getPasswordError);
         }else if(value.equals("nameerror")) {
    	 text=this.getText(driver,getNameError);
         }else if(value.equals("lpage"))
         {text=this.getText(driver,Loginpage );}
         else if(value.equals("Dashboard")) {
        	 text=this.getText(driver, Dashboard);
         }
		return text;
	}
	
	
	public void  EnterValue(WebDriver driver , String value , String data)
	{
		String text="";
		if(value.equals("getRegisterText")) {
    		 text=this.getText(driver,getRegisterText);
    	}else if(value.equals("email")) {
    	 this.EnterText(driver, emailF, data);
         }else if(value.equals("password")) {
        	 this.EnterText(driver, passwordF, data);}
         else if(value.equals("name")) {
        	 this.EnterText(driver, nameF, data);}
         else if(value.equals("passworderror")) {
    	 text=this.getText(driver,getPasswordError);
         }else if(value.equals("nameerror")) {
    	 text=this.getText(driver,getNameError);
         }
	
	}
}
