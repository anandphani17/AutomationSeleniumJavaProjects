package TutorialsNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.CommonUtils;

public class TC_RF_017 {
	WebDriver driver;
	
	
	
	@Test(dataProvider ="passwordProvider")
	public void VerifyPasswordFieldsFollowPasswordComplexityStandards(String passwordTest) {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Anand");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Phani");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(CommonUtils.generateNewEmail());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("12345678 ");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(passwordTest);
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(passwordTest);
		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		String ExpectedWarningMessageForDifferentPasswords = "Password confirmation does not match password!";
		
		String ActualMessage = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();
		
		Assert.assertEquals(ActualMessage, ExpectedWarningMessageForDifferentPasswords);
		Assert.assertFalse(driver.findElement(By.xpath("//a[normalize-space()='Success']")).isDisplayed());
		
		
		
		
	}
	@DataProvider(name = "passwordProvider")
	public Object[][] supplyPassword() {
		Object [] [] data = {{"12345"},{"abcd1232"},{"ABC123$"},{"abcdefghi"},{"abcd123@"} };
		return data;
		}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
