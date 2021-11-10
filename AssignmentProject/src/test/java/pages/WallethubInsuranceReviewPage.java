package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WallethubInsuranceReviewPage {
	private WebDriver driver;

	public WallethubInsuranceReviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@class,'dropdown second')]/span[contains(text(),'Select')]")
	private WebElement selectDropDown;
	@FindBy(xpath = "//div[contains(@class,'dropdown second')]/ul/li[contains(text(),'Health Insurance')]")
	private WebElement healthInsuranceOption;
	@FindBy(xpath = "//textarea[contains(@placeholder,'Write your review')]")
	private WebElement reviewTextArea;
	@FindBy(xpath = "//div[text()='Submit']")
	private WebElement submitButton;

	public void ClickOnDropdown() {
		selectDropDown.click();
		System.out.println("Clicked on the dropdown");
		healthInsuranceOption.click();
		System.out.println("Selected the health insurance option from the dropdown");

	}

	public void WriteReview(String postReviewText) {
		reviewTextArea.click();
		reviewTextArea.sendKeys(postReviewText);
		System.out.println(" review has been written");
	}

	public void ClickOnSubmit() {
		submitButton.click();
	}

}
