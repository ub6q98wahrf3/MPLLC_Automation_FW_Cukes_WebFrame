package MobileProgrammingLLC.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

import static org.junit.Assert.*;

public class Base {
	WebDriver driver;
	Logger log = LogManager.getLogger(Base.class.getName());
	String userDir = System.getProperty("user.dir");
	
	Properties dataProp = new Properties();
	FileInputStream dataFis = null;
	File dataSrc = new File(userDir + "/src/main/java/MobileProgrammingLLC/Resources/data.properties");
	
	Properties configProp = new Properties();
	FileInputStream configFis = null;
	File configSrc = new File(userDir + "/src/main/java/MobileProgrammingLLC/Resources/config.properties");
	
	Properties locProp = new Properties();
	FileInputStream locFis = null;
	File locSrc = new File(userDir + "/src/main/java/MobileProgrammingLLC/Resources/locators.properties");
	
	
	public  WebDriver invokeBrowser(String browserName) {
		log.debug("Attempting to load the driver...");
		try {
			if(browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", userDir + "/drivers/chromedriver");
				driver = new ChromeDriver();
				log.info("Driver successfully initialised.");
			}else if(browserName.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", userDir + "/drivers/geckodriver");
				driver = new FirefoxDriver();
				log.info("Driver successfully initialised.");
			}else {
				driver = new SafariDriver();
				log.info("Driver successfully initialised.");
			}
		}catch(Exception e) {
			log.error("Driver loading failed.");
		}
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		return driver;
	}
	
	public  Properties loadData() {
		try {
			dataFis = new FileInputStream(dataSrc.getAbsolutePath());
			dataProp.load(dataFis);
		} catch (FileNotFoundException e) {
			log.error("Data file not found");
		}catch (IOException e) {
			log.error("Reading Data file failed.");
		}
		return dataProp;
	}
	
	public  Properties loadLocators() {
		try {
			locFis = new FileInputStream(locSrc.getAbsolutePath());
			locProp.load(locFis);
		} catch (FileNotFoundException  e) {
			log.error("Locator file not found");
		} catch (IOException e1) {
			log.error("Reading Locator file failed.");
		}
		return locProp;
	}
	
	public  Properties loadConfig() {
		try {
			configFis = new FileInputStream(configSrc.getAbsolutePath());
			configProp.load(configFis);
		} catch (FileNotFoundException e) {
			log.error("ERROR: Config file not found");
		} catch (IOException e) {
			log.error("ERROR: Reading Config file failed.");
		}
		return configProp;
	}
	
	public void navigateToSite(String URL) {
		try {
			log.debug("Attempting to get navigated to URL: \"" + URL + "\"...");
			driver.get(URL);
		}catch(Exception e) {
			log.error("Navigation to site \""+ URL + "\" failed.");
		}
		log.info("Navigation to site \"" + URL + "\" successful.");
	}
	
	public void comparePageTitle(String expected) {
		String actual = null;
		try {
			log.debug("Trying to compare the actual page title from the expected one...");
			actual = driver.getTitle();
			assertEquals(expected, actual);
		}catch(Exception e) {
			log.error("Page title comparison failed: Expected :: '" + expected + "', Actual :: '" + actual + "'");
		}
		log.info("Page Title Comparison Successful.");
	}
	
	public  void waitFor(By ele) {
		try {
			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.presenceOfElementLocated(ele));
		}catch(Exception e) {
			log.error("Element having locator '"+ele+"'"+" could not be located.");
		}
	}
	
	public  void waitForSometime() {
		try {
			log.warn("Sleep feature used. Liberal usage not advised.");
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			log.error("Waiting Interrupted.");
		}
	}

	public  void waitForLongtime() {
		try {
			log.warn("Long Sleep feature used (only for exceptional scenarios). Liberal usage strictly discouraged.");
			Thread.sleep(30000L);
		} catch (InterruptedException e) {
			log.error("Waiting Interrupted.");
		}
	}
	
	public  void flash(WebElement ele) {
		String bgColor = ele.getCssValue("backgroundColor");
		for(int i=0; i<2; i++) {
			changeColor(ele, "rgb(173,255,47)");
			changeColor(ele, bgColor);
		}
	}
	
	public  void changeColor(WebElement ele, String bgColor) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = '" + bgColor + "'", ele);
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {
			log.error("Flashing Element Interrupted.");
		}
	}
	
	public void clickOn(WebElement ele) {
		try {
			log.debug("Attempting to click on element: '"+ele+"'...");
			ele.click();
		}catch(Exception e) {
			log.error("Clicking element '"+ele+"' failed.");
		}
		log.info("Element '"+ele+"' successfully clicked.");
	}
	
	public void enterContentInto(WebElement ele, String content) {
		try {
			log.debug("Attempting to send \""+ content + "\" to element \"" + ele + "\"...");
			ele.sendKeys(content);
		}catch(Exception e) {
			log.error("Entering content into element '"+ele+"' failed.");
		}
		log.info("Content \"" + content + "\" entered successfully into element \"" + ele + "\"");
	}
	
	public void compareContent(WebElement ele, String expected) {
		try {
			log.debug("Attempting to compare content returned by \"" + ele + "\" from \"" + expected + "\" ...");
			assertEquals(ele.getText(), expected);
		}catch(Exception e) {
			log.error("Comparison Failed! Expected was '"+expected+"' but actual is '"+ele.getText()+"'");
		}
		log.info("Comparison Successful!");
	}
	
	public void compareContent(WebElement e1, WebElement e2) {
		try {
			log.debug("Attempting to compare content returned by \"" + e1 + "\" from \"" + e2 + "\" ...");
			assertEquals(e1.getText(), e2.getText());
		}catch(Exception e) {
			log.error("Comparison Failed! Expected was '"+e2.getText()+"' but actual is '"+e1.getText()+"'");
		}
		log.info("Comparison Successful!");
	}
	
	public void compareContent(String s1, String s2) {
		try {
			log.debug("Attempting to compare content \"" + s1 + "\" from \"" + s2 + "\" ...");
			assertEquals(s1, s2);
		}catch(Exception e) {
			log.error("Comparison Failed! Expected was '"+s2+"' but actual is '"+s1+"'");
		}
		log.info("Comparison Successful!");
	}
	
	public void deleteAllCookies() {
		try {
			log.debug("Attempting to delete all cookies...");
			driver.manage().deleteAllCookies();
		}catch(Exception e) {
			log.error("Deleting all cookies failed.");
		}
		log.info("All cookies successfully deleted.");
	}
	
	public void isDisplayedOnPage(WebElement ele) {
		log.debug("Attempting to locate " + ele + " on the page...");
		try {
			if(ele.isDisplayed()) {
				log.info(ele + " is displayed on the page successfully.");
			}
		}catch(Exception e){
			log.error("Presence of " + ele + " on the page failed.");
		}
	}
	
	public void quitDriver() {
		try {
			log.debug("Attempting to quit the driver...");
			driver.quit();
			driver = null;
		}catch(Exception e) {
			log.error("Quitting driver failed!");
		}
		log.info("Driver successfully quitted.");
	}
	
    public void getScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
          // Take a screenshot...
          final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
          scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
        }
    }
}
