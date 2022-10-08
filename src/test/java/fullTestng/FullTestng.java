package fullTestng;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Excel;

public class FullTestng {
	@BeforeTest
	public void login() {
		
	}
	@BeforeMethod(alwaysRun = true)
	public void setUp(ITestContext context) {
	  
	}
	
	@DataProvider
	public Object[][] dataSet() throws IOException{
		String path = "src\\test\\resources\\data\\data-set.xlsx";
		return new Object[][] {
			{Excel.readExcel(path, "users", 1, 0), Excel.readExcel(path, "users", 1, 1)}
			,{"jesus", "password2"}
		};
		
	}
	
	@DataProvider
	public Object[][] dataset2() throws IOException{
		try {
			String path = "src\\test\\resources\\data\\data-set.xlsx";
			int row = Excel.rowNum(path, "users");
			int cell = Excel.cellNum(path, "users");
			Object[][] data = new Object[row-1][cell];
			for(int i=0;i<row-1;i++) {
				for(int j=0;j<cell;j++) {
					data[i][j] = Excel.cellValue(path, "users", i+1, j);
				}
			}
			System.out.println(data);
			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@DataProvider
	public Object[][] dataset3(){
		Object [][] data = new Object[2][2];
		data[0][0] = "rodri"; data[0][1] = "rodripass";
		data[1][0] = "jesus"; data[1][1] = "jesuspass";
		return data;
	}
	
	@Test(description = "descripcion1", enabled = true, dataProvider = "dataset2", groups = "regression")
	public void test(String nombre, String pass) {
		System.out.println(nombre+" "+pass);
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
