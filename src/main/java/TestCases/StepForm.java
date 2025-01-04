package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjects.Loginpageobject;
import PageObjects.StepFormObject;

public class StepForm extends BaseBrowser {

	StepFormObject StepObject = new StepFormObject();
	Properties properties = new Properties();
	
	@Test
	(priority=1)
	public void LandinDashboardPage() throws InterruptedException, IOException
	{
		//check the Login works fine
		
		  PageFactory.initElements(driver,Loginpageobject.class);
		  FileInputStream fileInputStream = new FileInputStream("config.properties");
	      properties.load(fileInputStream);
		  Loginpageobject.EnterText(driver, properties.getProperty("username"));
		  Loginpageobject.EnterPassword(driver,properties.getProperty("password") );
		  Loginpageobject.ClickSubmit(driver);
			try {
			    String texta = StepObject.getValueText(driver, "Dashboard");
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
    public void TabNameValidation() throws InterruptedException, IOException
    {
    	
	//Ensure the Error message Displayed when the Empty Data Added for Tab name
		
		  PageFactory.initElements(driver,UpdateFields.class);
		  StepObject.getListNameandClick(driver);
     	  StepObject.clickNextandFinish(driver, "Next");
     	  StepObject.clickhere(driver, "EditButton");
     	  StepObject.EnterValue(driver, "stepnamefield", "");
     	  StepObject.clickhere(driver, "Update");
     	 try {
			    String texta = StepObject.getValueText(driver, "popup");
			    if (texta.equals("Not updated")) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong !!");
			}
     	  
     	  
	
	
	
	
	
	
	
	
    }
	
    @Test
    (priority=3)
    public void UpdateTabName() throws InterruptedException, IOException
    {
    	
	//Ensure the Tab Name is getting Updated
		
		  PageFactory.initElements(driver,UpdateFields.class);
     	  StepObject.EnterValue(driver, "stepnamefield", "StepOne");
     	  StepObject.clickhere(driver, "Update");
     	 try {
			    String texta = StepObject.getValueText(driver, "popup");
			    if (texta.equals("Form Step Updated Successfully")) {
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
	public void AddFields() throws InterruptedException, IOException
	{
		//check the user can able to add the text field
		  
		  PageFactory.initElements(driver,UpdateFields.class);
		  StepObject.DragnDrop(driver, "phone");
		  StepObject.DragnDrop(driver, "web");
		  StepObject.DragnDrop(driver, "date");
		  StepObject.DragnDrop(driver, "time");
		  StepObject.DragnDrop(driver, "stext");
		  StepObject.DragnDrop(driver, "textarea");
		// upObject.EnterValue(driver, "name", "firstname");
		// upObject.clickhere(driver, "updateButton");
		  try 
		  { 
			   String texta =StepObject.getValueText(driver, "popup");
			   System.out.println(texta);
			    if (texta.equals(properties.getProperty("Successfields"))) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong !!");
			}
		}
	
	
	@Test
	(priority=5)
	public void AddNumberField() throws InterruptedException, IOException
	{
		//check the user can able to add the Email field name
		
		  PageFactory.initElements(driver,UpdateFields.class);
		  StepObject.enterLable(driver, "Number");
		  StepObject.EnterValue(driver, "phonenumber", "P Number");
		  StepObject.clickhere(driver, "updateButton");
		  Thread.sleep(5000);
		  try 
		  { 
			   String texta =StepObject.getValueText(driver, "toastCheck");
			   System.out.println(texta);
			    if (texta.equals(properties.getProperty("successaddfield"))) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong-Add Number Field 5");
			}
		}
	
	
	@Test
	(priority=6)
	public void AddWebsiteField() throws InterruptedException, IOException
	{
		//check the user can able to add the Website field name
		
		  PageFactory.initElements(driver,UpdateFields.class);
		  StepObject.enterLable(driver, "Website");
		  StepObject.EnterValue(driver, "text", "URL");
		  StepObject.clickhere(driver, "updateButton");
		  Thread.sleep(5000);
		  try 
		  { 
			   String texta =StepObject.getValueText(driver, "toastCheck");
			   System.out.println(texta);
			    if (texta.equals(properties.getProperty("successaddfield"))) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong 6!!");
			}
		}
	
	
	@Test
	(priority=7)
	public void AddTimeField() throws InterruptedException, IOException
	{
		//Check the Time Field Lable can be added.
		
		  PageFactory.initElements(driver,UpdateFields.class);
		  StepObject.enterLable(driver, "Time");
		  StepObject.EnterValue(driver, "text", "Time");
		  StepObject.clickhere(driver, "updateButton");
		  Thread.sleep(5000);
		  try 
		  { 
			   String texta =StepObject.getValueText(driver, "toastCheck");
			   System.out.println(texta);
			    if (texta.equals(properties.getProperty("successaddfield"))) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong 7!!");
			}
		}
	
	@Test
	(priority=8)
	public void TextAreaField() throws InterruptedException, IOException
	{
		//Check the Time Field Lable can be added.
		
		  PageFactory.initElements(driver,UpdateFields.class);
		  StepObject.enterLable(driver, "Address");
		  StepObject.EnterValue(driver, "text", "address1");
		  StepObject.clickhere(driver, "updateButton");
		  Thread.sleep(5000);
		  try 
		  { 
			   String texta =StepObject.getValueText(driver, "toastCheck");
			   System.out.println(texta);
			    if (texta.equals(properties.getProperty("successaddfield"))) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong 8!!");
			}
		}
	
	
	
	@Test
	(priority=9)
	public void shortTextField() throws InterruptedException, IOException
	{
		//Check the Time Field Lable can be added.
		
		  PageFactory.initElements(driver,UpdateFields.class);
		  StepObject.enterLable(driver, "ShortAddress");
		  StepObject.EnterValue(driver, "text", "address2");
		  StepObject.clickhere(driver, "updateButton");
		  Thread.sleep(5000);
		  try 
		  { 
			   String texta =StepObject.getValueText(driver, "toastCheck");
			   System.out.println(texta);
			    if (texta.equals(properties.getProperty("successaddfield"))) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong9 !!");
			}
		}
	
	@Test
	(priority=10)
	public void dateTextField() throws InterruptedException, IOException
	{
		//Check the Time Field Lable can be added.
		
		  PageFactory.initElements(driver,UpdateFields.class);
		  StepObject.enterLable(driver, "date");
		  StepObject.EnterValue(driver, "text", "Date");
		  StepObject.clickhere(driver, "updateButton");
		  Thread.sleep(5000);
		  try 
		  { 
			   String texta =StepObject.getValueText(driver, "toastCheck");
			   System.out.println(texta);
			    if (texta.equals(properties.getProperty("successaddfield"))) {
			    	System.out.println("pass-o");
			    } else {
			        System.out.println("Fail-o");
			    }
			} catch (Exception e) {
			    System.out.println("Something went wrong 10!!");
			}
		}
		
		
	
	
	    @Test
	    (priority=11)
	    public void Tab2NameValidation() throws InterruptedException, IOException
	    {
	    	
		//Ensure the Error message Displayed when the Empty Data Added for Tab name
			
			  PageFactory.initElements(driver,UpdateFields.class);
			  StepObject.clickhere(driver, "clickPlus");
	     	  StepObject.clickhere(driver, "Rock");
	     	  StepObject.EnterValue(driver, "stepnamefield2", "");
	     	  StepObject.clickhere(driver, "Update2");
	     	 try {
				    String texta = StepObject.getValueText(driver, "popup");
				    if (texta.equals("Not updated")) {
				    	System.out.println("pass-o");
				    } else {
				        System.out.println("Fail-o");
				    }
				} catch (Exception e) {
				    System.out.println("Something went wrong11 !!");
				}
	     	  
	     	  
	   }
	    
	    @Test
	    (priority=12)
	    public void Tab2NameAddition() throws InterruptedException, IOException
	    {
	    	
		//Ensure the Error message Displayed when the Empty Data Added for Tab name
			
			  PageFactory.initElements(driver,UpdateFields.class);
	     	  StepObject.EnterValue(driver, "stepnamefield2", "steptwo");
	     	  StepObject.clickhere(driver, "Update2");
	     	 try {
				    String texta = StepObject.getValueText(driver, "popup");
				    if (texta.equals("Not updated")) {
				    	System.out.println("pass-o");
				    } else {
				        System.out.println("Fail-o");
				    }
				} catch (Exception e) {
				    System.out.println("Something went wrong 12!!");
				}
	     	  
	     	  
	   }
	   
	   
   
	    
	    
	    @Test
		(priority=13)
		public void AddFieldsTwo() throws InterruptedException, IOException
		{
			//check the user can able to add the text field
			  
			  PageFactory.initElements(driver,UpdateFields.class);
			  StepObject.DragnDrop(driver, "dropdown");
			  StepObject.DragnDrop(driver, "radio");
			  StepObject.DragnDrop(driver, "checkbox");
			// upObject.EnterValue(driver, "name", "firstname");
			// upObject.clickhere(driver, "updateButton");
			  try 
			  { 
				   String texta =StepObject.getValueText(driver, "popup");
				   System.out.println(texta);
				    if (texta.equals(properties.getProperty("Successfields"))) {
				    	System.out.println("pass-o");
				    } else {
				        System.out.println("Fail-o");
				    }
				} catch (Exception e) {
				    System.out.println("Something went wrong 13!!");
				}
			}
	    
	    
	    
	    
	    @Test
		(priority=14)
		public void AddDropDownLable() throws InterruptedException, IOException
		{
			//check the user can able to add the lable name and dropdown values
	    	
			  PageFactory.initElements(driver,UpdateFields.class);
			  StepObject.enterLable(driver, "dropdown");
			  StepObject.EnterValue(driver, "phonenumber", "Graduation");
			  StepObject.EnterValue(driver, "maxselect", "1");
			  StepObject.addOptions(driver, "Graduation");
			  StepObject.clickhere(driver, "updateButton");
			  Thread.sleep(5000);
			   try 
			  { 
				   String texta =StepObject.getValueText(driver, "toastCheck");
				   System.out.println(texta);
				    if (texta.equals(properties.getProperty("successaddfield"))) {
				    	System.out.println("pass-o");
				    } else {
				        System.out.println("Fail-o");
				    }
				} catch (Exception e) {
				    System.out.println("Something went wrong !!");
				}
			}
	    
	    @Test
		(priority=15)
		public void AddRadioLable() throws InterruptedException, IOException
		{
			//check the user can able to add the lable name and radio values
	    	
			  PageFactory.initElements(driver,UpdateFields.class);
			  StepObject.enterLable(driver, "radio");
			  StepObject.EnterValue(driver, "phonenumber", "Gender");
			  StepObject.addOptions(driver, "Gender");
			  StepObject.clickhere(driver, "updateButton");
			  Thread.sleep(5000);
			   try 
			  { 
				   String texta =StepObject.getValueText(driver, "toastCheck");
				   System.out.println(texta);
				    if (texta.equals(properties.getProperty("successaddfield"))) {
				    	System.out.println("pass-o");
				    } else {
				        System.out.println("Fail-o");
				    }
				} catch (Exception e) {
				    System.out.println("Something went wrong !!");
				}
			}
	    @Test
		(priority=16)
		public void AddCheckboxLable() throws InterruptedException, IOException
		{
			//check the user can able to add the lable name and radio values
	    	
			  PageFactory.initElements(driver,UpdateFields.class);
			  StepObject.enterLable(driver, "checkbox");
			  StepObject.EnterValue(driver, "phonenumber", "Dep");
			  StepObject.EnterValue(driver, "maxselect", "1");
			  StepObject.addOptions(driver, "Dep");
			  StepObject.clickhere(driver, "updateButton");
			  Thread.sleep(5000);
			   try 
			  { 
				   String texta =StepObject.getValueText(driver, "toastCheck");
				   System.out.println(texta);
				    if (texta.equals(properties.getProperty("successaddfield"))) {
				    	System.out.println("pass-o");
				    } else {
				        System.out.println("Fail-o");
				    }
				} catch (Exception e) {
				    System.out.println("Something went wrong !!");
				}
			}
	    
	    @Test
		(priority=17)
		public void MakeActive() throws InterruptedException, IOException
		{
			//check the user can able to add the lable name and radio values
	    	
			  PageFactory.initElements(driver,UpdateFields.class);
			  StepObject.clickhere(driver, "publish");
			  Thread.sleep(5000);
			   try 
			  { 
				   String texta =StepObject.getValueText(driver, "popup");
				   System.out.println(texta);
				    if (texta.equals("Form Updated Successfully")) {
				    	System.out.println("pass-o");
				    } else {
				        System.out.println("Fail-o");
				    }
				} catch (Exception e) {
				    System.out.println("Something went wrong !!");
				}
			}
		
		

}
