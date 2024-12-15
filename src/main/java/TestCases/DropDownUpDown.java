package TestCases;

import org.testng.annotations.Test;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDownUpDown{
	
	protected WebDriver  driver ;
	
	


	public  void browserConfigChrome() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\srira\\Downloads\\chromedriver-win64wed\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);"); 
		WebElement sel=driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));
        js.executeScript("arguments[0].style.border='3px solid red'", sel);
		WebDriverWait wait = new WebDriverWait(driver, 10); // 10 seconds timeout
         wait.until(ExpectedConditions.elementToBeClickable(sel));
        Thread.sleep(5000);
		
		
	}
	
	
    public  void Hasmap() throws InterruptedException 
	
	{
		
		//Unique values !
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(21, "tom");
        map.put(22, "ram");
        map.put(23, "Sri");
        map.put(24, "riram");
        map.put(25, "sri");

        // New HashMap to store unique values
        HashMap<Integer, String> maps = new HashMap<Integer, String>();
        int i = 1; // Key counter for the new HashMap

        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            if (maps.containsValue(entry.getValue())) { // Only add if value is not already in maps
                maps.put(i, entry.getValue());
                i++; // Increment key counter
            }
        }

        // Display the contents of the new HashMap
        for (HashMap.Entry<Integer, String> entrys : maps.entrySet()) {
            System.out.println("Key: " + entrys.getKey() + ", Value: " + entrys.getValue());
        }
    }
	

    public  void Duplicates() throws InterruptedException 
	
	{
		
		//Get the Duplicate values
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(21, "tom");
        map.put(22, "ram");
        map.put(23, "Sri");
        map.put(24, "riram");
        map.put(25, "sri");
        
        
        HashMap<Integer, String> duplicates = new HashMap<Integer, String>();
        HashSet<String> Seen = new HashSet();
     
        
        for(HashMap.Entry<Integer, String> Entry: map.entrySet())
        {
        	String value = Entry.getValue().toLowerCase();
        	if(Seen.contains(value))
        			{
        		            duplicates.put(Entry.getKey(), Entry.getValue());
        		          
        			}else
        			{
        				 Seen.add(value);
        				
        			}
        }
        
        for(HashMap.Entry<Integer, String> Entry: duplicates.entrySet())
        {
        	System.out.println(Entry.getValue()+"-"+Entry.getKey());
        }

	}
    
    
    
    public  void ArrCommon() throws InterruptedException 
	
   	{
   		
   		//Common in Array List
    	
    	ArrayList<String> Arr = new ArrayList<String>();
    	Arr.add("cam");
    	Arr.add("lam");
    	Arr.add("zam");
    	Arr.add("nam");


    	ArrayList<String> Arrtwo = new ArrayList<String>();
    	Arrtwo.add("sam");
    	Arrtwo.add("nam");
    	Arrtwo.add("cam");
    	Arrtwo.add("sam");


 
        
    	 ArrayList<String> commonElements = new ArrayList<>(Arr);
         commonElements.retainAll(Arrtwo); // Keeps only elements that are in both lists
         System.out.println("Common Elements: " + commonElements);

        
   	}
    
    
   
 public  void JsExecuetor() throws InterruptedException 
	
   	{
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.scroll(0,500)");

   		
}
 @Test
 public  void xclude() throws InterruptedException 
	
	{
	 String name = "sriramraochandrasekararao";

	 HashMap<Character, Integer> map = new HashMap<>();

	// Loop through each character of the string
	for (int i = 0; i < name.length(); i++) {
	    char c = name.charAt(i); // Get character at index i
	    map.put(c, map.getOrDefault(c, 0) + 1); // Update the count for the character
	}

	// Alternative method for printing: Iterate over the map's keyset
	for (char key : map.keySet()) {
		if(map.get(key)>1)
		{
	    System.out.println(key + ": " + map.get(key));
		}
	}
 
 
	}
}
