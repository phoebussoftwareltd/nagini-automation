package com.nagini.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;



public class LandingPageTest {

  WebDriver driver;
  WebDriverWait wait;
  TestData testData;
  LandingPage landingPage = LandingPage.getLandingPage();

  @BeforeClass
  public void startUpBrowser() {
    driver = getChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wait = getWebDriverWait();

    testData = new TestData.Builder()
      .setEmail("lucy.dabbs.20@gmail.com")
      .setPassword("C@ntona7a")
      .setNewPassword("C@ntona7a*")
      .setCode("code1234")
      .setFromTransactionDate("28-04-2018")
      .setToTransactionDate("30-05-2018")
      .setPaymentDate("28/01/2019")
      .setBalance("£29,921.58")
      .setInterest("8.29%")
      .setInstalment("£238.39")
      .setSecurityAnswer("St Marys")
      .build();
  }



  @Test
  public void verifyLoginPageIsDisplayed() {

    landingPage.act()
      .clickOnLoginButton();

    landingPage.verify()
      .LoginPageIsDisplayed();
  }

  @Test
  public void verifyRegisterProfileIsDisplayed() {

    landingPage.act()
      .clickOnRegisterButton();

    landingPage.verify()
      .RegisterProfileIsDisplayed();
  }

  @AfterSuite
  public void closeBrowser() {
    driver.close();
  }

}
