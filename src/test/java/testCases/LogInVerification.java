package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogInPage;
import testBase.BaseClass;

public class LogInVerification extends BaseClass
{
	
	@Test
	public void login_Verificaton()
	{
		HomePage hp=new HomePage(driver);
		hp.clickSignIn();
		
		LogInPage lp=new LogInPage(driver);
		lp.EnterEmailId("saapruu1234@gmail.com");
		lp.Password("Sapp@1478");
		lp.clickLogin();
		lp.LogInAlertVerification();
	}

}
