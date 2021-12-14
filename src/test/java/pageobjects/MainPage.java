package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

	@FindBy(css=".popup_form.login_form.active>.popup_content_wrap>.popup_inputs_wrap>.form_label.must>.label_content>input[type='email']")
	WebElement email;
	@FindBy(css=".popup_form.login_form.active>.popup_content_wrap>.popup_inputs_wrap>.form_label.must>.label_content>input[type='password']")
	WebElement passwordInput;
	@FindBy(css="#header_nav>.top_nav>.content_wrapper>.to_right>.login>span>.login")
	WebElement loginButton;
	@FindBy(css=".popup_form.login_form.active>.form_label.label_submit.center.butt_wrapper>div>.submit")
	WebElement submit;
	@FindBy(css=".btn_expired")
	WebElement expired;
	public MainPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickOnLogin() {
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(loginButton);
	}
	public void fillLoginDetails() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		type(email, "matan.rozen@capriza.com");
		type(passwordInput, "K6v5f3xx!");
		click(submit);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitForElementToBeVisible(expired);
		
		
	}
}
