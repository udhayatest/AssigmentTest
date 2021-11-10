package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {
	private WebDriver driver;
	 
    public FacebookLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
 
    @FindBy(id = "email")
    private WebElement emailField;
 
    @FindBy(id = "pass")
    private WebElement passwordField;
 
    @FindBy(name = "login")
    private WebElement loginButton;
 
    public void login(String username, String password){
        emailField.sendKeys(username);
        System.out.println("Entered Username: "+username);
        passwordField.sendKeys(password);
        System.out.println("Entered Password: "+password);
        loginButton.click();
        System.out.println("Clicked on Login button");
    }
	

}
