package inheritance;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class ChildClass extends BaseClass{
	
	@BeforeTest
	public void preConditions() {
		driver = new FirefoxDriver();
		driver.get("https://www.msn.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();	
	}
	
	@Test
	public void search() {
		Shadow shadowDriver = new Shadow(driver);
		shadowDriver.findElementByXPath("//input[@type='search']").sendKeys("New Year", Keys.TAB);
	}
}