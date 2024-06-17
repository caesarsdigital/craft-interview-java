package com.caesars.us.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {

  final WebDriver webDriver;
  WebDriverWait wait;

  BasePage(WebDriver webDriver) {
    this.webDriver = webDriver;
    this.wait = new WebDriverWait(webDriver, 120);
  }

  void click(By webElement) {
    wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
  }

  void inputText(By webElement, String input) {
    wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(input);
  }

  WebElement getElement(By webElement) {
    return wait.until(ExpectedConditions.presenceOfElementLocated(webElement));
  }

  public void waitForPageLoad() {
    wait.until((ExpectedCondition<Boolean>) wd ->
            ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
  }
}
