package fullTestng;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners  implements ITestListener {
  public void onTestStart(ITestResult result) {
	  System.out.println("el test comienza desde suite");
  }
  
  public void onTestFailure(ITestResult result) {					
      System.out.println("take a screenshot");		
  }	
  
  public void onTestSuccess(ITestResult result) {					
      System.out.println("test existoso");				
      		
  }

}
