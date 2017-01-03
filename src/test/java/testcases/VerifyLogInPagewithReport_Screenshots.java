package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.LogInPage;
import utility.Helper;

public class VerifyLogInPagewithReport_Screenshots {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

@BeforeMethod
public void setUp(){

	report = new ExtentReports("./Reports/LogInPageReport.html",true);
	logger = report.startTest("Verify Test LogIn");

	driver = BrowserFactory.getBrowser("IE");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(DataProviderFactory.getConfig().getApplicationUrl());

	logger.log(LogStatus.INFO, "Application Up and Running");
}

@Test
public void testHomePage() throws InterruptedException{


	HomePage home = PageFactory.initElements(driver, HomePage.class);

	String title = home.getApplicationTitle();

	Assert.assertTrue(title.contains("Expect More."));

	logger.log(LogStatus.INFO, "Home Page is loaded and verified");

	home.clickOnSignInLink();

	logger.log(LogStatus.INFO, "Click on SignInLink");
    LogInPage logIn = PageFactory.initElements(driver, LogInPage.class);

	logIn.logInApplication(DataProviderFactory.getExcel().getData(0, 0, 0), DataProviderFactory.getExcel().getData(0, 0, 1));

    logIn.clickOnSignInButton();

    logger.log(LogStatus.INFO, "Log In to your account");
	logIn.verifySignOutLink();

	logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(driver, "Validation2")));
	logger.log(LogStatus.PASS,"sign Out Link is present");

}

@AfterMethod
public void tearDown(ITestResult result){

	if(result.getStatus()==ITestResult.FAILURE){
		String path = Helper.captureScreenshot(driver, result.getName());
		logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
	}

	BrowserFactory.closeBrowser(driver);
	report.endTest(logger);
	report.flush();
}

}
