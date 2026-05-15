package TutorialsNinja.Register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_008 {
	
	@Test
	public void VerifyRegisteringAccountWithDifferentPasswords() {
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/");
			
			driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
			driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Shree Ram");
			driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Jai");
			driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(generateNewEmail());
			driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9999999999");
			driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
			driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("abcde");
			driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
			driver.findElement(By.xpath("//input[@name='agree']")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			
			String ExpectedWarningForPasswordConfirmationMismatch = "Password confirmation does not match password!";
			
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(), ExpectedWarningForPasswordConfirmationMismatch);
			
			driver.quit();
		
	}
	public String generateNewEmail() {
		Date date = new Date();
		String stringDate = date.toString();
		return stringDate.replaceAll("\\s","").replaceAll("\\:", "")+"@gmail.com";
	}
}
