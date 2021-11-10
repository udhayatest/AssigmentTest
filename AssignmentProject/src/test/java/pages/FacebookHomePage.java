package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class FacebookHomePage {
	private WebDriver driver;

	public FacebookHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[starts-with(@class,'m9osqain a5q79mjw gy2v8mqq jm1wdb64 k4urcfbm qv66sw1b')]/span")
	private WebElement createPost;
	@FindBy(xpath = "//div[contains(@aria-label,'What')]/div/div/div/span/br")
	private WebElement postTextBox;
	@FindBy(xpath = "//a[contains(@aria-label,'Home')]")
	private WebElement home;
	@FindBy(xpath = "//div[@aria-label='Post']/div/div/div/span/span")
	private WebElement postButton;
	@FindBy(xpath = "//div[starts-with(@class,'kvgmc6') and text()='Hello World']")
	private WebElement post;

	public void postStatus(String textStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(home));
			home.click();
			System.out.println("clicked on home");
			wait.until(ExpectedConditions.visibilityOf(createPost));
			createPost.click();
			System.out.println("clicked on create post");
			postTextBox.sendKeys(textStatus);
			System.out.println("typed hello world in status");
			postButton.click();
			System.out.println("Clicked on Post button");
			Assert.assertEquals(true, post.isDisplayed());
			System.out.println("Posted successfully");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
