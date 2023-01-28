package TestngRunner;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {
	@Test
	@Parameters({ "username", "password" })
	private void browserLaunch(String username, String password) {
		System.out.println("username is " + username);
		System.out.println("password is " + password);

	}

}