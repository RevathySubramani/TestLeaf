package codingtest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CheapOAir {
	
	@Test
	public void getCheapestFlight() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.cheapoair.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Select one way trip
		WebElement tripType = driver.findElement(By.xpath("//label[text()='One Way']"));
		driver.executeScript("arguments[0].click", tripType);
		
		//Clear from value
		driver.findElement(By.xpath("//input[contains(@id,'from')]/following-sibling::a[@aria-label='clear field']")).click();
		
		//Enter from location
		driver.findElement(By.xpath("//input[contains(@id,'from')]")).sendKeys("Chennai",Keys.TAB);
		
		//Clear to location value
		driver.findElement(By.xpath("//input[contains(@id,'to')]/following-sibling::a[@aria-label='clear field']")).click();
		
		//Enter to location
		driver.findElement(By.xpath("//input[contains(@id,'to')]")).sendKeys("Bengaluru",Keys.TAB);
		
		//Select departure date
		driver.findElement(By.xpath("//input[contains(@id,'cal')]")).click();
		WebElement departureDate = driver.findElement(By.xpath("//a[@aria-label='2 January 2024']"));
		if(departureDate.isEnabled()) {
			departureDate.click();
		}
		else {
			System.out.println("Select valid current or future date");
		}
		
		//Close calendar widget
		driver.findElement(By.id("closeCalendar")).click();
		
		//Click traveller field
		driver.findElement(By.id("travellerButton")).click();
		
		//Increase adult count to 2
		driver.findElement(By.id("addadults")).click();
		
		//Close the traveller widget
		driver.findElement(By.id("closeDialog")).click();
		
		//Search flights
		driver.findElement(By.id("searchNow")).click();
		
		//Wait for the page to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.titleContains("Save on Cheap Flights, Cheap Airfares, Cheap Tickets"));
		
		//Locate the price element, get price value, sort and print the cheapest price
		List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='currency ']"));
		List<Double> priceList = new ArrayList<Double>();
		
		for (WebElement webElement : priceElements) {
			String priceValue = webElement.getAttribute("title");
			double price = Double.parseDouble(priceValue);
			priceList.add(price);
		}
		
		Collections.sort(priceList);	
		
		//System.out.println(priceList);
		System.out.println("Cheapest flight rate is " + priceList.get(0));
		
		driver.close();
		
	}

}
