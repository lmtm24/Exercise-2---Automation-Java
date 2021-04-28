package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class TestCases extends SetUp {

    By title = By.cssSelector("#reg_pages_msg");
    By createNewAccountButton = By.cssSelector("div:nth-of-type(5) > a[role='button']");
    By firstNameField = By.name("firstname");
    By lastNameField = By.name("lastname");
    By email = By.name("reg_email__");
    By reEmail = By.name("reg_email_confirmation__");
    By pass = By.xpath("//input[@name='reg_passwd__']");
    By month = By.xpath("//select[@id='month']");
    By day = By.xpath("//select[@id='day']");
    By year = By.xpath("//select[@id='year']");
    By gender = By.cssSelector("span:nth-of-type(1) > ._58mt");
    By close = By.xpath("//html[@id='facebook']/body/div[3]//div[@class='_8ien']/img");
    By text = By.cssSelector("._8eso");
    By forgotPassword = By.linkText("Forgot Password?");
    By FindYourAccountText = By.cssSelector(".uiHeaderTitle");
    By identifyEmail = By.id("identify_email");
    By searchButton = By.id("did_submit");
    By noResultText = By.xpath("//html[@id='facebook']//form[@id='identify_yourself_flow']//div[.='No Search Results']");
    WebElement element;
	WebDriver driver;
    SetUp setUp;

  @Test
  public void VerifyServicesLinks() {

      String actualURL= "https://www.facebook.com/";
      String actualTitle = "Facebook - Log In or Sign Up";
      String emailAddress = "lltoscano@gmail.com";
      String actualConnectText = "Connect with friends and the world around you on Facebook.";
      String actualFindText = "Find Your Account";
      String actualNoSearchText = "No Search Results";
      Assert.assertEquals(driver.getCurrentUrl(), actualURL);
      Assert.assertEquals(driver.getTitle(), actualTitle);
      driver.findElement(createNewAccountButton).click();
      driver.findElement(firstNameField).sendKeys("Luis");
      driver.findElement(lastNameField).sendKeys("Toscano");
      driver.findElement(email).sendKeys(emailAddress);
      driver.findElement(reEmail).sendKeys(emailAddress);
      driver.findElement(pass).sendKeys("password");
      Select selectMonth = new Select(driver.findElement(month));
      selectMonth.selectByVisibleText("Nov");
      Select selectDay = new Select(driver.findElement(day));
      selectDay.selectByValue("24");
      Select selectYear = new Select(driver.findElement(year));
      selectYear.selectByVisibleText("1980");
      driver.findElement(gender).click();
      driver.findElement(close).click();
      Assert.assertEquals(driver.findElement(text).getText(),actualConnectText);
      driver.findElement(forgotPassword).click();
      Assert.assertEquals(driver.findElement(FindYourAccountText).getText(),actualFindText);
      driver.findElement(identifyEmail).sendKeys(emailAddress);
      driver.findElement(searchButton).click();
      Assert.assertEquals(driver.findElement(noResultText).getText(),actualNoSearchText);




  }
  @BeforeTest
  public void beforeTest() {

	  setUp = new SetUp();
	  //setUp.CreateBrowser();
      driver= setUp.CreateBrowser();
  }
  @AfterTest
    public void teatDown(){
    driver.quit();
  }

}
