package TestngRunner;

import org.testng.annotations.Test;

public class PriorityTest {
	
	@Test(priority=-1)
	private void browserLaunch() {
		System.out.println("browserLaunch");
	}
	
	@Test(priority=1)
	private void maxi() {
		System.out.println("maximize");
	}
	@Test
	private void getUrl() {
		System.out.println("navigate url");
	}

}
