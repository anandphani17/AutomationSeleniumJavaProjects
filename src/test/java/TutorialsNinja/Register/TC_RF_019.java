package TutorialsNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Utils.CommonUtils;

public class TC_RF_019 {
	
	WebDriver driver;
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void VerifyLeadingAndTrailingSpacesAreTrimmedInRegisterAccountFields() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		String Expectedinput = "    Anand   ";
		String ExpectedLastname = "   Phani   ";
		String ExpectedEmail = CommonUtils.generateNewEmail();
		String ExpectedPhoneNumber = "   123456789   ";
		String ExpectedPassword = "12345";
		String ExpectedConfirmPassword = "12345";
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(Expectedinput);
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(ExpectedLastname);
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(ExpectedEmail);
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(ExpectedPhoneNumber);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(ExpectedPassword);
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(ExpectedConfirmPassword);
		
		String FirstnameInputField = driver.findElement(By.xpath("//input[@id='input-firstname']")).getAttribute("value");
		String LastnameInputField = driver.findElement(By.xpath("//input[@id='input-lastname']")).getAttribute("value");
		String EmailInputField = driver.findElement(By.xpath("//input[@id='input-email']")).getAttribute("value");
		String TelephoneInputField = driver.findElement(By.xpath("//input[@id='input-telephone']")).getAttribute("value");
		//String PasswordInputField = driver.findElement(By.xpath("//input[@id='input-password']")).getAttribute("value");
		//String ConfirmPasswordInputField = driver.findElement(By.xpath("//input[@id='input-confirm']")).getAttribute("value");
		
		Assert.assertEquals(FirstnameInputField, Expectedinput.trim());
		Assert.assertEquals(LastnameInputField, ExpectedLastname.trim());
		Assert.assertEquals(EmailInputField, ExpectedEmail.trim());
		Assert.assertEquals(TelephoneInputField, ExpectedPhoneNumber.trim());
		//Assert.assertEquals(PasswordInputField, ExpectedPassword.trim());
		//Assert.assertEquals(ConfirmPasswordInputField, ExpectedConfirmPassword.trim());
		
		driver.findElement(By.xpath("//input[@value='0']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		
	}
	
	
}
