package com.farevee.groceries;

public class Package
    implements Item
{
  /*Fields*/
  String name;
  Weight weight;
  int price;

  /*Constructor*/
  public Package(String name, Weight weight, int price)
  {
    this.name = name;
    this.weight = weight;
    this.price = price;
  } // Package(String, Weight, int)

  /*Methods*/
  //Information about the Package in a string
  @Override
  public String toString()
  {
    return this.weight.amount + " " + this.weight.unit.name + " package of "
           + this.name;
  }// toString()

  //Compares two Package
  public boolean equals(Object thing)
  {
    if (thing instanceof Package)
      {
        Package anotherPackage = (Package) thing;

        return ((this.name.compareTo(anotherPackage.name) == 0)
                && ((this.getWeight().unit).equals(anotherPackage.getWeight().unit))
                && ((this.getWeight().amount) == (anotherPackage.getWeight().amount)) && (this.getPrice() == anotherPackage.getPrice()));
      }//if 
    else
      {
        return Boolean.FALSE;
      }// else
  }// equals(Object)

  //Get the Weight, unit and amount
  @Override
  public Weight getWeight()
  {
    return this.weight;
  }// getWeight()

  //Get the price of the Package
  @Override
  public int getPrice()
  {
    return this.price;
  }//getPrice()

  //Get the amount of weight
  @Override
  public int getWeightAmount()
  {
    return this.getWeight().amount;
  }// getWeightAmount()

  //Get the unit of weight
  @Override
  public Units getWeightUnit()
  {
    return this.getWeight().unit;
  }//getWeightUnit()

  //Get the name of the Package
  @Override
  public String getName()
  {
    return this.name;
  }// getName()
}// class
