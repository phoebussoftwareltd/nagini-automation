package com.nagini.pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PageTest extends BaseTestClass {

  Page page = Page.getPage();

  @BeforeClass
  public void goToHome() {
    login.act()
      .loginUser(testData.getEmail(), testData.getPassword(), testData.getCode());
  }


  @Test
  public void testHeaderDetails() throws InterruptedException {
    page.act()
      .getHeaderElements()
      .clickOnMakePaymentWithinHeader();

    page.verify()
      .verifyHeaderDetails(testData.getBalance(), testData.getInterest(), testData.getInstalment())
      .verifyTitleIsDisplayed("paymentTitle");
  }

  @Test
  public void testAllSideBarLinks() throws InterruptedException {

    HashMap<String, String> sidebarLinks = new HashMap<String, String>();

    //add all sidebar menu options in hashmap
    sidebarLinks
      .put("//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[1]/a", "accountDetails");
    sidebarLinks
      .put("//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[2]/a",
        "propertyDetailsTitle");
    sidebarLinks
      .put("//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[3]/a", "paymentTitle");
    sidebarLinks
      .put("//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[4]/a",
        "singlePaymentTitle");
    sidebarLinks
      .put("//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[5]/a",
        "mp-monthlyPaymentAmountTitle");
    sidebarLinks
      .put("//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[6]/a", "statementsTitle");
    sidebarLinks
      .put("//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[8]/a", "redemptionTitle");
    sidebarLinks
      .put("//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[9]/a",
        "covidSupportTitle");

    //loop through all the links and verify correct page is loaded
    for (Map.Entry<String, String> entry : sidebarLinks.entrySet()) {
      String link = entry.getKey();
      String title = entry.getValue();
      page.act()
        .clickMenuOption(link, title);

      page.verify()
        .verifyTitleIsDisplayed(title);
    }
  }



}
