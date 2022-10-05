package practice_tetng;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Helper {
	WebDriver driver;
	
	public Helper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void newTab(String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeAsyncScript("window.open('"+url+"')");
	}
	
	public void handlesTab(int index) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(index));
		System.out.println(driver.getWindowHandle());
	}
}
