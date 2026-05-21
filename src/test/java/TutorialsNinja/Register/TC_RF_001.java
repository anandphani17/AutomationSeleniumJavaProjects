package TutorialsNinja.Register;

/*1. Click on 'My Account' Drop menu
2. Click on 'Register' option 
3. Enter new Account Details into the Mandatory Fields 
  	(First Name, Last Name, E-Mail,Telephone, Password, Password Confirm and  Privacy Policy Fields)
4. Click on 'Continue' button (ER-1)
5. Click on 'Continue' button that is displayed in the 'Account Success' page (ER-2)
*/
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.CommonUtils;

public class TC_RF_001 {
	
	@Test
	public void verifyRegisteringWithMandatoryFields() {
		
		WebDriver driver = new ChromeDriver();
		//It is global wait for any element in the application.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		//To Maximize the chrome window 
		driver.manage().window().maximize();
		//To open application page url
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
		//driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Shree Ram");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Jai");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(CommonUtils.generateNewEmail());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9999999999");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
			
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).isDisplayed());
		
		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText(), expectedHeading);
		
		String properDetailsOne = "Congratulations! Your new account has been successfully created!";
		String properDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String properDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String properDetailsFour = "contact us";
		
		String ExpectedProperDetails = driver.findElement(By.xpath("//div[@id='content']")).getText();
		
		Assert.assertTrue(ExpectedProperDetails.contains(properDetailsOne));
		Assert.assertTrue(ExpectedProperDetails.contains(properDetailsTwo));
		Assert.assertTrue(ExpectedProperDetails.contains(properDetailsThree));
		Assert.assertTrue(ExpectedProperDetails.contains(properDetailsFour));
	
		
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		
		
		WebElement editInfo = driver.findElement(By.linkText("Edit your account information"));
		Assert.assertTrue(editInfo.isDisplayed());
		
		driver.quit();
		} 
		
	
	}
	
	
	
	
	
	

