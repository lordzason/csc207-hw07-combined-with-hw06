package com.farevee.groceries;

public class BulkItem
    implements Item
{
  //+--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The type of food of the bulk item
   */
  BulkFood food;

  /**
   * The unit of the bulk item
   */
  Units unit;

  /**
   * The amount of bulk item
   */
  int amount;

  // +--------------+------------------------------------------------
  // | Constructor |
  // +--------------+

  public BulkItem(BulkFood food, Units unit, int amount)
  {
    this.food = food;
    this.unit = unit;
    this.amount = amount;
  } // BulkItem (BulkFood, Units, int)

  //+-----------+---------------------------------------------------
  // | Methods  |
  // +-----------+

  /**
   * Retrieve the Weight of BulkItem, including unit and amount
   */
  public Weight getWeight()
  {
    return new Weight(this.unit, this.amount);
  }//getWeight()

  /**
  * Retrieve the amount of Weight of BulkItem
  */
  @Override
  public int getWeightAmount()
  {
    return this.getWeight().amount;
  }//getWeightAmount()

  //Get the unit of weight
  @Override
  public Units getWeightUnit()
  {
    return this.unit;
  }//getWeightUnit()

  //Get the price
  public int getPrice()
  {
    return this.food.pricePerUnit * this.amount;
  }//getPrice()

  //Creates a string for the name
  public String toString()
  {
    return (amount + " " + unit.name + " of " + food.name);
  }//toString()

  //Gets the name
  @Override
  public String getName()
  {
    return this.food.name;
  }//getName()

  //Get the type of BulkFood
  public BulkFood getBulkFoodType()
  {
    return this.food;
  }//getBulkFoodType()

  //Get the amount of BulkItem
  public int getBulkItemAmount()
  {
    return this.amount;
  }//getBulkItemAmount()

  //Compares two BulkItem
  public boolean equalZ(Object thing)
  {
    if (thing instanceof BulkItem)
      {
        BulkItem anotherBulkItem = (BulkItem) thing;

        return ((this.food.name.equals(anotherBulkItem.food.name)) && (this.unit.name.equals(anotherBulkItem.unit.name)));
      }
    else
      {
        return Boolean.FALSE;
      }
  }//equals(Object)

  public void increaseAmount(int x)
  {
    this.amount += x;
    
  }//increaseAmount(int)
  
}
