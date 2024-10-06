package PageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateFormObject {

	public static  WebDriver driver;
	public static WebDriverWait wait;
	
	public static By Registerhere = By.xpath("//a[text()=' Register here!']");
	public static By getRegisterText = By.xpath("//h2[text()='Register']");
	public static By createbtn = By.xpath("//span[@id='form_name_hello']//following::button[2]");
	public static By crtformtext = By.xpath("//h5[@id='exampleModalLgLabel' and text()='Create a new form']");
	public static By clickcreateform = By.xpath("//h6[text()='Create from scratch']");
	public static By untitledform = By.xpath("//h4[@id='formname_title']");
	public static By pentool = By.xpath("//div[@id='zippy_form_status']//preceding::div[1]");
	public static By nextfinish = By.xpath("//button[text()='Finish' or text()='Next']");
	public static By Dashboard = By.xpath("//a[text()='My Forms']");
	public static By formname =By.id("formnameinput");
	public static By formupdate =By.xpath("//input[@id='formnameinput']//following::button[1]");
	public static By toastMessage = By.id("toast_type");
	public static By closeToast = By.xpath("//div[@id='toast_type']//following-sibling::button[1]");
	public static By back = By.xpath("//div[@id='zippy_form_status']//preceding::div[3]");
	
	public  String textField() throws IOException {
	Properties properties = new Properties();
	FileInputStream fileInputStream = new FileInputStream("config.properties");
	properties.load(fileInputStream);
	 return properties.getProperty("value");
	
	}
	 public String getListName(WebDriver driver) throws IOException {
	        String dynamicTextn = textField();
	        System.out.println(dynamicTextn);
	        By lname=By.xpath(String.format("//h6[contains(text(),'%s')]", dynamicTextn));
	        WebDriverWait wait = new WebDriverWait(driver, 20);
	 		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(lname));
	 	  return field.getText();
	    }
	
	public void RefreshPage(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//WebElement field = wait.until(ExpectedConditions.elementToBeClickable(logo));
		driver.get(driver.getCurrentUrl());
	}
	
	public static boolean isVisible(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		try {
		boolean field = wait.until(ExpectedConditions.visibilityOfElementLocated(nextfinish)).isDisplayed();
		return field;
		}catch (Exception e) {
	        // If the element is not found or not visible, return false
	        return false;
	    }
    	
	}
	
	public static boolean isVisibleField(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try {
		boolean field = wait.until(ExpectedConditions.visibilityOfElementLocated(formname)).isDisplayed();
		return field;
		}catch (Exception e) {
	        // If the element is not found or not visible, return false
	        return false;
	    }
    	
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
	
	
	
	
	public String getAttributeValue(WebDriver driver , By element ,String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(element));
		String text=field.getAttribute(value);
		return text;
	}
	
	public String getTextBoxValue(WebDriver driver , String value)
	{
		String text="";
		if(value.equals("getRegisterText")) {
    		 text=this.getText(driver,formname);
    	}else if(value.equals("email")) {
    	 text=this.getText(driver,formname);
         }
		return text;
	}
	
	public String getValueText(WebDriver driver , String value)
	{
		String text="";
		if(value.equals("getRegisterText")) {
    		 text=this.getText(driver,getRegisterText);
    	}else if(value.equals("email")) {
    	 text=this.getText(driver,getRegisterText);
         }else if(value.equals("Dashboard")) {
        	 text=this.getText(driver, Dashboard);
         }else if(value.equals("formlable")) {
        	 text=this.getText(driver, crtformtext);
         }else if(value.equals("untitledform"))
         {text = this.getText(driver, untitledform); }
         else if (value.equals("getToast"))
         {text = this.getText(driver, toastMessage); }
         
		return text;
	}
	
	public void clickhere(WebDriver driver ,String value)
	{
		if(value.equals("ClikCreateForm")) {
    		this.clickme(driver,createbtn);
    	}else if(value.equals("ClickCreate"))
    	{this.clickme(driver, clickcreateform);}
    	else if(value.equals("pentool"))
    	{
    		this.clickme(driver, pentool);
		}else if(value.equals("updateform"))
		{
			this.clickme(driver, formupdate);
		}else if(value.equals("moveBack"))
		{
			this.clickme(driver, back);
		}
		else if(value.equals("closeToast"))
		{
			this.clickme(driver, closeToast);
		}
        }
	
	public void  EnterValue(WebDriver driver , String value , String data)
	{
		String text="";
		if(value.equals("fake")) {
    		 text=this.getText(driver,formname);
    	}else if(value.equals("fname")) {
       	 this.EnterText(driver, formname, data);
        }
	}
	public void clickNextandFinish(WebDriver driver ,String value)
	{
		
		if(value.equals("Next")) {
			do {
				this.clickme(driver,nextfinish );
			}while(isVisible(driver));
		}
		
	}
}
