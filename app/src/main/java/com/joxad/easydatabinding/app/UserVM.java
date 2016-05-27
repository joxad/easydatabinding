package com.joxad.easydatabinding.app;

import android.content.Context;
import android.databinding.Bindable;
import com.joxad.easydatabinding.base.BaseVM;
import java.lang.Override;
import java.lang.String;

public class UserVM extends BaseVM<User> {
  public UserVM(Context context, User user) {
    super(context,user);
  }

  @Override
  public void init() {
  }

  @Override
  public void destroy() {
  }

  @Bindable
  public String getName() {
    return this.model.getName();
  }

  public void setName(String name) {
    this.model.setName(name);
  }
}
