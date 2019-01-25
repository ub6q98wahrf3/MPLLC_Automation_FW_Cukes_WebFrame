package stepDefinitions;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import MobileProgrammingLLC.PageLibraries.GMail_Login_EmailFillingPage;
import MobileProgrammingLLC.PageLibraries.GMail_Login_LandingPage;
import MobileProgrammingLLC.Resources.Base;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition_GMail_Login {
	Base b = new Base();
	WebDriver driver;
	
	
	Properties config = new Properties();
	Properties data = new Properties();
	Properties locators = new Properties();
	
	
	GMail_Login_LandingPage lp;
	GMail_Login_EmailFillingPage efp;
	
	
	@Before("@GmailTest")
	public void initConfigs() {
		config = b.loadConfig();
		data = b.loadData();
		locators = b.loadLocators();
		driver = b.invokeBrowser(data.getProperty("browser"));
		b.navigateToSite(config.getProperty("url"));
		b.comparePageTitle(config.getProperty("pageTitle"));
		lp = new GMail_Login_LandingPage(driver);
		efp = new GMail_Login_EmailFillingPage(driver);
	}
	
    
	@When("^User clicks on the Sign In button on the homepage$")
	public void user_clicks_on_the_Sign_In_button_on_the_homepage() throws Throwable {
		b.flash(lp.getSignInLink());
		b.clickOn(lp.getSignInLink());
		b.waitFor(By.xpath(locators.getProperty("emailTF")));
	}
    
    @And("^User enters \"([^\"]*)\" on the username page$")
    public void user_enters_something_on_the_username_page(String username)  {
    	b.flash(efp.getEmailTF());
		b.enterContentInto(efp.getEmailTF(), username);
		b.flash(efp.getNextBtn());
		b.clickOn(efp.getNextBtn());
		b.waitFor(By.xpath(locators.getProperty("pwdTF")));
    }

    @And("^User enters \"([^\"]*)\" on the password page$")
    public void user_enters_something_on_the_password_page(String password)  {
		b.flash(efp.getPwdTF());
		b.enterContentInto(efp.getPwdTF(), password);
		b.flash(efp.getNextBtn());
		b.clickOn(efp.getNextBtn());
    	b.waitFor(By.xpath(locators.getProperty("errorMsgLocator")));
    }

    @Then("^The user should be redirected on the same page with an error message: \"([^\"]*)\"$")
    public void the_user_should_be_redirected_on_the_same_page_with_an_error_message(String errorMsg) throws Throwable {
		b.flash(efp.getErrorMsg());
		b.compareContent(efp.getErrorMsg(), errorMsg);
    }
    
    @After("@GmailTest")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
          final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
          scenario.embed(screenshot, "image/png");
        }
        b.quitDriver();
    }
}
