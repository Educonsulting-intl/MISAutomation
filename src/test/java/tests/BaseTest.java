package tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pageobjects.MainPage;

public class BaseTest {
	
	protected WebDriver driver;
	private DesiredCapabilities cap;
	
	@BeforeSuite
	public void setup()
			throws MalformedURLException {
		cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setVersion("85.0");
		cap.setCapability("enableVideo", true);
		//driver = new RemoteWebDriver(new URL("http://192.168.18.22:4444/wd/hub"), cap);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.htzone.co.il/item/70395/%D7%98%D7%9C%D7%A4%D7%95%D7%9F-%D7%A1%D7%9C%D7%95%D7%9C%D7%A8%D7%99--Apple--iPhone-13-Pro-128GB--%D7%90%D7%A4%D7%9C/#");
		
		
	}
	
	@Test
	public void clickOnLogin() {
		MainPage mainPage = new MainPage(driver);
		Boolean flag = mainPage.clickOnLogin();
		if(flag) {
			driver.quit();
			return;
		}
			
		mainPage.fillLoginDetails();
	}
	
	@AfterSuite
	public void quit() {
		driver.quit();
	}
}
