package Abstractcomponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.LoginPage;

public class abstractComponentMethods {

	WebDriver driver;
	WebDriverWait wait;

	public abstractComponentMethods(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitTimeForWebElementToAppear(WebElement eleAppear) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(eleAppear));
	}

	public void waitTimeForWebElementListToAppear(List<WebElement> eleListAppear) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(eleListAppear));
	}

	public void waitTimeForElementToClickable(WebElement eleClick) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(eleClick));
	}

	public void waitTimeForElementToTextPresent(WebElement Numberfield) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElementValue(Numberfield, ""));
	}

	public void waitUntilFieldCleared(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
		wait.until(ExpectedConditions.attributeToBe(element, "value", ""));
	}

	
	public void actionClick() {
		// Perform the random screen click using Actions class
		Actions actions = new Actions(driver);
		actions.moveByOffset(200, 500).click().perform();
	}
	
	public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	public void scrollBy() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)");

	}
	
	public void scrollToElement(WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	//perform scrolling action using action method
	public void scroll()
	{
		// Scroll to the bottom of the page using Actions class
        Actions actions = new Actions(driver);
        WebElement body = driver.findElement(By.tagName("body"));
        actions.moveToElement(body).clickAndHold().moveByOffset(0, 3000).release().perform();

	}
	
	//perform Logout Action & recall Login action 
	@FindBy(id="logout")
	private WebElement LogoutBtn;
	public LoginPage logout()
	{
		LogoutBtn.click();
		LoginPage Login=new LoginPage(driver);
		return Login;
	}

}
