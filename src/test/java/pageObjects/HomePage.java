package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//a[text()='Register Now']")
	WebElement btn_Registration;
	
	@FindBy(xpath="//a[text()='Sign In']")
	WebElement btn_SignIn;
	
	public void clickRegistration()
	{
		btn_Registration.click();
	}
	
	public void clickSignIn()
	{
		btn_SignIn.click();
	}
}
