package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeletePageObject {
	
	public static  WebDriver driver;
	public static WebDriverWait wait;
	
	public static By Action_btn = By.xpath("//h6[text()='kilo']//following::button[1]");
	public static By Delete_menu = By.xpath("//span[text()='Delete']");
	public static By yes_btn = By.xpath("//button[text()='Delete']");
	public static By success_message = By.id("toastmsg");
	
	
	public void ClickActionButton(WebDriver driver )
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement field = wait.until(ExpectedConditions.elementToBeClickable(Action_btn));
		field.click();
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
	

}
