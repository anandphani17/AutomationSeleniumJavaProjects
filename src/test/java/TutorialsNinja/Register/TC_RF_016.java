package TutorialsNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_RF_016 {
	
	
	@Test
	public void VerifyMandatoryFieldsDoNotAcceptOnlySpaces() {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(" ");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		String firstNameWarning = "First Name must be between 1 and 32 characters!";
		String lastNameWarning = "Last Name must be between 1 and 32 characters!";
		String emailWarning = "E-Mail Address does not appear to be valid!";
		String telephoneWarning = "Telephone must be between 3 and 32 characters!";
		String passwordWarning = "Password must be between 4 and 20 characters!";
		
		String actualFirstNameWarning = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();

		String actualLastNameWarning = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();

		String actualEmailWarning = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();

		String actualTelephoneWarning = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();

		String actualPasswordWarning = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		
		Assert.assertEquals(actualFirstNameWarning, firstNameWarning);
		Assert.assertEquals(actualLastNameWarning, lastNameWarning);
		Assert.assertEquals(actualEmailWarning, emailWarning);
		Assert.assertEquals(actualTelephoneWarning, telephoneWarning);
		Assert.assertEquals(actualPasswordWarning, passwordWarning);
		
		driver.quit();
		
	}

}
