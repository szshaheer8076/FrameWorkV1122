package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	
public AccountRegistrationPage(WebDriver driver) {
		
		super(driver);
}



		@FindBy(xpath="//input[@id='input-firstname']")
		
		WebElement firstname;
		
		@FindBy(xpath="//input[@id='input-lastname']")
		WebElement lastname;
		@FindBy(xpath="//input[@id='input-email']")
		WebElement email;
		@FindBy(xpath="//input[@id='input-password']")
		WebElement password;
		

        @FindBy(xpath="//input[@name='agree']")
        WebElement agree;
        

        @FindBy(xpath="//button[normalize-space()='Continue']")
        
        WebElement btn;
        
        public void setFirstname(String fname) {
        	firstname.sendKeys(fname);
        	
        }
        
        public void setlastname(String lname) {
        	lastname.sendKeys(lname);
        	
        }
        
        public void setemail(String em) {
        	email.sendKeys(em);
        	
        }
        
        public void setepassword(String pwd) {
        	password.sendKeys(pwd);
        	
        }
        
        
        
        
        public void setagree() {
        	agree.click();;
        	
        }
        
        public void setcontinue() {
        	btn.click();;
        	
        }
        
      /*  public String getConfirmationMsg() {
        	
        	try {
        		return(msgConfirmation.getText());
        	}
        	catch(Exception e) {
        		return(e.getMessage());
        	}
        }*/
        
  
        
        
        
        
        
}
		
		


