package page_elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage 
{
	private Page page;
	
	private Locator username;
	private Locator next;
	private Locator password;
	private Locator signin;
	private Locator terminate;
	private Locator forgotpassword;
	private Locator securityquestion;
	private Locator securityanswer;
	private Locator submit;
	private Locator cancel;
	
	public LoginPage (Page page)
	{
		this.page=page;
		
		username=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username"));
		next=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next"));
		password=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("password"));
		signin=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SIGN IN"));
		terminate=page.locator("//md-checkbox[@name=\"confirmCheck\"]");
		forgotpassword=page.getByLabel("Forgot Password?");
		securityquestion=page.getByLabel("Security Question?*");
		securityanswer=page.locator("//input[@name=\"securityAnswer\"]");
		submit=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SUBMIT"));
		cancel=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("CANCEL"));
	}
	
	public void username(String username)
	{
		this.username.fill(username);
	}
	
	public void next()
	{
		this.next.click();
	}
	
	public void password(String password)
	{
		this.password.click();
		this.password.type(password);
	}
	
	public void signin()
	{
		this.signin.click();
	}
	
	public void terminate()
	{
		if(this.terminate.isVisible())
		{
			this.terminate.check();
		}
	}
	
	public void forgotpassword()
	{
		this.forgotpassword.click();
	}
	
	public void securityquestion()
	{
		this.securityquestion.selectOption("Who was your childhood hero?");
	}
	
	public void securityanswer(String securityanswer)
	{
		this.securityanswer.fill(securityanswer);
	}
	
	public void submit()
	{
		this.submit.click();
	}
	
	public void cancel()
	{
		this.cancel.click();
	}
}
