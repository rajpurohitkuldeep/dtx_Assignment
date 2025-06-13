package testCases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

import org.testng.annotations.Test;

import pageObject.AddPatient;
import pageObject.DashboardPage;
import pageObject.LoginPage;
import testComponents.baseClass;

public class addPatient extends baseClass{
	LoginPage login;
	DashboardPage Dashboard;
	AddPatient addPatient;
	
	Random rand = new Random();
	
	String username="dtxplus";
	String password="dtxplus";
	String MRN= UUID.randomUUID().toString().substring(0, 5);;
	String Fname=getRandomName();
	String Lname=getRandomName();
	String DOB=getRandomDOB();
	String DischargeDate=LocalDateTime.now()
			.format(DateTimeFormatter.ofPattern("dd MM yyyy HH mm"));
	String Phone=getRandomPhoneNumber();
			
	
	
	@Test
	//Verify Clicking on Add patient button is working proper or not
	public void clickAddpatient()
	{
		login=new LoginPage(driver);
		Dashboard=login.UserLogin(username, password);
		addPatient=Dashboard.addPatientBtn();
	}

	private String getRandomName() {
		String[] names = {"Arya", "Ravi", "Mira", "Kabir", "Tara", "Zoya", "Anil", "Rhea"};
		return names[rand.nextInt(names.length)];
	}

	private String getRandomDOB() {
		int day = rand.nextInt(28) + 1;
		int month = rand.nextInt(12) + 1;
		int year = rand.nextInt(30) + 1970; // Between 1970–1999
		return String.format("%02d %02d %d", day, month, year);
	}

	private String getRandomPhoneNumber() {
		return "9" + (100000000 + rand.nextInt(900000000)); // 10-digit Indian mobile number starting with 9
	}

	
	@Test
	//Verify providing values in Add patient form field is working proper or not
	public void fillFormFieldData()
	{
		login=new LoginPage(driver);
		Dashboard=login.UserLogin(username, password);
		addPatient=Dashboard.addPatientBtn();
		addPatient.MRN_value(MRN);
		addPatient.FirstName(Fname);
		addPatient.LastName(Lname);
		addPatient.dischargeDate(DischargeDate);
		addPatient.phoneNumber(Phone);
	}
	
	@Test
	//Verify Clicking on submit button when  valid data values provided working proper or not
	public void submitPatientDetails()
	{
		login=new LoginPage(driver);
		Dashboard=login.UserLogin(username, password);
		addPatient=Dashboard.addPatientBtn();
		addPatient.MRN_value(MRN);
		addPatient.FirstName(Fname);
		addPatient.LastName(Lname);
		addPatient.phoneNumber(Phone);
		addPatient.selectLangOpt("Spanish");
		addPatient.selectTimeZoneOpt("PST");
		addPatient.SubmitForm();
	}
	
	@Test
	//Verify Clicking on submit button when required mandatory fields are blank working proper or not
	public void SubmitBlankFields()
	{
		login=new LoginPage(driver);
		Dashboard=login.UserLogin(username, password);
		addPatient=Dashboard.addPatientBtn();
		addPatient.MRN_value("");
		addPatient.FirstName("");
		addPatient.LastName(Lname);
		addPatient.phoneNumber(Phone);
		addPatient.selectLangOpt("Spanish");
		addPatient.selectTimeZoneOpt("PST");
		addPatient.SubmitForm();
	}
	
	@Test
	//Verify Clicking on Submit button when invalid values provide in form fields are working proper or not 
	public void SubmitInvalidDataDetailsEntry()
	{

		login=new LoginPage(driver);
		Dashboard=login.UserLogin(username, password);
		addPatient=Dashboard.addPatientBtn();
		addPatient.MRN_value(MRN);
		addPatient.FirstName("123");
		addPatient.LastName("123");
		addPatient.phoneNumber("ahjsjs hjsh");
		addPatient.selectLangOpt("Spanish");
		addPatient.selectTimeZoneOpt("PST");
		addPatient.SubmitForm();
	
	}
	
	@Test
	//Verify newly add data record display on dashboard post relogin is working proper or not
	public void saveDetails_Logout_Relogin_ValidateDatatable()
	{

		login=new LoginPage(driver);
		Dashboard=login.UserLogin(username, password);
		addPatient=Dashboard.addPatientBtn();
		addPatient.MRN_value(MRN);
		addPatient.FirstName(Fname);
		addPatient.LastName(Lname);
		addPatient.phoneNumber(Phone);
		addPatient.selectLangOpt("Spanish");
		addPatient.selectTimeZoneOpt("PST");
		addPatient.SubmitForm();
		login=addPatient.logout();
		Dashboard=login.UserLogin(username, password);
		Dashboard.fetchDataList();
		
	
	}
}
