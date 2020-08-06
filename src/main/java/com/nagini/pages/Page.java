package com.nagini.pages;

import com.nagini.controllers.actions.PageActionsController;
import com.nagini.controllers.verifiers.PageVerifiyController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;

public class Page {

  private PageActionsController act;
  private PageVerifiyController verify;
  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public PageActionsController act() {
    return act;
  }

  public PageVerifiyController verify() {
    return verify;
  }

  private Page() {
  }

  public static Page getPage() {
    return new Page(new PageActionsController(),new PageVerifiyController());
  }


  public Page( PageActionsController act, PageVerifiyController verify) {
    this.act = act;
    this.verify = verify;
  }
}
