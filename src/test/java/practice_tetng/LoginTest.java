package practice_tetng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	private WebDriver driver;
	PageLogin page;
	WriteExcelFile writeFile;
	ReadExcelFile readFile;
	
  @BeforeClass
  public void setUp() {
	  page = new PageLogin(driver);
	  driver = page.chromeConnection();
	  writeFile = new WriteExcelFile();
	  readFile = new ReadExcelFile();
	  page.visit("https://www.saucedemo.com/");
  }
  
  @AfterClass
  public void tearDown() {
	  driver.quit();
  }
  
  @DataProvider(name = "authenticationData")
  public Object[][] getData() throws IOException{
	  String filepath = "E:\\Programacion\\user-saucedemo.xlsx";
	  String userName = readFile.getCellValue(filepath, "hoja 1", 1, 0);
	  String password = readFile.getCellValue(filepath, "hoja 1", 1, 1);
	  Object[][]data = new Object[1][2];
	  data[0][0] = userName; data[0][1] = password;
	  //data[1][0] = "standard_user"; data [1][1] = "secret_sauce";
	  return data;
  }
  
  @Test(dataProvider = "authenticationData")
  public void signUpTest(String user, String password) throws InterruptedException, IOException {
	  String filepath = "E:\\Programacion\\user-saucedemo.xlsx";
	  page.signUp(user, password);
	  page.waitTitlePlp();
	  writeFile.writeCellValue(filepath, "hoja 1", 1, 2, page.textAssert());
	  assertEquals(page.textAssert(), "PRODUCTS");
	  page.logOut();
	  assertTrue(page.imgAssert());
	  readFile.readExcel(filepath, "hoja 1");
  }
}
