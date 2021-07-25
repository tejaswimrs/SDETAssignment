package Step_Definition;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Step_Definition {
	static WebDriver driver;
			
	@Given("I should be in login page")
	public void i_should_be_in_login_page() throws InterruptedException {
	    WebDriverManager.chromedriver().setup();
	    driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://elearningm1.upskills.in/");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Thread.sleep(1000);
	}


	@When("I click on signup link")
	public void i_click_on_signup_link() throws InterruptedException {
	    driver.findElement(By.xpath("//*[@id=\"login-block\"]/div/ul/li[1]/a")).click();
	    Thread.sleep(2000);
	}
	@When("I enter First name as {string}")
	public void i_enter_first_name_as(String fname) {
	    driver.findElement(By.xpath("//*[@id=\"registration_firstname\"]")).sendKeys(fname);
	    
	}
	@When("I enter Last name as {string}")
	public void i_enter_last_name_as(String lname) {
	    driver.findElement(By.xpath("//*[@id=\"registration_lastname\"]")).sendKeys(lname);
	}
	@When("I enter email id as {string}")
	public void i_enter_email_id_as(String email) {
	    driver.findElement(By.xpath("//*[@id=\"registration_email\"]")).sendKeys(email);
	}
	@When("I enter username as {string}")
	public void i_enter_username_as(String uname) {
	    driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(uname);
	}
	@When("I enter password as {string}")
	public void i_enter_password_as(String pass) {
	    driver.findElement(By.xpath("//*[@id=\"pass1\"]")).sendKeys(pass);
	}
	@When("I enter confirmpass as {string}")
	public void i_enter_confirmpass_as(String cpass) {
	    driver.findElement(By.xpath("//*[@id=\"pass2\"]")).sendKeys(cpass);
	}
	@When("I click on Register button")
	public void i_click_on_register_button() throws InterruptedException {
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"registration_submit\"]")).click();
	}
	@Then("I should see the confirmation message:")
	public void i_should_see_the_confirmation_message(String docString)  throws IOException, InterruptedException {
	    String actual = driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/p[1]")).getText();
	    Assert.assertEquals(docString, actual);
	    System.out.println("Name displayed is " + actual);
	    System.out.println("Expected is " + docString);
	}
	
	@Given("User is successfully registered")
	public void user_is_successfully_registered() throws InterruptedException {
		Thread.sleep(1000);
	}
	

	@When("I click on profile option")
	public void i_click_on_profile_option() throws InterruptedException {
	    driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[2]/a")).click();
	}

	@When("I click on inbox option")
	public void i_click_on_inbox_option() {
	    driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[2]/ul/li[3]/a")).click();
	}

	@When("I click on compose button")
	public void i_click_on_compose_button() throws InterruptedException {
	    driver.findElement(By.xpath("//*[@id=\"toolbar\"]/div/div[1]/a[1]")).click();
	    Thread.sleep(6000);
	}

	@When("I enter name as {string}")
	public void i_enter_name_as(String lname) throws InterruptedException {
		Actions action = new Actions(driver);
	    driver.findElement(By.xpath("//*[@id=\"compose_message\"]/fieldset/div[1]/div[1]/span/span[1]/span/ul/li/input")).sendKeys(lname);
	    Thread.sleep(2000);
	    action.sendKeys(Keys.ENTER).build().perform();
	    
	}

	@When("I enter subject as {string} in subject box")
	public void i_enter_subject_as_in_subject_box(String subject) throws InterruptedException {
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"compose_message_title\"]")).sendKeys(subject);
	}

	@When("I enter body of the message:")
	public void i_enter_body_of_the_message(String docString) throws InterruptedException {
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("/html/body")).sendKeys(docString);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
	}

	@When("I click on send button")
	public void i_click_on_send_button() {
	   driver.findElement(By.xpath("//*[@id=\"compose_message_compose\"]")).click();
	}

	@Then("I should see confirmation message as {string}")
	public void i_should_see_confirmation_message_as(String cmessage) throws InterruptedException {
	    String actual = driver.findElement(By.xpath("//*[@id=\"cm-content\"]/div/div[2]/div/div[1]")).getText();
	    Assert.assertEquals(cmessage, actual);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[2]/li[2]/a")).click();
	    driver.findElement(By.xpath("//*[@id=\"logout_button\"]")).click();
	    driver.quit();
	    
	}

}
