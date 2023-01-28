package flipkart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.Reusable_Method;

public class Flipkart extends Reusable_Method {

	public static void main(String[] args) throws InterruptedException {

		browserLaunch("chrome");
		maximize();
		GetUrl("https://www.flipkart.com/");
		WebElement popup = driver
				.findElement(By.xpath("//div[@class='_2QfC02']//child::button[@class='_2KpZ6l _2doB4z']"));
		click(popup);
		click(driver.findElement(By.xpath("//div[text()='Electronics']")));
		actions(driver.findElement(By.xpath("//span[text()='Electronics']")), "moveToElement");
		actions(driver.findElement(By.linkText("Mi")), "moveToElement");
		click(driver.findElement(By.linkText("Mi")));
		WebElement source = driver.findElement(By.xpath("(//div[contains(@class,'3FdLqY')])[1]"));
		WebElement target = driver.findElement(By.xpath("(//div[contains(@class,'_1ftpgI')])[2]"));
		dragAndDrop(source, target);
		sleepForSec(3);
		WebElement select = driver.findElement(By.xpath("//div[@class='_2b0bUo']//following::select"));
		selectSingle(select, "value","30000");
		WebElement phone = driver.findElement(By.xpath("//div[text()='REDMI 10A (Sea Blue, 64 GB)']"));
		click(phone);
		sleepForSec(5);
		windowHandlesList(1);
		WebElement addCart = driver.findElement(By.xpath("//button[text()='Add to cart']"));
		click(addCart);
		WebElement deliverycode = driver.findElement(By.xpath("//button[text()='Enter Delivery Pincode']"));
		click(deliverycode);
		sleepForSec(4);
		driver.findElement(By.xpath("//input[@placeholder='Enter pincode']")).sendKeys("630108");
		driver.findElement(By.xpath("//div[text()='Submit']")).click();
		
	}
}
