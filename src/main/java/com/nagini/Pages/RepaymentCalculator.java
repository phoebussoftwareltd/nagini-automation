package com.nagini.Pages;

import com.nagini.controllers.actions.AccountSummaryActionsController;
import com.nagini.controllers.actions.RepaymentCalculatorActionsController;
import com.nagini.controllers.verifiers.RepaymentCalculatorVerifyController;

public class RepaymentCalculator {

  private RepaymentCalculatorActionsController act;
  private RepaymentCalculatorVerifyController verify;

  public RepaymentCalculatorActionsController act() {
    return act;
  }

  public RepaymentCalculatorVerifyController verify() {
    return verify;
  }


  private RepaymentCalculator() {
  }

  public RepaymentCalculator(RepaymentCalculatorActionsController act, RepaymentCalculatorVerifyController verify) {
    this.act = act;
    this.verify = verify;
  }

  public static RepaymentCalculator getRepaymentCalculator() {
    return new RepaymentCalculator(new RepaymentCalculatorActionsController(), new RepaymentCalculatorVerifyController());
  }
}


