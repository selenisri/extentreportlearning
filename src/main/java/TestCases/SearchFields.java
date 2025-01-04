package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Loginpageobject;
import PageObjects.SearchFieldsObject;

public class SearchFields extends BaseBrowser{
	
	SearchFieldsObject search = new SearchFieldsObject();
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
				String texta = search.getValueText(driver, "Dashboard");
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
	    public void SearchFieldExist() throws InterruptedException, IOException
	    {
	    	
		//Ensure Search Field is Exist
			
			  PageFactory.initElements(driver,UpdateFields.class);
			  search.getListNameandClick(driver);
			  search.clickNextandFinish(driver, "Next");
	     	   try {
	     		   String ph=search.getAttribute(driver, "field_ph");
				    if (ph.equals("Search Elements")) {
				    	System.out.println("pass-o");
				    } else {
				        System.out.println("Fail-o");
				    }
				} catch (Exception e) {
				    System.out.println("Something went wrong !!");
				}
	     	  
	     	  
	  }
	    
	    @DataProvider(name = "FieldValues")
	    public Object[][] provideData() {
	        return new Object[][] {
	        	{"Radio", "radio"},
	            {"Checkbox", "multiselect_checkbox"},
	            {"Website", "website_url"},
	            {"Date", "date"},
	            {"Time", "time"},
	            {"Email", "email"}
	        };
	    }
	    
	    @Test(dataProvider = "FieldValues", priority = 3)
	    public void SearchFindsFields(String FieldValue, String datatype) throws InterruptedException, IOException
	    {
	    	
		//Ensure Search Field finds Fields
	    	
			  PageFactory.initElements(driver,UpdateFields.class);
			  search.EnterValue(driver, "findsearch", FieldValue);
	     	   try {
	     		    String ph=search.getValueText(driver, "divvalue");
				    if (search.ElementExist(driver, FieldValue,datatype)) {
				    	System.out.println("pass-o");
				    	Thread.sleep(4000);
				    } else {
				        System.out.println("Fail-o");
				        Thread.sleep(4000);
				    }
				} catch (Exception e) {
				    System.out.println("Something went wrong !!");
				}
	     	  
	     	  
	  }
	  
	  
	  

}
