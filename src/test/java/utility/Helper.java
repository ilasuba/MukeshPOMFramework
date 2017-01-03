package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static String captureScreenshot(WebDriver driver , String screenShotName)
	{

		TakesScreenshot ts = (TakesScreenshot)driver;
		ts.getScreenshotAs(OutputType.FILE);

		File src = ts.getScreenshotAs(OutputType.FILE);

		String destination = "C:\\Users\\Ila Suba\\Desktop\\Abhishk_Homework\\Eclipse_Neon_NEW1\\MukeshPOMFrameWork\\ScreenShots\\"+screenShotName+System.currentTimeMillis()+".png";

		try
		{
			FileUtils.copyFile(src, new File(destination));
		} catch (IOException e)
		{
			System.out.println("Failed to captured Screenshot" + e.getMessage());
		}


		return destination;

	}

}
