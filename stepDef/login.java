package Cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user already at sauce demo login page")
    public void userAlreadyAtSauceDemoLoginPage() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        Assert.assertEquals(true, loginButton.isDisplayed());
    }

    @When("user input registered username")
    public void userInputRegisteredUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input registered password")
    public void userInputRegisteredPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user click login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("user login successfully")
    public void userLoginSuccessfully() {
        WebElement producttext = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertEquals(true, producttext.isDisplayed());
        driver.close();
    }

    @When("user input unregistered username")
    public void userInputUnregisteredUsername() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.id("user-name")).sendKeys("normal_user");
    }

    @And("user input unregistered password")
    public void userInputUnregisteredPassword() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys("secret_password");
    }

    @Then("user failed to login")
    public void userFailedToLogin() {
        WebElement errortext = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/button"));
        Assert.assertEquals(true, errortext.isDisplayed());
        driver.close();
    }

    @When("user input (.*) as username$")
    public void user_Input_Username_As_Username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("user input (.*) as password$")
    public void userInputPasswordAsPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("User login is (.*)$")
    public void userLoginIsStatus(String status) {
        if(status.equals("success")){
            WebElement producttext = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
            Assert.assertEquals(true, producttext.isDisplayed());
        } else {
            WebElement errortext = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
            Assert.assertEquals(true, errortext.isDisplayed());
        }
        driver.close();
    }
}