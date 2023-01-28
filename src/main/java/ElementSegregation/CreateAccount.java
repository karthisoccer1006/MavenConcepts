package ElementSegregation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.Reusable_Method;

public class CreateAccount extends Reusable_Method {
	
	public CreateAccount(WebDriver xdriver) {
		this.driver=xdriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name="firstname")
	private WebElement firstName;
	
	@FindBy(name="lastname")
	private WebElement surname;
	
	@FindBy(xpath="(//input[@data-type='text'])[3]")
	private WebElement mobileNumber;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	private WebElement  password;
	
	@FindBy(id="day")
	private WebElement day;
	
	@FindBy(id="month")
	private WebElement month;
	
	@FindBy(id="year")
	private WebElement year;
	
	@FindBy(xpath="(//input[@type='radio'])[2]")
	private WebElement sex;
	
	@FindBy(name="websubmit")
	private WebElement signUp;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getSurname() {
		return surname;
	}

	public WebElement getMobileNumber() {
		return mobileNumber;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getDay() {
		return day;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getSex() {
		return sex;
	}

	public WebElement getSignUp() {
		return signUp;
	}
	
	
	
	
	
	
	
	
}
