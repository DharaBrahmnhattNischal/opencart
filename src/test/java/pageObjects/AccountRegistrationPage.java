package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}


	

@FindBy(xpath="//input[@id='input-firstname']") 
WebElement txtfirstName;
@FindBy(xpath="//input[@id='input-lastname']") 
WebElement txtlastName;
@FindBy(xpath="//input[@id='input-email']") 
WebElement txtEMail;
@FindBy(xpath="//input[@id='input-telephone']") 
WebElement txttelephone;
@FindBy(xpath="//input[@id='input-password']") 
WebElement txtpassword;
@FindBy(xpath="//input[@id='input-confirm']") WebElement 
txtpasswordConfirm;
@FindBy(xpath="//input[@name='agree']") WebElement 
chkPolicy;
@FindBy(xpath="//input[@value='Continue']") 
WebElement btncontinue;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") 
WebElement msgConfirmation;

public void setFirstName(String fname)
{
	txtfirstName.sendKeys(fname);
}


public void setLasName(String lname)
{
	txtlastName.sendKeys(lname);
}

public void setEmail(String email)
{
	txtEMail.sendKeys(email);
}

public void setTelephone(String tel)
{
	txttelephone.sendKeys(tel);
}

public void setPassword(String pwd)
{
	txtpassword.sendKeys(pwd);
}

public void setconfirmPassword(String pwd)
{
	txtpasswordConfirm.sendKeys(pwd);
}

public void setPrivacyPolicy()
{
	chkPolicy.click();
}

public void clickContinue()
{
	btncontinue.click();
}
		
		//sol2 (interview perspective
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		

public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());

	}

}
}
