package TestngRunner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	@Test(dataProvider = "data")
	private void credentials(String username, String password) {

		System.out.println("username is " + username);
		System.out.println("password is " + password);
	}

	@DataProvider
	private Object[][] data() {
		return new Object[][] { { "James", "james123" }, { "karthi", "karthi123" }, { "john", "john123" } };
	}
}
