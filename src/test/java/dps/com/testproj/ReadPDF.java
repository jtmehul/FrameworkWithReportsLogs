package dps.com.testproj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPDF {

	public WebDriver driver = null;

	@BeforeTest
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		// instantiate the driver
		driver = new ChromeDriver();
	}

	@Test
	public void readPDFDocument() {
		driver.get(Objects.pdfFileURL);

		try {
			String pdfContent = readPdfContent(Objects.pdfFileURL);
			Assert.assertTrue(pdfContent.contains(Objects.matchPDFContentHeader));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	public static String readPdfContent(String urlPDF) throws IOException {

		// this code locates the pdf file only provided web url and then reads it
		// URL pdfUrl = new URL(urlPDF);
		// InputStream in = pdfUrl.openStream();

		// This code locally find the pdf file and read the text in it
		//PDF file is kept in recourse folder under project folder
		InputStream inputStream = new FileInputStream(urlPDF);
		BufferedInputStream bInputStream = new BufferedInputStream(inputStream);
		PDDocument pdfDocument = PDDocument.load(bInputStream);
		int numberOfPages = getPageCount(pdfDocument);
		System.out.println("The total number of pages " + numberOfPages);
		String content = new PDFTextStripper().getText(pdfDocument);
		System.out.println(content);
		pdfDocument.close();
		return content;
	}

	public static int getPageCount(PDDocument doc) {
		// get the total number of pages in the pdf document
		int pageCount = doc.getNumberOfPages();
		return pageCount;
	}

}
