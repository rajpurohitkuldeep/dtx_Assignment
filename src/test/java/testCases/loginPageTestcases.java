package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import testComponents.baseClass;

public class loginPageTestcases extends baseClass{
	LoginPage login;
	String username="dtxplus";
	String password="dtxplus";
	String invalidUsername="Ajayplus";
	String invalidPassword="132456dd";
	
	
	@Test
//Verify User login by providing valid user credentials are working proper or not
	public void validUserLogin()
	{
		 login=new LoginPage(driver);
		login.userLoginCreds(username, password);
		login.submit();
		
	}
	
	@Test
//Verify User Login with providing invalid password is working proper or not
	public void UserLogin_InvalidPassword()
	{
		LoginPage login=new LoginPage(driver);
		login.userLoginCreds(username, invalidPassword);
		login.submit();
			
	}
	
	@Test
	//Verify clicking on login button with blank password field is working proper or not
	public void UserLogin_BlankPasssword()
	{
		LoginPage login=new LoginPage(driver);
		login.userLoginCreds(username, "");
		login.submit();
	}
	
	@Test
	//Verify clicking on login button with blank username field is working proper or not
	public void UserLogin_BlankUsername()
	{
		LoginPage login=new LoginPage(driver);
		login.userLoginCreds("", password);
		login.submit();
	}
	
	@Test
	//Verify clicking on login button with blank username & password fields working proper or not
	public void UserLogin_blankCreds()
	{
		 login=new LoginPage(driver);
		login.userLoginCreds("", "");
		login.submit();
	}
	
	
}
