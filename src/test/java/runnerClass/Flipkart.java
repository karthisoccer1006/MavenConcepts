package runnerClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseClass.Reusable_Method;

public class Flipkart extends Reusable_Method{
	
	public static  void flip() throws Throwable {
		browserLaunch("chrome");
		GetUrl("https://www.flipkart.com/");
		maximize();
		sleepForSec(3);	
		WebElement closeButton = driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]"));
		click(closeButton);
		screenshot("photos");
		WebElement electronics = driver.findElement(By.xpath("//div[text()='Electronics']"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(electronics).build().perform();
		sleepForSec(3);
		WebElement game = driver.findElement(By.linkText("Gaming"));
		mouse.moveToElement(game).build().perform();
		sleepForSec(3);

		WebElement controller = driver.findElement(By.linkText("Controllers"));
	
		mouse.moveToElement(controller).perform();
		controller.click();
	}
	public static void main(String[] args) throws Throwable {
		flip();
	}

}
