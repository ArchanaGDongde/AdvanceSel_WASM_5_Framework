package vitiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;

public class LoginTest {

	public static void main(String[] args) {
		// Launch the Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		//login to app
		LoginPage lp= new LoginPage(driver);
		
		lp.loginToApp("admin", "admin");	
	}

}
