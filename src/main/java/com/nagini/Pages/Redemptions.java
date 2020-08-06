package com.nagini.Pages;

import com.nagini.controllers.actions.RedemptionsActionsController;
import com.nagini.controllers.actions.RepaymentCalculatorActionsController;
import com.nagini.controllers.verifiers.RedemptionsVerifyController;
import com.nagini.controllers.verifiers.RepaymentCalculatorVerifyController;

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


