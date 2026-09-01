package testcases;



import org.testng.Reporter;
import org.testng.annotations.Test;



import base.BaseTest;
import page_elements.LoginPage;
import utilities.LoginCredentials;

public class TC_Login_Page extends BaseTest
{
	private LoginPage lg;
	
	
//	TC1: Login with valid username & valid password
	@Test (priority=1, enabled=true)
	public void validLogin() throws InterruptedException
	{	
		lg=new LoginPage(page);
		
		lg.username(LoginCredentials.logindata("valid_username"));
		lg.next();
		lg.password(LoginCredentials.logindata("valid_password"));
		lg.terminate();
		lg.signin();
		Thread.sleep(20000);
		lg.pageTitle();
		Reporter.log("Successfully Logged In to "+page.title(), true);
	}
	
	
//	TC2: Login with invalid username
	@Test (priority=2, enabled=true)
	public void invalidLogin1() throws InterruptedException
	{
		lg=new LoginPage(page);
		
		lg.username(LoginCredentials.logindata("invalid_username"));
		lg.next();
//		Thread.sleep(5000);
		lg.verifyinvalidUserMessage();
		Reporter.log("The entered username is invalid", true);
	}
	
	
//	TC3: Login with invalid password
	@Test (priority=3, enabled=true)
	public void invalidLogin2() throws InterruptedException
	{
		lg=new LoginPage(page);
		
		lg.username(LoginCredentials.logindata("valid_username"));
		lg.next();
		lg.password(LoginCredentials.logindata("invalid_password"));
		lg.terminate();
		lg.signin();
//		Thread.sleep(5000);
		lg.verifyinvalidPasswordMessage();
		Reporter.log("The entered password is invalid", true);
	}
	
//	TC4: Forgot Password 
	@Test (priority=4)
	public void forgotpassword()
	{
		lg=new LoginPage(page);
		
		lg.username(LoginCredentials.logindata("valid_username"));
		lg.next();
		lg.forgotpassword();
		lg.securityquestion();
		lg.securityanswer(LoginCredentials.logindata("securityanswer"));
		lg.submit();
	}
	
}

