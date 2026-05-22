package TutorialsNinja.Register;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Utils.CommonUtils;

public class TC_RF_015 {
			
		WebDriver driver;
			
		@Test
		public void VerifyRegisteredAccountDetailsAreStoredInDatabase() throws SQLException {
			
				
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get("http://localhost/opencart/");
			
			driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
			
			String firstName = "Vadappali";
			driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(firstName);
			String lastName ="venkateshwaraswami";
			driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(lastName);
			String email = CommonUtils.generateNewEmail();
			driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
			String password = "123456";
			driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
			//driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']")).click();
			//.findElement(By.name("agree")).click();
			WebElement privacyPolicy =
					driver.findElement(By.name("agree"));

					JavascriptExecutor js = (JavascriptExecutor) driver;

					js.executeScript("arguments[0].click();",
					privacyPolicy);

			WebElement continueButton = driver.findElement(
					By.xpath("//button[normalize-space()='Continue']"));

			JavascriptExecutor jse = (JavascriptExecutor) driver;

			jse.executeScript("arguments[0].click();", continueButton);
			
			//Database
			
			String dbURL = "jdbc:mysql://localhost:3306/opencart_db";

			String dbUsername = "root";

			String dbPassword = null;

			Connection con = DriverManager.getConnection(
					dbURL,
					dbUsername,
					dbPassword);

			// Create Statement

			Statement stmt = con.createStatement();

			// SQL Query

			String query =
					"SELECT * FROM oc_customer WHERE firstname = 'Vadappali'";
			// Execute Query

			ResultSet rs = stmt.executeQuery(query);
			

			// ==========================
			// ASSERTIONS
			// ==========================



			// Check user exists in DB

			Assert.assertTrue(rs.next(),
					"User data is NOT stored in database");



			// Validate First Name

			String dbFirstName = rs.getString("firstname");

			Assert.assertEquals(dbFirstName,
					firstName,
					"First Name is not matching");



			// Validate Last Name

			String dbLastName = rs.getString("lastname");

			Assert.assertEquals(dbLastName,
					lastName,
					"Last Name is not matching");



			// Validate Email

			String dbEmail = rs.getString("email");

			Assert.assertEquals(dbEmail,
					email,
					"Email is not matching");



			System.out.println("UI Data and Database Data are matching");



			// Close Connection

			con.close();
			
			
				
	
		}
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		
		
}
