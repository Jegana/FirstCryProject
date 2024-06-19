package com.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GetScreenWindow {
  @Test
  public static String getScreen(WebDriver driver,String ScreenshotName) throws IOException {
	  //1. Convert the WebDriver driver object into the TakeScreenshot Object
	  TakesScreenshot ts = (TakesScreenshot)driver;
	  
	  //2. Call the getScreenshotAsMethod to create a raw image
	  File f_temp = ts.getScreenshotAs(OutputType.FILE);
	  
	  //3. copy the raw file into the desired location
	  String location = System.getProperty("user.dir")+"\\test-output\\Screenshots\\IMG_"+System.currentTimeMillis()+".jpg";
	  File target = new File(location);
	  FileUtils.copyFile(f_temp,target);
	  
	  return location;
  }
}
