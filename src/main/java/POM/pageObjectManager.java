package POM;

import org.openqa.selenium.WebDriver;

import BaseClass.Reusable_Method;
import ElementSegregation.CreateAccount;
import ElementSegregation.Login;

public class pageObjectManager extends Reusable_Method {
	public pageObjectManager(WebDriver xdriver) {

		this.driver = xdriver;

	}
//	public static Login log=new Login(driver);
//	public static  CreateAccount createAcc= new CreateAccount(driver);

	private Login login;
	private CreateAccount createAccount;

	public Login getLogin() {
		if (login == null) {
			login = new Login(driver);
		}

		return login;
	}

	public CreateAccount getCreateAccount() {
		if (createAccount == null) {
			createAccount = new CreateAccount(driver);
		}
		return createAccount;
	}

}
