package com.nagini.Pages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class StatementsTest extends BaseTestClass {

  Statements statements = Statements.getStatements();

  @BeforeMethod
  public void goToHome() {
    login.act()
      .loginUser( testData.getEmail(), testData.getPassword(), testData.getCode() );
  }

  @Test
  public void testStatementIsDisplayed() throws InterruptedException, IOException {
    statements.act()
      .clickOnStatementsLink()
      .selectStatementYear()
      .selectDownloadStatement();

    statements.verify()
      .correctYearIsDisplyed()
      .correctStatementIsDisplayed();

  }

}


