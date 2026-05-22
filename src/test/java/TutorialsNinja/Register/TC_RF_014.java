package TutorialsNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_014 {
	
	WebDriver driver;
	
	
	@Test
	 public void VerifyMandatoryFieldsAreMarkedWithRedAsteriskSymbol() {
		
		

		 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebElement firstnameLabel = driver.findElement(By.xpath("//label[normalize-space()='First Name']"));
		
		String fnContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", firstnameLabel);
		String fnColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');",firstnameLabel);
		
		Assert.assertEquals(fnContent, expectedContent);
		Assert.assertEquals(fnColor, expectedColor);
		
		WebElement LastnameLabel = driver.findElement(By.xpath("//label[normalize-space()='Last Name']"));
		
		String lnContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", LastnameLabel);
		String lnColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');",LastnameLabel);
		
		Assert.assertEquals(lnContent, expectedContent);
		Assert.assertEquals(lnColor, expectedColor);
		
		WebElement EmailLabel = driver.findElement(By.xpath("//label[normalize-space()='E-Mail']"));
		
		String emContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", EmailLabel);
		String emColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');",EmailLabel);
	
		Assert.assertEquals(emContent, expectedContent);
		Assert.assertEquals(emColor, expectedColor);
		
		WebElement TelLabel = driver.findElement(By.xpath("//label[normalize-space()='Telephone']"));
		
		String TelContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", TelLabel);
		String TelColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');",TelLabel);
		
		Assert.assertEquals(TelContent, expectedContent);
		Assert.assertEquals(TelColor, expectedColor);
		
		WebElement pwdLabel = driver.findElement(By.xpath("//label[normalize-space()='Password']"));
		
		String pwdContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", pwdLabel);
		String pwdColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');",pwdLabel);
		
		Assert.assertEquals(pwdContent, expectedContent);
		Assert.assertEquals(pwdColor, expectedColor);
		
		
		WebElement pwdcLabel = driver.findElement(By.xpath("//label[normalize-space()='Password Confirm']"));
		
		String pwdcContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", pwdcLabel);
		String pwdcColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');",pwdcLabel);
		
		Assert.assertEquals(pwdcContent, expectedContent);
		Assert.assertEquals(pwdcColor, expectedColor);
		
		WebElement privacyLabel = driver.findElement(By.xpath("//div[@class='pull-right']"));
		
		String privacyContent = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", privacyLabel);
		String privacyColor = (String) jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');",privacyLabel);
		
		Assert.assertEquals(privacyContent, expectedContent);
		Assert.assertEquals(privacyColor, expectedColor);
		
		
				
		
	 }
	
	@AfterMethod
	public void tearDown() {
		driver.quit(); 
	}

}
