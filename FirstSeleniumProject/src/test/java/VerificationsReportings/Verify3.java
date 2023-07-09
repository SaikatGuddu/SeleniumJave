package VerificationsReportings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.BaseTest;

public class Verify3 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		/*ChromeOptions option=new ChromeOptions();
		option.addArguments("--remove-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in");
		 */
		init();
		test= report.createTest("Verify3");
		test.log(Status.INFO, "init properties:");

		Launch("Chromebrowser");
		test.log(Status.PASS, "Opening Browse:"+p.getProperty("Chromebrowser"));
		//log.info("Opening Browse:"+p.getProperty("Chromebrowser"));

		NavigateURL("Amazon");
		test.log(Status.PASS, "Navigate to URL:"+childprop.getProperty("Amazon"));
		//log.info("Navigate to URL:"+childprop.getProperty("Amazon"));
		
		String expectedLink="Customer Ser";

		if(!isLinkEqual(expectedLink))
			//System.out.println("not Equal");
			reportFailure("not Equal");
		else
			reportPass("Equal");
		
		report.flush();

	}




}
