package Screenshot;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selfy4 {

	public static void main(String[] args) throws Exception
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remove-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		List<WebElement> links = driver.findElements(By.xpath("//div[@id=\"SIvCob\"]/a"));
		for(int i=0;i<links.size();i++)
		{
			String linkname = links.get(i).getText();
			links.get(i).click();
			
			File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(scrfile, new File("C:\\Users\\SAIKAT\\Desktop\\Java+Selenium Durgasoft\\Screesshot\\"+linkname+".png"));
			
			links = driver.findElements(By.xpath("//div[@id=\"SIvCob\"]/a"));
		}

	}

}
