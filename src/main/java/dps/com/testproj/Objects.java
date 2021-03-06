package dps.com.testproj;

public class Objects {
	
	
	public static String urlDps = "https://www.dps.texas.gov/";
	public static String urlAustin = "https://www.austintexas.org/";
	public static String btnMenu =  "//button[@id='pop-out-control']";
	public static String btnWeather = "//button[@name='weather-control']";
	public static String btnCloseWeather = "//button[@class='weather-control active']";
	public static String btnMenuClose = "//button[@class='initial active']";

	
	// Trell Shop 
	public static String urlTrellShop	= "https://shop.trell.co/?utm_source=Trell%20Web&utm_medium=Home&utm_content=Shop%20Now";
	public static String btnTrellShopCartIcon = "//*[@class='d-flex align-items-center position-relative']";
	public static String txtSearchTextBox = "#search-input";
	public static String scrollToText = "(//*[@class='item-productName-2bT'])[1]";
	public static String btnAddToCart = "(//*[contains(text(), 'ADD TO CART')])[1]";
	public static String btnCartValue = "//*[@class='header-cartValueBtn-ivy']";
	public static String btnProceed = "//*[@class='totalsSummary-proceedButtonText-1Kl']";
	public static String productPrice = "(//*[@class='item-productPrice-36i'])[2]";
	public static String totalMRP = "(//*[@class='totalsSummary-detailsTitle-30t'])[1]//span[2]//span[2]";
	public static String mrpCheckout = "(//*[@class='product-mrpValues-eSI'])";
	
	public static String strURLForBrokenLinkPageCheck = "https://www.amazon.in/";
	 
	//https://shop.trell.co/
	//https://www.amazon.in/
	//
	
	
	//Adding PDF file location as string
	public static String pdfFileURL = System.getProperty("user.dir")+ "\\resource\\Get_Started_With_Smallpdf.pdf";
	public static String matchPDFContentHeader = "Welcome to Smallpdf";
	
}
