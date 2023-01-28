package BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.grid.config.Role;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Reusable_Method {
	public static WebDriver driver;

	public static void browserLaunch(String value) {
		if (value.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Dhanam\\Downloads\\Maven_Concept\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		}

		else if (value.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", "");
		} else if (value.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "");

		}

	}

	public static void GetUrl(String url) {
		driver.get(url);

	}

	public static void maximize() {

		driver.manage().window().maximize();

	}

	public static void minimizeSize(int a, int b) {
		Dimension d = new Dimension(a, b);
		driver.manage().window().setSize(d);
	}

	public static void minimizePosition(int a, int b) {
		Point d = new Point(a, b);
		driver.manage().window().setPosition(d);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
		;
	}

	public static void navigateForward() {
		driver.navigate().forward();

	}

	public static void navigateBackWard() {
		driver.navigate().back();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();

	}

	public static void getTitle() {
		driver.getTitle();
	}

	public static void getCurrentUrl() {
		driver.getCurrentUrl();
	}

	public static void send(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void screenshot(String image) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\Dhanam\\Downloads\\Maven_Concept\\screenshot//" + image + ".png");
		FileUtils.copyFile(source, destination);

	}

	public static void scroll(WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver; // narrowing

		if (value.equalsIgnoreCase("elementClick")) {
			js.executeScript("arguments[0].click();", element);
		} else if (value.equalsIgnoreCase("elementView")) {
			js.executeScript("arguments[0].scrollIntoView();", element);
		} else if (value.equalsIgnoreCase("scrollUp")) {
			js.executeScript("window.scrollBy(0,0)");
		} else if (value.equalsIgnoreCase("scrollDown")) {
			js.executeScript("window.scrollBy(0,1000)");
		}
	}

	public static void thread(int a) throws InterruptedException {
		Thread.sleep(a);
	}

	public static void sleepForSec(int sec) throws InterruptedException {
		TimeUnit.SECONDS.sleep(sec);
	}

	public static void sleepForMin(int min) throws InterruptedException {
		TimeUnit.MINUTES.sleep(min);

	}

	public static void selectSingle(WebElement element, String value, String value2) {
		Select s = new Select(element);
		if (value.equalsIgnoreCase("value")) {
			s.selectByValue(value2);
		} else if (value.equalsIgnoreCase("index")) {
			int rupee = Integer.parseInt(value2);
			s.selectByIndex(rupee);
		} else if (value.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value2);
		}
	}

	public static void selectMultiple(WebElement element) {
		Select s = new Select(element);
		s.getAllSelectedOptions();

	}

	public static boolean isMultipleOptions(WebElement element) {
		boolean multiple=false;
		Select s = new Select(element);
		s.isMultiple();
return multiple;
	}

	public static void deselectSingle(WebElement element, String value, int a) {
		Select s = new Select(element);
		if (value.equalsIgnoreCase("deselectByValue")) {
			s.deselectByValue("a");
		} else if (value.equalsIgnoreCase("deselectByIndex")) {
			s.deselectByIndex(a);
		} else if (value.equalsIgnoreCase("deselectByText")) {
			s.deselectByVisibleText(value);
		}
	}

	public static void firstOption(WebElement element) {
		Select s = new Select(element);
		s.getFirstSelectedOption();

	}

	public static void simpleAlert(String value) {
		if (value.equalsIgnoreCase("accept")) {
			driver.switchTo().alert().accept();
		} else if (value.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		}
	}

	public static void promptAlert(String value) {
		driver.switchTo().alert().sendKeys(value);

	}

	public static boolean isEnable(WebElement element) {
		boolean enable = false;
	try {
			element.isEnabled();
		} catch (Exception e) {
			e.printStackTrace();
		}
	return enable;
		
	}

	public static boolean isdisplayed(WebElement element) {
		boolean displayed =false;
		try {
			element.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return displayed;
	}

	public static boolean isSelected(WebElement element) {
		boolean selected =false;
		element.isSelected();
	return selected;
	}

	public static void singleFrame(WebElement element) {
		driver.switchTo().frame(element);

	}

	public static void defaultContent() {
		driver.switchTo().defaultContent();
	}

	public static void multipleFrame(int a) {
		driver.switchTo().frame(a);
	}

	public static void FrameById(String id) {
		driver.switchTo().frame(id);

	}

	public static void actions(WebElement element, String value) {
		Actions mouse = new Actions(driver);
		if (value.equalsIgnoreCase("click")) {
			mouse.click(element).build().perform();
		} else if (value.equalsIgnoreCase("rightClick")) {
			mouse.contextClick(element).build().perform();

		} else if (value.equalsIgnoreCase("doubleClick")) {
			mouse.doubleClick(element).build().perform();

		} else if (value.equalsIgnoreCase("moveToElement")) {
			mouse.moveToElement(element).build().perform();
		}
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions mouse = new Actions(driver);
		mouse.dragAndDrop(source, target).build().perform();

	}

	public static void keyBoard(String value) throws Throwable {
		Robot r = new Robot();
		if (value.equalsIgnoreCase("down")) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		} else if (value.equalsIgnoreCase("up")) {
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		} else if (value.equalsIgnoreCase("enter")) {
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}

	}

	public static void windowHandles(String Ex_Title) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String id : windowHandles) {
			String title = driver.switchTo().window(id).getTitle();
			if (title.equals(Ex_Title)) {
				break;
			}
		}
	}

	public static void windowHandlesList(int a) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<>(windowHandles);
		driver.switchTo().window(list.get(a));

	}

	public static void screenshotAlternate(String name) throws Throwable {
		String des = "C:\\Users\\Dhanam\\Downloads\\Maven_Concept\\screenshot\\" + name + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File(des));

	}

}
