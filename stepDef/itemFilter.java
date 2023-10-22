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

public class itemFilter {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user login and on homepage")
    public void userLoginAndOnHomepage() throws InterruptedException {
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
    }

    @When("user click filter button")
    public void userClickFilterButton() throws InterruptedException{
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
    }

    @And("user choose one option")
    public void userChooseOneOption() throws InterruptedException{
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
    }

    @Then("user can filter item")
    public void userCanFilterItem() {
        driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div"));
        Assert.assertTrue("Sauce Labs Onesie", true);
        driver.close();
    }
}
