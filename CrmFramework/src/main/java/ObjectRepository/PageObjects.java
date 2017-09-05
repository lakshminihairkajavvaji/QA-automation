package ObjectRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PageObjects {
	public Properties getpageObjects() throws IOException {
		
		 FileInputStream fis = new FileInputStream("src//test//resources//objects.properties");
		 Properties prop = new Properties();
		 prop.load(fis);
		 return prop;
		}

}
