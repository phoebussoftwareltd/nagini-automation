package com.nagini.pages;

import com.nagini.controllers.actions.RedemptionsActionsController;
import com.nagini.controllers.verifiers.RedemptionsVerifyController;

public class Redemptions {

  private RedemptionsActionsController act;
  private RedemptionsVerifyController verify;


  public RedemptionsActionsController act() {
    return act;
  }

  public RedemptionsVerifyController verify() {
    return verify;
  }


  private Redemptions() {
  }

  public Redemptions(RedemptionsActionsController act, RedemptionsVerifyController verify) {
    this.act = act;
    this.verify = verify;
  }

  public static Redemptions getRedemptions() {
    return new Redemptions(new RedemptionsActionsController(), new RedemptionsVerifyController());
  }
}


