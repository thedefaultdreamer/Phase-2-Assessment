package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartStepDefs {
	
	WebDriver driver = Hooks.driver;

	@When("I click on the Product name as {string}")
	public void i_click_on_the_Product_name_as(String string) throws InterruptedException {
		WebElement productName = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		productName.click();
		Thread.sleep(2000);
	}

	@When("I click on the Add to cart Button")
	public void i_click_on_the_Add_to_cart_Button() throws InterruptedException {
	    ////button[text()='Add to cart']
		WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='Add to cart']"));
		addToCartButton.click();
		Thread.sleep(2000);
	}

	@When("I click on Shopping cart link")
	public void i_click_on_shopping_cart_link() throws InterruptedException {
	    // //a[@class='shopping_cart_link']
		WebElement shoppingCartLink  = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		shoppingCartLink.click();
		Thread.sleep(2000);
	}

	@Then("I verify the item on cart page")
	public void i_verify_the_item_on_cart_page() throws InterruptedException {
	    // //div[@class='inventory_item_name']
		
		WebElement productTitleOnCartPage = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
		String actualProductName = productTitleOnCartPage.getText();
		Thread.sleep(2000);
		String expectedProductName = "Sauce Labs Backpack";
		Assert.assertEquals(actualProductName, expectedProductName);
	}

}
