package TestngRunner;

import org.testng.annotations.Test;

public class GroupingTest {
	@Test(groups = "delivery")
	private void doink() {
		System.out.println("doink");

	}
	@Test(groups="delivery")
	private void zomatto() {
		System.out.println("zomatto");
	}
	@Test
	private void amazon() {
		System.out.println("swiggy");

	}
	
	
	
	
}
