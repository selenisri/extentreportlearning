package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeletePageObject {
	
	public static  WebDriver driver;
	public static WebDriverWait wait;
	
	public static By Action_btn = By.xpath("//h6[text()='kilo']//following::button[1]");
	public static By Delete_menu = By.xpath("//span[text()='Delete']");
	public static By yes_btn = By.xpath("//button[text()='Delete']");
	public static By success_message = By.id("toastmsg");
	public static By nameDraft =By.xpath("//section[starts-with(@id,'dragareasection_')]//input/following::p[1]");
	public static By emailDraft =By.xpath("//section[starts-with(@id,'dragareasection_')]//input[@type='email']/following::p[1]");
	public static By numDraft =By.xpath("//section[starts-with(@id,'dragareasection_')]//input[@type='number']/following::p[1]");
	public static By editbutton = By.xpath("//section[starts-with(@id,'dragareasection')]//following-sibling::span");
	
	public static By delete_Fields = By.xpath("//section[starts-with(@id,'dragareasection_')]//span[text()='Active']");
	
	public static By nextfinish = By.xpath("//button[text()='Finish' or text()='Next']");
	public static By field_delete = By.id("zippy_deleteConfirmed");
	public static By toastMessage = By.id("toast_type");
	
	public static By back_button = By.xpath("//div[@id='formname_section_con']//preceding::div[@class='backarrow']");
	public static By Dashboard = By.xpath("//span[@id='form_name_hello']");
	public void ClickActionButton(WebDriver driver )
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(Action_btn));
		field.click();
	}
	
	
	public boolean MovebackandWait(WebDriver driver )
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(back_button));
		field.click();
		WebElement text_dasbboard = wait.until(ExpectedConditions.presenceOfElementLocated(Dashboard));
		 boolean status =text_dasbboard.isDisplayed();
		 return status;
	}
	
	
	public void ClickDeleteMenu(WebDriver driver )
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(Delete_menu));
		field.click();
	}
	
	public void ConfirmYes(WebDriver driver )
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(yes_btn));
		field.click();
	}
	
	public String getText(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(success_message));
		String text=field.getText();
		return text;
	}
	
	
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
	                

	       

		  
		 
	
	public void movetoElement(WebDriver driver , By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		 Actions actions = new Actions(driver);

	        // Move to the element to hover
	        actions.moveToElement(field).perform();
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
	
	
	public void clickme(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(field_delete));
		field.click();
	}
	
	
	public void clickme(WebDriver driver , By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(element));
		field.click();
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
	
	public void HoverElement(WebDriver driver ,String value)
	{
		if(value.equals("textfield")) {
    		this.movetoElement(driver, nameDraft);
    	}else if(value.equals("emailfield")) {
    		this.movetoElement(driver, emailDraft);
    	}
    	else if(value.equals("numberfield")) {
    		this.movetoElement(driver, numDraft);
    	}else if(value.equals("delete"))
    	{
    		this.movetoElement(driver, delete_Fields);
    	}
	}
	
	public int ClickDeleteButton(WebDriver driver,String value)
	{
		int count = 0;
		if(value.equals("name")) {
			
			do {
				
			 try {
				this.HoverElement(driver, "delete");
				this.editbutton(driver ,2 );
	             if(isInVisible(driver,toastMessage)) {
	        		this.clickme(driver);
	        		count++;
	        		}
			 } catch (Exception e) {
				    System.out.println("Click Delete Button");
			 }
	        	}while(isVisible(driver ,delete_Fields));
			
			    return count;
			}
		
    	else if(value.equals("emailfield")) {
        	this.HoverElement(driver, "emailfield");
        	this.editbutton(driver ,5);
        	 return count;
          }else if(value.equals("number")) {
        	this.HoverElement(driver, "numberfield");
        	this.editbutton(driver,7 );
        	 return count;
          }
		 return count;
	
}

	

}
