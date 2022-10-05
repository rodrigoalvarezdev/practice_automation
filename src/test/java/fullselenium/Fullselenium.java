package fullselenium;

import org.testng.annotations.Test;

import dataProviders.DataProviderDemo;
import practice_tetng.Util;

import org.testng.annotations.BeforeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Fullselenium {
  private WebDriver driver;
  private Select select;
  Util util;
 
  
  By sel = By.id("oldSelectMenu");
  By multisel = By.id("cars");
  By links = By.tagName("a");
  //By header = By.xpath("//*[@id=\"app\"]/header/a");
  By toggleHome = By.xpath("//span[text()='Home']//ancestor::li/span/button");
  By checkHome = By.xpath("//span[@class='rct-title' and text()='Home']");
  By toggleDesktop = By.xpath("//span[text()='Desktop']//ancestor::span/button");
  By checkDesktop = By.xpath("//span[@class='rct-title' and text()='Desktop']");
  By frame = By.id("frame1Wrapper");
  By titleFrame = By.id("sampleHeading");
  By principalTitle = By.xpath("//*[@id=\"app\"]/header/a/img");
  By alertButton = By.id("alertButton");
  By alertDissmis = By.id("confirmButton");
  By tabButton = By.id("tabButton");
  By titleTab = By.id("sampleHeading");
  By hover = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]");
  By tShirt = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a");
  By drag = By.id("draggable");
  By drop = By.id("droppable");
  By resize = By.xpath("//*[@id=\"resizableBoxWithRestriction\"]/span");
  By user = By.id("userName");
  By mail = By.xpath("//input[@placeholder = 'name@example.com']");
  By address = By.id("currentAddress");
  By address2 = By.id("permanentAddress");
  By submit = By.id("submit");
  By firstnameForm = By.id("firstName");
  By lastnameForm = By.id("lastName");
  By footer = By.xpath("//*[@id=\"footer\"]/div/section[4]/div/a");
	@BeforeMethod(alwaysRun = true)
  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		util = new Util();
  }
  
  @Test(enabled = false, groups = {"segundo"})
  public void f() throws InterruptedException {
	  driver.get("https://demoqa.com/select-menu");
	  //driver.findElement(header).click();
	  select = new Select(driver.findElement(multisel));
	  //select.selectByVisibleText("Black");
	  //select.selectByIndex(1);
	  select.selectByValue("saab");
	  select.selectByValue("opel");
	  ArrayList<WebElement> list = new ArrayList<WebElement>(select.getAllSelectedOptions());
	  System.out.println(list.size());
	  Thread.sleep(3000);
	  select.deselectAll();
  }
  
  @Test(enabled = false, groups = {"segundo"})
  public void printLinks() {
	  driver.get("http://automationpractice.com/index.php");
	  driver.findElements(links);
	  ArrayList<WebElement> linkss = new ArrayList<WebElement>(driver.findElements(links));
	  for(WebElement i: linkss) {
		  System.out.println(i.getAttribute("href"));
	  }
	  
  }
  @Test(enabled = true, groups = {"primero"})
  public void checks () throws InterruptedException {
	  driver.get("https://demoqa.com/checkbox");
	  Thread.sleep(2000);
	  driver.findElement(toggleHome).click();
	  driver.findElement(checkHome).click();
	  Thread.sleep(2000);
	  driver.findElement(toggleDesktop).click();
	  driver.findElement(checkDesktop).click();
	  Thread.sleep(2000);
  }
  
  @Test(enabled = true, groups = {"primero"})
  public void frames() throws InterruptedException {
	  driver.get("https://demoqa.com/frames");
	  driver.switchTo().frame("frame1");
	  Assert.assertTrue(driver.findElement(titleFrame).isDisplayed());
	  driver.switchTo().parentFrame();
	  Assert.assertTrue(driver.findElement(principalTitle).isDisplayed());
	  Thread.sleep(3000);
  }
  
  @Test(enabled = false, groups = {"primero"})
  public void alert() throws InterruptedException {
	  driver.get("https://demoqa.com/alerts");
	  driver.findElement(alertButton).click();
	  Thread.sleep(6000);
	  driver.switchTo().alert().accept();
	  Thread.sleep(3000);
	  driver.findElement(alertDissmis).click();
	  Thread.sleep(3000);
	  driver.switchTo().alert().dismiss();
	  Thread.sleep(3000);
  }
  
  @Test(enabled = false, groups = {"primero"})
  public void switchTabs() throws InterruptedException {
	  driver.get("https://demoqa.com/browser-windows");
	  Thread.sleep(2000);
	  driver.findElement(tabButton).click();
	  Thread.sleep(2000);
	  Set<String> tabs = driver.getWindowHandles();
	  Iterator<String> iterator = tabs.iterator();
	  String tab1 = iterator.next();
	  String tab2 = iterator.next();
	  Thread.sleep(2000);
	  driver.switchTo().window(tab2);
	  Thread.sleep(2000);
	  Assert.assertTrue(driver.findElement(titleTab).isDisplayed());
	  driver.switchTo().window(tab1);
	  Thread.sleep(2000);
  }
  
  @Test(enabled = false, description = "actions", groups = "segundo")
  public void moveTo() throws InterruptedException {
	  driver.get("http://automationpractice.com/index.php");
	  Actions action = new Actions(driver);
	  action.moveToElement(driver.findElement(hover)).build().perform();
	  Thread.sleep(3000);
	  driver.findElement(tShirt).click();
	  Thread.sleep(3000);
  }
  
  @Test(enabled = false, description = "drag and drop", groups = "primero")
  public void dragdrop() throws InterruptedException {
	  driver.get("https://demoqa.com/droppable");
	  Actions action = new Actions(driver);
	  action.dragAndDrop(driver.findElement(drag), driver.findElement(drop)).build().perform();
	  Thread.sleep(5000);
  }
  
  @Test(enabled = false, description = "resize", groups = "primero")
  public void resize() throws InterruptedException {
	  driver.get("https://demoqa.com/resizable");
	  Actions action = new Actions(driver);
	  action.dragAndDropBy(driver.findElement(resize), 300, 50).build().perform();
	  Thread.sleep(5000);
  }
  
  
  @Test(enabled = false, description = "data provider", dataProvider = "dataSet", 
		dataProviderClass = DataProviderDemo.class)
  public void textBox(String username, String email, String dir, String bar) throws InterruptedException {
	  driver.get("https://demoqa.com/text-box");
	  driver.findElement(user).sendKeys(username);
	  driver.findElement(mail).sendKeys(email);
	  driver.findElement(address).sendKeys(dir);
	  driver.findElement(address2).sendKeys(bar);
	  driver.findElement(submit).click();
	  Thread.sleep(3000);
	  driver.findElement(user).clear();
	  driver.findElement(mail).clear();
	  driver.findElement(address).clear();
	  driver.findElement(address2).clear();
	  Thread.sleep(3000);
  }
  
  @Test(enabled = true)
  public void table() throws InterruptedException {
	  driver.get("https://demoqa.com/webtables");
	  //driver.findElement(util.searchEmailDelete("cierra@example.com")).click();
	  driver.findElement(util.editxEmail("cierra@example.com")).click();
	  Thread.sleep(3000);
	  util.editField(firstnameForm, driver, "rodri");
	  Thread.sleep(3000);
  }
  
  @Test(enabled = false)
  public void js() throws InterruptedException {
	  driver.get("http://automationpractice.com/index.php");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  WebElement foot = driver.findElement(footer);
	  js.executeScript("arguments[0].scrollIntoView(true);", foot);
	  Assert.assertTrue(foot.isDisplayed());
	  Thread.sleep(5000);
  }
  
  @AfterMethod(alwaysRun = true)
  public void afterMethod(ITestResult result) {
	  Reporter.log(null, result.getStatus());
	  Reporter.log(result.getName());
	  driver.quit();
  }

}
