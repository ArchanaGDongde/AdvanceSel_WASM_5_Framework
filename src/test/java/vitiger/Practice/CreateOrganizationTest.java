package vitiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganizationTest {
	public static void main(String[] args) 
	{
		//step 1: Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		// step 2: Login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		// step 3: Navigate to organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step 4: click on create organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step 5: Enter the mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("Qspiders");
		
		//Step 5: Save 
		driver.findElement(By.name("button")).click();
		
		
}
}
