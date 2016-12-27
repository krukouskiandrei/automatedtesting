package by.krukouski.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage
{
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://testmoz.com/673139";

	@FindBy(id = "id_student-name")
	private WebElement inputLogin;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement buttonSubmit;
	
	@FindBy(id = "title")
	private WebElement title;


	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}

	public void login(String username)
	{
		
		inputLogin.sendKeys(username);
		buttonSubmit.click();
		logger.info("Login performed");
	}
	
	public String getTitle(){
		logger.info(title.getText() + "@@@@@@@");
		return title.getText();
	}


}
