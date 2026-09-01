package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginCredentials
{
	private static Properties properties=new Properties();
	private static FileInputStream fis;
	
	public static void loadfile()
	{
            try 
            {
            	fis = new FileInputStream("src/test/resources/credentials.properties");
				properties.load(fis);
			} 
            catch (IOException e) 
            {
				e.printStackTrace();
            }
	}
	
	public static String logindata(String key)
	{
		return properties.getProperty(key);
	}
}
