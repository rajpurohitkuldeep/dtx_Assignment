package testComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;

public class baseClass {
	public WebDriver driver;

	public WebDriver invokeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@BeforeMethod(alwaysRun=true)
	
	public void launchWebsite()
	{
		driver=invokeDriver();
			LoginPage Login=new LoginPage(driver);
			Login.invokeURL();
			//return Login;
	}
	
	// Closing browser once Test Methods completed

		@AfterMethod
		public void tearDown() {
			//driver.quit();

		}

}
