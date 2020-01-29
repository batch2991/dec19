package Yahoo_Prg;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MainClass 
{
  public static WebDriver driver; 
  
  public static ExtentHtmlReporter htmlreport;
  public static ExtentReports ext;
  public static ExtentTest log;
  
  @BeforeSuite
  public void initreport()
  {
	  //location of report...theame...title...heading...
	   htmlreport = new ExtentHtmlReporter("D:\\sel_prac\\yahooreport.html");
	   ext = new ExtentReports();
	   ext.attachReporter(htmlreport);
	   ext.setSystemInfo("Host Name", "SYS1");
	   ext.setSystemInfo("Environment", "Test Env");
	   ext.setSystemInfo("User Name", "Venkat");
	
	   
	   htmlreport.config().setDocumentTitle("Yahoo");
	   htmlreport.config().setReportName("Yahoo Functional Testing");
	   htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);
	   htmlreport.config().setTheme(Theme.STANDARD);
  }
  
  @AfterSuite
  public void updaterport()
  {
	   ext.flush();  //save the report
	   try
	   {
	   Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
	   Runtime.getRuntime().exec("taskkill /f /im geckodriver.exe");
	   }catch(Exception e) {}
  }
  
  
}
