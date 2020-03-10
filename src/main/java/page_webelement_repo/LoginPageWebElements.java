package page_webelement_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWebElements {

	public WebDriver driver;
	
	public LoginPageWebElements(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//1
	@FindBy(id="sign-in-email")
	WebElement email;

	public WebElement emailOnLoginPage() {
		return email;
	}
	//2
	@FindBy(id="sign-in-password")
	WebElement password;

	public WebElement passwordOnLoginPage() {
		return password;
	}
	//3  
		@FindBy(xpath="//button[@type='submit']")
		WebElement signInButton;

		public WebElement signInButtonOnLoginPage() {
			return signInButton;
		}
	
}