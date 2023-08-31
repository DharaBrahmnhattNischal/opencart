package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class Tc_003_LoginDataDrivenTest extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_Login(String email,String pwd,String expres)
	{
		logger.info("Starting Tc_003_LoginDataDrivenTest....");
		try
		{
		//homepage
		logger.info("clicking Homepage");

		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		logger.info("checking if My account displayed");
		//myaccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		
		if(expres.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();//we put before assert bc agter assert it will not execute other statement
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(expres.equalsIgnoreCase("invalid"))
		{
			if(targetpage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}	
		
		
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("finishing Tc_003_LoginDataDrivenTest....");

	}
}
