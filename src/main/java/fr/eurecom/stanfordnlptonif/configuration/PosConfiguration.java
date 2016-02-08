package fr.eurecom.stanfordnlptonif.configuration;

import org.hibernate.validator.constraints.*;

/**
 * POS Configuration object
 */
public class PosConfiguration {

  @NotEmpty
  private String model;

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

}
