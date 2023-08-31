package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;//**

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;// reading config.properties 
	@BeforeClass(groups={"sanity","regression","master"})
	@Parameters({"browser"})
	public void setup(String br) throws InterruptedException
	{
		rb=ResourceBundle.getBundle("config"); //loading config.properties 
		
		logger=LogManager.getLogger(this.getClass());
		//launching right brpwser from testng xml
		if(br.equals("chrome")) 
		{
			driver=new ChromeDriver();
		}
		else if (br.equals("edge"))
		{
			EdgeOptions Options= new EdgeOptions();
			Options.addArguments("--guest");
			driver=new EdgeDriver(Options);
		}
		else 
		{
			driver=new ChromeDriver();

		}
			
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appURL"));// in properties file WE HAVE TO KEEP IN ""
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@AfterClass(groups={"sanity","regression","master"})
	public void tearDown()
	{
		driver.quit();
	}

public String randomString()
{
	String generatedString=RandomStringUtils.randomAlphabetic(5);
	return generatedString;
	
}
		
	public String randomNumeric()
{
	String generatedString=RandomStringUtils.randomNumeric(10);
	return generatedString;
	
}		
			
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(5);
		String num=RandomStringUtils.randomNumeric(5);
		return str+num;
		
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
	
	}
		