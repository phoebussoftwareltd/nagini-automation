package com.nagini.pages;

import com.nagini.controllers.actions.ManagePaymentDetailsActionsController;
import com.nagini.controllers.verifiers.ManagePaymentDetailsVerifyController;

public class ManagePaymentDetails {

  private ManagePaymentDetailsActionsController act;
  private ManagePaymentDetailsVerifyController verify;

  public ManagePaymentDetailsActionsController act() {
    return act;
  }

  public ManagePaymentDetailsVerifyController verify() {
    return verify;
  }

  private ManagePaymentDetails() {

  }

  public ManagePaymentDetails(ManagePaymentDetailsActionsController act, ManagePaymentDetailsVerifyController verify) {
    this.act = act;
    this.verify = verify;
  }

  public static ManagePaymentDetails getManagePaymentDetails() {
    return new ManagePaymentDetails( new ManagePaymentDetailsActionsController(),
      new ManagePaymentDetailsVerifyController() );
  }
}
