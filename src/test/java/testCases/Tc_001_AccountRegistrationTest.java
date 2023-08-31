package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class Tc_001_AccountRegistrationTest extends BaseClass {

	
	

	
	@Test(groups= {"sanity","master"})
	public void test_accountRegistration()
	{
		
		logger.info("****************starting Tc_001_AccountRegistrationTest************");
		HomePage hp=new HomePage(driver);
		logger.info("clicking my account link");
		hp.clickMyAccount();
		logger.info("clicking registration link");
		hp.clickRegister();
		logger.info("providing customer details");

		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLasName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumeric());
		
		String password=randomAlphaNumeric();
		
		
		regpage.setPassword(password);
		regpage.setconfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String conmsg=regpage.getConfirmationMsg();
		if(conmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Registration successful!!!");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("**Registration failed **");
			Assert.fail();
		}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}		
	
}
