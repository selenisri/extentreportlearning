package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateFieldsObject {
	
	public static  WebDriver driver;
	public static WebDriverWait wait;
	
	public static By Registerhere = By.xpath("//a[text()=' Register here!']");
	public static By getRegisterText = By.xpath("//h2[text()='Register']");
	public static By Dashboard = By.xpath("//a[text()='My Forms']");
	public static By nextfinish = By.xpath("//button[text()='Finish' or text()='Next']");
	public static By formname = By.xpath("//h4[@id='formname_title']");
	public static By textfield = By.id("zippyform_text_input");
	public static By numberfield = By.xpath("//div[@data-type='number']");
	public static By emailfield = By.xpath("//div[@data-type='email']");
	public static By drop = By.xpath("//section[starts-with(@id,'dragareasection_')]");
	public static By editbutton = By.xpath("//section[starts-with(@id,'dragareasection')]//following-sibling::span");
	
	public static By nameDraft =By.xpath("//section[starts-with(@id,'dragareasection_')]//input[@type='text']/following::p[1]");
	public static By emailDraft =By.xpath("//section[starts-with(@id,'dragareasection_')]//input[@type='email']/following::p[1]");
	public static By numDraft =By.xpath("//section[starts-with(@id,'dragareasection_')]//input[@type='number']/following::p[1]");
	
	
	public static By toastMessage = By.id("toast_type");
	public static By Gen_Settings = By.xpath("//h6[text()='General Settings']");
	
	public static By fieldUpdated = By.xpath("//span[text()='Field Settings Updated Successfully']");
	
	public static By cancel_button = By.xpath("//div[@id='settings_sec_show']//button[text()='Cancel']");
	
	
	public static By textfield_drop = By.xpath("//section[starts-with(@id,'dragareasection_')]//input[1]");
	public static By emailfield_drop = By.xpath("//section[starts-with(@id,'dragareasection_')]//input[@type='email']");
	public static By numberfield_drop = By.xpath("//section[starts-with(@id,'dragareasection_')]//input[@type='number']");
	
	//configuration name
	
	public static By lablename = By.xpath("//input[@id='labelname']");
	public static By updatebtn = By.xpath("//span[@id='zippy_bulder_updateFieldSettings']");
	
	//
	
	public static By publishbtn = By.xpath("//button[text()='Publish']");
	
	public static By send_btn= By.id("Share_form_icon");
	public static By custom_link_menu = By.xpath("//span[text()='Custom Form Link']");
	public static By get_link= By.xpath("//p[@id='customform_link']");
	
	public void editbutton(WebDriver driver , int val)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30); // 10 seconds timeout

        // Wait for the list of web elements to be present
		 List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(editbutton));
		 
	                // Wait for the button to be clickable and click it
	            	if (!elements.isEmpty()) {
	            		
	            		wait.until(ExpectedConditions.elementToBeClickable(editbutton));
	            	
	                	elements.get(val).click();
	        			 } else {
	                    System.out.println("No elements found.");
	                }
	                

	       

		  
		 }
	
	
	

	
	
	public void draganddrop(WebDriver driver, By element ) {
		
        //Building a drag and drop action
		 WebElement elements = driver.findElement(element);
		 WebElement elex = driver.findElement(drop);
		 Actions builder = new Actions(driver);
		 Action dragAndDrop =  builder.clickAndHold(elements)
		.moveToElement(elex)
		.release(elex)
		.build();

		//Performing the drag and drop action
		dragAndDrop.perform();

	}
	
	public static boolean waitforinvisible(WebDriver driver , By ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout

        // Wait until the element is invisible
        boolean isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(ele));
        System.out.print(isElementInvisible);
        return isElementInvisible;
       
	}
	
	
	
	
	public  String textField() throws IOException {
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		properties.load(fileInputStream);
		 return properties.getProperty("value");
		
		}
		 public void getListNameandClick(WebDriver driver) throws IOException {
		        String dynamicTextn = textField();
		        By lname=By.xpath(String.format("//h6[contains(text(),'%s')]", dynamicTextn));
		        WebDriverWait wait = new WebDriverWait(driver, 20);
		 		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(lname));
		 	   field.click();
		    }
		
	
	
	public void RefreshPage(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//WebElement field = wait.until(ExpectedConditions.elementToBeClickable(logo));
		driver.get(driver.getCurrentUrl());
	}
	
	public void movetoElement(WebDriver driver , By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		 Actions actions = new Actions(driver);

	        // Move to the element to hover
	        actions.moveToElement(field).perform();
	}

	public void clickme(WebDriver driver , By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(element));
		field.click();
	}
	
	public void clickmewhenvisible(WebDriver driver , By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		field.click();
	}
	
	public static void scrolldown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);"); 
	}
	
	public static void EnterText(WebDriver driver,By element ,String text) {
	    WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(element));
	    emailField.clear();
	    Actions actions = new Actions(driver);
	    actions.moveToElement(emailField).click().sendKeys(text).build().perform();
	 
	}
	
	public void clickUpdate(WebDriver driver , By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);"); 
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(updatebtn));
		//do {
			this.clickme(driver,updatebtn );
		//}while(isVisible(driver ,fieldUpdated));
		
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
	
	public String getValueText(WebDriver driver , String value)
	{
		String text="";
		if(value.equals("getRegisterText")) {
    		 text=this.getText(driver,getRegisterText);
    	}else if(value.equals("email")) {
    	 text=this.getText(driver,getRegisterText);
         }else if(value.equals("Dashboard")) {
        	 text=this.getText(driver, Dashboard);
         }else if(value.equals("forname"))
         {text=this.getText(driver, formname); }
         else if(value.equals("popup"))
         {text=this.getText(driver, toastMessage); }
		return text;
	}
	
	
	public void DragnDrop(WebDriver driver,String value)
	{
		
		if(value.equals("name")) {
    		 this.draganddrop(driver,textfield );
    	}else if(value.equals("email")) {
    	this.draganddrop(driver,emailfield);
    	}else if(value.equals("number")) {
        	this.draganddrop(driver, numberfield);
        	this.HoverElement(driver, "textfield");
        	this.editbutton(driver, 1 );
          }
		
	}
	
	public void enterLable(WebDriver driver,String value)
	{
		
		if(value.equals("name")) {
			this.HoverElement(driver, "textfield");
        	this.editbutton(driver, 1 );
    	}else if(value.equals("emailfield")) {
        	this.HoverElement(driver, "emailfield");
        	this.editbutton(driver, 4 );
          }else if(value.equals("number")) {
        	this.HoverElement(driver, "numberfield");
        	this.editbutton(driver, 7 );
          }
		
	}
	
	
	
	
	public void  EnterValue(WebDriver driver , String value , String data) throws InterruptedException
	{
		String text="";
		if(value.equals("getRegisterText")) {
    		 text=this.getText(driver,getRegisterText);
    	}else if(value.equals("name")) {
    		if(isInVisible(driver,toastMessage)) {
    			this.EnterText(driver, lablename, data);
        		}
    	         //this.editbutton(driver, 1);
    	    	
			
         }
    	else if(value.equals("email")) {
    		this.EnterText(driver, lablename, data);
      
            }
    	else if(value.equals("num")) {
    		this.EnterText(driver, lablename, data);
      
            }
	}
	
	
	public void clickhere(WebDriver driver ,String value)
	{
		if(value.equals("clickForm")) {
    		this.clickme(driver,Dashboard);
    	}else if(value.equals("updateButton")) {
    		if(isInVisible(driver,toastMessage)) {
    		this.clickUpdate(driver, updatebtn);
    		}
    	}else if(value.equals("cancel"))
    	{
    		this.clickme(driver, cancel_button);
    	}
    	else if(value.equals("publish"))
    	{
    		if(isInVisible(driver,toastMessage)) {
    			this.clickme(driver, publishbtn);
        		}
    		
    	}
	}
	
	public void HoverElement(WebDriver driver ,String value)
	{
		if(value.equals("textfield")) {
    		this.movetoElement(driver, nameDraft);
    	}else if(value.equals("emailfield")) {
    		this.movetoElement(driver, emailDraft);
    	}
    	else if(value.equals("numberfield")) {
    		this.movetoElement(driver, numDraft);
    	}
	}
	
	public static boolean isVisible(WebDriver driver ,By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		try {
		boolean field = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
		return field;
		}catch (Exception e) {
	        // If the element is not found or not visible, return false
	        return false;
	    }
    	
	}
	
	public static boolean isInVisible(WebDriver driver ,By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 40);
		try {
		boolean field = wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		return field;
		}catch (Exception e) {
	        // If the element is not found or not visible, return false
	        return false;
	    }
    	
	}
	
	public void clickNextandFinish(WebDriver driver ,String value)
	{
		
		if(value.equals("Next")) {
			do {
				this.clickme(driver,nextfinish );
			}while(isVisible(driver ,nextfinish));
		}
		
	}
	
	
}
