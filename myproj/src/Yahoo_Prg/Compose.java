package Yahoo_Prg;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import Yahoo_prop.ComposeP;
import Yahoo_prop.LoginP;

public class Compose extends MainClass
{
 public void sendmail() throws Exception
 {
	 Thread.sleep(5000);
	 driver.findElement(By.xpath(ComposeP.xcompose)).click();
	 Thread.sleep(5000);
	 try
	 {
		 if(driver.findElement(By.name(ComposeP.ito)).isDisplayed())
		 {
			 log=ext.createTest("PassTest");
			 log.log(Status.PASS, "Compose is working");
			 System.out.println("above one is for compose program");
			 File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(f,new File("d:\\sel_prac\\images\\compose.png"));
			 log.addScreenCaptureFromPath("d:\\sel_prac\\images\\compose.png");
			 
			 driver.findElement(By.id(ComposeP.ito)).sendKeys("abcd@gmail.com");
			 driver.findElement(By.id(ComposeP.isub)).sendKeys("testmail");
			 driver.findElement(By.id(ComposeP.ibody)).sendKeys("This is sample message in the body");
			 driver.findElement(By.xpath(ComposeP.xsend)).click();
			 Thread.sleep(5000);
		 }
	 }
	 catch(Exception e)
	 {
		    log=ext.createTest("FailTest");
		    log.log(Status.FAIL,"Compose not working");
		    File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f,new File("d:\\sel_prac\\images\\compose.png"));
			log.addScreenCaptureFromPath("d:\\sel_prac\\images\\compose.png");
	 }	 
 }
 public void close()
 {
	 driver.findElement(By.linkText(LoginP.lsignout)).click();
	 driver.close();
 }
}
