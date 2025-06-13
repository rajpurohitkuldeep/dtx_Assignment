package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponent.abstractComponentMethods;

public class DashboardPage extends abstractComponentMethods {
	
WebDriver driver;

public DashboardPage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}


//find patient data list & fetch data list
@FindBy(id="patients-table")
private WebElement dataTable;
	
public void fetchDataList()
{
	System.out.println(dataTable.getText());
}

//Find Add patient Button & perform click action 
@FindBy(id="add-patient-btn")
private WebElement AddPatientBtn;

public AddPatient addPatientBtn()
{
	AddPatientBtn.click();
	AddPatient addPatient=new AddPatient(driver);
	return addPatient;
}




}
