package TestngRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleAnnotation {
	public static WebDriver driver;

	@BeforeSuite
	private void setProperty() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeTest
	private void browserLaunch() {
		driver = new ChromeDriver();
	}

	@BeforeClass
	private void getUrl() {
		driver.get("https://adactinhotelapp.com/");
	}

	@BeforeMethod
	private void signIn() {
		driver.findElement(By.id("username")).sendKeys("jokee10699");
		driver.findElement(By.id("password")).sendKeys("000000");
		driver.findElement(By.id("login")).click();
	}

	@Test
	private void searchHotel() {
		boolean displayed = driver.findElement(By.className("logo")).isDisplayed();
		System.out.println(displayed);

	}

	@AfterMethod
	private void logout() {
		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterClass
	private void homePage() {
		driver.findElement(By.linkText("Click here to login again")).click();
	}

	@AfterTest
	private void close() {
		driver.close();
	}

	@AfterSuite
	private void quit() {
		driver.quit();
	}
}
