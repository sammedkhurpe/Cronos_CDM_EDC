package testcases;



import org.testng.annotations.Test;



import base.BaseTest;
import page_elements.LoginPage;
import utilities.LoginCredentials;

public class TestCase1 extends BaseTest
{
	private LoginPage lg;
	
	@Test (priority=1)
	public void validLogin() throws InterruptedException
	{	
		lg=new LoginPage(page);
		
		lg.username(LoginCredentials.logindata("valid_username"));
		lg.next();
		lg.password(LoginCredentials.logindata("valid_password"));
		lg.terminate();
		lg.signin();
//		Thread.sleep(20000);
	}
	
	@Test (priority=2)
	public void invalidLogin1()
	{
		lg=new LoginPage(page);
		
		lg.username(LoginCredentials.logindata("invalid_username"));
		lg.next();
//		lg.password(LoginCredentials.logindata("valid_password"));
//		lg.terminate();
//		lg.signin();
	}
	
	@Test (priority=3)
	public void invalidLogin2()
	{
		lg=new LoginPage(page);
		
		lg.username(LoginCredentials.logindata("valid_username"));
		lg.next();
		lg.password(LoginCredentials.logindata("invalid_password"));
		lg.terminate();
		lg.signin();
	}
	
	@Test (priority=4)
	public void invalidLogin3()
	{
		lg=new LoginPage(page);
		
		lg.username(LoginCredentials.logindata("invalid_username"));
		lg.next();
		lg.password(LoginCredentials.logindata("invalid_password"));
		lg.terminate();
		lg.signin();
	}
}

