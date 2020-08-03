package com.nagini.controllers.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.Pages.DriverFactory.getChromeDriver;
import static com.nagini.Pages.DriverFactory.getWebDriverWait;

public class LoginActionsController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  private static String url = "http://nagini-test-ui.phoebus-internal.com/";


  public LoginActionsController loginUser(String email, String password, String code) {

    driver.get(url + "login");
    driver.findElement(By.id("email")).sendKeys(email);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.id("loginButton")).click();
    driver.findElement(By.id("code")).sendKeys(code);
    driver.findElement(By.id("verifyButton")).click();
    return this;
  }

  public LoginActionsController loginUserWithEmailPassword(String email, String password) {

    driver.get(url + "login");
    driver.findElement(By.id("email")).sendKeys(email);
    driver.findElement(By.id("password")).sendKeys(password);
    driver.findElement(By.id("loginButton")).click();
    return this;
  }

  public LoginActionsController clickResetPassword() {
    driver.get(url + "login");
    wait.until(
      ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginFirstStep\"]/mat-card/div[1]/form/a")));
    driver.findElement(By.xpath("//*[@id=\"loginFirstStep\"]/mat-card/div[1]/form/a")).click();
    return this;
  }

  public LoginActionsController enterEmail(String email) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pr-email")));
    driver.findElement(By.id("pr-email")).sendKeys(email);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pr-nextBtn")));
    driver.findElement(By.id("pr-nextBtn")).click();
    return this;
  }

  public LoginActionsController answerSecurityQuestion(String answer) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ps-secretQuestion")));
    driver.findElement(By.id("ps-secretQuestion")).sendKeys(answer);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ps-nextBtn")));
    driver.findElement(By.id("ps-nextBtn")).click();
    return this;
  }

  public LoginActionsController enterCode(String code) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("code")));
    driver.findElement(By.id("code")).sendKeys(code);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("verifyButton")));
    driver.findElement(By.id("verifyButton")).click();
    return this;
  }

  public LoginActionsController enterNewPassword(String password) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPasswordInput")));
    driver.findElement(By.id("newPasswordInput")).sendKeys(password);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newPasswordCompleteButton")));
    driver.findElement(By.id("newPasswordCompleteButton")).click();
    return this;
  }

  public LoginActionsController clickRegisterNow() {
    driver.get(url + "login");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginFirstStep\"]/mat-card/div[1]/div[1]/div/a")));
    driver.findElement(By.xpath("//*[@id=\"loginFirstStep\"]/mat-card/div[1]/div[1]/div/a")).click();
    return this;

  }
}
