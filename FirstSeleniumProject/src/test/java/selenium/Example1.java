package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example1 {

	public static void main(String[] args) 
	
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://money.rediff.com/gainers");
		
		////table[@class="dataTable"]/tbody/tr[6]/td[4]
		//String price = driver.findElement(By.xpath("//table[@class=\"dataTable\"]/tbody/tr[6]/td[4]")).getText();
		//Dynamic
		////a[contains(text(),'Sonalis Consumer Pro')]/parent::*/following-sibling::td[3]
		
		String price = driver.findElement(By.xpath("//a[contains(text(),'Sonalis Consumer Pro')]/parent::*/following-sibling::td[3]")).getText();
		System.out.println(price);
		driver.close();

	}

}
