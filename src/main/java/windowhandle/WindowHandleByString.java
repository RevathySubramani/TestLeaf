package windowhandle;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandleByString {
	
	@Test
	public void windowHandling() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[text()='Open Multiple']/parent::button")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			if(driver.getTitle().equals("Web Table")) {
				driver.close();
				
			}
		}
		
		driver.quit();
		
	}
}
