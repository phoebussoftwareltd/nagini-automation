package com.nagini.pages;

import com.nagini.controllers.actions.LoginActionsController;
import com.nagini.controllers.verifiers.LoginVerifyController;

public class Login {

  private LoginActionsController act;
  private LoginVerifyController verify;

  public LoginActionsController act() {
    return act;
  }

  public LoginVerifyController verify() {
    return verify;
  }

  private Login() {

  }

  public Login(LoginActionsController act,LoginVerifyController verify) {
    this.act = act;
    this.verify = verify;
  }

  public static Login getLogin() {
    return new Login(new LoginActionsController(), new LoginVerifyController());
  }
}
