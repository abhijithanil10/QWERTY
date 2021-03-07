package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadNaukri {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		
		driver.findElement(By.xpath("//div[.='Login']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys("abhijithanil10@gmail.com");
			Thread.sleep(4000);

		 driver.findElement(By.xpath("//input[@class='err-border'])[1]")).sendKeys("abhijith99");
			Thread.sleep(4000);

			driver.findElement(By.xpath("//button[.='Login']")).click();
			Thread.sleep(4000);

		 driver.close();
		 				

	}

}
