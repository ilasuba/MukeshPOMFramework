package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider
{
	Properties pro;

	public ConfigDataProvider()
	{

		File src = new File("Configuration\\config.properties");
		FileInputStream fis = null;

		try
		{
			fis = new FileInputStream(src);



			pro = new Properties();


			pro.load(fis);


		} catch (Exception e)
		{
			System.out.println("Exception is "+ e.getMessage());
		}

	}

	public String getFirefoxPath()
	{
	   String firefoxPath = pro.getProperty("firefox");
	   return firefoxPath;
	}

	public String getIEPath()
	{
	   String IEPath = pro.getProperty("IEPath");
	   return IEPath;
	}


	public String getChromePath()
	{
	   String chromePath = pro.getProperty("chromePath");
	   return chromePath;
	}


	public String getApplicationUrl()
	{
		String url = "http://www.target.com/";
	   //String url = pro.getProperty("url");
	   return url;
	}

}
