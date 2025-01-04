package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFieldsObject {
	
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
	public static By toastCheck = By.id("toastmsg");
	public static By Gen_Settings = By.xpath("//h6[text()='General Settings']");
	
	
	public static By field_search = By.id("zippydragsearch_elements");
	public static By div_value = By.xpath("//i[@id='clearicon_zippy_element']//following::div[1]");
	
	
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
	
	public String getAttribute(WebDriver driver , String value)
	{
		String text="";
		if(value.equals("field_ph"))
		{
			text=this.getAttributeValue(driver,field_search,"placeholder");
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
         }else if(value.equals("forname"))
         {text=this.getText(driver, formname); }
         else if(value.equals("popup"))
         {text=this.getText(driver, toastMessage); }
         else if(value.equals("toastCheck"))
         {
        	 text=this.getText(driver, toastCheck);
         }else if(value.equals("divvalue"))
         {
        	 text=this.getText(driver, div_value);
         }
		return text;
	}
	
	public static By field_exist = By.xpath("//i[@id='clearicon_zippy_element']//following::div[@data-type='number']");
	
	public boolean ElementExist(WebDriver driver ,String value , String datatype)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
	    String xpath = "//i[@id='clearicon_zippy_element']//following::div[@data-type='" + datatype + "']";
		try {
			WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			if(field.getText().contains(value))
			{
				System.out.println(value +" is  visible under div");
				return true;
				
			}else {
	            System.out.println(value + " is not found under div");
	            return false;
	        }
	    } catch (Exception e) {
	        // Log the exception
	        System.out.println("Exception occurred while checking visibility: " + e.getMessage());
	        System.out.println(value + " is not visible under div");
	        return false;
	    }
			
		
		
	}
	
	public void  EnterValue(WebDriver driver , String value , String data) throws InterruptedException
	{
		
		if(value.equals("findsearch")) {
    		 this.EnterText(driver, field_search, data);
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
	
	
	public void clickNextandFinish(WebDriver driver ,String value)
	{
		
		if(value.equals("Next")) {
			do {
				this.clickme(driver,nextfinish );
			}while(isVisible(driver ,nextfinish));
		}
		
	}

}
