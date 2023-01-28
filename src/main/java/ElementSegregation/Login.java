package ElementSegregation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.Reusable_Method;

public class Login extends Reusable_Method {

	public Login(WebDriver xdriver) {
		this.driver=xdriver;
		PageFactory.initElements(driver, this);
		
	}
	


	@FindBy(xpath="//img[@alt='Facebook']")
	private WebElement fblogo;
	
	@FindBy(xpath="//a[text()='Create New Account']")
	private WebElement createId;

	public WebElement getFblogo() {
		return fblogo;
	}

	public WebElement getCreateId() {
		return createId;
	}
}
