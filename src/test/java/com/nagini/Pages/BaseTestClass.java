package com.nagini.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;

public class BaseTestClass {
  WebDriver driver;
  WebDriverWait wait;
  TestData testData;
  Login login = Login.getLogin();


  @BeforeSuite
  public void startUpBrowser() {
    driver = getChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wait = getWebDriverWait();

//    testData = new TestData.Builder()
//      .setEmail("veloen4@googlemail.com")
//      .setPassword("String1*")
//      .setNewPassword("String1*")
//      .setCode("code1234")
//      .setFromTransactionDate("22-03-2018")
//      .setToTransactionDate("22-12-2018")
//      .setPaymentDate("20/02/2020")
//      .setBalance("£21,756.90")
//      .setInterest("8.29%")
//      .setInstalment("£229.09")
//      .setSecurityAnswer("Bromley")
//      .build();
//  }

    testData = new TestData.Builder()
      .setEmail("lucy.dabbs.20@gmail.com")
      .setPassword("C@ntona7a")
      .setNewPassword("C@ntona7a*")
      .setCode("code1234")
      .setFromTransactionDate("28-04-2018")
      .setToTransactionDate("30-05-2018")
      .setPaymentDate("28/01/2019")
      .setBalance("£29,921.58")
      .setInterest("8.05%")
      .setInstalment("£238.39")
      .setSecurityAnswer("St Marys")
      .build();
  }


  @AfterSuite
  public void closeBrowser() {
    driver.close();
  }

}
