package com.nagini.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;
import static org.testng.Assert.assertTrue;

public class PropertyDetailsPage{

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

}
