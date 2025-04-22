package lamdaseleniumpack;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Test_trailx {
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","‪‪C:\\testdrivers\\geckodriver.exe");
	WebDriver driver=new FirefoxDriver();
	driver.get("https://www.trialx.com");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	Actions act=new Actions(driver);
	WebElement search=driver.findElement(By.id("search-medical-conditions"));
	search.sendKeys("heart");
    Thread.sleep(3000);
    WebElement location=driver.findElement(By.name("place"));
    location.sendKeys("hyderabad");
    Thread.sleep(2000);
    location.sendKeys(Keys.ARROW_DOWN);
    location.sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    
    location.submit();
   
    List<WebElement> searchResults = driver.findElements(By.cssSelector("div.aos-init.aos-animate"));

 System.out.println("Search Results:");
 for (WebElement result : searchResults) {
     System.out.println(result.getText());
 }

    Thread.sleep(3000);
    driver.navigate().back();
    
    Thread.sleep(3000);
    // Negative test scenarios by entering incorrect location
    WebElement n_search = driver.findElement(By.id("search-medical-conditions"));
    n_search.click(); 
    n_search.sendKeys(Keys.CONTROL + "a"); 
    n_search.sendKeys(Keys.BACK_SPACE); 
    Thread.sleep(2000);

    n_search.sendKeys("eyes");
    Thread.sleep(3000);

    
    WebElement n_location = driver.findElement(By.name("place"));
    n_location.sendKeys("5264");
    Thread.sleep(2000);
    n_location.submit();
    

}
}