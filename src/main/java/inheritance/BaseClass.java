package inheritance;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class BaseClass {
	
	public RemoteWebDriver driver;
	
	@BeforeTest
	public void preConditions() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();	
	}
	
	/*
	 * @Test public void search() { Shadow shadowDriver = new Shadow(driver);
	 * shadowDriver.findElementByXPath("//input[contains(placeholder,'Search')]").
	 * sendKeys("New Year", Keys.TAB); }
	 */

}
