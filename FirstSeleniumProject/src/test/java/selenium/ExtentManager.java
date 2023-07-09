package selenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager extends BaseTest
{

	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports report;
	
	public static ExtentReports getInstance()
	{
		if(htmlReport==null)
		{
			htmlReport=new ExtentHtmlReporter("C:\\Users\\SAIKAT\\Desktop\\Java+Selenium Durgasoft\\Saikat Code\\FirstSeleniumProject\\Reports\\report.html");
			htmlReport.config().setDocumentTitle("Automation Report");
			htmlReport.config().setReportName("Functional report");
			htmlReport.config().setTheme(Theme.STANDARD);
			
			report=new ExtentReports();
			report.attachReporter(htmlReport);
			report.setSystemInfo("OS", "Windos 10");
			report.setSystemInfo("Tester Name", "Saikat");
		}
		return report;
		
	}
}
