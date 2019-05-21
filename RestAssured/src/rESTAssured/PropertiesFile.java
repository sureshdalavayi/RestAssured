package rESTAssured;

import java.util.ResourceBundle;

public class PropertiesFile {

	private static ResourceBundle rb = ResourceBundle.getBundle("resources/data");

	public static String getValue(String key) throws Exception {
		return rb.getString(key);
	}

}
