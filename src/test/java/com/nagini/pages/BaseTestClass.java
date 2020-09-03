package com.nagini.pages;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import static com.mongodb.client.model.Filters.eq;
import static com.nagini.pages.DriverFactory.getChromeDriver;
import static com.nagini.pages.DriverFactory.getWebDriverWait;

public class BaseTestClass {
  WebDriver driver;
  WebDriverWait wait;
  TestData testData;
  Login login = Login.getLogin();


  @BeforeSuite
  public void startUpBrowser() {
    driver = getChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS );
    wait = getWebDriverWait();

    String capitalBalance = "";
    String interest = "";
    String contractualMonthlyInstalmentAmount = "";

    // Connect to MongoDB and get the account collection
    MongoCollection<Document> collection = retrieveAccountCollection();

    capitalBalance = getCapitalBalance( collection, new ObjectId( "5ecd18bd4af32b0001d9fc30" ) );
    interest = getInterest( collection, new ObjectId( "5ecd18bd4af32b0001d9fc30" ) );
    contractualMonthlyInstalmentAmount =
      getContractMonthlyInstallment( collection, new ObjectId( "5ecd18bd4af32b0001d9fc30" ) );

    // set up account for assertions
    testData = new TestData.Builder()
      .setEmail( "lucy.dabbs.20@gmail.com" )
      .setPassword( "C@ntona7a" )
      .setNewPassword( "C@ntona7a*" )
      .setCode( "code1234" )
      .setFromTransactionDate( "28-04-2018" )
      .setToTransactionDate( "30-05-2018" )
      .setPaymentDate( "28/01/2019" )
      .setBalance( capitalBalance ) //£29,921.58
      .setInterest( interest ) //8.05%
      .setInstalment( contractualMonthlyInstalmentAmount ) //£238.39
      .setSecurityAnswer( "St Marys" )
      .build();

    System.out.println(testData.toString());
  }

  private MongoCollection<Document> retrieveAccountCollection() {
    // connect to Mongo environment
    MongoClient mongoClient = MongoClients
      .create( "mongodb://nagini-live:O%407%252&nxv5mk#Kov@mongodb-internal.psl-nagini.com:27017/nagini-live" );

    //connect to the database
    MongoDatabase database = mongoClient.getDatabase( "nagini-live" );

    // selct collection to collect data
    MongoCollection<Document> collection = database.getCollection( "account" );

    return collection;
  }

  private String getContractMonthlyInstallment(MongoCollection<Document> collection, ObjectId collectionId) {
    String contractualMonthlyInstalmentAmount = "";
    Document document = collection.find( eq( "_id", collectionId ) ).first();
    if (document == null) {
      //Document does not exist
      System.out.println( "Document does not exist" );
    } else {
      //We found the document
      contractualMonthlyInstalmentAmount = "£" + document.get( "contractualMonthlyInstalmentAmount" );
      System.out.println( contractualMonthlyInstalmentAmount );
    }
    return contractualMonthlyInstalmentAmount;
  }

  public String getCapitalBalance(MongoCollection<Document> collection, ObjectId collectionId) {
    String capitalBalance = "";
    Document document = collection.find( eq( "_id", collectionId ) ).first();
    if (document == null) {
      //Document does not exist
      System.out.println( "Document does not exist" );
    } else {
      //We found the document
      String number = (String) document.get( "capitalBalance" );
      double amount = Double.parseDouble( number );
      DecimalFormat formatter = new DecimalFormat( "#,###.00" );

      number = formatter.format( amount );
      capitalBalance = "£" + number;
      System.out.println( capitalBalance );
    }
    return capitalBalance;
  }

  public String getInterest(MongoCollection<Document> collection, ObjectId collectionId) {
    String interest = "";

    Document document = collection.find( eq( "_id", collectionId ) ).first();
    if (document == null) {
      //Document does not exist
      System.out.println( "Document does not exist" );
    } else {
      //We found the document

      String number = (String) document.get( "contractMargin" );
      interest = number + "%";
      System.out.println( interest );
    }
    return interest;
  }

  @AfterSuite
  public void closeBrowser() {
    driver.close();
  }

}
