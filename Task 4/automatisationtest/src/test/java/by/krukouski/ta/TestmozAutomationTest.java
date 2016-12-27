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
	

	@BeforeClass
	public static void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test
	public void testBuildTest(){
		steps.createTest(TESTNAME, TESTPASSWORD);
		Assert.assertTrue(steps.isCreatedTest(TESTNAME));
	}

	@Test
	public void oneCanLoginGithub()
	{
		steps.loginTestmoz(USERNAME);
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
	
	@Test
	public void chooseTowAnswers(){
		steps.loginTestmoz(USERNAME);
		Assert.assertTrue(steps.chooseTwoAnswers());
	}
	
	@AfterClass
	public static void stopBrowser()
	{
		steps.closeDriver();
	}
	
}
