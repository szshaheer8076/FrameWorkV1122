package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	
	@Test(dataProvider = "LoginData", dataProviderClass=DataProviders.class, groups="datadriven")
	public void verify_LoginDDT (String email, String pwd, String exp ) {
		
	logger.info("******** Staritng TC200_LoginTest*****");
		
	try {
	HomePage hp = new HomePage(driver);
	
	hp.clickAcc();
	hp.clicklogin();
	
	LoginPage lp = new LoginPage(driver);
	
	lp.setEmail(email);
	
	lp.setpassword(pwd);
	
	lp.clicklogin(null);
	
	MyAccountPage macc= new MyAccountPage(driver);
	
	boolean targetPage = macc.isMyAccountPageExists();
	
	if(exp.equalsIgnoreCase("valid")) {
		
		if(targetPage==true) {
			
			
			macc.clickLogout();
			Assert.assertTrue(true); 
		}
		
		else {
			Assert.assertTrue(false);
		}
	}

	
	if(exp.equalsIgnoreCase("invalid")) {
		
		if(targetPage==true) {
			
			
			macc.clickLogout();
			Assert.assertTrue(false);
		}
		
		else {
			Assert.assertTrue(true);
		}
	}
	
	}
	catch(Exception e) {
		Assert.fail();
	}
	
	logger.info("******** finished TC200_LoginTest*****");
	
	
	
	}
}
