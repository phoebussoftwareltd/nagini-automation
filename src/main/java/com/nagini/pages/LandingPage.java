package com.nagini.pages;


import com.nagini.controllers.actions.LandingPageActionsController;
import com.nagini.controllers.verifiers.LandingPageVerifyController;

public class LandingPage {

  private LandingPageActionsController act;
  private LandingPageVerifyController verify;

  public LandingPageActionsController act() {
    return act;
  }

  public LandingPageVerifyController verify() {
    return verify;
  }

  private LandingPage() {

  }

  public LandingPage(LandingPageActionsController act, LandingPageVerifyController verify) {
    this.act = act;
    this.verify = verify;
  }

  public static LandingPage getLandingPage() {
    return new LandingPage(new LandingPageActionsController(), new LandingPageVerifyController());
  }

}
