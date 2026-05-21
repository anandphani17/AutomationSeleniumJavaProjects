package TutorialsNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_013 {

				
	
		
		@Test
		public void VerifyAllFieldsInRegisterAccountPageHaveProperPlaceholders() {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/");
			
			driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
			

			String expectedFirstnamePlaceholderTest = "First Name";
			Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"), expectedFirstnamePlaceholderTest);
			
			String expectedLastnamePlaceholderTest = "Last Name";
			Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"), expectedLastnamePlaceholderTest);
			
			String expectedEmailPlaceholderTest = "E-Mail";
			Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"), expectedEmailPlaceholderTest);
			
			String expectedTelephonePlaceholderTest = "Telephone";
			Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"), expectedTelephonePlaceholderTest);
			
			String expectedPasswordPlaceholderTest = "Password";
			Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"), expectedPasswordPlaceholderTest);
			
			String expectedPasswordConfirmPlaceholderTest = "Password Confirm";
			Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"), expectedPasswordConfirmPlaceholderTest);
			
			driver.quit();
			
			
		}
}
