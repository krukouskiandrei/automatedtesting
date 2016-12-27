package by.krukouski.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuildTestPage extends AbstractPage{
	
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://testmoz.com/";
	
	@FindBy(xpath = "//a[contains(text(), 'Build')]")
	private WebElement buildLink;
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement inputTestName;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement inputTestPassword;
	
	@FindBy(xpath = "//input[@name='confirm_password']")
	private WebElement inputTestConfirmPassword;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	public BuildTestPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@Override
	public void openPage(){
		driver.navigate().to(BASE_URL);
		logger.info("Main Page opened");
	}
	
	public void clickBuildLink(){
		buildLink.click();
	}
	
	public void createTest(String testName, String testPassword){
		inputTestName.sendKeys(testName);
		inputTestPassword.sendKeys(testPassword);
		inputTestConfirmPassword.sendKeys(testPassword);
		continueButton.click();
		logger.info("Creating performed");
	}
	
	public String getTestName(){
		
		return driver.getTitle();
	
	}
	
	
	

}
