package fullTestng;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FullTestng {
	@BeforeTest
	public void login() {
		
	}
	@BeforeMethod(alwaysRun = true)
	public void setUp(ITestContext context) {
	  
	}
	
	@DataProvider
	public Object[][] dataSet(){
		return null;
		
	}
	
	@Test(description = "descripcion1", enabled = true, dataProvider = "dataSet", groups = "regression")
	public void test() {
		
	}
	
	@Test
	public void test1() {
		
	}
	
	@Test
	public void test2() {
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {
		
	}
	
	@AfterTest
	public void logOut() {
		
	}
}
