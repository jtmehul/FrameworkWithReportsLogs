package dps.com.testproj;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBrokenLink {

	
	public ExtentReports extent;
	public ExtentSparkReporter reporter;
	public WebDriver driver;
	
	
	
	@BeforeTest
	public void startChromeHere() {
		  extent = ExtentReportCLS.getReportObject();
	}
	@Test
	public void newBrokenCheckLink() {
		// TODO Auto-generated method stub
		
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
	
		driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		extent.createTest("This is first Test Case for Broken Link Check");
		driver.get("https://www.amazon.in/");
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
				
		System.out.println("No of links present on amazone website is :---> " + linkList.size());	
		
		
		List<String> urlList = new ArrayList<String>();
		
		
		for(WebElement eLink : linkList) {
			String strURL = eLink.getAttribute("href");
			urlList.add(strURL);
			//brokenLinkCheck(strURL);
		}
		
		long startTime = System.currentTimeMillis();
		// Total time taken for execution :->37136 = 37.136 seconds
		urlList.parallelStream().forEach(e ->brokenLinkCheck(e));
		// apply normal stream here 
		// Total time taken for execution :->137070 =   1.37 Min
		//urlList.stream().forEach(e ->brokenLinkCheck(e));
		long endTime  = System.currentTimeMillis();
		System.out.println("Total time taken for execution :->" + (endTime - startTime));
		driver.quit();	
	}
	
	 @AfterTest
	  public void quiteBrowser() {
		  extent.flush(); 
		  driver.quit();
	  }
	
	public void brokenLinkCheck(String brokenLink) {
		try {
			URL url = new URL(brokenLink);
			//url.openConnection();
			HttpURLConnection urlHttpConnection = (HttpURLConnection) url.openConnection();
			urlHttpConnection.setConnectTimeout(5000);
			urlHttpConnection.connect();
			if(urlHttpConnection.getResponseCode()>=400) {
				System.out.println(brokenLink + "---> " + urlHttpConnection.getResponseMessage()+ " is a broken link");	
			}
			else {
				System.out.println(brokenLink + "---> " + urlHttpConnection.getResponseMessage()+ urlHttpConnection.getResponseCode());
			}
		}catch(Exception e) {
			
		}
	}
}
