package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

public class Tc_004 extends BaseTest
{
	private static final Logger log=Logger.getLogger(Tc_004.class);
	
	public static void main(String[] args) throws Exception 
	{
		
		init();
		test= report.createTest("Tc_004");
		test.log(Status.INFO, "init properties:");
		
		Launch("Chromebrowser");
		test.log(Status.PASS, "Opening Browse:"+p.getProperty("Chromebrowser"));
		//log.info("Opening Browse:"+p.getProperty("Chromebrowser"));
		
		NavigateURL("Amazon");
		test.log(Status.FAIL, "Navigate to URL:"+childprop.getProperty("Amazon"));
		//log.info("Navigate to URL:"+childprop.getProperty("Amazon"));
		
		selectOption("amazondropdown_id","Books");
		test.log(Status.PASS, "select option:"+orprop.getProperty("amazondropdown_id"));
		//log.info("select option:"+orprop.getProperty("amazondropdown_id"));
		
		typeText("amazonSearchText_id","Harry Porter");
		test.log(Status.PASS, "type text:"+orprop.getProperty("amazonSearchText_id"));
		//log.info("type text:"+orprop.getProperty("amazonSearchText_id"));
		
		clickElement("amazonSearchButton_xpath");
		test.log(Status.PASS, "search:"+orprop.getProperty("amazonSearchButton_xpath"));
		//log.info("search:"+orprop.getProperty("amazonSearchButton_xpath"));
		
		
		report.flush();
		
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Porter");
		
		//driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		
		driver.close();
	}

	

}
