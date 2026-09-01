package base;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utilities.LoginCredentials;

public class BaseTest 
{
	protected Playwright playwright;
	protected Browser browser;
	protected BrowserContext context;
	protected Page page;
	
	
	@BeforeMethod
	public void startup()
	{
		LoginCredentials.loadfile();
		
		ArrayList<String> arguments=new ArrayList<>();
		arguments.add("--start-maximized");
		
		playwright=Playwright.create();
		browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		context=browser.newContext(new Browser.NewContextOptions().setViewportSize(null).setRecordVideoDir(Paths.get("screenrecods")).setRecordVideoSize(1280, 720));
		page=context.newPage();
		page.navigate(LoginCredentials.logindata("url"));
	}
	
	@AfterMethod
	public void closeout()
	{
		page.close();
		browser.close();
		playwright.close();
	}
}
