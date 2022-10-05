package practice_tetng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin extends BaseSauceDemo {
	
	By inputNameLocator = By.id("user-name");
	By inputPasswordLocator = By.id("password");
	By btnLoginLocator = By.id("login-button");
	By titleHeaderPlp = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
	By btnBurgerLocator = By.id("react-burger-menu-btn");
	By btnLogoutLocator = By.id("logout_sidebar_link");
	By imgHomeLocator = By.xpath("//*[@id=\"root\"]/div/div[1]");
	
	public PageLogin(WebDriver driver) {
		super(driver);
	}
	
	public void signUp(String user, String password) {
		inputText(inputNameLocator, user);
		inputText(inputPasswordLocator, password);
		click(btnLoginLocator);
	}
	
	public String textAssert() {
		return getText(titleHeaderPlp);
	}
	
	public void waitTitlePlp() {
		WaitVisibility(titleHeaderPlp);
	}
	
	public void logOut() throws InterruptedException {
		WaitVisibility(btnBurgerLocator);
		click(btnBurgerLocator);
		WaitVisibility(btnLogoutLocator);
		click(btnLogoutLocator);
	}
	public Boolean imgAssert() {
		return driver.findElement(imgHomeLocator).isDisplayed();
	}
}
