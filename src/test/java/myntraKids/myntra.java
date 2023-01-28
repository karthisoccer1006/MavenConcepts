package myntraKids;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class myntra {
	public static WebDriver driver;
	public static WebElement totalProducts;
	public static int products;
	public static int minimumValue;
	public static String baseBrand;

	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.myntra.com/kids?f=Categories%3ATshirts%3A%3AGender%3Aboys%2Cboys%20girls&plaEnabled=false");
		driver.manage().window().maximize();

	}

	public static void screenshot() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\Dhanam\\Downloads\\Maven_Concept\\screenshot//image.png");
		FileUtils.copyFile(source, destination);
		File pic = new File("C:\\Users\\Dhanam\\Downloads\\Maven_Concept\\screenshot");

	}

	public static void totalNumberOfProducts() {
		List<WebElement> totalProducts = driver.findElements(By.xpath("//li[@class='product-base']"));
		products = totalProducts.size();
		System.out.println("total number of products=" + products);
	}

	public static void minimumPrice() {
		List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
		ArrayList<Integer> allPrices = new ArrayList<Integer>();
		for (WebElement eachPrice : priceList) {
			String replace = eachPrice.getText().replace("Rs. ", "");
			int priceValue = Integer.parseInt(replace);
			allPrices.add(priceValue);
		}
		minimumValue = Collections.min(allPrices);
		System.out.println("minimum price of products" + minimumValue);
	}

	public static void minimumBrandName(int minimumValue) {
		WebElement minBrandName = driver
				.findElement(By.xpath("//li[@class='product-base']//descendant::span[text()='" + minimumValue
						+ "']//ancestor::div[@class='product-productMetaInfo']//child::h3[@class='product-brand']"));
		baseBrand = minBrandName.getText();
		System.out.println("minimum brand name is " + baseBrand);

	}

	public static void minSubBrandName(String baseBrand) {
		WebElement minSubBrand = driver.findElement(By.xpath(
				"//li[@class='product-base']//descendant::span[@class='product-discountedPrice']//ancestor::div[@class='product-productMetaInfo']//child::h3[text()='"
						+ baseBrand + "']//following-sibling::h4[@class=\"product-product\"]"));
		String BaseSubBrand = minSubBrand.getText();
		System.out.println("minimum Sub Brand Name is" + BaseSubBrand);
		driver.close();
	}

	public static void main(String[] args) throws IOException {
		browserLaunch();
		screenshot();
		totalNumberOfProducts();
		minimumPrice();
		minimumBrandName(minimumValue);
		minSubBrandName(baseBrand);
	}

}
