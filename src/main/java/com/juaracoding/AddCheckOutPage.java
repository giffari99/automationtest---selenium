package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static com.juaracoding.LoginPage.loginValidUser;

public class AddCheckOutPage {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\my tools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.printf("Open Browser");
        driver.get("https://www.saucedemo.com/");


        loginUser(driver,"standard_user","secret_sauce");
        String txtProducts = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        System.out.println(txtProducts);

        if(txtProducts.contains("Products")){
            System.out.println("Login Berhasil");
        } else{
            System.out.println("Login Gagal");
        }

        Utils.delay(2);
        driver.quit();
        System.out.println("Quit Browser");

    }

    public static void loginUser(WebDriver driver, String username, String password){

        driver.findElement(By.id("user-name")).sendKeys(username);
        Utils.delay(1);
        driver.findElement(By.id("password")).sendKeys(password);
        Utils.delay(1);
        driver.findElement(By.id("login-button")).click();
        Utils.delay(2);

        // add 2 product
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Utils.delay(2);
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        Utils.delay(1);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Utils.delay(1);
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        Utils.delay(1);
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Juara");
        Utils.delay(1);
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Coding");
        Utils.delay(1);
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("12630");
        Utils.delay(1);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        Utils.delay(1);
        driver.findElement(By.xpath("//button[@id='finish']")).click();


    }




}
