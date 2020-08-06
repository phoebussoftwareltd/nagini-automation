package com.nagini.controllers.verifiers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class StatementsVerifyController {

  WebDriver driver = getChromeDriver();
  WebDriverWait wait = getWebDriverWait();

  public StatementsVerifyController correctStatementIsDisplayed() throws IOException {
    URL url = new URL( "https://dev-ui.psl-nagini.com/assets/CertificateOfInterest-pdf.pdf" );


    BufferedInputStream bis = new BufferedInputStream( url.openStream() );
    PDDocument doc = PDDocument.load( bis );
    String text = new PDFTextStripper().getText( doc );
    doc.close();
    bis.close();
    assertTrue( text.contains( "The Phoebus Mortgage Self Service system has been designed to integrate" ) );
    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs2.get(1));
    driver.close();
    driver.switchTo().window(tabs2.get(0));
    return this;
  }

  public StatementsVerifyController correctYearIsDisplyed() throws InterruptedException {
    Thread.sleep( 1000 );
    wait.until(
      ExpectedConditions
        .visibilityOfElementLocated( By.id( "title" ) ) );
    String title = driver.findElement( By.id( "title" ) ).getText();
    assertEquals( title, "2019" );
    return this;
  }
}

