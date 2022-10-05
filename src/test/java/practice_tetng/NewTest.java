package practice_tetng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NewTest {
	WebDriver driver;
	ArrayList<String> tabs;
	ArrayList<WebElement> links;
	By btn = By.id("simpleLink");
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/broken");
		
	}
  @Test(enabled = false)
  public void f() throws InterruptedException {
	  System.out.println(driver.getWindowHandle());
	  driver.findElement(btn).click();
	  Thread.sleep(2000);
	  tabs = new ArrayList<String>(driver.getWindowHandles());
	  driver.switchTo().window(tabs.get(1));
	  System.out.println(driver.getWindowHandle());
	  Thread.sleep(5000);
  }
  
  @Test
  public void testLinks() throws MalformedURLException, IOException {
	  links = new ArrayList<WebElement>(driver.findElements(By.tagName("a")));
	  for (WebElement i : links) {
		  if (i.getAttribute("href")==null || i.getAttribute("href").isEmpty()) {
			  System.out.println(i.getText() + " link vacio o nulo");
			  System.out.println("sin codigo");
		  }else {
		  
		  HttpURLConnection httpConection = (HttpURLConnection)(new URL(i.getAttribute("href")).openConnection());
		  httpConection.setRequestMethod("HEAD");
		  httpConection.connect();
		  int responseCode = httpConection.getResponseCode();
		  System.out.println(i.getText() + " " + i.getAttribute("href"));
		  System.out.println(responseCode);
	}}
	  
	 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
