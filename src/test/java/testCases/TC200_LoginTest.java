package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC200_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity", "Master"})
	public void verify_login() {
		
		logger.info("******** Staritng TC200_LoginTest*****");
		
		try{
		HomePage hp = new HomePage(driver);
		
		hp.clickAcc();
		hp.clicklogin();
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setEmail(p.getProperty("email"));
		
		lp.setpassword(p.getProperty("password"));
		
		lp.clicklogin(null);
		
		MyAccountPage macc= new MyAccountPage(driver);
		
		boolean targetPage = macc.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*******Finished TC200_LoginTest*******");
		
		
		
	}

}
