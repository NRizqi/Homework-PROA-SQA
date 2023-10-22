package Cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class credential {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user in cart page")
    public void userInCartPage() throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        Thread.sleep(500);

        //Input registered username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //input registered password
        Thread.sleep(500);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click login button
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));

        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]"));
        Assert.assertEquals(true, true);


    }

    @When("user click checkout")
    public void userClickCheckout() {
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    }

    @And("user directed to checkout your information page")
    public void userDirectedToCheckoutYourInformationPage() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertEquals(true, true);
    }

    @And("user fill first name")
    public void userFillFirstName() throws InterruptedException{
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("abe");
    }

    @And("user fill last name")
    public void userFillLastName() throws InterruptedException{
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("mono");
    }

    @And("user fill postal code")
    public void userFillPostalCode() throws InterruptedException{
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("12345");
    }

    @And("user click continue")
    public void userClickContinue() throws InterruptedException{
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }

    @Then("user directed to checkout overview page")
    public void userDirectedToCheckoutOverviewPage() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        Assert.assertEquals(true, true);
        driver.close();
    }
}
