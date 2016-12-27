package by.krukouski.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassTestPage extends AbstractPage{
	
	private final String BASE_URL = "https://testmozusercontent.com/673139/student";
	private final Logger logger = LogManager.getRootLogger();
	
	@FindBy(id = "question7805417")
	private WebElement question1;
	
	@FindBy(id = "question7805423")
	private WebElement question2;
	
	@FindBy(id = "question7805431")
	private WebElement question3;
	
	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submit;
	
	private final String ResultXPATH = "//h1[@id='score']";
	private final String ErrorXPATH = "//p[@class='error']";
	
	private final String SuccessResult = "YOUR SCORE: 100% (3 POINTS OUT OF 3)";
	private final String MiddleResult = "YOUR SCORE: 67% (2 POINTS OUT OF 3)";
	private final String NotSuccesResult = "YOUR SCORE: 0% (0 POINTS OUT OF 3)";
	private final String ErrorResult = "YOU MUST ANSWER EVERY QUESTION. INCOMPLETE TESTS WILL NOT BE ACCEPTED.";
	
	public PassTestPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(this.driver, this);
		logger.info("context created");
	}
	
	
	public void chooseFirstQuestion(String answerValue){
		WebElement answer = question1.findElement(By.xpath("//input[@value='" + answerValue + "']"));
		answer.click();
	}
	
	public void chooseSecondQuestion(String[] answers){
		
		for(int i = 0; i < answers.length; i++){
			WebElement answer = question2.findElement(By.xpath("//input[@value='" + answers[i] + "']"));
			answer.click();
		}
		
	}
	
	public void chooseThirdQuestion(String answerValue){
		WebElement answer = question3.findElement(By.xpath("//input[@value='" + answerValue + "']"));
		answer.click();
	}
	
	public void clickSubmit(){
		submit.click();
	}
	
	private String getTestResult(){
			
		WebElement score = driver.findElement(By.xpath(ResultXPATH));
		
		return score.getText();
	}
	
	private String getTeatErrorResult(){
		
		WebElement result = driver.findElement(By.xpath(ErrorXPATH));
		
		return result.getText();
		
	}
	
	public boolean tryToChooseTwoAnswers(String answerValue1, String answerValue2){
		WebElement answer1 = question3.findElement(By.xpath("//input[@value='" + answerValue1 + "']"));
		answer1.click();
		WebElement answer2 = question3.findElement(By.xpath("//input[@value='" + answerValue2 + "']"));
		answer2.click();
		return answer1.isSelected() == false;
	}
	
	public boolean getSuccessResult(){
		return getTestResult().trim().toUpperCase().equals(SuccessResult);
	}
	
	public boolean getMiddleresult(){
		return getTestResult().trim().toUpperCase().equals(MiddleResult);
	}
	
	public boolean getErrorResult(){
		return getTeatErrorResult().trim().toUpperCase().equals(ErrorResult);
	}
	
	public boolean getNotSuccessResult(){
		return getTestResult().trim().toUpperCase().equals(NotSuccesResult);
	}
	
	@Override
	public void openPage(){
		driver.navigate().to(BASE_URL);
	}
	
	

}
