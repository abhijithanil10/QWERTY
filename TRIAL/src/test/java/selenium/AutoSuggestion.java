package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion {
	
	static {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			
	}

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		
		Thread.sleep(1000);
		
		List<WebElement> allauto = driver.findElements(By.xpath("//div[contains(text(),'iphone')]"));
		
		Thread.sleep(1000);
		
		int c=allauto.size();
		
		for(int i=0;i<c;i++)
		{
			String text= allauto.get(i).getText();
			System.out.println(text);
		}

	}

}
