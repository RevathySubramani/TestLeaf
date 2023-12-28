package codingtest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Techlistic {
	
	public String countryName = "India";
	
	@Test
	public void getCompanyName() {
		
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		
		//Locate the table
		WebElement table = driver.findElement(By.xpath("//div[@dir='ltr']/table[@id='customers']/tbody"));
		
		//get row count
		List<WebElement> row = table.findElements(By.tagName("tr"));
		int rowCount = row.size();
		//System.out.println(rowCount);
		
		//get column count
		//List<WebElement> column = row.get(0).findElements(By.tagName("th"));
		//int columnCount = column.size();
		//System.out.println(columnCount);
		
		//creating new list to store company values
		List<String> companies = new ArrayList<String>();
		//get company names from the table
		for(int i=2; i<=rowCount; i++) {
			String company = driver.findElement(By.xpath("//div[@dir='ltr']/table[@id='customers']/tbody/tr["+i+"]/td[1]/span")).getText();
			companies.add(company);
		}
		System.out.println(companies);
		
		//creating new list to store country values
		List<String> countries = new ArrayList<String>();
		//get country names from the table
		for(int i=2; i<=rowCount; i++) {
			String country = driver.findElement(By.xpath("//div[@dir='ltr']/table[@id='customers']/tbody/tr["+i+"]/td[3]/span")).getText();
			countries.add(country);
		}
		System.out.println(countries);
		
		//store the countries as key and companies as value in a map
		Map<String,String> tableList = new HashMap<String, String>();
		
		for (int i=0;i<countries.size();i++) {
			if(!tableList.containsKey(countries.get(i))) {
				if(!tableList.containsValue(companies.get(i))) {
					tableList.put(countries.get(i), companies.get(i));
				}
			}
		}
		System.out.println(tableList);	
		
		//generate random country data
		//Faker faker = new Faker();
		//String countryName = faker.country().name();
		System.out.println("The given country name is: " +countryName);
		
		if(tableList.containsKey(countryName)) {
			String companyName = tableList.get(countryName);
			System.out.println(countryName + " has " + companyName);
		}
		else {
			System.out.println("No match found");
		}	
		driver.close();
	}
}
