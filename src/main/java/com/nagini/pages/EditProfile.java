package com.nagini.pages;

import com.nagini.controllers.actions.EditProfileActionsController;
import com.nagini.controllers.verifiers.EditProfileVerifyController;

public class EditProfile {
  private EditProfileActionsController act;
  private EditProfileVerifyController verify;

  public EditProfileActionsController act() {
    return act;
  }

  public EditProfileVerifyController verify() {
    return verify;
  }

  public EditProfile() {
  }

  public EditProfile( EditProfileActionsController act, EditProfileVerifyController verify) {
    this.act = act;
    this.verify = verify;
  }

  public  static EditProfile getEditProfile() {
    return new EditProfile(new EditProfileActionsController(),new EditProfileVerifyController());
  }







}
