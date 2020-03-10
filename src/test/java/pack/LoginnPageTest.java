package pack;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_webelement_repo.LoginPageWebElements;
import resources.Base;

public class LoginnPageTest extends Base{

	public static Logger log= LogManager.getLogger(LoginnPageTest.class.getName());
	
	@BeforeClass
	public void initialize() throws IOException {
		
		driver=initializeDriver();
		driver.get(prop.getProperty("loginpageurl"));
		driver.manage().window().maximize();
		log.info("successfully landed on the login page and window maximized");
	}
	
	@Test(dataProvider="getData")
	public void loginPage(String username, String password) throws IOException, InterruptedException {

		LoginPageWebElements lp=new LoginPageWebElements(driver);	
		lp.emailOnLoginPage().sendKeys(username);
		lp.passwordOnLoginPage().sendKeys(password);
		lp.signInButtonOnLoginPage().click();
		log.info("successfully verified with two sets of invalid username and password login is unsuccessful");
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] obj=new Object[2][2];
		obj[0][0]="emre";
		obj[0][1]="Abcd1234";
		obj[1][0]="eniste";
		obj[1][1]="Asd4321";
		return obj;
	}
	
	@AfterClass
	public void quitBrowser() {
		driver.close();
		driver=null;
		log.info("successfully closed the browser");
	}
}
