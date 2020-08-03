package com.nagini.Pages;



import com.nagini.controllers.actions.AuthenticationActionsController;
import com.nagini.controllers.verifiers.AuthenticationVerifyController;

public class Authentication {
  private AuthenticationActionsController act;
  private AuthenticationVerifyController verify;

  public AuthenticationActionsController act() {
    return act;
  }

  public AuthenticationVerifyController verify() {
    return verify;
  }

  private Authentication() {
  }

  public Authentication( AuthenticationActionsController act, AuthenticationVerifyController verify) {
    this.act = act;
    this.verify = verify;
  }

  public  static Authentication getAuthentication() {
    return new Authentication(new AuthenticationActionsController(),new AuthenticationVerifyController());
  }


}
