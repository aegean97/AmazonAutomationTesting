package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;




public class amazon {


    public static void main(String[] Args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Selenium\\ChromeDriver\\chromedriver.exe");


        File file = new File("MacbookData.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        WebDriver driver = new ChromeDriver();


        driver.get("https://www.amazon.com.tr"); //Go to the website.
        driver.manage().window().maximize(); //Makes full screen the browser.

        driver.findElement(By.id("sp-cc-accept")).click();

        WebElement ddown = driver.findElement(By.id("searchDropdownBox")); //Clicks on Browser.

        Thread.sleep(1000);

        Select select = new Select(ddown);

        select.selectByValue("search-alias=computers"); //Chooses the category.

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Macbook Pro"); //Writes the wanted product's name.

        Thread.sleep(1000);

        driver.findElement(By.id("nav-search-submit-button")).click(); //Clicks on the search button.

        Thread.sleep(1000);

        driver.findElement(By.className("s-image")).click(); // Choose the very first product.

        Thread.sleep(2000);


        String MacbookPrice = driver.findElement(By.id("attach-base-product-price")).getAttribute("value");
        String ModelName = driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");
        String CPUModel = driver.findElement(By.className("a-size-base")).getAttribute("value");


        pw.println("Macbook's Price: "+MacbookPrice+"TL");
        pw.println("Macbook's Model Name: "+ModelName);
        pw.println("Macbook's CPU: "+CPUModel);
        pw.close();
        System.out.println("Macbook's Price:"+"TL"+MacbookPrice+"\nMacbook's Model: "+ModelName+"\nCPU Model: "+CPUModel);
        }
}