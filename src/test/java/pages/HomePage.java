package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver lDriver)
	{
		this.driver = lDriver;
	}

	@FindBy(xpath="//span[text()='sign in']") WebElement SignInLink;
	@FindBy(xpath="//ul[@class='navigation--menu']//li[1]//a[@id='rightNav-signIn']") WebElement clickDropDownsignIn;
	@FindBy(xpath="//a[@id='js-toggleRightNavLg']") WebElement MyAccountLink;
	@FindBy(xpath="//a[@id='js-toggleMiniCartLg']/span") WebElement MyCartLink;
	@FindBy(xpath="//a[@id='js-toggleSecondaryNav']")WebElement DealLink;

	public void clickOnSignInLink() throws InterruptedException
	{
		SignInLink.click();
		Thread.sleep(3000);
		clickDropDownsignIn.click();

	}

	public void clickMyAccountLink()
	{
		MyAccountLink.click();
	}
	public void clickMyCartLink()
	{
		MyCartLink.click();
	}
	public void DealLink()
	{
		DealLink.click();
	}

	public String getApplicationTitle()
	{
		return driver.getTitle();

	}
}
