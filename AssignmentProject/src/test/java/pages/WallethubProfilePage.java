package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class WallethubProfilePage {
	private WebDriver driver;
	 
    public WallethubProfilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    @FindBy(xpath="//span[text()='Login']")
    private WebElement LoginOption; 
    @FindBy(xpath="//div[@class='rating-box-wrapper']/button[contains(text(),'Rate 4 and review')]//preceding-sibling::*[1]")
    private WebElement fourStar;
    @FindBy(xpath="//button[contains(text(),'Write a Review')][1]")
    private WebElement createReviewButton;
    @FindBy(xpath="//div[contains(@class,'rvtab-ci-content with-links')]")
    private WebElement posts;
    @FindBy(xpath="//div[@class='rvc-body-bottom']/div[2]")
    private WebElement continueButtonAfterPost;
  
  
    public void ClickOnLoginOption()
    {
    	LoginOption.click();
    	System.out.println("clicked on Login option");
    }
 
    public boolean SelectRating() throws InterruptedException
    { 
    	boolean isStarHighlighted = false;
    	WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='rating-box-wrapper']/button[contains(text(),'Rate 4 and review')]//preceding-sibling::*[1]")));
    	String colorBeforeHover= fourStar.getAttribute("-webkit-tap-highlight-color");
    	System.out.println("Color of the star before hover is "+ colorBeforeHover);
    	Actions action =new Actions(driver);
    	action.moveToElement(fourStar).moveToElement(fourStar).perform();;
    	String colorAfterHover= fourStar.getCssValue("-webkit-tap-highlight-color");
    	System.out.println("Color of the star before hover is "+ colorAfterHover);
    	if(!colorAfterHover.isEmpty())
    	{
    		System.out.println("the four star is highlighted");
    		isStarHighlighted=true;
    		
    	}
    	else
    	{
    		System.out.println("Star is not higlighted");
    	}
    	fourStar.click();
  
    	
    	System.out.println(" Rating has been selected");
    	
    	return isStarHighlighted;
}
    
    public void CheckIfReviewISPosted(String postText)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='rvc-body-bottom']/div[2]")));
		continueButtonAfterPost.click();
    	WebElement postsPosted = driver.findElement(By.xpath("//div[text()=\""+postText+"\"]")); 
    	Assert.assertEquals(true, postsPosted.isDisplayed());

    }
    
    
    }
    
