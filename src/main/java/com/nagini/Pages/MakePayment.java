package com.nagini.Pages;

import com.nagini.controllers.actions.MakePaymentActionsController;
import com.nagini.controllers.verifiers.MakePaymentVerifyController;

public class MakePayment {

  private MakePaymentActionsController act;
  private MakePaymentVerifyController verify;

  public MakePaymentActionsController act() {
    return act;
  }

  public MakePaymentVerifyController verify() {
    return verify;
  }

  private MakePayment() {

  }

  public MakePayment(MakePaymentActionsController act, MakePaymentVerifyController verify) {
    this.act = act;
    this.verify = verify;
  }



  public static MakePayment getMakePayment() {
    return new MakePayment( new MakePaymentActionsController(), new MakePaymentVerifyController() );
  }

}
