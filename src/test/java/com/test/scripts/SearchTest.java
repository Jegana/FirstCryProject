package com.test.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BaseClassPackage.BaseDriver;

public class SearchTest extends BaseDriver{
  @Test
  public void f() {
	  hp.enterSearchKey("Shirt");
	  hp.searchBtnClick();
	  
	  Assert.fail();
  }
}
