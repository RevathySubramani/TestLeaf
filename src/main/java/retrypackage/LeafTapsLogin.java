package retrypackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ownerconfiguration.Configuration;

public class LeafTapsLogin {
	
		FileInputStream input;
		
		@Test
		public void login() {

		try {
			input = new FileInputStream("./src/main/resources/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties file = new Properties();
		try {
			file.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get(file.getProperty("url"));
		//driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Configuration.configuration().getUserName());
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys(Configuration.configuration().getPassword());
		driver.findElement(By.xpath("//input[contains(@class, 'Submit')]")).click();
		
		driver.close();
	}

}
