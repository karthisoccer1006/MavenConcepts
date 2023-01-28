package runnerClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openxmlformats.schemas.drawingml.x2006.chart.STLegendPos;

import BaseClass.Reusable_Method;

public class Amazon extends Reusable_Method {
	public static int price;
	public static int finalPrice;

	public static void redmi() throws Throwable {
		browserLaunch("chrome");
		maximize();
		GetUrl("https://www.amazon.in/");
		WebElement search_Box = driver.findElement(By.id("twotabsearchtextbox"));
		send(search_Box, "redmi");
		WebElement search = driver.findElement(By.id("nav-search-submit-button"));
		click(search);
		thread(3000);
		WebElement redmiA1 = driver.findElement(By.xpath(
				"//span[text()='RESULTS']//ancestor::div[@data-cel-widget='search_result_1']//following-sibling::div[@data-asin='B0BBN4DZBD']//descendant::span[@class='a-price-whole']"));
		String replace = redmiA1.getText().replace("[^0-9]", "");
		price = Integer.parseInt(replace);
		int price1=price*3;
		System.out.println(price1);
		click(redmiA1);
//		String windowHandle = driver.getWindowHandle();
//		driver.switchTo().window(windowHandle).getTitle();
		windowHandlesList(1);
		close();

		
	}

	public static void main(String[] args) throws Throwable {
		redmi();
	}
}
