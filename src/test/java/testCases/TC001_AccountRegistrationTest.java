package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	
	
	@Test(groups={"Regression", "Master"})
	public void verification() {
		
		logger.info("****** Starting TC001_AccountRegistrationTest ******** ");
		
		try {
		HomePage hp  = new HomePage(driver);
		
		hp.clickAcc();
		logger.info("Click in my account ");
		hp.clickregister();
		logger.info("click on register");
		
		AccountRegistrationPage page =  new AccountRegistrationPage(driver);
		logger.info("providing customer detals");
		page.setFirstname(randomString().toUpperCase());
		page.setlastname(randomString().toUpperCase());
		page.setemail(randomString()+"@gmail.com");
		page.setepassword("9283647");
		page.setagree();
		page.setcontinue();
		
		logger.info("validating expected message");
		
		/*String confmsg = page.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "your account has been created!");*/
		
		}
		
		catch(Exception e) {
			logger.error("test failed");
			logger.debug("debug");
			Assert.fail();
		}
		
		 
		
	}
	
	
}
