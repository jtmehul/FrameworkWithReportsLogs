package dps.com.testproj;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class NewTest1 {
	
	static WebDriver driver;
	public ExtentReports extent3;
	public ExtentSparkReporter reporter;
	
	@BeforeTest
	public void startChromeHere() {
		  driver = Base.launchChromeBrowser(driver);
		  extent3 = ExtentReportCLS.getReportObject();
	}
  @Test
  public void startTestOne() {
	  extent3.createTest("This is first Test Case to be verified");
	  PageFactory pf = new PageFactory(driver);
	  //pf.btnWeatherClick();
  }
  @AfterTest
  public void quiteBrowser() {
	  extent3.flush(); 
	  driver.quit();
  }
}
