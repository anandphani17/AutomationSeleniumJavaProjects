package TutorialsNinja.Register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_010 {

	
	@Test
	public void VerifyAccountRegistrationWithInvalidEmailAddress() throws InterruptedException, IOException {
		
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Arun");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Motoori");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("amotoori");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("09246812111");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(3000);
		
		File srcScreenshot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		// to copy the file use filehandler from selenium
		FileHandler.copy(srcScreenshot1, new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));
		Thread.sleep(3000);
		Assert.assertFalse(CompareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png", System.getProperty("user.dir")+"\\Screenshots\\sc1Expected.png"));		
		
		
		driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("amotoori@");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(3000);
		
		
		File scrScreenshot2 =  driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrScreenshot2, new File(System.getProperty("user.dir")+"\\Screenshots\\sc2Expected.png"));
		
		Assert.assertFalse(CompareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\sc2Actual.png", System.getProperty("user.dir")+"\\Screenshots\\sc2Expected.png"));	
		
		
		driver.quit();
		
		
	}
	
	public boolean CompareTwoScreenshots(String actualImagePath, String expectedImagePath) throws IOException {
		BufferedImage actualBImg = ImageIO.read(new File(actualImagePath));
		BufferedImage expectedBImg = ImageIO.read(new File(expectedImagePath));
		
		ImageDiffer imgDiffer = new ImageDiffer();
		
		ImageDiff ImgDifference = imgDiffer.makeDiff(expectedBImg, actualBImg);
		return ImgDifference.hasDiff();
	}
	
	
	
	
}