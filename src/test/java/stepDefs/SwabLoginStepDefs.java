package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwabLoginStepDefs {
	
	WebDriver driver = Hooks.driver;
	
	@Given("I have launched the application")
	public void i_have_launched_the_application() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.saucedemo.com/");
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String UserNameVal) {
	    // Write code here that turns the phrase above into concrete actions
	   
		WebElement userName = driver.findElement(By.id("user-name"));
		userName.sendKeys(UserNameVal);
		
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String PassVal) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(PassVal);
	}

	@When("I click on Login button")
	public void i_click_on_Login_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement loginBtn = driver.findElement(By.name("login-button"));
		loginBtn.click();
	}

	@Then("I should land on home page {string}")
	public void i_should_land_on_home_page(String ExpCurrentUrl) {
	    // Write code here that turns the phrase above into concrete actions
		String CurrentUrl =	driver.getCurrentUrl();
		Assert.assertEquals(CurrentUrl, ExpCurrentUrl);
	}

	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String ExpError) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));
		String ActError = error.getText();

		Assert.assertEquals(ActError, ExpError);
	}

}
