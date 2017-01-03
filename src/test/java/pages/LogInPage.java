package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogInPage {

	WebDriver driver;

	public LogInPage(WebDriver ldriver){

		this.driver = ldriver;
	}

	@FindBy(id="logonIdMain") WebElement userEmail;
	@FindBy(name="password") WebElement password;

	By signInBtn = By.name("AccountSignIn");
	//By signInBtn = By.xpath("//div[@id='signIn']//form//div[@class='card--buttons']//button");
	//@FindBy(css="#signin-btn") WebElement signInBtn;
	@FindBy(id="js-toggleRightNavLg") WebElement myAccountLink;

	By signOutLink = By.xpath("//ul[@class='navigation--menu']//li//a[@id='guest-sign-out']");
    //@FindBy(xpath="//ul[@class='navigation--menu']//li//a[@id='guest-sign-out']") WebElement signOutLink;

	public void logInApplication(String user, String pass) throws InterruptedException
	{
		userEmail.clear();
		userEmail.sendKeys(user);
		password.clear();
		password.sendKeys(pass);


		}

	public void clickOnSignInButton(){

		WebDriverWait wait = new WebDriverWait(driver,40);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(signInBtn));
	    ele.click();
	}
	public void verifySignOutLink()
	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		myAccountLink.click();
		//Thread.sleep(3000);

		WebDriverWait wait = new WebDriverWait(driver,40);
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(signOutLink));
		String text = ele.getText();
		Assert.assertEquals(text, "sign-out","Sign out link not verified properly");
		//signOutLink.click();
	}

}
