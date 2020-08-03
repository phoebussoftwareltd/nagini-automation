package com.nagini.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;



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
      .setEmail("veloen4@googlemail.com")
      .setPassword("String1*")
      .setCode("code1234")
      .setFromTransactionDate("22-03-2018")
      .setToTransactionDate("22-12-2018")
      .setPaymentDate("20/02/2020")
      .setBalance("£21,756.90")
      .setInterest("8.29%")
      .setInstalment("£229.09")
      .setSecurityAnswer("Bromley")
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
