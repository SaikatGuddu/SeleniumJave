package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static Properties p;
	public static FileInputStream fis;
	public static Properties mainprop;
	public static Properties childprop;
	public static Properties orprop;
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	
	public static void init() throws Exception 
	{
		fis=new FileInputStream("C:\\Users\\SAIKAT\\Desktop\\Java+Selenium Durgasoft\\Saikat Code\\FirstSeleniumProject\\src\\test\\resources\\data.properties");
		p= new Properties();
		p.load(fis);
		p.getProperty("Chromebrowser");
		p.getProperty("firefoxbrowser");
		p.getProperty("Amazon");
		
		fis=new FileInputStream("C:\\Users\\SAIKAT\\Desktop\\Java+Selenium Durgasoft\\Saikat Code\\FirstSeleniumProject\\src\\test\\resources\\Environment.properties");
		mainprop=new Properties();
		mainprop.load(fis);
		String s=mainprop.getProperty("env");
		
		fis=new FileInputStream("C:\\Users\\SAIKAT\\Desktop\\Java+Selenium Durgasoft\\Saikat Code\\FirstSeleniumProject\\src\\test\\resources\\"+s+".properties");
		childprop=new Properties();
		childprop.load(fis);
		childprop.getProperty("Amazon");
		
		fis=new FileInputStream("C:\\Users\\SAIKAT\\Desktop\\Java+Selenium Durgasoft\\Saikat Code\\FirstSeleniumProject\\src\\test\\resources\\or.properties");
		orprop= new Properties();
		orprop.load(fis);
		
		fis=new FileInputStream("C:\\Users\\SAIKAT\\Desktop\\Java+Selenium Durgasoft\\Saikat Code\\FirstSeleniumProject\\src\\test\\resources\\log4jconfig.properties");		
		PropertyConfigurator.configure(fis);
		
		report=ExtentManager.getInstance();
		
	}
	
	public static void Launch(String Browser) 
	{
		
		if(p.getProperty(Browser).equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if (p.getProperty(Browser).equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if (p.getProperty(Browser).equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
	}
	
	
	public static void NavigateURL(String URL) 
	{
		driver.get(childprop.getProperty(URL));
	}
	
	public static void clickElement(String locatorKey)
	{
		getElement(locatorKey).click();
		//driver.findElement(By.xpath(orprop.getProperty(locatorKey))).click();
		
	}

	public static WebElement getElement(String locatorKey) 
	{
		WebElement element=null;
		
		//check of locator present
		if(!isElementPresent(locatorKey))
		{
			System.out.println("Element not present"+ locatorKey);
		}
		
		element=driver.findElement(getLocator(locatorKey));
		/*
		if(locatorKey.endsWith("_id")) {
			element=driver.findElement(By.id(orprop.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_name")) {
			element=driver.findElement(By.name(orprop.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_xpath")) {
			element=driver.findElement(By.xpath(orprop.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_cssselector")) {
			element=driver.findElement(By.cssSelector(orprop.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_classname")) {
			element=driver.findElement(By.className(orprop.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_linkedtext")) {
			element=driver.findElement(By.linkText(orprop.getProperty(locatorKey)));
		}else if (locatorKey.endsWith("_partiallinkedtext")) {
			element=driver.findElement(By.partialLinkText(orprop.getProperty(locatorKey)));
		}
		*/
		
		return element;
	}

	public static boolean isElementPresent(String locatorKey) 
	{
		System.out.println("checking:"+locatorKey);
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
		
		/*
		if(locatorKey.endsWith("_id"))
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orprop.getProperty(locatorKey))));
		}
		if(locatorKey.endsWith("_name"))
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orprop.getProperty(locatorKey))));
		}
		if(locatorKey.endsWith("_className"))
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orprop.getProperty(locatorKey))));
		}
		if(locatorKey.endsWith("_xpath"))
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orprop.getProperty(locatorKey))));
		}
		if(locatorKey.endsWith("_csselector"))
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orprop.getProperty(locatorKey))));
		}
		if(locatorKey.endsWith("_linktext"))
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orprop.getProperty(locatorKey))));
		}
		if(locatorKey.endsWith("_partiallinktext"))
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(orprop.getProperty(locatorKey))));
		}
		
		*/
		return true;
	}

	public static void typeText(String locatorKey, String text) 
	{
		getElement(locatorKey).sendKeys(text);
		//driver.findElement(By.id(orprop.getProperty(locatorKey))).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String item)
	{
		
		getElement(locatorKey).sendKeys(item);
		//driver.findElement(By.id(orprop.getProperty(locatorKey))).sendKeys(item);
	}
	
	public static By getLocator(String locatorKey) 
	{
		By by=null;
		
		if(locatorKey.endsWith("_id"))
		{
			by=By.id(orprop.getProperty(locatorKey));
		}
		else if (locatorKey.endsWith("_name"))
		{
			by=By.name(orprop.getProperty(locatorKey));
		}
		else if (locatorKey.endsWith("_classname"))
		{
			by=By.className(orprop.getProperty(locatorKey));
		}
		else if (locatorKey.endsWith("_xpath"))
		{
			by=By.xpath(orprop.getProperty(locatorKey));
		}else if (locatorKey.endsWith("_csselector"))
		{
			by=By.cssSelector(orprop.getProperty(locatorKey));
		}
		else if (locatorKey.endsWith("_linktext"))
		{
			by=By.linkText(orprop.getProperty(locatorKey));
		}
		else if (locatorKey.endsWith("_partiallinktext"))
		{
			by=By.partialLinkText(orprop.getProperty(locatorKey));
		}
		return by;
		
	}
	
	//Link quual or not
	
	public static boolean isLinkEqual(String expectedLink) 
	{
		
		String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		if(actualLink.equals(expectedLink))
		return true;
		else
		return false;
	}

	//reporting
	public static void reportPass(String passMessage) 
	{
		test.log(Status.PASS, passMessage);
		
	}

	public static void reportFailure(String failMessage) throws Exception 
	{
		
		test.log(Status.FAIL, failMessage);
		takesScreenshot();
	}
	
	//Take screenshot
	public static void takesScreenshot() throws Exception
	{
		Date dt=new Date();
		System.out.println(dt);
		String dateFormat=dt.toString().replace(":", "_").replace(" ", "_")+".png";		
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrFile, new File(System.getProperty("user.dir")+"//failurescreenshots//"+dateFormat));
		
		test.log(Status.INFO,"Screenshot --->" +test.addScreenCaptureFromPath(System.getProperty("user.dir")+"//failurescreenshots//"+dateFormat));
	}
	

}
