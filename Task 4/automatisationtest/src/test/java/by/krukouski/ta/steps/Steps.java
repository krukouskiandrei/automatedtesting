package by.krukouski.ta.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.krukouski.ta.driver.DriverSingleton;
import by.krukouski.ta.pages.CreateNewRepositoryPage;
import by.krukouski.ta.pages.LoginPage;
import by.krukouski.ta.pages.MainPage;

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
		loginPage.login(username);
	}
	
	public boolean isLoggedIn(String title){
		
		LoginPage loginPage = new LoginPage(driver);
		return (loginPage.getTitle().trim().toUpperCase().equals(title));
		
	}

	/*public boolean isLoggedIn(String username)
	{
		LoginPage loginPage = new LoginPage(driver);
		return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(username));
	}*/

	public boolean createNewRepository(String repositoryName, String repositoryDescription)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnCreateNewRepositoryButton();
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		String expectedRepoName = createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
		return expectedRepoName.equals(createNewRepositoryPage.getCurrentRepositoryName());
	}

	public boolean currentRepositoryIsEmpty()
	{
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.isCurrentRepositoryEmpty();
	}
	
}
