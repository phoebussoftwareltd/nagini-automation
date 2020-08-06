package com.nagini.controllers.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;

public class EditProfileActionsController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();


  public EditProfileActionsController clickEditProfile() throws InterruptedException {
    Thread.sleep(1000);
    Dimension dimension = new Dimension(950, 900);
    driver.manage().window().setSize(dimension);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#up-editProfile .btn")));
    driver.findElement(By.cssSelector("#up-editProfile .btn")).click();

    return this;
  }

  public EditProfileActionsController changePassword() throws InterruptedException {
    wait.until(ExpectedConditions
      .visibilityOfElementLocated(
        By.xpath("/html/body/modal-container/div/div/app-user-details/div/app-user-details-menu/ul/li[2]/a")));
    driver
      .findElement(By.xpath("/html/body/modal-container/div/div/app-user-details/div/app-user-details-menu/ul/li[2]/a"))
      .click();
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cp-new")));
    driver.findElement(By.id("cp-new")).sendKeys("String1*");
    driver.findElement(By.id("cp-retype")).sendKeys("String1*");
    driver.findElement(By.id("cp-savePassword")).click();
    return this;
  }

  public EditProfileActionsController answerSecurityQuestion() {
    wait.until(ExpectedConditions
      .visibilityOfElementLocated(By.id("ps-secretQuestion")));
    driver.findElement(By.id("ps-secretQuestion")).sendKeys("Bromley");
    driver.findElement(By.id("ps-nextBtn")).click();
    return this;
  }

  public EditProfileActionsController authenticateByCode() {
    wait.until(ExpectedConditions
      .visibilityOfElementLocated(By.id("code")));
    driver.findElement(By.id("code")).sendKeys("code1234");
    wait.until(ExpectedConditions
      .visibilityOfElementLocated(By.id("verifyButton")));
    driver.findElement(By.id("verifyButton")).click();
    return this;
  }

  public EditProfileActionsController closeEditProfile() {
    wait.until(ExpectedConditions
      .visibilityOfElementLocated(By.xpath("/html/body/modal-container/div/div/app-user-details/div/a/i")));
    driver.findElement(By.xpath("/html/body/modal-container/div/div/app-user-details/div/a/i")).click();
    return this;
  }

  public EditProfileActionsController logout() throws InterruptedException {
    driver.manage().window().maximize();
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout")));
    driver.findElement(By.id("logout")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("l-logoutBtn")));
    driver.findElement(By.id("l-logoutBtn")).click();

    return this;
  }

}
