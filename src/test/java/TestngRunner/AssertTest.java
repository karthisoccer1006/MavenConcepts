package TestngRunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertTest {
	
	@Test
	private void demo() {
		String expected="James";
		
		String actual="James";
		
//		Assert.assertEquals(actual, expected);
//		
//		
//		Assert.assertNotEquals(actual, expected);
//		System.out.println("welcome");
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actual, expected);
		
		
	}

}
