package dps.com.testproj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base extends Objects{
	
	WebDriver driver;
	public static WebDriver launchChromeBrowser(WebDriver driver) {	
		//WebDriverManager.chromedriver().setup();
	    //driver = new ChromeDriver();
		driver = new HtmlUnitDriver();
		driver.get(urlDps);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver launchFirefoxBrowser(WebDriver driver) {
		
		//WebDriverManager.firefoxdriver().setup();
		//driver = new FirefoxDriver();.
		driver = new HtmlUnitDriver();
		driver.get(urlAustin);
		driver.manage().window().maximize();		
		return driver;
	}
	public static WebDriver launchChromeTrellShop(WebDriver driver) {
		
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		driver = new HtmlUnitDriver();
		driver.get(urlTrellShop);
		driver.manage().window().maximize();		
		return driver;
	}
}
