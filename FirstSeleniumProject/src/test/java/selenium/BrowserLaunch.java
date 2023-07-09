package selenium;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch 
{

	public static void main(String[] args) 
	{
		//invoke browse using system property
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAIKAT\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		
		//invoke browse using webdrivermanager(use this always)
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

	}

}
