package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.FacebookHomePage;
import pages.FacebookLoginPage;

public class FacebookPostStatus {
	WebDriver driver;
	WebDriverWait wait;
	// String userName = "testudhaya@gmail.com"; //Enter your username for facebook
	// String password = "Test@123"; //Enter your password for facebook
	FacebookLoginPage facebookLoginPage;
	FacebookHomePage facebookHomePage;

	@BeforeClass
	public void setup() throws IOException {

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(
					"C:\\Users\\udhay\\Desktop\\MyWorkspace\\AssignmentProject\\test_data\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String userName = prop.getProperty("facebookUserName");
		String password = prop.getProperty("facebookPassword");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		System.setProperty(prop.getProperty("ChromeDriver"), prop.getProperty("chromeDriverPath"));
		driver = new ChromeDriver(ops);
		wait = new WebDriverWait(driver, 25);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get(prop.getProperty("facebookURL"));
		facebookLoginPage = new FacebookLoginPage(driver);
		facebookHomePage = new FacebookHomePage(driver);
		facebookLoginPage.login(userName, password);

	}

	@Test
	public void FacebookPost() {
		String post = "Hello World";
		facebookHomePage.postStatus(post);
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
