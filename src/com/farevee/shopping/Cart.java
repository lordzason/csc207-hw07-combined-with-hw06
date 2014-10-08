/**
 * Consulted code from Samuel Rebelsky, Samuel Rebelsky's Thursday Review Session
 * ,Albert Owusu-Asare, Ajuna S. Kyaruzi, and Zoe Wolter
 * 
 * Reference on implementing Array Lists in Java:
 * http://www.tutorialspoint.com/java/java_arraylist_class.htm
 *
 * Reference on ArrayList methods
 * http://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 * 
 * Reference on contains:
 * http://www.tutorialspoint.com/java/lang/string_contains.htm
 * 
 * Reference on isInstance:
 * http://www.tutorialspoint.com/java/java_inheritance.htm
 * http://stackoverflow.com/questions/13873933/java-instanceof-with-class-name
 * http://www.tutorialspoint.com/java/lang/class_isinstance.htm
 * 
 */

package com.farevee.shopping;

import java.io.PrintWriter;
import java.util.ArrayList;

import com.farevee.groceries.BulkContainer;
import com.farevee.groceries.BulkItem;
import com.farevee.groceries.Item;
import com.farevee.groceries.ManyPackages;
import com.farevee.groceries.Package;
import com.farevee.groceries.Units;

public class Cart
{
  //+--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * An ArrayList to hold elements, as suggested by Samuel A. Rebelsky
   */
  ArrayList<Item> shoppingCart = new ArrayList<Item>();

  /**
   * A count for the number of things
   */
  int numberOfThings = 0;

  //+--------------+------------------------------------------------
  // | Constructor |
  // +--------------+
  public Cart()
  {
  } // Cart()

  //+-----------+---------------------------------------------------
  // | Methods  |
  // +-----------+

  /**
   * Add an item to the cart.
   * @param itemToAdd
   */
  public void addItem(Item itemToAdd)
  {
    //Update numberOfThings, numberofEntries, totalPrice
    if (itemToAdd instanceof ManyPackages)
      {
        numberOfThings += ((ManyPackages) itemToAdd).getCount();
      }//if()
    else
      {
        numberOfThings++;
      }//else()

    shoppingCart.add(itemToAdd);

  }//addItem(Item)

  /**
   * Get the number of things in the cart.
   */
  public int numThings()
  {
    return this.numberOfThings;
  }//numThings()

  /**
   * Get the number of entries in the cart.
   */
  public int numEntries()
  {
    return shoppingCart.size();
    //return this.numberOfEntries;

  }//numEntries()

  //Print the contents of the cart. 
  public void printContents(PrintWriter pen)
  {
    pen.println("The shopping cart contains the following:");

    for (Item thingInCart : shoppingCart)
      {
        pen.println(thingInCart.toString());
      }//for()

  }//printContents(PrintWriter)

  //Computes the total price of the order, in cents. 
  public int getPrice()
  {
    int totalPrice = 0;

    for (Item thingInCart : shoppingCart)
      {
        totalPrice += thingInCart.getPrice();
      } // for
    return totalPrice;

  }//getPrice()

  //Returns an array with weights in pounds, ounces, kilograms, and grams
  public int[] getWeight()
  {
    /**
     * An array of 4 ints to hold the amount for Weights
     * weightsArray[0] for amount in pounds, weightsArray[1] for amount in ounces
     * weightsArray[2] for amount in kilograms, weightsArray[3] for amount in grams
     */
    int[] weightsArray = new int[4];

    for (Item itemInCart : shoppingCart)
      {
        //Update the weightsArray
        Units weightUnit = itemInCart.getWeightUnit();
        int weightAmount = itemInCart.getWeightAmount();

        if (weightUnit.equals(Units.POUND))
          {
            weightsArray[0] += weightAmount;
          }// if 
        else if (weightUnit.equals(Units.OUNCE))
          {
            weightsArray[1] += weightAmount;
          }// else if
        else if (weightUnit.equals(Units.KILOGRAM))
          {
            weightsArray[2] += weightAmount;
          }// else if
        else if (weightUnit.equals(Units.GRAM))
          {
            weightsArray[3] += weightAmount;
          }// else if

      }//for()

    return weightsArray;

  }//getWeight()

  //Removes all of the products whose name exactly matches name.
  public void remove(String name)
  {

    //Get the size of the cart
    int size = shoppingCart.size();

    for (int i = 0; i < size; i++)
      {

        Item itemInCart = shoppingCart.get(i);

        //If the item has the desired name
        if (itemInCart.getName().equals(name))
          {
            /*If the item is a ManyPackages, 
             decrease numberOfThings by the 
             number of packages in ManyPackages*/
            if (itemInCart instanceof ManyPackages)
              {
                numberOfThings -= ((ManyPackages) itemInCart).getCount();
              }//if()
            else
              {
                numberOfThings--;
              }//else()

            //Remove the item from the shoppingCart
            shoppingCart.remove(itemInCart);

            //Decrement because of the removal of an element
            i--;

          }//if()

      }//for()

  }//remove(String name)

  /**
   * 
   * Replaces an element at index x with the last element in the ArrayList
   * Consulted Samuel Rebelsky, Albert Owusu-Asare, Ajuna S. Kyaruzi, and Zoey Wolter
   */
  public int replace(int x)
  {
    int size = shoppingCart.size() - 1;
    shoppingCart.set(x, shoppingCart.get(size));
    shoppingCart.remove(size);
    return size;
  }//replace(int)

  /**
   * Finds identical items and merges them into a single item. 
   */
  public void merge()
  {
    Item itemI;
    Item itemJ;
    int shoppingCartSize = shoppingCart.size();

    for (int i = 0; i < shoppingCartSize; i++)
      {
        itemI = shoppingCart.get(i);

        for (int j = i + 1; j < shoppingCartSize; j++)
          {
            //itemI = shoppingCart.get(i);
            itemJ = shoppingCart.get(j);

            if (itemI instanceof Package)
              {
                if ((itemJ instanceof Package)
                    && (((Package) itemI).equals(itemJ)))
                  {
                    /*Set the element at index i to the combination of 
                     * the package at index i and the package at index j*/
                    shoppingCart.set(i, new ManyPackages((Package) itemI, 2));

                    //Remove the element at index j
                    shoppingCartSize = replace(j);

                    //Decrement because of element removal
                    j--;

                  }//if()
                else if ((itemJ instanceof ManyPackages)
                         && ((((ManyPackages) itemJ).getType()).equals((Package) itemI)))
                  {
                    //Add a package to ManyPackages
                    ((ManyPackages) itemJ).addPackage(1);

                    //Remove the element at index i
                    shoppingCartSize = replace(i);

                    //Decrement because of element removal
                    j--;

                  }//else if()
              }//if()

            else if (itemI instanceof ManyPackages)
              {
                ManyPackages morePackages = (ManyPackages) itemI;

                if ((itemJ instanceof Package)
                    && (((Package) itemJ).equals(morePackages.getType())))
                  {
                    //Add Package into ManyPackages
                    morePackages.addPackage(1);

                    //Remove the element at index j
                    shoppingCartSize = replace(j);

                    //Decrement because of element removal
                    j--;
                  }//if()
                else if ((itemJ instanceof ManyPackages)
                         && (((ManyPackages) itemJ).equalZ(morePackages)))
                  {
                    //Determine the number of packages to merge
                    int increase = ((ManyPackages) itemJ).getCount();

                    //Add Package into ManyPackages
                    morePackages.addPackage(increase);

                    //Remove the element at index j
                    shoppingCartSize = replace(j);

                    //Decrement because of element removal
                    j--;

                  }//else if()
              }//else if()

            else if (!(itemI instanceof BulkContainer || itemJ instanceof BulkContainer)
                     && (itemI instanceof BulkItem)
                     && (itemJ instanceof BulkItem)
                     && (((BulkItem) itemI).equalZ((BulkItem) itemJ)))
              {
                //Determine the number of BulkItem to merge
                int increase = ((BulkItem) itemJ).getBulkItemAmount();

                //Increase the amount of BulkItem
                ((BulkItem) itemI).increaseAmount(increase);

                //Remove the element at index j
                shoppingCartSize = replace(j);

                //Decrement because of element removal
                j--;

              }//else if()

          }//for(j)

      }//for(i)

  }//merge()

}//public class Cart
