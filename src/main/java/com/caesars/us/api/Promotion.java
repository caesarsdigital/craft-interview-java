package com.caesars.us.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Promotion {
  @JsonProperty("class")
  private String clazz;
  private String bonusConfigurationId;
  private String slug;
  private String title;
  private boolean manualLoyaltyMode;
  private boolean singleClaimBonus;
  private String integration;
  private String bannerImage;
  private Integer priority;
}
