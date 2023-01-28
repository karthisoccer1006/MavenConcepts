package TestngRunner;

import org.testng.annotations.Test;

public class DependencyTest {
	@Test
	private void browserLaunch() {
		System.out.println("browserLaunch");
	}
	
	@Test(dependsOnMethods ="navigateUrl")
	private void maxi() {
		System.out.println("maximize");
	}
	@Test(dependsOnMethods ="browserLaunch")
	private void navigateUrl() {
		System.out.println("navigate url ");

	}

}
