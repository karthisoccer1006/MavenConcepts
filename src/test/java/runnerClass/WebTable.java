package runnerClass;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import BaseClass.RealBaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {
	public static WebDriver driver;

	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().window().maximize();

	}

	
	public static void allData() {
		WebElement element = driver.findElement(By.id("customers"));
		List<WebElement> allData = element.findElements(By.xpath("//table/tbody/tr/td"));
		for (WebElement webElement : allData) {
			System.out.println(webElement.getText());

		}
	}

	public static void particularRow() {
		WebElement element = driver.findElement(By.id("customers"));
		List<WebElement> row = element.findElements(By.xpath("//table/tbody/tr[1]/td"));
		for (WebElement webElement : row) {
			System.out.println(webElement.getText());
		}
	}

	public static void particularColumn() {
		WebElement element = driver.findElement(By.id("customers"));
		List<WebElement> column = element.findElements(By.xpath("//table/tbody/tr/td[1]"));
		for (WebElement webElement : column) {
			System.out.println(webElement.getText());
		}
	}

	public static void particularData() {
		WebElement element = driver.findElement(By.id("customers"));
		WebElement data = element.findElement(By.xpath("//table/tbody/tr[1]]/td[1]"));
		System.out.println(data.getText());

	}

	public static void main(String[] args) {
		browserLaunch();
		allData();
//		particularRow();
//		particularColumn();
//		particularData();
		}
}
