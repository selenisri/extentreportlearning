package extentreportlearning;

import org.testng.annotations.Test;

public class Reports {


	
	@Test
	public void callme()
	{
		
		int i=6;
		String hum="ram";
		if(!(i==7))
		{
			do
			{
				
				if(hum.equals("ram"))
				{
				System.out.println("Chumma");
				i++;
				}
			}while(i<=9);
		}
	}

}
