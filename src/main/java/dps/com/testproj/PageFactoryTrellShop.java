package dps.com.testproj;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PageFactoryTrellShop {
	
	 WebDriver driver;
	 WebElement element;
	
	public PageFactoryTrellShop(WebDriver driver) {
		this.driver = driver;
	}
	
	
	private static By cartBtn = By.xpath(Objects.btnTrellShopCartIcon);
	private static By txtSearch = By.cssSelector(Objects.txtSearchTextBox);	
	
	public  By scrollToSearchedText = By.xpath(Objects.scrollToText);
	public  By btnAddToCart = By.xpath(Objects.btnAddToCart);
	public  By btnCartValue = By.xpath(Objects.btnCartValue);
	public  By btnProceed = By.xpath(Objects.btnProceed);
	
	
	public WebDriver btnCartIconClickTrellShop() {
		driver.findElement(cartBtn).click();
		return driver;
	}
	
	public WebDriver txtSearchTextBox(String str) {
		driver.findElement(txtSearch).sendKeys(str);
		return driver;
	}
	
	public WebDriver searchTextEnter() {
		driver.findElement(txtSearch).sendKeys(Keys.ENTER);
		return driver;
	}
	
	public WebElement scrollTillSearchedText(WebElement element) {
		driver.findElement(scrollToSearchedText);
		return element;
	}
	
	
	
}
