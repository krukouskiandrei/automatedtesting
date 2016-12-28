package by.krukouski.ta;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.krukouski.ta.steps.Steps;

public class TestmozAutomationTest {

	private static Steps steps;
	private final String USERNAME = "Andrei";
	private final String TITLE = "FIRST TEST";
	private final String TESTNAME = "My Test";
	private final String TESTPASSWORD = "mytest";
	private final String QUESTION = "What is the capital city of Belarus?";
	private final String[] ANSWERS = new String[]{"Grodno", "Brest", "Minsk", "Dukora"};
	private final int RIGHTANSWER = 3;
	

	@BeforeClass
	public static void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}
	
	//Test on login #1
	@Test
	public void oneCanLoginTestmoz()
	{
		steps.loginTestmoz(USERNAME);
		Assert.assertTrue(steps.isLoggedIn(TITLE));
		
	}
	
	//Test on creating of test #2
	@Test
	public void testBuildTest(){
		steps.createTest(TESTNAME, TESTPASSWORD);
		Assert.assertTrue(steps.isCreatedTest(TESTNAME));
	}

	//Test on passing of test with multiple data #3
	@Test
	public void passTestSuccess(){
		steps.loginTestmoz(USERNAME);
		Assert.assertTrue(steps.chooseRightAnswers());
	}
	
	@Test
	public void passTestUsually(){
		steps.loginTestmoz(USERNAME);
		Assert.assertTrue(steps.chooseMiddleAnswers());
	}
	
	@Test
	public void passTestError(){
		steps.loginTestmoz(USERNAME);
		Assert.assertTrue(steps.chooseNegativeAnswers());
	}
	
	@Test
	public void passTestNotSuccess(){
		steps.loginTestmoz(USERNAME);
		Assert.assertTrue(steps.chooseNotSuccessAnswers());
	}
	
	@Test
	public void chooseTowAnswers(){
		steps.loginTestmoz(USERNAME);
		Assert.assertTrue(steps.chooseTwoAnswers());
	}
	
	//Test on creating of question #4
	@Test
	public void testCreateQuestion(){
		
		steps.createTest(TESTNAME, TESTPASSWORD);
		steps.createQuestion(QUESTION, ANSWERS, RIGHTANSWER);
		Assert.assertTrue(steps.isCreatedQuestion(QUESTION));
		
	}
	
	//Test on checking of right answers #5
	@Test
	public void testCorrectAnswersPage(){
		
		steps.createTest(TESTNAME, TESTPASSWORD);
		steps.createQuestion(QUESTION, ANSWERS, RIGHTANSWER);
		steps.checkCorrectAnswers();
		Assert.assertTrue(steps.isOpenedRightAnswersPage());
		
	}
	
	@AfterClass
	public static void stopBrowser()
	{
		steps.closeDriver();
	}
	
}
