package com.farevee.groceries;

public interface Item
{

  /*Methods*/
  public Weight getWeight();
  
  public int getWeightAmount();
  
  public Units getWeightUnit();

  public int getPrice();

  public String toString();
  
  public String getName();
  
} // interface
