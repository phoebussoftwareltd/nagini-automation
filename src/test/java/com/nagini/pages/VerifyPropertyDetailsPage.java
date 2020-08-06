package com.nagini.pages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyPropertyDetailsPage extends BaseTestClass {

  PropertyDetailsPage propertyDetailsPage = new PropertyDetailsPage();

  @BeforeMethod
  public void goToHome() {
    login.act()
      .loginUser(testData.getEmail(), testData.getPassword(), testData.getCode());
  }

  @Test
  public void testPropertyDetailsPage() throws InterruptedException {
   // propertyDetailsPage.verifyPageIsDisplayedById(propertyDetailsPage,
   //   "//*[@id=\"clientAccents\"]/app-portal/app-home/div/div/div[1]/app-home-menu/ul/li[2]/a", "propertyDetailsTitle");

  }



}
