package com.carrefour.printer.printerapp;

/**
 * TODO madwived This type ...
 *
 */
public class ObjetoPOCCNF {

  private String poption;

  private String optvalue;

  private String aux;

  private String tray;

  /**
   * @return tray
   */
  public String getTray() {

    return this.tray;
  }

  /**
   * @param tray new value of {@link #gettray}.
   */
  public void setTray(String tray) {

    this.tray = tray;
  }

  /**
   * @return poption
   */
  public String getPoption() {

    return this.poption;
  }

  /**
   * @param poption new value of {@link #getpoption}.
   */
  public void setPoption(String poption) {

    this.poption = poption;
  }

  /**
   * @return optvalue
   */
  public String getOptvalue() {

    return this.optvalue;
  }

  /**
   * @param optvalue new value of {@link #getoptvalue}.
   */
  public void setOptvalue(String optvalue) {

    this.optvalue = optvalue;
  }

  /**
   * @return aux
   */
  public String getAux() {

    return this.aux;
  }

  /**
   * @param aux new value of {@link #getaux}.
   */
  public void setAux(String aux) {

    this.aux = aux;
  }

  @Override
  public String toString() {

    return "ObjetoPOCCNF [poption=" + this.poption + ", optvalue=" + this.optvalue + ", aux=" + this.aux + ", tray="
        + this.tray + "]";
  }

}