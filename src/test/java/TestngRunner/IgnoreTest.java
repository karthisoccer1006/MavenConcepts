package TestngRunner;


import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import BaseClass.Reusable_Method;

public class IgnoreTest extends Reusable_Method {

	@Test
	private void browserLaunch() {
		System.out.println("browserLaunch");
	}
	@Ignore
	@Test
	private void maxi() {
		System.out.println("maximize");
	}
	@Test (enabled=false)
	private void navigateUrl() {
		System.out.println("navigate url ");
		

	}
	
}
