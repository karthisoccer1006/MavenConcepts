package runnerClass;

import BaseClass.Reusable_Method;
import POM.pageObjectManager;

public class FaceBookPom  extends Reusable_Method{
	public static void main(String[] args) throws Throwable {
		browserLaunch("chrome");
		pageObjectManager obj = new pageObjectManager(driver);
		maximize();
		GetUrl("https://en-gb.facebook.com/");
		sleepForSec(3);
		System.out.println(isdisplayed(obj.getLogin().getFblogo()));
		click(obj.getLogin().getCreateId());
		send(obj.getCreateAccount().getFirstName(), "jokke");
		send(obj.getCreateAccount().getSurname(), "lokee");
		send(obj.getCreateAccount().getMobileNumber(),"9876543210");
		send(obj.getCreateAccount().getPassword(), "00000");
		selectSingle(obj.getCreateAccount().getDay(), "text", "10");
		selectSingle(obj.getCreateAccount().getMonth(), "value", "4");
		selectSingle(obj.getCreateAccount().getYear(), "value", "2022");
		click(obj.getCreateAccount().getSex());
		click(obj.getCreateAccount().getSignUp());
		
		
	}

}
