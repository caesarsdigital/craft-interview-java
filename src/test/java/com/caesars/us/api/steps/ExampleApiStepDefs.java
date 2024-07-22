package com.caesars.us.api.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import com.caesars.us.api.Promotion;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.List;


// What is this file for?

public class ExampleApiStepDefs {
  private Response response;
  private List<Promotion> promotions;

  @Given("I call the api requesting promotions")
  public void iCallTheApiRequestingPromotions() {

    // Write the API call on the line below using the module given
    //  documentation https://rest-assured.io/
    // API URL to call: https://api.americanwagering.com/regions/us/locations/mi/brands/czr/igaming/bonus-engine/api/v1/promotions
    // Store the response from the API call in the "response" variable
    // You need to add headers to request like user-agnet x-appbranding and content-type = application/json
    // Your code here:
   //    response = "";

    // map response to Promotion class, so it can be used later
    // promotions = ...
    try{

    } catch (Exception e){
        throw new Error("No events here...");
    }
  }

  // Write cucumber steps below to match test in feature file

}
