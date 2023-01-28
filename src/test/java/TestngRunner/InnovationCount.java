package TestngRunner;

import org.testng.annotations.Test;

public class InnovationCount {
	@Test(invocationCount=5,priority=1)
	private void browserLaunch() {
		System.out.println("browserLaunch");
	}
	@Test(priority=2)
	private void maxi() {
		System.out.println("maximize");
	}
	@Test(priority=3)
	private void navigateUrl() {
		System.out.println("navigate url ");

	}
}