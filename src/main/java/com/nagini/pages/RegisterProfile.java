package com.nagini.pages;

import com.nagini.controllers.actions.RegisterProfileActionsController;
import com.nagini.controllers.verifiers.RegisterProfileVerifyController;

public class RegisterProfile {
  private RegisterProfileActionsController act;
  private RegisterProfileVerifyController verify;

  public RegisterProfileActionsController act() {
    return act;
  }

  public RegisterProfileVerifyController verify() {
    return verify;
  }

  public RegisterProfile() {
  }

  public RegisterProfile( RegisterProfileActionsController act, RegisterProfileVerifyController verify) {
    this.act = act;
    this.verify = verify;
  }

  public static RegisterProfile getRegisterProfile() {
    return new RegisterProfile(new RegisterProfileActionsController(), new RegisterProfileVerifyController());
  }
}
