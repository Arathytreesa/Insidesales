package com.kayak.POMSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectedResultAssertions {
	private static WebElement org= null;
	private static WebElement dest= null;
	
	public static WebElement getOriginAssert(WebDriver driver){
		{
			org = driver.findElement(By.xpath("//div[@id='resbody']/div[1]/div[1]/div[1]/span[1]"));
			return org;
		}
	}
	
	public static WebElement getDestAssert(WebDriver driver){
		{
			dest = driver.findElement(By.xpath("//div[@id='resbody']/div[1]/div[1]/div[1]/span[3]"));
			return dest;
		}
	}
}
//org: //div[@id='yts']/div/div[2]/div[1]/div/div[1]/table/tbody/tr[2]/td[1]
//dest: //div[@class='yts-trip--lg cf ng-scope']/div[1]/table/tbody/tr[2]/td[3]