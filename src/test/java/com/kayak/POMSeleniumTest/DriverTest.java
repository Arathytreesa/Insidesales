package com.kayak.POMSeleniumTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.kayak.POMSelenium.FlightsRegistration;
import com.kayak.POMSelenium.HomePage;
import com.kayak.POMSelenium.SearchResults;
import com.kayak.POMSelenium.SelectedResultAssertions;

public class DriverTest {
	private static Logger Log = Logger.getLogger(Log.class.getName());
	static WebDriver driver;
	
	 @BeforeClass
	  public void Setup() {
		 //ProfilesIni allProfiles = new ProfilesIni();
		 //FirefoxProfile profile = allProfiles.getProfile("Your-profile-name");
		 //profile.setPreference( "intl.accept_languages", "no,en-us,en" ); 
		 // FirefoxDriver driver = new FirefoxDriver(profile);
		 //driver.get("http://www.example.com/");
		 driver=new FirefoxDriver();
			driver.get("http://www.kayak.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	 
	 @DataProvider(name="DynamicInputs")
      public Object[][] OrgDest(){
	  return new Object[][]{
			  {"SFO","LAX"},
			  {"SJC","JFK"},
			  {"SFO","DEN"}
	  };
 }
 
 
 @Test(dataProvider="DynamicInputs")
 public void dynamicScripts(String Org, String Dest){
	 
	     DOMConfigurator.configure("log4j.xml");
	     HomePage.getFlights(driver).click();
	     Log.info("Fights Registration page launched");
	     
 		 //FlightsRegistration.getselectNone(driver).click();
		 FlightsRegistration.getOrigin(driver).clear();
		 Log.info("Cleared default Origin text");
		 
		 FlightsRegistration.getOrigin(driver).sendKeys(Org);
		 Log.info("Entered Origin as "+Org);
		 String actual1= FlightsRegistration.getOrigin(driver).getAttribute("value");
		 System.out.println(actual1);
		 
		 FlightsRegistration.getDestination(driver).clear();
		 FlightsRegistration.getDestination(driver).sendKeys(Dest);
		 Log.info("Entered destination as "+Dest);
		 
		 String actual2= FlightsRegistration.getDestination(driver).getAttribute("value");
		 FlightsRegistration.getCalenderStart(driver).click();
		 FlightsRegistration.getStartDate(driver).click();
		 Log.info("Entered start date");
		 
		 FlightsRegistration.getCalenderEnd(driver).click();
		 FlightsRegistration.getReturnDate(driver).click();
		 Log.info("Entered return date");
		 
		 // OPTIONAL
		 //FlightsRegistration.getNearByOrigin(driver).click();
		 //FlightsRegistration.getNearByDest(driver).click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 FlightsRegistration.getSearch(driver).click();
		 Log.info("Clicked Search button");
		 System.out.println(driver.getTitle());
		 Log.info("Entered search results page");
		 Log.info("Printed the title to see if the origin and destination is correct");
		 String expected1=SelectedResultAssertions.getOriginAssert(driver).getText();
		 String expected2=SelectedResultAssertions.getDestAssert(driver).getText();
		 AssertJUnit.assertEquals(expected1, actual1);
		 System.out.println("Asserted the origin is same as that entered");
		 AssertJUnit.assertEquals(expected2, actual2);
		 System.out.println("Asserted the destination is same as that entered");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		/* List<WebElement> allSelect = driver.findElements(By.tagName("Select"));
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 System.out.println(allSelect.size());
		 allSelect.get(1).click();
		 */
		 
		 SearchResults.getSelect(driver).click();
		 Log.info("Selected the first available option");
		 
		 //Getting the window handlers to switch to the specific window
		 Set<String> handle1= driver.getWindowHandles();
	 	 System.out.println("Name: " + handle1);
	 	 Set<String> handle2= driver.getWindowHandles();
	     System.out.println("Name: " + handle2);
	     
	  String[] WindowNames = handle2.toArray(new String[handle2.size()]);
	  String val=WindowNames[1];
	  String val1=WindowNames[0];
	  String val2=WindowNames[2];
	  
	  
	  driver.switchTo().window(val);
	  Log.info("Switched to the first window");
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  System.out.println(driver.getTitle());
	  driver.close();
	  
	  driver.switchTo().window(val1);
	  System.out.println(driver.getTitle());
	  driver.switchTo().window(val2);
	  Log.info("Switched to the second window");
	  System.out.println(driver.getTitle());
	  //assertTrue(driver.getPageSource().contains(Org));
	  Log.info("Asserting if the page origin detail is the same");
	  //AssertJUnit.assertTrue(driver.getPageSource().contains(Dest));
	  Log.info("Asserting if the page destination detail is the same");
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  
	 
	 // String expected1=SelectedResultAssertions.getOriginAssert(driver).getText();
	 // String expected2=SelectedResultAssertions.getDestAssert(driver).getText();
	  //AssertJUnit.assertTrue(driver.findElement(By.tagName("body")).getText().matches(Org));
	 // AssertJUnit.assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches(Dest));
	  //AssertJUnit.assertEquals(actual1, expected1);
	  //AssertJUnit.assertEquals(actual2, expected2);
	 
	 //assertTrue(selenium.isTextPresent("Below table contains the information about the Customer's transactions"));
		//assertTrue(selenium.isTextPresent("Name of the Customer"));
	  System.out.println("Asserted");
	
	 driver.close();
	 driver.switchTo().window(val1);
	 Log.info("Switched back to original window");
	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		 
		// System.out.println(SelectedResultAssertions.getOriginAssert(driver).getAttribute("Value"));
		 
		
	 }

  @AfterClass
  public void teardown() {
	  driver.close();
	  
  }
}
