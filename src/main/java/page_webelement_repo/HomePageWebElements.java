package page_webelement_repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageWebElements {

	public WebDriver driver;
	
	public HomePageWebElements(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id='main-content']/div/div/div[3]/div/div/div/div/ul/li[2]")
	WebElement freeCancellationText;
	
	public WebElement getFreeCancellation() {
		return freeCancellationText;
	}
	
	@FindBy(xpath="//*[@id='header-full']/header/nav[1]/div")
	WebElement navBar;
	
	public WebElement getNavBar() {
		return navBar;
	}
	
	@FindBy(id="header-sign-in")
	WebElement loginButton;
	
	public WebElement getLogin() {
		return loginButton;
	}
	
	
	
	
}
