package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
	
	public LogInPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath="//input[@placeholder='Eg: johnsmith@gmail.com']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement btn_click;
	
	public void EnterEmailId(String EmailId)
	{
		txt_username.sendKeys(EmailId);
	}
	
	public void Password(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btn_click.click();
	}
	
	public void LogInAlertVerification()
	{
		String alert=driver.switchTo().alert().getText();
		//Assert.assertEquals(alert, "LogIn Successful");
			System.out.println(alert);
			
	}
}
