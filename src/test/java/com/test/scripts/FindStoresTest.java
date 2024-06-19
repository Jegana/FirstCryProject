package com.test.scripts;

import org.testng.annotations.Test;

import com.BaseClassPackage.BaseDriver;

public class FindStoresTest extends BaseDriver{
  @Test
  public void FindStoresNav() {
	  hp.hoverSP();
	  hp.clickFindStore();
	  hp.switchToNewTab();
	  slp.navAssert();
	  slp.selectStore("FirstCr");
	  slp.selectState("Bihar");
	  slp.selectCity("Chapra");
	  slp.clickSearch();
  }
}