package runnerClass;

import org.openqa.selenium.By;

import BaseClass.Reusable_Method;
import ElementSegregation.CreateAccount;
import ElementSegregation.Login;

public class Facebook extends Reusable_Method {

	public static void main(String[] args) throws InterruptedException {
		
		browserLaunch("chrome");
		GetUrl("https://en-gb.facebook.com/");
		maximize();
		sleepForSec(3);
		Login login = new Login(driver);
		System.out.println((login.getFblogo().isDisplayed()));
		click(login.getCreateId());
		sleepForSec(3);
		CreateAccount ac = new CreateAccount(driver);
		send(ac.getFirstName(), "jokee");
		send(ac.getSurname(), "lokee");
		send(ac.getMobileNumber(), "9876543210");
		send(ac.getPassword(), "1006");
		selectSingle(ac.getDay(), "value", "4");
		selectSingle(ac.getMonth(), "value", "4");
		selectSingle(ac.getYear(), "value", "2022");
		click(ac.getSex());
		click(ac.getSignUp());
	}

}
