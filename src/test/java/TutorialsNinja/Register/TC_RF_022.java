package TutorialsNinja.Register;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_022 {
	
	
	
	@Test
	public void VerifyPasswordFieldsHideEnteredTextVisibility() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']")).getAttribute("type"), "password");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-confirm']")).getAttribute("type"), "password");
		
		driver.quit();
	}

}
