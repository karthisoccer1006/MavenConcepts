package TestngRunner;

import org.testng.annotations.Test;

public class TimeOutTest {
	@Test(priority = 1)
	private void browserLaunch() {
		System.out.println("browserLaunch");
		
	}

	@Test(priority = 2)
	private void maxi() {
		System.out.println("maximize");
	}

	@Test(timeOut =7000,priority = 3)
	private void navigateUrl() throws InterruptedException {
		System.out.println("navigate url ");
		Thread.sleep(3000);
		System.out.println("mens t-shirt");
		
		Thread.sleep(2000);
		System.out.println("kids shirts");
		Thread.sleep(1000);
		System.out.println("womens collection");

	}
}
