package VerificationsReportings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify1 {

	public static void main(String[] args) 
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remove-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in");
		
		String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		String expectedLink="Customer Service";
		
		if(actualLink.equals(expectedLink))
		{
			System.out.println("Both equal");
		}
		else 
		{
			System.out.println("not equal");
		}

	}

}
