package pack;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import page_webelement_repo.HomePageWebElements;
import resources.Base;

public class HP_ValidateFreeCancellationTextTest extends Base{

	public static Logger log= LogManager.getLogger(HP_ValidateFreeCancellationTextTest.class.getName());
	
	@BeforeClass
	public void initialize() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("successfully landed on the home page and window maximized");
	}
	
	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		
		HomePageWebElements hp=new HomePageWebElements(driver);	
	    Assert.assertEquals("Free cancellation on most rooms", hp.getFreeCancellation().getText());
	    log.info("successfully validated that Free cancellation on most rooms test is displayed");
	}
	
	@AfterClass
	public void quitBrowser() {
		driver.close();
		driver=null;
		log.info("successfully closed the browser");
	}
}
