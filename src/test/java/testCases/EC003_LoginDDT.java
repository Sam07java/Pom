package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid		-	login success	-	test pass	-	logout
 * Data is valid	-	login failed	-	test failed
 * 
 * Data is invalid	-	login success	-	test fail	-	logout
 * Data is invalid	-	login failed	-	test pass	
 */

public class EC003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String pwd) throws IOException
	{
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickSignIn();
		
		//LogInPage
		LogInPage lp=new LogInPage(driver);
		lp.EnterEmailId(email);
		lp.Password(pwd);
		lp.clickLogin();
		
		//MyAccountHomePage
		
		MyAccountPage mp=new MyAccountPage(driver);
		
		boolean logver= mp.isMyAccountPageExixtes();
		
		if(logver==true)
		{
			Assert.assertTrue(true);
			Thread.sleep(2000);
			mp.ClickLogOut();
		}
		
		else if(logver==false)
		{
			Assert.assertTrue(false);
			//String alertmsg=driver.switchTo().alert().getText();
			//Assert.assertEquals(alertmsg,"Invalid Username or Password");
			driver.switchTo().alert().accept();
			//alertmsg.equals("Invalid Username or Password");
			//System.out.println(alertmsg);
		}
		//Invalid Username or Password
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	

}
