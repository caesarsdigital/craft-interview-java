package com.caesars.us.api.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "summary"},
        snippets = CAMELCASE,
        features = "src/test/resources/features/api",
        tags = "@api",
        glue = "com.caesars.us.api.steps")
public class ApiTestRunner {
}