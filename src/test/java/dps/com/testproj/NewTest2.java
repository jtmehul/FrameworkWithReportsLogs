package dps.com.testproj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class NewTest2 {
  
	
  static WebDriver driver;
  public ExtentReports extent2;
  public ExtentSparkReporter reporter;
  
  
   @BeforeTest
  public void startFirFoxBrowser() {
	  driver = Base.launchFirefoxBrowser(driver);
	  extent2 = ExtentReportCLS.getReportObject(); 
  }
  
  @Test
  public void startFirefox() {  
	 
	  PageFactory pf = new PageFactory(driver);
	  extent2.createTest("This is Second Case to be verified");
	   WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
	  //Click on Menu button
	  pf.btnMenuClick();
	  //Click on Menu close button
	  pf.btnMenuClose();
	  //Click on Weather button
	  pf.btnWeatherClick();
	  //Click on close button for Weather
	  webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Objects.btnCloseWeather)));
	  pf.btnWeatherClose();
	  
  }
  @AfterTest
  public void closeFireFoxBrowser() {
	  extent2.flush(); 
	  driver.quit();
  }
}
