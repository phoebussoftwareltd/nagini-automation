package com.nagini.pages;

import com.nagini.controllers.actions.Covid19ActionsController;
import com.nagini.controllers.actions.PageActionsController;
import com.nagini.controllers.verifiers.Covid19VerifiyController;
import com.nagini.controllers.verifiers.PageVerifiyController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;

public class Covid19 {

  private Covid19ActionsController act;
  private Covid19VerifiyController verify;
  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public Covid19ActionsController act() {
    return act;
  }

  public Covid19VerifiyController verify() {
    return verify;
  }

  private Covid19() {
  }

  public static Covid19 getCovid19() {
    return new Covid19(new Covid19ActionsController(),new Covid19VerifiyController());
  }


  public Covid19( Covid19ActionsController act, Covid19VerifiyController verify) {
    this.act = act;
    this.verify = verify;
  }
}
