package practice_tetng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Util {
	public By searchEmailDelete(String text) {
		By locator = By.xpath("//*[text()='"+text+"']/parent::*/*[7]/*/span[@id='delete-record-1']");
		
		return locator;	
	}
	
	public By editxEmail(String text) {
		By locator = By.xpath("//*[text()='"+text+"']/parent::*/*[7]/*/span[@id='edit-record-1']");
		
		return locator;	
	}
	
	public void editField(By locator, WebDriver driver, String text) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}
}
