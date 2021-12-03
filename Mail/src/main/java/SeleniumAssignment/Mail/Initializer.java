package SeleniumAssignment.Mail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Initializer {
	
	WebDriver driver;
	Properties prop;
	
	
	public WebDriver setUp() throws IOException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\yashwanth.n\\Desktop\\chromedriver.exe");
		prop = new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\yashwanth.n\\eclipse-workspace\\Mail\\src\\main\\java\\SeleniumAssignment\\Mail\\data.properties");
		prop.load(fis);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
}
