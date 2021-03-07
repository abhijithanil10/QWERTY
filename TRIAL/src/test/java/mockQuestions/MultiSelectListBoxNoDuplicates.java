package mockQuestions;

import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectListBoxNoDuplicates {
	
	
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/abhij/OneDrive/Desktop/hotel.html");
		
		WebElement MTRlist = driver.findElement(By.id("mtr"));
		Select s=new Select(MTRlist);
		TreeSet<String> set = new TreeSet<String>();
				
		List<WebElement> allOptions = s.getOptions();
		int count = allOptions.size();
		
		for(int i=0;i<count;i++){
			WebElement option=allOptions.get(i);
			String text = option.getText();
			if(set.add(text)==true) 
			{
			System.out.println(text);
			}	
		}driver.close();
	}
}