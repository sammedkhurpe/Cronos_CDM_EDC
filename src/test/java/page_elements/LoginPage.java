package page_elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

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
	private Locator invalidUserMessage;
	private Locator invalidPasswordMessage;
	
	public LoginPage (Page page)
	{
		this.page=page;
		
		username=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username"));
		next=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next"));
		password=page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("password"));
		signin=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SIGN IN"));
		terminate=page.locator("//md-checkbox[@name=\"confirmCheck\"]");
		forgotpassword=page.getByText("Forgot Password?");
		securityquestion=page.locator("//md-select[@aria-label=\"Security Question?*\"]");
		securityanswer=page.locator("//input[@name=\"securityAnswer\"]");
		submit=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("SUBMIT"));
		cancel=page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("CANCEL"));
		invalidUserMessage=page.getByText("Couldn't find your account ");
		invalidPasswordMessage=page.getByText("Invalid password.");
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
//		this.securityquestion.selectOption(new SelectOption().setLabel("Who was your childhood hero?"));
		this.securityquestion.click();
		this.page.getByText("What is name of your grand mother?", new Page.GetByTextOptions().setExact(true)).click();
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
	
	public void verifyinvalidUserMessage()
	{
		assertThat(this.invalidUserMessage).isVisible();
	}
	
	public void verifyinvalidPasswordMessage()
	{
		assertThat(this.invalidPasswordMessage).isVisible();
	}
	
	public void pageTitle()
	{
		assertThat(this.page).hasTitle("Cronos");
	}
}
