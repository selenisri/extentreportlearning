package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.sound.midi.SysexMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepFormObject {

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
	
	public static By phonenumberfield = By.xpath("//div[@data-type='phone_number']");
	public static By webfield = By.xpath("//div[@data-type='website_url']");
	public static By datefield = By.xpath("//div[@data-type='date']");
	public static By timefield = By.xpath("//div[@data-type='time']");
	public static By textareafield = By.xpath("//div[@data-type='text_area']");
	public static By stextareafield = By.xpath("//div[@data-type='short_text_area']");
	public static By EditButton = By.xpath("//div[@id='tab_sub_content']//h4//following::div[1]");
	
	public static By radio = By.xpath("//div[@data-type='radio']");
	public static By checkbox = By.xpath("//div[@data-type='multiselect_checkbox']");
	public static By dropdown = By.xpath("//div[@data-type='dropdown']");
	
	public static By Stepname = By.xpath("//input[starts-with(@id,'stepnameinput')]");
	public static By upbtn =By.xpath("//input[starts-with(@id,'stepnameinput')]//following::button[1]");
	
	
	
	public static By drop = By.xpath("//section[starts-with(@id,'dragareasection_')]");
	public static By drop2 = By.xpath("//h4[text()='steptwo']//following::section[starts-with(@id,'dragareasection_')]");
	public static By editbutton = By.xpath("//section[starts-with(@id,'dragareasection')]//following-sibling::span");
	
	public static By phonenumber =By.xpath("//section[starts-with(@id,'dragareasection_')]//input[@type='number']/following::p[1]");
	public static By textdraft =By.xpath("//section[starts-with(@id,'dragareasection_')]//input[@type='text']/following::p[1]");
	public static By timedraft =By.xpath("//section[starts-with(@id,'dragareasection_')]//input[@type='time']/following::p[1]");
	public static By textareadraft =By.xpath("//section[starts-with(@id,'dragareasection_')]//following::textarea[@rows=4]/following::p[1]");
	public static By textareatwo = By.xpath("//section[starts-with(@id,'dragareasection_')]//following::textarea[@rows=2]/following::p[1]");
	public static By date = By.xpath("//section[starts-with(@id,'dragareasection_')]//input[@type='text' and @placeholder='d-m-y']/following::p[1]");
	
	public static By dropdowndraft = By.xpath("//section[starts-with(@id,'dragareasection_')]//select//following::p[1]");
	public static By radiodraft = By.xpath("//div[@id='drag_area_section_contaniner']/div[2]//div[@data-type='radio']//p[1]");
	public static By checkdraft = By.xpath("//section[starts-with(@id,'dragareasection_')]//input[@id='check']//following::p[1]");
	
	
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
	public static By max_selection = By.id("max_selection");
	public static By add_options = By.xpath("//div[@id='option_count_div']//small//span");
	public static By add_dropdown= By.xpath("//input[@id='option1']//following::span[2]");
	public static By option_one = By.id("option1");
	public static By option_two = By.id("option2");
	public static By save = By.xpath("//button[text()='Save']");

	
	//
	
	public static By publishbtn = By.xpath("//button[text()='Publish']");
	
	public static By send_btn= By.id("Share_form_icon");
	public static By custom_link_menu = By.xpath("//span[text()='Custom Form Link']");
	public static By get_link= By.xpath("//p[@id='customform_link']");
	
	
	
	
	//Add Step
	
	public static By plusButton = By.xpath("//ul[@id='stepsection_list']//following::button[1]");
	public static By SteptwoEdit = By.xpath("//div[@id='tab_sub_content']//h4[text()='Step 2']//following::i[1]");
	public static By inputStep = By.xpath("//input[starts-with(@id,'stepnameinput') and @value='Step 2']");
	public static By stepUpdate = By.xpath("//input[starts-with(@id,'stepnameinput') and @value='Step 2']//following::button[1]");
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
	
public void draganddrop2(WebDriver driver, By element ) {
		
        //Building a drag and drop action
		 WebElement elements = driver.findElement(element);
		 WebElement elex = driver.findElement(drop2);
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
	
	public void movetoElementc(WebDriver driver , By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement parentSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//section[starts-with(@id,'dragareasection_')]//div[@data-type='dropdown']")));
		WebElement selectElement = parentSection.findElement(By.tagName("select"));

		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(selectElement));
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
	
	public void TabNameUpdate(WebDriver driver , By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);"); 
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(element));
		//do {
			this.clickme(driver,element );
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
	
	
	public int DragnDrop(WebDriver driver,String value)
	{
		
		if(value.equals("phone")) {
    		 this.draganddrop(driver, phonenumberfield);
    		 return 1;
    	}else if(value.equals("web")) {
    	this.draganddrop(driver,webfield);
    	return 1;
    	}
    	else if(value.equals("date")) {
        	this.draganddrop(driver,datefield);
        	return 1;
        	}else if(value.equals("time")) {
            	this.draganddrop(driver,timefield);
            	return 1;
        	}else if(value.equals("stext")) {
            	this.draganddrop(driver,stextareafield);
            	return 1;
        	}else if(value.equals("textarea")) {
            	this.draganddrop(driver,textareafield);
            	return 1;
        	}else if(value.equals("number")) {
        	this.draganddrop(driver, numberfield);
        	this.HoverElement(driver, "textfield");
        	this.editbutton(driver, 1 );
        	return 1;
          }
		else if(value.equals("radio")) {
            	this.draganddrop2(driver,radio);
            	return 1;
            	}else if(value.equals("checkbox")) {
                	this.draganddrop2(driver,checkbox);
                	return 1;
                	}else if(value.equals("dropdown")) {
                    	this.draganddrop2(driver,dropdown);
                    	return 1;
                    	}
		
		
		return 1;
	}
	
	
	public void enterLable(WebDriver driver,String value)
	{
		
		if(value.equals("Number")) {
			this.HoverElement(driver, "Number");
        	this.editbutton(driver, 1 );
    	}else if(value.equals("Website")) {
        	this.HoverElement(driver, "text");
        	this.editbutton(driver, 4 );
          }else if(value.equals("Time")) {
        	this.HoverElement(driver, "time");
        	this.editbutton(driver, 7 );
          }
          else if(value.equals("Address")) {
          	this.HoverElement(driver, "tarea");
          	this.editbutton(driver, 10 );
            }
          else if(value.equals("ShortAddress")) {
            	this.HoverElement(driver, "tareatwo");
            	this.editbutton(driver, 13);
              }
          else if(value.equals("date")) {
          	this.HoverElement(driver, "date");
          	this.editbutton(driver, 16);
            }
          else if(value.equals("dropdown")) {
            	this.HoverElement(driver, "dropdown");
            	this.editbutton(driver, 1);
              }
          else if(value.equals("radio")) {
          	this.HoverElement(driver, "radio");
          	this.editbutton(driver, 4);
            }
          else if(value.equals("checkbox")) {
            	this.HoverElement(driver, "check");
            	this.editbutton(driver, 7);
              }
		
	}
	
	
	
	
	public void  EnterValue(WebDriver driver , String value , String data) throws InterruptedException
	{
		String text="";
		if(value.equals("getRegisterText")) {
    		 text=this.getText(driver,getRegisterText);
    	}else if(value.equals("phonenumber")) {
    		if(isInVisible(driver,toastMessage)) {
    			this.EnterText(driver, lablename, data);
        		}
    	         //this.editbutton(driver, 1);
    	    	
			
         }
    	else if(value.equals("text")) {
    		if(isInVisible(driver,toastMessage)) {
    			this.EnterText(driver, lablename, data);
        		}
      
            }
		
    	else if(value.equals("time")) {
    		if(isInVisible(driver,toastMessage)) {
    			this.EnterText(driver, lablename, data);
        		}
      
            }
    	else if(value.equals("num")) {
    		this.EnterText(driver, lablename, data);
      
            }
    	else if(value.equals("stepnamefield"))
    	{
    		this.EnterText(driver, Stepname, data);
    	}
		
    	else if(value.equals("stepnamefield2"))
    	{
    		this.EnterText(driver, inputStep, data);
    	}
		
    	else if(value.equals("maxselect"))
    	{
    		this.EnterText(driver, max_selection, data);
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
    	else if(value.equals("EditButton")){
    		this.clickme(driver,EditButton );
    	}
    	else if(value.equals("publish"))
    	{
    		if(isInVisible(driver,toastMessage)) {
    			this.clickme(driver, publishbtn);
        		}
    		
    	}else if(value.equals("Update"))
    	{
    		if(isInVisible(driver,toastMessage)) {
        		this.TabNameUpdate(driver,upbtn );
        		}
    	}else if(value.equals("clickPlus")) {
    		if(isInVisible(driver,toastMessage)) {
        		this.clickme(driver,plusButton );
        		}
    	}
    		else if(value.equals("Rock")) {
    			System.out.println("hello");
        		if(isInVisible(driver,toastMessage)) {
            		this.clickme(driver,SteptwoEdit );
            		}
    		}else if(value.equals("Update2"))
        	{
        		if(isInVisible(driver,toastMessage)) {
            		this.TabNameUpdate(driver,stepUpdate );
            		}
        	}
    		
	}
	
	public void addOptions(WebDriver driver, String value )
	{
		if(value.equals("Graduation")) {
    		this.clickme(driver,add_options);
    		this.EnterText(driver, option_one,"profess" );
    		this.clickme(driver, add_dropdown);
    		this.EnterText(driver, option_two,"arts" );
    		this.clickme(driver, save);
    	}else if(value.equals("Gender"))
    	{
    		this.clickme(driver,add_options);
    		this.EnterText(driver, option_one,"M" );
    		this.clickme(driver, add_dropdown);
    		this.EnterText(driver, option_two,"F" );
    		this.clickme(driver, save);
    		
    	}else if(value.equals("Dep"))
    	{
    		this.clickme(driver,add_options);
    		this.EnterText(driver, option_one,"CS" );
    		this.clickme(driver, add_dropdown);
    		this.EnterText(driver, option_two,"Arts" );
    		this.clickme(driver, save);
    		
    	}
    		
	}
	
	public void HoverElement(WebDriver driver ,String value)
	{
		if(value.equals("Number")) {
    		this.movetoElement(driver, phonenumber);
    	}else if(value.equals("text")) {
    		this.movetoElement(driver, textdraft);
    	}
    	else if(value.equals("time")) {
    		this.movetoElement(driver, timedraft);
    	}
    	else if(value.equals("tarea")) {
    		this.movetoElement(driver, textareadraft);
    	}
    	else if(value.equals("tareatwo")) {
    		this.movetoElement(driver, textareatwo);
    	}
    	else if(value.equals("date")) {
    		this.movetoElement(driver, date);
    	}
    	else if(value.equals("dropdown")) {
    		if(isInVisible(driver,toastMessage)) {
    			this.movetoElement(driver,dropdowndraft );
        		}
    		
    	}
    	else if(value.equals("radio")) {
    		this.movetoElement(driver,radiodraft );
    	}
    	else if(value.equals("check")) {
    		this.movetoElement(driver,checkdraft );
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
