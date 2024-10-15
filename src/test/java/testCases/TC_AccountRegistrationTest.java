package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_AccountRegistrationTest extends BaseClass {
	
	@Test(priority=1)
	public void verify_acct_registration()
	{
		HomePage HP=new HomePage(driver);
		HP.clickRegistration();
		
		AccountRegistrationPage acrp=new AccountRegistrationPage(driver);
		acrp.EnterAdmissionNumber("110011");
		acrp.SelectDepartment();
		acrp.BatchName("ECE-2016");
		acrp.CourseCompletionYear("2015");
		acrp.Name("Salih");
		acrp.DateofBirth("20/01/2000");		
		acrp.PhoneNumber("9898653156");
		acrp.Gender();
		acrp.EnterEmailId("saapruu1234@gmail.com");
		acrp.Address("dj sajdk skijdubnqiwj isjudhij");
		acrp.Password("Sapp@1478");
		acrp.UploadProfilePicture("C:\\Users\\aleen\\OneDrive\\Pictures\\Screenshots\\HD User 03.png");
		acrp.UploadyourResume("C:\\Users\\aleen\\OneDrive\\Pictures\\Screenshots\\HD User 04.png");
		acrp.clickregistration();
		acrp.alertvalidation();
	}
	
	public String randomeString()
	{
	String generatedString=	RandomStringUtils.randomAlphabetic(5); 
	return generatedString;
	}
	
}
