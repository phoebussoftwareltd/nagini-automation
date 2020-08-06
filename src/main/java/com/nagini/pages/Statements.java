package com.nagini.pages;

import com.nagini.controllers.actions.StatementsActionsController;
import com.nagini.controllers.verifiers.StatementsVerifyController;

public class Statements {

  private StatementsActionsController act;
  private StatementsVerifyController verify;

  public StatementsActionsController act() {
    return act;
  }

  public StatementsVerifyController verify() {
    return verify;
  }

  private Statements() {

  }

  public Statements(StatementsActionsController act, StatementsVerifyController verify) {
    this.act = act;
    this.verify = verify;
  }



  public static Statements getStatements() {
    return new Statements( new StatementsActionsController(), new StatementsVerifyController() );
  }

}
