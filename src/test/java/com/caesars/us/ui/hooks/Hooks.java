package com.caesars.us.ui.hooks;

import com.caesars.us.ui.driver.WebDriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks   {

    @Before(order = 50, value = "@ui")
    public void driverSetup() {
        WebDriverSetup.setupWebDriver();
    }

    @After(order = 50, value = "@ui")
    public void driverTearDown() {
        WebDriverSetup.quitWebDriver();
    }
}
