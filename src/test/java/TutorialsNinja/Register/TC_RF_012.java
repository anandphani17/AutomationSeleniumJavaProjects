package TutorialsNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.CommonUtils;

public class TC_RF_012 {

	
		@Test
		public void VerifyAccountRegistrationUsingKeyboardKeys() {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/");
			
			driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
			
			
			Actions actions = new Actions(driver);
			
			for(int i=1; i<=23; i++) {
			actions.sendKeys(Keys.TAB).perform();
			}
			
				actions.sendKeys("Anand").sendKeys(Keys.TAB).sendKeys("Phani").sendKeys(Keys.TAB).sendKeys(CommonUtils.generateNewEmail())
				.sendKeys(Keys.TAB).sendKeys("123456789").sendKeys(Keys.TAB).sendKeys("12345").sendKeys(Keys.TAB).sendKeys	("12345").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.LEFT).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.SPACE).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
				
				Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).isDisplayed());
				Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Success']")).isDisplayed());
				
			
			
			
			
			
			driver.quit();
			
			
			
			
			
			
			
			
		}
	
	
}
