package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WallethubLoginPage {

	private WebDriver driver;

	public WallethubLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement emailTextBox;

	@FindBy(id = "password")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//button[@type='button']//span[text()=\"Login\"]")
	private WebElement loginButtonElement;

	public void wallethubLogin(String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(emailTextBox));
		emailTextBox.click();
		emailTextBox.sendKeys(username);
		System.out.println("Entered Username: " + username);
		wait.until(ExpectedConditions.visibilityOf(passwordTextBox));
		passwordTextBox.click();
		passwordTextBox.sendKeys(password);
		System.out.println("Entered Password ");
		loginButtonElement.click();
		System.out.println("Clicked on Login button");
	}
}
