package com.farevee.groceries;

public class BulkContainer
    extends BulkItem
{

  //+--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The name of the container to hold BulkItem.
   */
  String container;

  // +--------------+------------------------------------------------
  // | Constructor |
  // +--------------+
  public BulkContainer(String containerName, BulkFood food, Units unit,
                       int amount)
  {
    super(food, unit, amount);
    this.container = containerName;
  }//BulkContainer(String, Bulkfood, Units, int)

  //+-----------+---------------------------------------------------
  // | Methods  |
  // +-----------+

  /**
   * Retrieve information about the BulkContainer in a string
   */
  @Override
  public String toString()
  {
    return (this.container + " of " + this.amount + " " + this.unit.plural
            + " of " + this.food.name);
  }//toString()

  /**
   * Compares two BulkContainer
   */
  public boolean equals(Object thing)
  {
    if (thing instanceof BulkContainer)
      {
        BulkContainer anotherBulkContainer = (BulkContainer) thing;

        return ((this.food.equals(anotherBulkContainer.food)) && (this.container.compareTo(anotherBulkContainer.container) == 0));
      } // if ()
    else
      {
        return Boolean.FALSE;
      }// else

  }//equals(Item)

}// class
