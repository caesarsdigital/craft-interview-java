package com.caesars.us.ui.steps;

import com.caesars.us.ui.Keys;
import com.caesars.us.ui.context.ScenarioContext;
import com.caesars.us.ui.driver.WebDriverSetup;
import com.caesars.us.ui.pages.CasinoPage;
import com.caesars.us.ui.pages.LoginPage;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Data
public class AbstractUiSteps {

    private final ScenarioContext scenarioContext;
    private final CasinoPage casinoPage;
    private final LoginPage loginPage;
    private final WebDriver webDriver;

    public AbstractUiSteps( ) {
        this.webDriver = WebDriverSetup.getWebDriver();
        this.scenarioContext = new ScenarioContext();
        this.scenarioContext.set(Keys.DRIVER, WebDriverSetup.getWebDriver());
        this.casinoPage = PageFactory.initElements(this.webDriver, CasinoPage.class);
        this.loginPage = PageFactory.initElements(this.webDriver, LoginPage.class);
    }
}
