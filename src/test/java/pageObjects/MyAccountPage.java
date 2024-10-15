package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//h2[text()='Welcome User']")
	WebElement hp_Heading;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement btn_logout;
	
	
	public boolean isMyAccountPageExixtes()
	{
		try
		{
		return (hp_Heading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void ClickLogOut()
	{
		btn_logout.click();
	}
	
}
