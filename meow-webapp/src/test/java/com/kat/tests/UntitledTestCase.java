package com.kat.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class UntitledTestCase {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {

        System.getProperty("webdriver.gecko.driver", "src/test/geckodriver.exe");
        driver.get("http://localhost:8080/sendYourMeow__1__war/");
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("inputLogin")).clear();
        driver.findElement(By.id("inputLogin")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).clear();
        driver.findElement(By.id("inputPassword")).sendKeys("password");
        driver.findElement(By.id("inputPassword")).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("inputLogin")).clear();
        driver.findElement(By.id("inputLogin")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).clear();
        driver.findElement(By.id("inputPassword")).sendKeys("password");
        driver.findElement(By.id("inputPassword")).sendKeys(Keys.ENTER);
        driver.findElement(By.linkText("Add Meow")).click();
        driver.findElement(By.id("title")).click();
        driver.findElement(By.id("title")).clear();
        driver.findElement(By.id("title")).sendKeys("Fourth Meow");
        driver.findElement(By.id("exampleFormControlTextarea1")).clear();
        driver.findElement(By.id("exampleFormControlTextarea1")).sendKeys("May the Meow be with you.");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Example textarea'])[1]/following::button[1]")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

//    private boolean isAlertPresent() {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
//
//    private String closeAlertAndGetItsText() {
//        try {
//            Alert alert = driver.switchTo().alert();
//            String alertText = alert.getText();
//            if (acceptNextAlert) {
//                alert.accept();
//            } else {
//                alert.dismiss();
//            }
//            return alertText;
//        } finally {
//            acceptNextAlert = true;
//        }
//    }
}
