package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponent.abstractComponentMethods;

public class LoginPage extends abstractComponentMethods {
			
		WebDriver driver;
		
		public LoginPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void invokeURL()
		{
			driver.get("https://qa-takehome.dtxplus.com/");
		}

//find Username , password & Login button element and call the required action 
		@FindBy(xpath="//input[@id='username']")
		private WebElement username;
		
		@FindBy(xpath="//input[@id='password']")
		private WebElement password;
		
		@FindBy(xpath="(//button[@type='submit'])[1]")
		private WebElement submit;
		
		//Perform Call action 
		public void userLoginCreds(String userName, String Password)
		{
			waitTimeForWebElementToAppear(username);
			username.sendKeys(userName);
			password.sendKeys(Password);
		}
		
		//Perform Submit action 
		public void submit()
		{
			submit.click();
		}
		
		//User Login 
		public DashboardPage UserLogin(String userName, String Password)
		{
			username.sendKeys(userName);
			password.sendKeys(Password);
			submit.click();
			DashboardPage Dashboard=new DashboardPage(driver);
			return Dashboard;
		}
}
