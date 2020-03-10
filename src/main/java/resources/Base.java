package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	public static WebDriver driver;    //declared as a public static field so we only create one WebDriver insted of three in each if else
	public Properties prop;   //declared as a public field so we can use prop in our test class by extending the base class
	
	public WebDriver initializeDriver() throws IOException  {
		
		prop=new Properties();   //here i connect my data.properties with this Base class by Properties object and FileInputStream
		FileInputStream f=new FileInputStream("C://Users//emrba//EndToEndFramework//src//main//java//resources/data.properties");
		prop.load(f);   // this makes the connection
		
		String browserName=prop.getProperty("browser");   // this goes into data.properties and reads the browser in there.
		
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C://Users//emrba//Drivers/chromedriver.exe");
		 driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C://Users//emrba//OneDrive//Masaüstü//Drivers//WebDrivers//geckodriver-v0.26.0-win64/geckodriver.exe");
			 driver=new FirefoxDriver();
		}			
		else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver",   //fix ie , something wrong
					"C://Users//emrba//OneDrive//Masaüstü//Drivers//WebDrivers//IEDriverServer_x64_3.150.1/IEDriverServer.exe");
			 driver=new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;  // this method returns driver thats why initializeDriver() is a WebDriver method
		
	}
	
	public void getScreenShot(String result) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\emrba\\Screenshots//"+result+"failed.png"));
	}
	
}
