package stepDefinitions;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import MobileProgrammingLLC.PageLibraries.Rediff_Login_MainPage;
import MobileProgrammingLLC.Resources.Base;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition_RediffMail_Login {
	Base b = new Base();
	WebDriver driver;
	
	
	Properties config = new Properties();
	Properties data = new Properties();
	Properties locators = new Properties();
	
	
	Rediff_Login_MainPage rlp;
	
	
	@Before("@RediffTest")
	public void initConfigs() {
		config = b.loadConfig();
		data = b.loadData();
		locators = b.loadLocators();
		driver = b.invokeBrowser(data.getProperty("browser"));
		b.navigateToSite(config.getProperty("rediff_url"));
		rlp = new Rediff_Login_MainPage(driver);
	}
	
    
	@Given("^The user is on the rediff homepage$")
    public void the_user_is_on_the_rediff_homepage()  {
		b.comparePageTitle(config.getProperty("rediff_PageTitle"));
    }

    @When("^The user enters (.+) and password (.+)$")
    public void the_user_enters_and_password(String Username, String Password) {
    	b.flash(rlp.getRUserNameTF());
		b.enterContentInto(rlp.getRUserNameTF(), Username);
		b.flash(rlp.getRPasswordTF());
		b.enterContentInto(rlp.getRPasswordTF(), Password);
    }
    
    @And("^Unchecks the Keep Me Sign In checkbox$")
    public void unchecks_the_keep_me_sign_in_checkbox() {
    	b.flash(rlp.getRRememberChkBox());
		b.clickOn(rlp.getRRememberChkBox());
    }
    
    @And("^Clicks on Login Button$")
    public void Clicks_on_Login_Button() {
    	b.flash(rlp.getRSubmitBtn());
		b.clickOn(rlp.getRSubmitBtn());
    }

    @Then("^The user should get redirected to the same page$")
    public void the_user_should_get_redirected_to_the_same_page() {
    	b.comparePageTitle(config.getProperty("rediff_PageTitle"));
    }

    
    @After("@RediffTest")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
          final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
          scenario.embed(screenshot, "image/png");
        }
        b.quitDriver();
    }
}
