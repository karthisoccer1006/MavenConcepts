package runnerClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.Reusable_Method;

public class ClassA extends Reusable_Method {

	public static void amazon() throws IOException, Throwable {
		browserLaunch("chrome");
		GetUrl("https://www.amazon.in/");
		maximize();
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		click(search);
		send(search, "iphone\n");
		List<WebElement> mobiles = driver.findElements(By
				.xpath("//span[text()='RESULTS']//following::span[@class='a-size-medium a-color-base a-text-normal']"));
		click(mobiles.get(3));
		windowHandles("Apple iPhone 13 (128GB) - Pink : Amazon.in: Electronics");
		WebElement addCart = driver.findElement(By.id("add-to-cart-button"));
		scroll(addCart, "elementClick");
		sleepForSec(5);
		navigateRefresh();

		WebElement cart = driver.findElement(By.id("nav-cart-count-container"));
		click(cart);
		sleepForSec(5);

		WebElement qty = driver.findElement(By.xpath("//select[@name='quantity']"));
		selectSingle(qty, "selectByValue", "2");

		WebElement totalPrice = driver.findElement(
				By.xpath("(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]"));
		String replace = totalPrice.getText().replaceAll("[^0-9]", "");
		int finalPrice = Integer.parseInt(replace);
		System.out.println(finalPrice);
		sleepForSec(3);
		WebElement price1 = driver.findElement(By.xpath(
				"//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
		String replace1 = price1.getText().replaceAll("[^0-9]", "");
		int basePrice = Integer.parseInt(replace1);
		int a = basePrice * 2;
		System.out.println(a);
		sleepForSec(3);
		if (a == finalPrice) {
			System.out.println("test passed");

		} else {
			System.out.println("test is failed");
		}

	}

	public static void main(String[] args) throws Throwable {
		amazon();

	}

}
