package by.krukouski.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
	
	public void clickCreateQuestion(){
		driver.findElement(By.xpath("//a[contains(text(), 'Add questions')]")).click();;
	}
	
	public void setQuestionInForm(String question, String[] answers, int rightAnswer){
		
		WebElement inputQuestion = driver.findElement(By.xpath("//textarea[@name='question']"));
		
		inputQuestion.sendKeys(question);
		
		WebElement answerDiv = driver.findElement(By.xpath("//div[@id='multiple-choice-options']"));
		
		for(int i = 0; i < answers.length; i++){
			WebElement inputAnswer = answerDiv.findElement(By.xpath("//textarea[@id='id_2-answer_" + i +"']"));
			WebElement checkoutAnswer = answerDiv.findElement(By.xpath("//input[@id='id_2-correct_" + i +"']"));
			inputAnswer.sendKeys(answers[i]);
			if(i == rightAnswer-1){
				checkoutAnswer.click();
			}			
		}
			
	}
	
	public void clickSaveQuestion(){
	
		WebElement submitButton = driver.findElement(By.xpath("//input[@value='Save']"));
		submitButton.click();
		
	}
	
	public boolean checkCreatedQuestion(String question){
		
		WebElement currentQuestions = driver.findElement(By.xpath("//table[@class='questions']"));
		
		return currentQuestions != null;
		
	}
	
	public void clickReportsLink(){
		
		driver.findElement(By.xpath("//a[contains(text(), 'Reports')]")).click();
		
	}
	
	public void clickAnswerKey(){
		
		driver.findElement(By.xpath("//a[contains(text(), 'answer key')]")).click();
		
	}
	
	public boolean checkRightAnswerPage(){
		
		WebElement correctLabel =  driver.findElement(By.xpath("//span[contains(text(), 'Correct')]"));
		
		return correctLabel != null;
		
	}
	

}
