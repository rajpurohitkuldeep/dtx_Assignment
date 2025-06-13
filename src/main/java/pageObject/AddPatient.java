package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Abstractcomponent.abstractComponentMethods;

public class AddPatient extends abstractComponentMethods {
	
WebDriver driver;

public AddPatient(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

//Find MRN Number Field & provide input
@FindBy(id="mrn")
private WebElement MRN;

public void MRN_value(String Mrn)
{
	MRN.sendKeys(Mrn);
}

//Find First Name Field & Provide input
@FindBy(id="firstName")
private WebElement FName;

public void FirstName(String firstName)
{
	FName.sendKeys(firstName);
}

//Find Last Name Field & Provide input
@FindBy(id="lastName")
private WebElement LName;

public void LastName(String lastName)
{
	LName.sendKeys(lastName);
}

//Find DOB Field & Provide input
@FindBy(id="dob")
private WebElement DOB;

public void DateOfBirth(String BirthDate)
{
	DOB.sendKeys(BirthDate);
}

//Find Discharge date Field & Provide input
@FindBy(id="discharge")
private WebElement Discharge;
public void dischargeDate(String DDATE)
{
	Discharge.sendKeys(DDATE);
}


//Find Phone Field & Provide input
@FindBy(id="phone")
private WebElement Phone;

public void phoneNumber(String PhNumber)
{
	Phone.sendKeys(PhNumber);
}

//Find language Field & Select option

@FindBy(id="language")
private WebElement lang;

@FindBy(xpath="//select[@id='language']/option")
private List<WebElement> langOptions;

public void selectLangOpt(String val)
{
	lang.click();
	Select select =new Select(lang);
	select.selectByVisibleText(val);
}

//Find Timezone Field & Select option

@FindBy(id="timezone")
private WebElement TMZ;

@FindBy(xpath="//select[@id='timezone']/option")
private List<WebElement> ZoneOptions;

public void selectTimeZoneOpt(String Tvalue)
{
	TMZ.click();
	Select select =new Select(TMZ);
	select.selectByVisibleText(Tvalue);
}

//Find Submit Button & perform click action
@FindBy(xpath="(//button[@type='submit'])[2]")
private WebElement submitBtn;

public void SubmitForm()
{
	submitBtn.click();
}

}
