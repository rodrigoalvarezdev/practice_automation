package practice_tetng;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNgPractice {
	private int num1;
	private int num2;
	
	@BeforeMethod
	public void beforeMethod() {
		num1 = 5;
		num2 = 10;
	}

	@Test(description="verificar que numero 1 es mayor a numero 2")
  public void f() {
		Assert.assertTrue(num1 < num2, "num1 deberia ser mayor num2");
  }
	
	@Test(description="verificar que numero 1 sumando 5 sea igual numero 2")
	public void g() {
		Assert.assertTrue(num1+4 == num2, "num1 incrementado 5 deberia ser igual a num2");
	}
	
	@Test(enabled=false)
	public void i() {
		System.out.println("esto no debería salir");
	}
	
	@Test(description= "verificar igualdad")
	public void j() {
		Assert.assertEquals(1, 1, "deberian ser iguales");
	}
	
	@AfterMethod
	public void h(ITestResult result) {
		System.out.println("el test " + result.getMethod().getDescription()+" resultó: "+result.getStatus());
		System.out.println("programa terminado");
	}
  
  

}
