package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDisabledElementsScroll {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("https://www.bbc.com/news");
		
		driver.findElement(By.xpath("//button[text()='Maybe later']")).click();
		
		JavascriptExecutor j=(JavascriptExecutor) driver;
		Object a = null;
		j.executeScript("window.scrollTo(0,document.body.scrollHeight)", a);
		Thread.sleep(4000);
		j.executeScript("window.scrollTo(0,0)",a);
		Thread.sleep(4000);
	}
}
