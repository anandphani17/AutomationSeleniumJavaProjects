package TutorialsNinja.Register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_018 {
	
		WebDriver driver;
		
		@Test
		public void VerifyRegisterAccountFieldsMeetClientRequirements() throws IOException {
			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/");
			
			driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
			
			String expectedHeight = "34px";
			String expectedWidth = "701.25px";
			
		
			WebElement Firstnamefield = driver.findElement(By.xpath("//input[@id='input-firstname']"));
			String firstnameHeight = Firstnamefield.getCssValue("height");
			String firstnameWidth = Firstnamefield.getCssValue("width");
			Assert.assertEquals(expectedHeight, firstnameHeight);
			Assert.assertEquals(expectedWidth, firstnameWidth);
			
			WebElement ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));

			String ExpectedWarning = "First Name must be between 1 and 32 characters!";

		

			// Empty First Name
			
			Firstnamefield.clear();
			Firstnamefield.sendKeys("");
			ContineButton.click();

			String WarningMessage = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
			Assert.assertEquals(WarningMessage, ExpectedWarning);

			// First Name with 1 character
			Firstnamefield = driver.findElement(By.xpath("//input[@id='input-firstname']"));
			Firstnamefield.clear();
			Firstnamefield.sendKeys("a");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			boolean status1 = driver.findElements(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).size() > 0;
			Assert.assertFalse(status1);

			// First Name with 2 characters
			Firstnamefield = driver.findElement(By.xpath("//input[@id='input-firstname']"));
			Firstnamefield.clear();
			Firstnamefield.sendKeys("ab");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			boolean status2 = driver.findElements(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).size() > 0;
			Assert.assertFalse(status2);

			// First Name with 15 characters
			Firstnamefield = driver.findElement(By.xpath("//input[@id='input-firstname']"));
			Firstnamefield.clear();
			Firstnamefield.sendKeys("abcdefghijklmno");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			boolean status3 = driver.findElements(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).size() > 0;
			Assert.assertFalse(status3);

			// First Name with exactly 32 characters
			Firstnamefield = driver.findElement(By.xpath("//input[@id='input-firstname']"));
			Firstnamefield.clear();
			Firstnamefield.sendKeys("abcdefghijklmnopqrstuvwxyzabcdef");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			boolean status4 = driver.findElements(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).size() > 0;
			Assert.assertFalse(status4);

			// First Name with more than 32 characters
			Firstnamefield = driver.findElement(By.xpath("//input[@id='input-firstname']"));
			Firstnamefield.clear();
			Firstnamefield.sendKeys("abcdefghijklmnopqrstuvwxyzabcdefghi");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			String ActualWarning = driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText();
			Assert.assertEquals(ActualWarning, ExpectedWarning);
			
			
			//-------------------------------------//
			
			// Last Name Field UI Validation
			WebElement Lastnamefield = driver.findElement(By.xpath("//input[@id='input-lastname']"));

			String lastnameHeight = Lastnamefield.getCssValue("height");
			String lastnameWidth = Lastnamefield.getCssValue("width");

			Assert.assertEquals(expectedHeight, lastnameHeight);
			Assert.assertEquals(expectedWidth, lastnameWidth);


			String LastnameExpectedWarning = "Last Name must be between 1 and 32 characters!";


			// Empty Last Name
			Lastnamefield = driver.findElement(By.xpath("//input[@id='input-lastname']"));
			Lastnamefield.clear();
			Lastnamefield.sendKeys("");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			String LastnameWarning1 = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();
			Assert.assertEquals(LastnameWarning1, LastnameExpectedWarning);


			// Last Name with 1 character
			Lastnamefield = driver.findElement(By.xpath("//input[@id='input-lastname']"));
			Lastnamefield.clear();
			Lastnamefield.sendKeys("a");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			boolean LastnameStatus1 = driver.findElements(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).size() > 0;
			Assert.assertFalse(LastnameStatus1);


			// Last Name with 2 characters
			Lastnamefield = driver.findElement(By.xpath("//input[@id='input-lastname']"));
			Lastnamefield.clear();
			Lastnamefield.sendKeys("ab");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			boolean LastnameStatus2 = driver.findElements(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).size() > 0;
			Assert.assertFalse(LastnameStatus2);


			// Last Name with 15 characters
			Lastnamefield = driver.findElement(By.xpath("//input[@id='input-lastname']"));
			Lastnamefield.clear();
			Lastnamefield.sendKeys("abcdefghijklmno");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			boolean LastnameStatus3 = driver.findElements(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).size() > 0;
			Assert.assertFalse(LastnameStatus3);


			// Last Name with exactly 32 characters
			Lastnamefield = driver.findElement(By.xpath("//input[@id='input-lastname']"));
			Lastnamefield.clear();
			Lastnamefield.sendKeys("abcdefghijklmnopqrstuvwxyzabcdef");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			boolean LastnameStatus4 = driver.findElements(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).size() > 0;
			Assert.assertFalse(LastnameStatus4);


			// Last Name with more than 32 characters
			Lastnamefield = driver.findElement(By.xpath("//input[@id='input-lastname']"));
			Lastnamefield.clear();
			Lastnamefield.sendKeys("abcdefghijklmnopqrstuvwxyzabcdefghi");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			String LastnameActualWarning = driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText();

			Assert.assertEquals(LastnameActualWarning, LastnameExpectedWarning);
			
				//---------------------------------------------------//
			
			// Email Field UI Validation
			WebElement Emailfield = driver.findElement(By.xpath("//input[@id='input-email']"));

			String emailnameHeight = Emailfield.getCssValue("height");
			String emailnameWidth = Emailfield.getCssValue("width");

			Assert.assertEquals(expectedHeight, emailnameHeight);
			Assert.assertEquals(expectedWidth, emailnameWidth);


			// Email Address with more than 32 characters
			Emailfield = driver.findElement(By.xpath("//input[@id='input-email']"));
			Emailfield.clear();
			Emailfield.sendKeys("anandphaniqaautomationtesting123456789@gmail.com");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			boolean EmailStatus = driver.findElements(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).size() > 0;

			Assert.assertFalse(EmailStatus);
			
			//---------------------------------------------//

			// Telephone Field UI Validation
			WebElement Telephonefield = driver.findElement(By.xpath("//input[@id='input-telephone']"));

			String telephonenameHeight = Telephonefield.getCssValue("height");
			String telephonenameWidth = Telephonefield.getCssValue("width");

			Assert.assertEquals(expectedHeight, telephonenameHeight);
			Assert.assertEquals(expectedWidth, telephonenameWidth);


			String TelephoneExpectedWarning = "Telephone must be between 3 and 32 characters!";


			// Telephone with 0 digits
			Telephonefield = driver.findElement(By.xpath("//input[@id='input-telephone']"));
			Telephonefield.clear();
			Telephonefield.sendKeys("");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			String TelephoneWarning1 = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();

			Assert.assertEquals(TelephoneWarning1, TelephoneExpectedWarning);


			// Telephone with 1 digit
			Telephonefield = driver.findElement(By.xpath("//input[@id='input-telephone']"));
			Telephonefield.clear();
			Telephonefield.sendKeys("1");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			String TelephoneWarning2 = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();

			Assert.assertEquals(TelephoneWarning2, TelephoneExpectedWarning);


			// Telephone with 3 digits
			Telephonefield = driver.findElement(By.xpath("//input[@id='input-telephone']"));
			Telephonefield.clear();
			Telephonefield.sendKeys("123");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			boolean TelephoneStatus1 = driver.findElements(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).size() > 0;

			Assert.assertFalse(TelephoneStatus1);


			// Telephone with exactly 32 digits
			Telephonefield = driver.findElement(By.xpath("//input[@id='input-telephone']"));
			Telephonefield.clear();
			Telephonefield.sendKeys("12345678901234567890123456789012");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			boolean TelephoneStatus2 = driver.findElements(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).size() > 0;

			Assert.assertFalse(TelephoneStatus2);


			// Telephone with 33 digits
			Telephonefield = driver.findElement(By.xpath("//input[@id='input-telephone']"));
			Telephonefield.clear();
			Telephonefield.sendKeys("123456789012345678901234567890123");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			String TelephoneWarning3 = driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText();

			Assert.assertEquals(TelephoneWarning3, TelephoneExpectedWarning);
			
			//--------------------------------------------//
			

			// Password Field UI Validation
			WebElement Passwordfield = driver.findElement(By.xpath("//input[@id='input-password']"));

			String passwordnameHeight = Passwordfield.getCssValue("height");
			String passwordnameWidth = Passwordfield.getCssValue("width");

			Assert.assertEquals(expectedHeight, passwordnameHeight);
			Assert.assertEquals(expectedWidth, passwordnameWidth);


			String PasswordExpectedWarning = "Password must be between 4 and 20 characters!";


			// Password with 0 characters
			Passwordfield = driver.findElement(By.xpath("//input[@id='input-password']"));
			Passwordfield.clear();
			Passwordfield.sendKeys("");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			String PasswordWarning1 = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();

			Assert.assertEquals(PasswordWarning1, PasswordExpectedWarning);


			// Password with 1 character
			Passwordfield = driver.findElement(By.xpath("//input[@id='input-password']"));
			Passwordfield.clear();
			Passwordfield.sendKeys("a");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			String PasswordWarning2 = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();

			Assert.assertEquals(PasswordWarning2, PasswordExpectedWarning);


			// Password with 4 characters
			Passwordfield = driver.findElement(By.xpath("//input[@id='input-password']"));
			Passwordfield.clear();
			Passwordfield.sendKeys("abcd");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			boolean PasswordStatus1 = driver.findElements(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).size() > 0;

			Assert.assertFalse(PasswordStatus1);


			// Password with exactly 20 characters
			Passwordfield = driver.findElement(By.xpath("//input[@id='input-password']"));
			Passwordfield.clear();
			Passwordfield.sendKeys("abcdefghijklmnopqrst");

			ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			ContineButton.click();

			boolean PasswordStatus2 = driver.findElements(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).size() > 0;

			Assert.assertFalse(PasswordStatus2);


			// Password with 21 characters
			//Passwordfield = driver.findElement(By.xpath("//input[@id='input-password']"));
			//Passwordfield.clear();
			//Passwordfield.sendKeys("abcdefghijklmnopqrstu");

			//ContineButton = driver.findElement(By.xpath("//input[@value='Continue']"));
			//ContineButton.click();

			//String PasswordWarning3 = driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText();

			//Assert.assertEquals(PasswordWarning3, PasswordExpectedWarning);
			
			//----------------------------------------------//

			//WebElement ConfirmPasswordfield = driver.findElement(By.xpath("//input[@id='input-confirm']"));
			//String confirmpwdnameHeight = ConfirmPasswordfield.getCssValue("height");
			//String confirmpwdnameWidth = ConfirmPasswordfield.getCssValue("width");
			//Assert.assertEquals(expectedHeight, confirmpwdnameHeight);
			//Assert.assertEquals(expectedWidth, confirmpwdnameWidth);
			
			//--------------------------------------------//
			
			driver.navigate().to("https://tutorialsninja.com/demo/index.php?route=account/register");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(srcScreenshot, new File(System.getProperty("user.dir")+"\\Screenshots\\regpagealignscreenshot.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Expected screenshot
			BufferedImage ExpectedImage = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\Expectedregpagealignscreenshot.png"));
		
			//Actual screenshot
			
			BufferedImage ActualImage = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\regpagealignscreenshot.png"));
			
			
			//Compare screesnhots
			
			ImageDiff diff =  new ImageDiffer().makeDiff(ExpectedImage, ActualImage);
			
			Assert.assertFalse(diff.hasDiff(), "Page Alignment/UI is not matching");
			
			driver.quit();
			
		}
}
