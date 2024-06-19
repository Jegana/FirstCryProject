package com.test.scripts;

import org.testng.annotations.Test;

import com.BaseClassPackage.BaseDriver;

public class ContactUsTest extends BaseDriver {
  @Test
  public void f() {
	  hp.contactUsClick();
	  cup.detailsClick();
	  cup.customerCareExpand();
	  cup.validateEmail();
  }
}
