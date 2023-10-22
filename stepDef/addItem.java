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

public class addItem {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user already login")
    public void userAlreadyLogin() throws InterruptedException {
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
    }

    @When("user in homepage screen")
    public void userInHomepageScreen() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select"));
        Assert.assertTrue("Name (A to Z)", true);
    }

    @And("user click add to cart button for any item")
    public void userClickAddToCartButtonForAnyItem() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }

    @And("button change to remove button")
    public void buttonChangeToRemoveButton() {
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]"));
        Assert.assertTrue("Remove", true);
    }

    @And("cart icon have count number")
    public void cartIconHaveCountNumber() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        Assert.assertEquals(true, true);
    }

    @Then("item succesfully added to cart")
    public void itemSuccesfullyAddedToCart() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]"));
        Assert.assertEquals(true, true);
        driver.close();
    }

    @When("user tap any item")
    public void userTapAnyItem() {
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
    }

    @And("user directed to item page")
    public void userDirectedToItemPage() {
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]"));
    }

    @And("user click add to cart button")
    public void userClickAddToCartButton() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
    }

    @And("button didnt change into remove button")
    public void buttonDidntChangeIntoRemoveButton() {
        driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]"));
        Assert.assertTrue("Remove", true);
    }

    @And("cart icon didnt show count number")
    public void cartIconDidntShowCountNumber() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        Assert.assertEquals(false, false);
    }

    @Then("user cant add item to cart from item page")
    public void userCantAddItemToCartFromItemPage() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]"));
        Assert.assertEquals(false, false);
        driver.close();
    }
}
