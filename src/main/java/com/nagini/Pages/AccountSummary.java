package com.nagini.Pages;

import com.nagini.controllers.actions.AccountSummaryActionsController;
import com.nagini.controllers.actions.AccountSummaryGetTransactionsController;
import com.nagini.controllers.verifiers.AccountSummaryVerifyController;

public class AccountSummary {

  private AccountSummaryActionsController act;
  private AccountSummaryVerifyController verify;
  private AccountSummaryGetTransactionsController get;

  public AccountSummaryActionsController act() {
    return act;
  }

  public AccountSummaryVerifyController verify() {
    return verify;
  }

  public AccountSummaryGetTransactionsController get() {
    return get;
  }

  private AccountSummary() {
  }

  public AccountSummary(AccountSummaryActionsController act, AccountSummaryVerifyController verify,
    AccountSummaryGetTransactionsController get) {
    this.act = act;
    this.verify = verify;
    this.get = get;
  }

  public static AccountSummary getAccountSummary() {
    return new AccountSummary(new AccountSummaryActionsController(), new AccountSummaryVerifyController(),
      new AccountSummaryGetTransactionsController());
  }
}


