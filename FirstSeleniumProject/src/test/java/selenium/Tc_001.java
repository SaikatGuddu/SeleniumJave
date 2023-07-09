package selenium;

import java.sql.Driver;

public class Tc_001 extends BaseTest
{

	public static void main(String[] args) throws InterruptedException 
	{
		Launch("chrome");
		
		NavigateURL("https://www.amazon.in");
		
		// window maximize
		driver.manage().window().maximize();
		
		//title
		String title = driver.getTitle();
		System.out.println(title);

		//current url
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		//delete cookie
		driver.manage().deleteAllCookies();
		
		//backward, forward, refresh
		driver.navigate().back();
		Thread.sleep(3000);
		
		driver.navigate().forward();
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		//closing (only current active window)
		driver.close();
		
		//closing (all active window)
		driver.quit();
		
	}

}
