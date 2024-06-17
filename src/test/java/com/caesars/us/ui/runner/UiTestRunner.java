package com.caesars.us.ui.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "summary"},
        snippets = CAMELCASE,
        features = "src/test/resources/features/ui",
        tags = "@ui",
        glue = {"com.caesars.us.ui.steps", "com.caesars.us.ui.hooks"})
public class UiTestRunner {
}