package BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RealBaseClass {
	public static WebDriver driver;

	public static WebDriver browserLaunch(String value) throws Throwable {
		try {
			if (value.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Dhanam\\Downloads\\Maven_Concept\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (value.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "");
				driver = new FirefoxDriver();
			} else if (value.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "");
				driver = new InternetExplorerDriver();
			} else {
				throw new Exception("Browser name id not valid");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return driver;

	}

	public static void getUrl(String url) {
		try {
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();

		}

	}

	public static void maximize() {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public static void minimizeSize(int a, int b) {
		try {
			Dimension d = new Dimension(a, b);
			driver.manage().window().setSize(d);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public static void minimizePosition(int a, int b) {
		try {
			Point p = new Point(a, b);
			driver.manage().window().setPosition(p);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public static boolean isDisplayed(WebElement element) {
		boolean displayed = false;
		try {
			element.isDisplayed();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return displayed;
	}

	public static boolean isEnabled(WebElement element) {
		boolean enabled = false;
		try {
			element.isEnabled();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return enabled;
	}

	public static boolean isSelected(WebElement element) {
		boolean selected = false;
		try {
			element.isSelected();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return selected;
	}

	public static boolean isMultiple(WebElement element) {
		boolean multiple = false;
		try {
			Select s = new Select(element);
			s.isMultiple();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return multiple;
	}

	public static void waitUntilElementVisibility(WebElement element) {
		try {
			WebDriverWait wb = new WebDriverWait(driver, null);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public static void inputValue(WebElement element, String value) {

		try {

			waitUntilElementVisibility(element);
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println("unable to send value :" + e.getMessage());
		}

	}

	public static void click(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void close() {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println("unable to close :" + e.getMessage());

		}
	}

	public static void quit() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public static void getTitle() {
		try {
			driver.getTitle();
		} catch (Exception e) {
			System.out.println("unable to get title:" + e.getMessage());

		}
	}

	public static void getCurrentUrl() {
		try {
			driver.getCurrentUrl();
		} catch (Exception e) {
			System.out.println("unable to get current url:" + e.getMessage());

		}

	}

	public static void selectSingelDD(WebElement element, String value) {
		try {
			Select s = new Select(element);
			if (value.equalsIgnoreCase("value")) {
				s.selectByValue(value);
			} else if (value.equalsIgnoreCase("text")) {
				s.selectByVisibleText(value);
			} else if (value.equalsIgnoreCase("index")) {
				s.selectByIndex(Integer.parseInt(value));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("unable to select options");

		}
	}

	public static void selectAllDD(WebElement element) {
		try {
			Select s = new Select(element);
			s.getAllSelectedOptions();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public static void deselectSingelDD(WebElement element, String value) {
		try {
			Select s = new Select(element);
			if (value.equalsIgnoreCase("value")) {
				s.deselectByValue(value);
			} else if (value.equalsIgnoreCase("text")) {
				s.deselectByVisibleText(value);
			} else if (value.equalsIgnoreCase("index")) {
				s.deselectByIndex(Integer.parseInt(value));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("unable to deselect options");

		}
	}

	public static void mouse(WebElement element, String value) {
		try {
			Actions mouse = new Actions(driver);
			if (value.equalsIgnoreCase("Click")) {
				mouse.click(element).build().perform();
			} else if (value.equalsIgnoreCase("doubleClick")) {
				mouse.doubleClick(element).build().perform();
			} else if (value.equalsIgnoreCase("rightClick")) {
				mouse.contextClick(element).build().perform();
			} else if (value.equalsIgnoreCase("moveToElement")) {
				mouse.moveToElement(element).build().perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("unable to use mouse:" + e.getMessage());
		}

	}

	public static void DragAndDrop(WebElement source, WebElement target) {
		try {
			Actions mouse = new Actions(driver);
			mouse.dragAndDrop(source, target).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("unable to drag and drop:" + e.getMessage());
		}

	}

	public static void keyBoard(String value) {
		try {
			Robot rb = new Robot();
			if (value.equalsIgnoreCase("down")) {
				rb.keyPress(KeyEvent.VK_DOWN);
				rb.keyRelease(KeyEvent.VK_DOWN);
			} else if (value.equalsIgnoreCase("enter")) {
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
			}
		} catch (AWTException e) { // abstract window toolkit
			e.printStackTrace();
			System.out.println("unable to use keyboard actios:" + e.getMessage());
		}
	}

	public static void inputValuesusingActions(WebElement element, String value) {
		try {
			Actions ac = new Actions(driver);
			ac.sendKeys(element, value).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();

		}
	}

	public static void scroll(WebElement element, String value, int a, int b) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver; // narrowing
			if (value.equalsIgnoreCase("toElement")) {
				js.executeScript("arguments[0].scrollIntoView();", element);
			} else if (value.equalsIgnoreCase("click")) {
				js.executeScript("arguments[0].click();", element);

			} else if (value.equalsIgnoreCase("scrollToBottom")) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			} else if (value.equalsIgnoreCase("UpAndDown")) {
				js.executeScript("window.scrollBy(" + a + "," + b + ")");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public static void screenshot(String name) throws IOException {
		try {
			TakesScreenshot ss = (TakesScreenshot) driver;
			File source = ss.getScreenshotAs(OutputType.FILE);
			File destination = new File("C:\\Users\\Dhanam\\Downloads\\Maven_Concept\\screenshot\\" + name + ".png");
			FileUtils.copyFile(source, destination);
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	public static void confirmAlert(String value) {
		try {
			Alert alert = driver.switchTo().alert();
			if (value.equalsIgnoreCase("accept")) {
				alert.accept();
			} else if (value.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void simpleAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void promptAlert(String value, String values) {

		try {
			Alert alert = driver.switchTo().alert();
			if (value.equalsIgnoreCase("confirm")) {
				alert.sendKeys(values);
				alert.accept();

			} else if (value.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void navigateTo(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public static void navigate(String value) {
		try {
			if (value.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (value.equalsIgnoreCase("backward")) {
				driver.navigate().back();
			} else if (value.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("unable to use" + value + ":" + e.getMessage());

		}

	}

	public static void windowHandles(int index) {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> list = new ArrayList<>(windowHandles);
			driver.switchTo().window(list.get(index));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public static void switchtoSecondWindow() {
		try {
			String cId = driver.getWindowHandle();
			Set<String> pId = driver.getWindowHandles();
			for (String x : pId) {
				if (!x.equals(cId)) {
					driver.switchTo().window(x);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchtoIframe(String options, Object value) {
		try {
			if (options.equalsIgnoreCase("index")) {
				driver.switchTo().frame(Integer.parseInt((String) value));
			} else if (options.equalsIgnoreCase("name")) {
				driver.switchTo().frame((String) value);
			} else if (options.equalsIgnoreCase("element")) {
				driver.switchTo().frame((WebElement) value);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getAllData(WebElement element) {
		List<WebElement> allData = element.findElements(By.xpath("//table/body/tr/td"));
		for (WebElement webElement : allData) {
			System.out.println(webElement.getText());
		}

	}

	public static void getParticularRow(WebElement element, int row) {
		List<WebElement> rowValue = element.findElements(By.xpath("//table/body/tr[" + row + "]/td"));
		for (WebElement webElement : rowValue) {
			System.out.println(webElement.getText());
		}

	}

	public static void getParticularColumn(WebElement element, int column) {
		List<WebElement> columnValue = element.findElements(By.xpath("//table/body/tr[]/td[" + column + "]"));
		for (WebElement webElement : columnValue) {
			System.out.println(webElement.getText());
		}

	}

	public static void getParticularData(WebElement element, int column, int row) {
		WebElement data = element.findElement(By.xpath("//table/body/tr[" + row + "]/td[" + column + "]"));
		System.out.println(data.getText());
	}

//	public static String getValuesfromExcel(String sheetname, int rownum, int cellnum) throws Throwable {
//
//		try {
//			File f = new File("");
//			FileInputStream fin = new FileInputStream(f);
//			Workbook wb = new XSSFWorkbook(fin);
//			Sheet sheet = wb.getSheet(sheetname);
//			Cell cell = sheet.getRow(rownum).getCell(cellnum);
//			CellType cellType = cell.getCellType();
//			String string = null;
//			if (cellType.equals(CellType.STRING)) {
//				string = cell.getStringCellValue();
//			} else if (cellType.equals(CellType.NUMERIC)) {
//				double numericCellValue = cell.getNumericCellValue();
//				long l = (long) numericCellValue;
//				string = String.valueOf(l);
//			}
//			return string;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new RuntimeException();
//
//		}
//
//	}

//	public static void setValuetoExcel1(String fileName, String sheetname, int rownum, int cellnum, String value) {
//
//		try {
//			File f = new File(System.getProperty("user.dir") + "\\Datas\\" + fileName + ".xlsx");
//			FileInputStream fin = new FileInputStream(f);
//			Workbook wb = new XSSFWorkbook(fin);
//			Sheet sheet = wb.getSheet(sheetname);
//			Cell cell = sheet.getRow(rownum).getCell(cellnum);
//			if (cell == null) {
//				Cell createCell = sheet.getRow(rownum).createCell(cellnum);
//				createCell.setCellValue(value);
//			} else {
//				cell.setCellValue(value);
//			}
//			FileOutputStream fout = new FileOutputStream(f);
//			wb.write(fout);
//			fout.close();
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new RuntimeException();
//
//		}
//
//	}

}