package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static String getProperty(String key) throws IOException {

		Properties pro = new Properties();
		pro.load(new FileInputStream(new File(System.getProperty("user.dir") + "/config/config.properties")));
		String value=pro.getProperty(key);
		return value;

	}

}
