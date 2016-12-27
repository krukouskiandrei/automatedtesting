package by.krukouski.ta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.krukouski.ta.steps.Steps;

public class TestmozAutomationTest {

	private Steps steps;
	private final Logger logger = LogManager.getRootLogger();
	private final String USERNAME = "Andrei";
	private final String TITLE = "FIRST TEST";
	

	@Before
	public void setUp()
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

	@After
	public void stopBrowser()
	{
		steps.closeDriver();
	}
	
}
