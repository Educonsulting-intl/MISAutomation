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
		cap.setVersion("81.0");
		cap.setCapability("enableVideo", false);
		//driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub/"), cap);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.htzone.co.il/item/70395/%D7%98%D7%9C%D7%A4%D7%95%D7%9F-%D7%A1%D7%9C%D7%95%D7%9C%D7%A8%D7%99--Apple--iPhone-13-Pro-128GB--%D7%90%D7%A4%D7%9C/#");
		driver.get("https://www.htzone.co.il/item/45408/%D7%AA%D7%A0%D7%95%D7%A8-%D7%91%D7%99%D7%9C%D7%93-%D7%90%D7%99%D7%9F-%D7%A0%D7%99%D7%A8%D7%95%D7%A1%D7%98%D7%94-%D7%A0%D7%A4%D7%97-%D7%AA%D7%90-%D7%90%D7%A4%D7%99%D7%99%D7%94-%D7%92%D7%93%D7%95%D7%9C-71-%D7%9C%D7%99%D7%98%D7%A8-BOSCH-%D7%91%D7%95%D7%A9/");
		
		
	}
	
	@Test
	public void clickOnLogin() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnLogin();
		mainPage.fillLoginDetails();
	}
	
	@AfterSuite
	public void quit() {
		driver.quit();
	}
}
