package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDrivenExcel {
		
		static {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		}

		public static void main(String[] args) throws EncryptedDocumentException, IOException, FileNotFoundException  {
		
			FileInputStream fis = new FileInputStream("./data/Book1.xlsx");
			
			Workbook wb = WorkbookFactory.create(fis);
			
			String value = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();

			System.out.println(value);

}
}
