package com.caesars.us.ui.steps;

import com.caesars.us.ui.Keys;
import com.caesars.us.ui.context.ScenarioContext;
import com.caesars.us.ui.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

// What is this file for?

public class ExampleUiStepDefs extends AbstractUiSteps {
  public ExampleUiStepDefs() {
    super();
  }

  @Given("I am on the Casino Palace website")
  public void iAmOnTheCasinoPalaceWebsite() {
    ((WebDriver) getScenarioContext().get(Keys.DRIVER)).navigate().to("https://caesarspalaceonline.com/us/mi/casino");
    getCasinoPage().waitForPageLoad();
  }
}
