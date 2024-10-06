package PageObjects;

import java.io.FileInputStream;
import org.openqa.selenium.JavascriptExecutor;
import java.io.IOException;
import java.util.Properties;
import java.awt.HeadlessException;
import java.awt.Toolkit; 
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormObject {
	
	
	public static  WebDriver driver;
	public static WebDriverWait wait;
	
	public static By send_btn= By.id("zippy_launch_form_btn");
	public static By custom_link_menu = By.xpath("//span[text()='Custom Form Link']");
	public static By get_link= By.xpath("//p[@id='customform_link']");
	public static By copy_btn = By.xpath("//p[@id='customform_link']//following::button[1]");
	
	
	public static By Dashboard = By.xpath("//a[text()='My Forms']");
	public static By nextfinish = By.xpath("//button[text()='Finish' or text()='Next']");
	public static By custom_lable= By.xpath("//h4[text()='Custom Form Link']");
	public static By Success_message = By.id("okButton");
	public static By submission_count = By.xpath("//h6[text()='kilo']//following::p[1]//strong");
	
	//action drop down
	
	public static By action = By.xpath("//h6[text()='kilo']//following::button[1]");
	
	//shadow element
	
	public static By name= By.cssSelector("input[data-type='text_box'][data-label='Name']");
	public static By email= By.cssSelector("input[data-type='email'][data-label='E Address']");
	public static By number= By.cssSelector("input[data-type='number'][data-label='Your Number']");
	
	
	
	public String getText(WebDriver driver , By element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(element));
		String text=field.getText();
		return text;
	}
	
	public void NavigatetoURL(WebDriver driver , String value)
	{
		driver.get(value);
		
	}
	
	
	public String getValueText(WebDriver driver , String value)
	{
		String text="";
		if(value.equals("Dashboard")) {
    		 text=this.getText(driver,Dashboard);
    	}else if(value.equals("custom_lable"))
    	{
    		text=this.getText(driver,custom_lable);
    	}else if(value.equals("Successmsg"))
    	{
    		text=this.getText(driver,Success_message);
    	}
    	else if(value.equals("count"))
    	{
    		text=this.getText(driver,submission_count);
    	}
         
		return text;
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
	public void clickhere(WebDriver driver ,String value) throws InterruptedException
	{
		if(value.equals("clk_send")) {
    		this.clickme(driver,send_btn);
    	}else if(value.equals("custm_link"))
    	{
    		this.clickme(driver,custom_link_menu);
    	}else if(value.equals("copy_btn"))
    	{
    		this.clickme(driver,copy_btn);
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
	
	public void openNewtabandPaste(WebDriver driver) throws HeadlessException, UnsupportedFlavorException, IOException
	{
		((JavascriptExecutor) driver).executeScript("window.open('about:blank', '_blank');");

        // Get the list of window handles and switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        // Get the clipboard content (URL)
        String clipboardContent = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);

        // Navigate to the URL from clipboard
        driver.get(clipboardContent);

	}
	
	String namex = "input[data-type='text_box'][data-label='Name']";
	String emailx = "input[data-type='email'][data-label='E Address']";
	String numx = "input[data-type='email'][data-label='E Address']";
	public void EnterText(WebDriver driver ,String value) throws InterruptedException
	{
		if(value.equals("name")) {
    		this.ShadowEnterName(driver,"sriram");
    	}else if(value.equals("email"))
    	{
    		this.ShadowEnterEmail(driver,"sriram@gmail.com");
    	}
    	else if(value.equals("number"))
    	{
    		this.ShadowEnterNum(driver,"1");
    	}
		
	}
	
	
	public void  ShadowEnterName(WebDriver driver ,  String value) throws InterruptedException
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;

		    // Locate the shadow host element by its ID or CSS selector
		    WebElement shadowHost = driver.findElement(By.cssSelector("#zippy_form"));
		    
		    Thread.sleep(3000);;

		    // Use JavaScript to access the shadow DOM and directly target the input element
		    WebElement elementInShadowDom = (WebElement) js.executeScript(
		        "return arguments[0].shadowRoot.querySelector('input[data-type=\"text_box\"][data-label=\"Name\"]')", 
		        shadowHost);

		    // Check if the element is found, throw exception if it's null
		    if (elementInShadowDom == null) {
		        throw new RuntimeException("Element inside shadow DOM not found.");
		    }

		    // Send the desired text to the input field inside the shadow DOM
		    elementInShadowDom.sendKeys(value);
	}
	
	
	public void  ShadowEnterEmail(WebDriver driver ,  String value)
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;

		    // Locate the shadow host element by its ID or CSS selector
		    WebElement shadowHost = driver.findElement(By.cssSelector("#zippy_form"));

		    // Use JavaScript to access the shadow DOM and directly target the input element
		    WebElement elementInShadowDom = (WebElement) js.executeScript(
		        "return arguments[0].shadowRoot.querySelector('input[data-type=\"email\"][data-label=\"E Address\"]')", 
		        shadowHost);

		    // Check if the element is found, throw exception if it's null
		    if (elementInShadowDom == null) {
		        throw new RuntimeException("Element inside shadow DOM not found.");
		    }

		    // Send the desired text to the input field inside the shadow DOM
		    elementInShadowDom.sendKeys(value);
	}
	
	public void  ShadowEnterNum(WebDriver driver ,  String value)
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;

		    // Locate the shadow host element by its ID or CSS selector
		    WebElement shadowHost = driver.findElement(By.cssSelector("#zippy_form"));

		    // Use JavaScript to access the shadow DOM and directly target the input element
		    WebElement elementInShadowDom = (WebElement) js.executeScript(
		        "return arguments[0].shadowRoot.querySelector('input[data-type=\"number\"][data-label=\"Your Number\"]')", 
		        shadowHost);

		    // Check if the element is found, throw exception if it's null
		    if (elementInShadowDom == null) {
		        throw new RuntimeException("Element inside shadow DOM not found.");
		    }

		    // Send the desired text to the input field inside the shadow DOM
		    elementInShadowDom.sendKeys(value);
	}
	
	public void  submit(WebDriver driver) throws InterruptedException
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;

		    // Locate the shadow host element by its ID or CSS selector
		    WebElement shadowHost = driver.findElement(By.cssSelector("#zippy_form"));

		    // Use JavaScript to access the shadow DOM and directly target the input element
		    WebElement elementInShadowDom = (WebElement) js.executeScript(
		        "return arguments[0].shadowRoot.querySelector('span.next.action-button')", 
		        shadowHost);
		    

		    // Check if the element is found, throw exception if it's null
		    if (elementInShadowDom == null) {
		        throw new RuntimeException("Element inside shadow DOM not found.");
		    }

		    // Send the desired text to the input field inside the shadow DOM
		    elementInShadowDom.click();
		    
		    Thread.sleep(2000);
		    
//		    WebElement elementInShadowDom1 = (WebElement) js.executeScript(
//		    	    "return Array.from(arguments[0].shadowRoot.querySelectorAll('h2')).find(el => el.textContent.trim() === 'Thank you!')", 
//		    	    shadowHost);
//		   return elementInShadowDom1.getText();
//	
	
	}
	
	
}

