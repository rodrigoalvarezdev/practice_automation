package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utils.ExtentManager;

public class Commons {
	protected WebDriver driver;
	
	@BeforeSuite(groups = {"primero", "segundo"})
   	public void beforeTest() {
   		ExtentManager.initReport();
   	}
	
	 @AfterSuite(groups = {"primero", "segundo"})
	  public static void afterTest() {
		 ExtentManager.closeReport();
	  }
	 
		@BeforeMethod(alwaysRun = true, groups = {"primero", "segundo"})
		  public void beforeMethod() {
				System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
		  }
		@AfterMethod(alwaysRun = true, groups = {"primero", "segundo"})
		  public void afterMethod(ITestResult result) {
			  
			  Reporter.log(null, result.getStatus());
			  Reporter.log(result.getName());
			  driver.quit();
		  }
}
