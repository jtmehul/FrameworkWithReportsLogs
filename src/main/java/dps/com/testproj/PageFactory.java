package dps.com.testproj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageFactory {

	

	WebDriver driver;
	
	public PageFactory(WebDriver driver) {
		this.driver = driver;
	}
	
	
	private static By btnMenu = By.xpath(Objects.btnMenu);
	private static By btnWeather = By.xpath(Objects.btnWeather);
	private static By btnCloseWeather = By.xpath(Objects.btnCloseWeather);
	private static By bntCloseMenu	= By.xpath(Objects.btnMenuClose);
	
	
	
		public WebDriver btnMenuClick() {
			driver.findElement(btnMenu).click();
			return driver;
		}
		
		public WebDriver btnWeatherClick() {
			driver.findElement(btnWeather).click();
			return driver;
		}
		public WebDriver btnWeatherClose() {
			driver.findElement(btnCloseWeather).click();
			return driver;
		}
		public WebDriver btnMenuClose() {
			driver.findElement(bntCloseMenu).click();
			return driver;
		}
}
