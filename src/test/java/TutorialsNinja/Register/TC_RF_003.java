package TutorialsNinja.Register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_003 {
	
	@Test
	public  void VerifyRegisteringanAccountbyprovidingalltheFields() {
			
		
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/");
			driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
			driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Anand");
			driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Phani");
			driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(generateNewEmail());
			driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("123456789");
			driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
			driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
			driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
			driver.findElement(By.xpath("//input[@name='agree']")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			
			Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Success']")).isDisplayed());
			
			String expectedProperDetailsOne = "Your Account Has Been Created!";
			String expectedProperDetailsTwo = "Congratulations! Your new account has been successfully created!";
			String expectedProperDetailsThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
			String expectedProperDetailsFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
			String expectedProperDetailsFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
			String expectedProperDetailsSix = "contact us.";
			
			String actualProperDetails = driver.findElement(By.xpath("//div[@id='content']")).getText();
			
			Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsOne));
			Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsTwo));
			Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsThree));
			Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFour));
			Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsFive));
			Assert.assertTrue(actualProperDetails.contains(expectedProperDetailsSix));
			
			driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
			Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
			
			driver.quit();
	}
	public  String generateNewEmail(){
		return new Date().toString().replaceAll("\\s", "").replaceAll("\\:","")+"@gmail.com";

}
}
