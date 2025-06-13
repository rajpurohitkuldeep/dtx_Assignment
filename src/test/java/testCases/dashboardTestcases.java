package testCases;

import org.testng.annotations.Test;

import pageObject.DashboardPage;
import pageObject.LoginPage;
import testComponents.baseClass;

public class dashboardTestcases extends baseClass{
LoginPage login;
DashboardPage Dashboard;

	String username="dtxplus";
	String password="dtxplus";
	
	
	
	@Test
	//Verify that patients table displays after login is working prooper or not
	public void fetchPatientDataTable() throws InterruptedException
	{
		login=new LoginPage(driver);
		Dashboard=login.UserLogin(username, password);
		Thread.sleep(3000);
		Dashboard.fetchDataList();
	}

	@Test
	//Verify Clicking on Add patient button is working proper or not
	public void clickAddPatient_Btn()
	{
		Dashboard=login.UserLogin(username, password);
		Dashboard.addPatientBtn();
	}
}
