package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.redbus.in/");
		//Xpath= //div[@id="onwardCal"]
		
		driver.findElement(By.xpath("//div[@id=\"onwardCal\"]")).click();
		
		//driver.wait(5000);
		//xpath= //div[@id="onwardCal"]/div/div/text[2]
		
		//String month = driver.findElement(By.xpath("//div[@id=\"onwardCal\"]/div/div/text[2]")).getText();
		//System.out.println(month);
		
		//driver.close();

	}
	

}
