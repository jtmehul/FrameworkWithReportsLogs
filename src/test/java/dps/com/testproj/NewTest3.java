package dps.com.testproj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class NewTest3 extends Base{

	static WebDriver driver;
	public ExtentReports extent1;
	public ExtentSparkReporter reporter;
	
	@BeforeTest
	public void startHere() {
		driver = Base.launchChromeTrellShop(driver);
		extent1 = ExtentReportCLS.getReportObject();
	}
	@Test(dataProvider="getData")
	
	public void startTrellShopWebsite(String searchTextHere) throws InterruptedException {

		 extent1.createTest("This is Third Case to be verified");
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 PageFactoryTrellShop trellShopPF = new PageFactoryTrellShop(driver);
		
		 //Wait till search text box appears
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Objects.txtSearchTextBox)));
		 trellShopPF.txtSearchTextBox(searchTextHere);
		 trellShopPF.searchTextEnter();

		 //Wait for the products to be displayed
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(trellShopPF.scrollToSearchedText));
		 JavascriptExecutor je = (JavascriptExecutor) driver;
		
		 //Scroll to the searched element
		 WebElement element = driver.findElement(trellShopPF.scrollToSearchedText);
		 je.executeScript("arguments[0].scrollIntoView(true);",element);
		 
		 String productPrice = driver.findElement(By.xpath(Objects.productPrice)).getText();
		 //Click on Add to cart button
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(trellShopPF.btnAddToCart));
		 driver.findElement(trellShopPF.btnAddToCart).click();
		
		 //Click on the cart value button displayed in bottom right corner
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(trellShopPF.btnCartValue));
		 driver.findElement(trellShopPF.btnCartValue).click();
		 
		//wait till product price displayed on the screen and then compère  it with price displayed after product search 
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Objects.mrpCheckout)));
		 String mrpValueAtCheckout = driver.findElement(By.xpath(Objects.mrpCheckout)).getText();
		 //Assert.assertEquals(productPrice, mrpValueAtCheckout);

		 //Wait for Proceed button visible
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(trellShopPF.btnProceed));
		 WebElement elementProceedToPay = driver.findElement(trellShopPF.btnProceed);
		
		 //Scroll to Proceed button
		 je.executeScript("arguments[0].scrollIntoView(true);", elementProceedToPay);
		 
		 //Click on Proceed button
		 elementProceedToPay.click();	 
	}
	@AfterTest
	public void closeBrowser() {
		//quite the browser
		 extent1.flush();
		 driver.quit();
	}
	
	@DataProvider 
	public Object[][] getData(){
		return new Object [][]{
				{ "Lakme Eyeconic Kajal"}
				};
	}
	
}
