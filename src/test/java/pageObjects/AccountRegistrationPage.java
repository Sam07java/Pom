package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Eg : 45565']")
	WebElement txt_addmissionNo;
	
	@FindBy(xpath="//select[@name]")
	WebElement drop_Department;
	
	@FindBy(xpath="//*[@name='batch']")
	WebElement txt_BatchName;
	
	@FindBy(xpath="//*[@name='completion_year']")
	WebElement txt_comYear;
	
	@FindBy(xpath="//*[@name='name']")
	WebElement txt_Name;
	
	@FindBy(xpath="//*[@type='date']")
	WebElement date_DOB;
	
	@FindBy(xpath="//*[@name='phone']")
	WebElement phn_NO;
	
	@FindBy(xpath="//*[@name='gender'][1]")
	WebElement btn_gender;
	
	@FindBy(xpath="//*[@name='email']")
	WebElement txt_email;
	
	@FindBy(xpath="//*[@name='address']")
	WebElement txt_address;
	
	@FindBy(xpath="//*[@name='password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@name='photo']")
	WebElement file_ProPic;
	
	@FindBy(xpath="//input[@name='resume']")
	WebElement file_resume;
	
	@FindBy(xpath="//input[@name='add']")
	WebElement btn_Register;
	
	public void EnterAdmissionNumber(String Addno)
	{
		txt_addmissionNo.sendKeys(Addno);
	}
	
	public void SelectDepartment()
	{
		Select act=new Select(drop_Department);
		act.selectByVisibleText("BCA");		
	}
	
	public void BatchName(String Batchname)
	{
		txt_BatchName.sendKeys(Batchname);
	}
	
	public void CourseCompletionYear(String year) 
	{
		txt_comYear.sendKeys(year);
	}
	
	public void Name(String name)
	{
		txt_Name.sendKeys(name);
	}
	
	public void DateofBirth(String DOB)
	{
		date_DOB.sendKeys(DOB);
	}
	
	public void PhoneNumber(String phnNO) 
	{
		phn_NO.sendKeys(phnNO);
	}
	
	public void Gender()
	{
		btn_gender.click();
	}
	
	public void EnterEmailId(String EmailID)
	{
		txt_email.sendKeys(EmailID);
	}
	
	public void Address(String Addrss)
	{
		txt_address.sendKeys(Addrss);
	}
	
	public void Password(String password)
	{
		txt_password.sendKeys(password);
	}
	
	public void UploadProfilePicture(String pathPic) 
	{
		file_ProPic.sendKeys(pathPic);
	}
	
	public void UploadyourResume(String pathResume) 
	{
		file_resume.sendKeys(pathResume);
	}
	
	public void clickregistration()
	{
		btn_Register.click();
	}
	
	public void alertvalidation()
	{
		String alert=driver.switchTo().alert().getText();
		String expected="Registration Completed";
		try
		{
			Assert.assertEquals(alert, expected);
			System.out.println("Registration Successful");
			driver.switchTo().alert().accept();
		}
		catch(Exception e)
		{
			System.out.println("Registration Failed");
		}
	}
}
