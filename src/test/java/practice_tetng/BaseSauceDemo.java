package practice_tetng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSauceDemo {
	WebDriver driver;
	
	public BaseSauceDemo(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver chromeConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  return driver;
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void inputText(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
		
	}
	
	public void WaitVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
