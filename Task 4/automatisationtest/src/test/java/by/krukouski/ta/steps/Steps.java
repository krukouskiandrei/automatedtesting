package by.krukouski.ta.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.krukouski.ta.driver.DriverSingleton;
import by.krukouski.ta.pages.BuildTestPage;
import by.krukouski.ta.pages.LoginPage;
import by.krukouski.ta.pages.PassTestPage;

public class Steps {

	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	
	
	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		driver.quit();
	}

	public void loginTestmoz(String username)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		logger.info("Page opened");
		loginPage.login(username);
	}
	
	public boolean isLoggedIn(String title){
		
		LoginPage loginPage = new LoginPage(driver);
		return (loginPage.getTitle().trim().toUpperCase().equals(title));
		
	}
	
	public boolean chooseRightAnswers(){
		
		String answer1 = "32658339";
		String[] answer2 = new String[]{"32658360", "32658358", "32658362"};
		String answer3 = "32658394";
		
		PassTestPage testPage = new PassTestPage(driver);
		
		chooseAnswers(testPage, answer1, answer2, answer3);				
		
		return testPage.getSuccessResult();
		
	}
	
	private void chooseAnswers(PassTestPage testPage, String answer1, String[] answer2, String answer3){
		
		testPage.chooseFirstQuestion(answer1);
		testPage.chooseSecondQuestion(answer2);
		testPage.chooseThirdQuestion(answer3);
		testPage.clickSubmit();
		
	}

	public boolean chooseMiddleAnswers(){
		
		String answer1 = "32658339";
		String[] answer2 = new String[]{"32658362", "32658358", "32658359"};
		String answer3 = "32658394";
		
		PassTestPage testPage = new PassTestPage(driver);
		
		chooseAnswers(testPage, answer1, answer2, answer3);
		
		return testPage.getMiddleresult();
		
	}
	
	public boolean chooseNotSuccessAnswers(){
		
		String answer1 = "32658338";
		String[] answer2 = new String[]{"32658359"};
		String answer3 = "32658395";
		
		PassTestPage testPage = new PassTestPage(driver);
		
		chooseAnswers(testPage, answer1, answer2, answer3);
		
		return testPage.getNotSuccessResult();
	}
	
	public boolean chooseNegativeAnswers(){
		
		PassTestPage testPage = new PassTestPage(driver);
		
		testPage.clickSubmit();
		
		return testPage.getErrorResult();
	}
	
	public boolean chooseTwoAnswers(){
		String answer1 = "32658394";
		String answer2 = "32658395";
		
		PassTestPage testPage = new PassTestPage(driver);
		
		return testPage.tryToChooseTwoAnswers(answer1, answer2);
				
	}
	
	
	public void createTest(String testName, String testPassword){
		
		BuildTestPage buildTestPage = new BuildTestPage(driver);
		buildTestPage.openPage();
		buildTestPage.clickBuildLink();
		logger.info("Build page opened");
		buildTestPage.createTest(testName, testPassword);
		
	}
	
	public boolean isCreatedTest(String testName){
		
		BuildTestPage buildTestPage = new BuildTestPage(driver);
		
		return buildTestPage.getTestName().trim().equals(testName);
		
	}
	
}
