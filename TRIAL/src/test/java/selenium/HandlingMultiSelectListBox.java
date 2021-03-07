package selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class HandlingMultiSelectListBox {	
	
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/abhij/OneDrive/Desktop/hotel.html");
		Thread.sleep(4000);
	
		
		WebElement MTRListBox = driver.findElement(By.id("mtr"));
		Select s= new Select(MTRListBox);
		
		ArrayList<String> list= new ArrayList<String>();
		
		
		
	List<WebElement> allOptions = s.getOptions();
		int count=allOptions.size();
		System.out.println(count);
		
		for(int i=0;i<count;i++)
		{
			WebElement option =allOptions.get(i);
			String text=option.getText();
			list.add(text);
			System.out.println(text);
		}
	
		System.out.println("---------");
		Collections.sort(list);
		for(String sortedtext:list)
		{
			System.out.println(sortedtext);

		}
		driver.close();
			}

}
