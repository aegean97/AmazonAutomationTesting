package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.*;

public class amazon_Steps {


    private WebDriver driver;

    @Given("Reach the Amazon and verify it")
    public void reach_the_amazon_and_verify_it() throws IOException {

        File file = new File("MacbookData.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Selenium\\ChromeDriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr"); //Websitesine ulaşır.
        driver.manage().window().maximize(); //Tarayıcıyı tam ekran yapar.

        driver.findElement(By.id("sp-cc-accept")).click();
    }

    @Given("Choose the category")
    public void choose_as_a_category() throws InterruptedException {

        WebElement ddown = driver.findElement(By.id("searchDropdownBox")); //Kategorilere tıklar.

        Thread.sleep(1000);

        Select select = new Select(ddown);

        select.selectByValue("search-alias=computers"); //Kategoriyi seçer.

        System.out.println("Category is chosen");
    }

    @Given("Write the wanted product")
    public void write_on_the_search() throws InterruptedException {


        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Macbook Pro"); //"Macbook Pro" yazar.

        Thread.sleep(1000);
        System.out.println("Name of the product is written");
    }

    @Given("Do searching")
    public void do_searching() throws InterruptedException {

        driver.findElement(By.id("nav-search-submit-button")).click(); //Arama butonuna tıklar.

        Thread.sleep(1000);
        System.out.println("Search button is clicked");

    }

    @Given("Click on the very first product")
    public void click_on_the_very_first_product() throws InterruptedException {

        driver.findElement(By.className("s-image")).click(); // Macbook'u seçer.

        Thread.sleep(2000);
        System.out.println("The first product is chosen");

    }

    @When("Collect the data from product and save the data")
    public void collectTheDataFromProductAndSaveTheData() throws IOException {

        String MacbookPrice = driver.findElement(By.id("attach-base-product-price")).getAttribute("value");
        String ModelName = driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");
        String CPUModel = driver.findElement(By.className("a-size-base")).getAttribute("value");

        File file = new File("MacbookData.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("Macbook fiyatı: " + MacbookPrice + "TL");
        pw.println("Macbook Model Name: " + ModelName);
        pw.println("Macbook CPU Model: " + CPUModel);
        System.out.println("The data is saved on a txt file");

        System.out.println("Macbook's price: "+MacbookPrice);
        System.out.println("Macbook's model: "+ModelName);
        System.out.println("Macbook's CPU : "+CPUModel);
    }

    @Then("Verify the success message")
    public void verify_the_success_message() {
        System.out.println("Test is completed successfully");
    }
    }

