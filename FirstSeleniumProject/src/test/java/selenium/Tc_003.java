package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Tc_003 extends BaseTest
{
	private static final Logger log=Logger.getLogger(Tc_003.class);
	
	public static void main(String[] args) throws Exception 
	{
		
		init();
		log.info("init properties:");
		
		Launch("Chromebrowser");
		log.info("Opening Browse:"+p.getProperty("Chromebrowser"));
		
		NavigateURL("Amazon");
		log.info("Navigate to URL:"+childprop.getProperty("Amazon"));
		
		selectOption("amazondropdown_id","Books");
		log.info("select option:"+orprop.getProperty("amazondropdown_id"));
		
		typeText("amazonSearchText_id","Harry Porter");
		log.info("type text:"+orprop.getProperty("amazonSearchText_id"));
		
		clickElement("amazonSearchButton_xpath");
		log.info("search:"+orprop.getProperty("amazonSearchButton_xpath"));
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Porter");
		
		//driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
		
		driver.close();
	}

	

}
