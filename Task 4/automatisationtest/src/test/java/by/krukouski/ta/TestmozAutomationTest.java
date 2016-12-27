package by.krukouski.ta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.krukouski.ta.steps.Steps;

public class TestmozAutomationTest {

	private static Steps steps;
	private final Logger logger = LogManager.getRootLogger();
	private final String USERNAME = "Andrei";
	private final String TITLE = "FIRST TEST";
	

	@BeforeClass
	public static void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	

	@Test
	public void oneCanLoginGithub()
	{
		steps.loginTestmoz(USERNAME);
		logger.info(steps.isLoggedIn(TITLE) + "!)!)!");
		Assert.assertTrue(steps.isLoggedIn(TITLE));
		
	}

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
	
	@AfterClass
	public static void stopBrowser()
	{
		steps.closeDriver();
	}
	
}
