package mockQuestions;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAll {

	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		}

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		
		Set<String> allwh=driver.getWindowHandles();
		for(String wh:allwh)
		{
			driver.switchTo().window(wh);
			String title=driver.getTitle();
			System.out.println(title);
			driver.close();
			}

	}

}
