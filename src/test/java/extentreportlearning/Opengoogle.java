package extentreportlearning;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Opengoogle {
	
	
	@Test(priority=2)
	public void openbrowser()
	{
		int [] chump = { 2 , 7 , 8 , 9 ,0};
		
	
		int[] Arr = {1, 2, 4, 8};
		int[] tempArr = Arrays.copyOfRange(chump, 2, 3);
		
		
		
	boolean um=	Character.isAlphabetic('2');
	
	System.out.println(um);
		
	}
	 /*
	 @Test
	 public void Navaid()
	 {
		 String raven = "dmabi";
		 
		 Character dog = raven.charAt(0);
		 
		 for(int i=0;i<raven.length();i++)
			
		 {
			 if(raven.charAt(i)==a)
			 {
		          System.out.println(raven.charAt(i));
		 }
		 
		 
	 }

*/
	 
	 @Test(priority=1)
	 public void exceptions()
	 {
		try {
			 
			 int a= 34;
		 int rock= 30;
		 
		 int rockz= 0;
		 if(a==34)
		 {
		 int suk = rock/rockz;
		 }
		 else
		 {
			 System.out.println("Never");
		 }
		}
		catch (Exception e) {
			System.out.println("RAM");
		}
		 
		 	
		 
		 System.out.println("mommomomom");
	 }
	 
	 
	 @Test(priority=3)
	 public void exceptionsd()
	 
	 {
		 System.out.println("HUMMMARAA");
	 }
	 
	 
	 
	 
	 
}
