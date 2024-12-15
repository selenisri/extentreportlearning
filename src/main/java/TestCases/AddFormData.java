package TestCases;

import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjects.FormObject;
import PageObjects.Loginpageobject;
import PageObjects.UpdateFieldsObject;

public class AddFormData extends BaseBrowser{
	
	FormObject upObject = new FormObject();
	Properties properties = new Properties();
	String Number;
	
	
	
	@Test
	(priority=1)
	public void Login() throws InterruptedException, IOException
	{
		//check the user can able to Copy the URL and Paste it in the New Tab
		
		  PageFactory.initElements(driver,Loginpageobject.class);
		  FileInputStream fileInputStream = new FileInputStream("config.properties");
	      properties.load(fileInputStream);
		  Loginpageobject.EnterText(driver, properties.getProperty("username"));
		  Loginpageobject.EnterPassword(driver,properties.getProperty("password") );
		  Loginpageobject.ClickSubmit(driver);
			try {
			    String texta = upObject.getValueText(driver, "Dashboard"); 
			    if (texta.equals("My Forms")) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong !!");
			}
		  
		
	}
	
	
	@Test
	(priority=2)
	public void getSubmissionCount() throws InterruptedException, IOException
	{
		//get the count b4 submission
		PageFactory.initElements(driver,UpdateFields.class);
		Number=upObject.getValueText(driver,"count");
        System.out.println(Number);
	
	}
	
	@Test
	(priority=3)
	public void ClickCustomFormLink() throws InterruptedException, IOException
	{
		//check the user can able to Click Custome Form Link and View the Lable Custom Form Link
		PageFactory.initElements(driver,UpdateFields.class);
		upObject.getListNameandClick(driver);
		upObject.clickNextandFinish(driver, "Next");
		upObject.clickhere(driver, "clk_send");
		upObject.clickhere(driver, "custm_link");
			try {
		    String texta = upObject.getValueText(driver, "custom_lable");
		    System.out.println(texta);
		    if (texta.equals("Custom Form Link")) {
		    	System.out.println("pass-o");
		    } else {
		        System.out.println("Fail-o");
		    }
		} catch (Exception e) {
		    System.out.println("Something went wrong !!");
		}
			
			
	

}
	
	@Test
	(priority=4)
	public void Newtab() throws InterruptedException, IOException, HeadlessException, UnsupportedFlavorException
	{
		//check the user can able to Copy the URL and Paste it in the New Tab
		PageFactory.initElements(driver,UpdateFields.class);
		upObject.clickhere(driver, "copy_btn");
		upObject.openNewtabandPaste(driver);
		upObject.EnterText(driver, "name");
		upObject.EnterText(driver, "email");
		upObject.EnterText(driver, "number");
		upObject.submit(driver);
			try {
		    String texta = upObject.getValueText(driver,"Successmsg");
		    System.out.println(texta);
		    if (texta.equals("Ok")) {
		    	System.out.println("pass-o");
		    } else {
		        System.out.println("Fail-o");
		    }
		} catch (Exception e) {
		    System.out.println(e);
		}
	
	}
	
	
	
	@Test
	(priority=5)
	public void checkSubmissionCount () throws InterruptedException, IOException, HeadlessException, UnsupportedFlavorException
	{
		//check the Submission count is working fine
		
		PageFactory.initElements(driver,UpdateFields.class);
		upObject.NavigatetoURL(driver, "https://beta.zippyform.io/forms/");
		String Number1 =upObject.getValueText(driver, "count");
		int num1 = Integer.parseInt(Number1);
        int num2 = Integer.parseInt(Number);
        // Add the two integers
        int sum = num2 + 1;
        System.out.println(sum);
        System.out.print(num1);
			try {
		    if (sum==num1) {
		    	System.out.println("pass-o");
		    } else {
		        System.out.println("Fail-o");
		    }
		} catch (Exception e) {
		    System.out.println(e);
		}
	
	}
	
	
	
	@Test
	(priority=5)
	public void checkSubmissionList() throws InterruptedException, IOException, HeadlessException, UnsupportedFlavorException
	{
		//check the Submission count is working fine
		
		PageFactory.initElements(driver,UpdateFields.class);
		upObject.NavigatetoURL(driver, "https://beta.zippyform.io/forms/");
		upObject.clickhere(driver, "action_menu");
		upObject.clickhere(driver, "submissionlist");
		int num=upObject.get(driver);
		System.out.println(num);
		
		
	}
	
	
	
	
	
	
	@Test
	(priority=6)
	public void deleteForm() throws InterruptedException, IOException, HeadlessException, UnsupportedFlavorException
	{
		//check the Number count !
		
		PageFactory.initElements(driver,UpdateFields.class);
		upObject.NavigatetoURL(driver, "https://beta.zippyform.io/forms/");
		String Number1 =upObject.getValueText(driver, "count");
		int num1 = Integer.parseInt(Number1);
        int num2 = Integer.parseInt(Number);
        // Add the two integers
        int sum = num2 + 1;
        System.out.println(sum);
        System.out.print(num1);
			try {
		    if (sum==num1) {
		    	System.out.println("pass-o");
		    } else {
		        System.out.println("Fail-o");
		    }
		} catch (Exception e) {
		    System.out.println(e);
		}
	
	}
	
	
	
	
}
