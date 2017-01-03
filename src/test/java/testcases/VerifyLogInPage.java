package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LogInPage;

public class VerifyLogInPage {

	WebDriver driver;

@BeforeMethod
public void setUp(){

	driver = BrowserFactory.getBrowser("IE");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(DataProviderFactory.getConfig().getApplicationUrl());
}

@Test
public void testHomePage() throws InterruptedException{


	HomePage home = PageFactory.initElements(driver, HomePage.class);
	String title = home.getApplicationTitle();
	Assert.assertTrue(title.contains("Expect More."));

	home.clickOnSignInLink();

    LogInPage logIn = PageFactory.initElements(driver, LogInPage.class);

	logIn.logInApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));

	logIn.clickOnSignInButton();
	logIn.verifySignOutLink();

}

@AfterMethod
public void tearDown(){

	BrowserFactory.closeBrowser(driver);
}

}
