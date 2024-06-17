package com.caesars.us.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CasinoPage extends BasePage {

    By userButton = By.id("account-button");

    public CasinoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickUserButton() {
        click(userButton);
    }
}