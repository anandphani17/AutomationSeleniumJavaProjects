package TutorialsNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Utils.CommonUtils;

public class TC_RF_011 {
	
	WebDriver driver;
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	@Test
	public  void VerifyAccountRegistrationWithInvalidPhoneNumber() {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Anand");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Phani");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(CommonUtils.generateNewEmail());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		String expectedErrormessage = " Telephone number is not matching";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']")).getText(), expectedErrormessage);
		
		
	}

	
	
}
