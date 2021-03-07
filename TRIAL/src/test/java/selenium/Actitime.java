package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class Actitime {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
	}

	public static void main(String[] args) {
		

		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://demo.actitime.com/login.do");
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		driver.close();
		
		
	}

}
