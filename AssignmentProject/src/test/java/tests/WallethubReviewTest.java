package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import junit.framework.Assert;
import pages.WallethubInsuranceReviewPage;
import pages.WallethubProfilePage;
import pages.WallethubLoginPage;

public class WallethubReviewTest {
	WebDriver driver;
	WebDriverWait wait;
	WallethubInsuranceReviewPage reviewPage;
	WallethubProfilePage profilePage;
	WallethubLoginPage loginPage;
	String walletHubUserName = "";
	String walletHubPassword = "";
	String postReview = "";

	@BeforeMethod
	public void setup() {

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(
					"C:\\Users\\udhay\\Desktop\\MyWorkspace\\AssignmentProject\\test_data\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties props = new Properties();
		try {
			props.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ChromeOptions chrome = new ChromeOptions();
		System.setProperty(props.getProperty("ChromeDriver"), props.getProperty("chromeDriverPath"));
		driver = new ChromeDriver(chrome);
		wait = new WebDriverWait(driver, 50);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get(props.getProperty("wallethubURL"));
		postReview = props.getProperty("postReviewText");
		walletHubUserName = props.getProperty("wallethubUserName");
		walletHubPassword = props.getProperty("wallethubPassword");
	}

	@Test
	public void WallethubReview() throws InterruptedException {
		loginPage = new WallethubLoginPage(driver);
		reviewPage = new WallethubInsuranceReviewPage(driver);
		profilePage = new WallethubProfilePage(driver);
		profilePage.ClickOnLoginOption();
		loginPage.wallethubLogin(walletHubUserName, walletHubPassword);
		Assert.assertEquals(true, profilePage.SelectRating());
		reviewPage.ClickOnDropdown();
		reviewPage.WriteReview(postReview);
		reviewPage.ClickOnSubmit();

		profilePage.CheckIfReviewISPosted(postReview);
		System.out.println("Review posted successfully");

	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
