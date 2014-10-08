package com.farevee.groceries;

public class NonFood
    implements Item
{
  /*Fields*/
  String name;
  Weight weight;
  int price;

  /*Constructor*/
  public NonFood(String name, Weight weight, int price)
  {
    this.name = name;
    this.weight = weight;
    this.price = price;
  }

  /*Methods*/
  //Get information about the NonFood
  @Override
  public String toString()
  {
    return this.name + "costs " + this.price;
  } // toString()

  //Get the price of the NonFood
  public int getPrice()
  {
    return this.price;
  }//getPrice()

  //Get the Weight of the NonFood, including unit and amount
  public Weight getWeight()
  {
    return this.weight;
  }//getWeight()

  //Compares two NonFood
  public boolean equals(Object thing)
  {
    if (thing instanceof NonFood)
      {
        NonFood anotherNonFood = (NonFood) thing;

        return (((this.name).compareTo(anotherNonFood.name) == 0)
                && ((this.weight.unit).equals(anotherNonFood.weight.unit))
                && ((this.weight.amount) == (anotherNonFood.weight.amount)) && (this.price == anotherNonFood.price));
      }// if
    else
      {
        return Boolean.FALSE;
      } // else
  }// equal(Object)

  //Get the amount of weight of NonFood
  @Override
  public int getWeightAmount()
  {
    return this.getWeight().amount;
  }// getWeightAmount()

  //Get the unit of weight of NonFood
  @Override
  public Units getWeightUnit()
  {
    return this.getWeight().unit;
  }//getWeightUnit()

  //Get the name of the NonFood
  @Override
  public String getName()
  {
    return this.name;
  }// getName()
}// class
