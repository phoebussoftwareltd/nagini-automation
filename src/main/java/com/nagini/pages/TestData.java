package com.nagini.pages;

public class TestData {
  private String email;
  private String password;
  private String newPassword;
  private String code;
  private String fromTransactionDate;
  private String toTransactionDate;
  private String paymentDate;
  private String balance;
  private String interest;
  private String instalment;
  private String securityAnswer;


  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public String getCode() {
    return code;
  }

  public String getFromTransactionDate() {
    return fromTransactionDate;
  }

  public String getToTransactionDate() {
    return toTransactionDate;
  }

  public String getPaymentDate() {
    return paymentDate;
  }

  public String getBalance() {
    return balance;
  }

  public String getInterest() {
    return interest;
  }

  public String getInstalment() {
    return instalment;
  }

  public String getSecurityAnswer() {
    return securityAnswer;
  }

  public TestData(String email, String password, String newPassword, String code, String fromTransactionDate,
    String toTransactionDate, String paymentDate, String balance, String interest, String instalment,
    String securityAnswer) {
    this.email = email;
    this.password = password;
    this.newPassword = newPassword;
    this.code = code;
    this.fromTransactionDate = fromTransactionDate;
    this.toTransactionDate = toTransactionDate;
    this.paymentDate = paymentDate;
    this.balance = balance;
    this.interest = interest;
    this.instalment = instalment;
    this.securityAnswer = securityAnswer;
  }

  public static class Builder {
    private String email;
    private String password;
    private String newPassword;
    private String code;
    private String fromTransactionDate;
    private String toTransactionDate;
    private String paymentDate;
    private String balance;
    private String interest;
    private String instalment;
    private String securityAnswer;


    public Builder() {
    }

    public Builder setEmail(String email) {
      this.email = email;
      return this;
    }

    public Builder setPassword(String password) {
      this.password = password;
      return this;
    }

    public Builder setNewPassword(String newPassword) {
      this.newPassword = newPassword;
      return this;
    }

    public Builder setCode(String code) {
      this.code = code;
      return this;
    }

    public Builder setFromTransactionDate(String fromTransactionDate) {
      this.fromTransactionDate = fromTransactionDate;
      return this;
    }

    public Builder setToTransactionDate(String toTransactionDate) {
      this.toTransactionDate = toTransactionDate;
      return this;
    }

    public Builder setPaymentDate(String paymentDate) {
      this.paymentDate = paymentDate;
      return this;
    }

    public Builder setBalance(String balance) {
      this.balance = balance;
      return this;
    }

    public Builder setInterest(String interest) {
      this.interest = interest;
      return this;
    }

    public Builder setInstalment(String instalment) {
      this.instalment = instalment;
      return this;
    }

    public Builder setSecurityAnswer(String securityAnswer) {
      this.securityAnswer = securityAnswer;
      return this;
    }

    public TestData build() {
      return new TestData(email, password, newPassword, code, fromTransactionDate, toTransactionDate, paymentDate,
        balance, interest, instalment, securityAnswer);
    }
  }
}
