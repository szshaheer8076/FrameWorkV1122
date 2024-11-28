package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	
	public HomePage(WebDriver driver) {
		
		super(driver);
	}
	

		@FindBy(xpath="//span[normalize-space()='My Account']")
		
		WebElement Myacc;
		
		@FindBy(xpath="//a[normalize-space()='Register']")
		
		WebElement register;
		
		@FindBy(xpath="//a[normalize-space()='Login']")
		
		WebElement login;
		
		
		public void clickAcc() {
			
			Myacc.click();
			
		}
		
	public void clickregister() {
			
		register.click();
			
		}
	
	public void clicklogin() {
		
		login.click();
		
	}
}
