package testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
public WebDriver driver;
public HomePage homepage;

 public WebDriver initializeDriver() throws IOException{
	 
    //properties class
	Properties prop= new Properties();
	//read from file
	FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//GlobalData.properties");
    prop.load(fis);
	String browserName=prop.getProperty("browser");
	if (browserName.equalsIgnoreCase("chrome")){
	driver= new ChromeDriver();
    WebDriverManager.chromedriver().setup();
 }
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 driver.manage().window().maximize();
 return driver;
 }
 
@BeforeMethod
 public HomePage launchApplication() throws IOException{
	driver =initializeDriver();
	homepage= new HomePage(driver);
	homepage.goTo();
	return homepage;
 }
@AfterMethod
public void tearDown(){
	driver.quit();
}

public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver ;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File file =new File(System.getProperty("user.dir")+"//reports//"+testCaseName+ ".png");
	FileUtils.copyFile(source, file);
	return System.getProperty("user.dir")+"//reports//"+testCaseName+ ".png";
}

}

