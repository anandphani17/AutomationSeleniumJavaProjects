package TutorialsNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_004 {

		@Test
		public void VerifypropernotificationmessagesaredisplayedforthemandatoryFields() {
				
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/");
			
			driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			
			//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).isDisplayed());
			//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).isDisplayed());
			//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).isDisplayed());
			//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).isDisplayed());
			//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).isDisplayed());
			//Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed());
			
			//WebElement firstNameError = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"));
			
			String expectedFirstNameErrorMessage = "First Name must be between 1 and 32 characters!";
			String expectedLastNameErrorMessage = "Last Name must be between 1 and 32 characters!";
			String expectedEmailErrorMessage = "E-Mail Address does not appear to be valid!";
			String expectedTelephoneErrorMessage = "Telephone must be between 3 and 32 characters!";
			String expectedPasswordErrorMessage = "Password must be between 4 and 20 characters!";
			String expectedPrivacyPolicyWarningMessage = "Warning: You must agree to the Privacy Policy!";
			
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText(), expectedFirstNameErrorMessage);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText(), expectedLastNameErrorMessage);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText(), expectedEmailErrorMessage);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText(), expectedTelephoneErrorMessage);
			Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText(), expectedPasswordErrorMessage);
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), expectedPrivacyPolicyWarningMessage);
			
			
			
			
				
		}
	
	
}
