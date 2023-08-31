package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class Tc_002_LoginTest extends BaseClass {

	@Test(groups= {"sanity","master"})
	public void test_Login()
	{
		logger.info("Starting Tc_002_LoginTest....");
		try
		{
		//homepage
		logger.info("clicking Homepage");

		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		lp.setPassword(rb.getString("password"));
		lp.clickLogin();
		
		logger.info("checking if My account displayed");
		//myaccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true);
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("finishing Tc_002_LoginTest....");

	}
}
