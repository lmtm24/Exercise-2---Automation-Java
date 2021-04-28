package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SetUp {
public WebDriver CreateBrowser() {
	//System.setProperty("webdriver.chrome.driver","C:\\Users\\luis.osuna\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.get("https://www.facebook.com/");
	
	return driver;
	}
}
