package com.farevee.groceries;

import java.io.PrintWriter;

public class GroceriesTest
{

  public static void main(String args[])
  {
    
    PrintWriter pen = new PrintWriter(System.out, true);
    
    /*Test 1: Class Tests*/

    //BulkItem Tests
    pen.println("BulkItem Tests");
    //20 pounds of red apples, priced at 50 cents per pound
    BulkFood redApples = new BulkFood("Red Apples", Units.POUND, 50, 20);
    //50 pounds of green apples, priced at 20 cents per pound
    BulkFood greenApples = new BulkFood("Green Apples", Units.POUND, 20, 50);
    BulkItem redApplesBulk = new BulkItem(redApples, Units.POUND, 5);
    BulkItem greenApplesBulk = new BulkItem(greenApples, Units.POUND, 5);
    pen.println("Red apples weight is "
                       + redApplesBulk.getWeightAmount());
    pen.println("Green apples weight is "
                       + greenApplesBulk.getWeightAmount());
    pen.println("Red apples weight is in unit "
                       + redApplesBulk.getWeightUnit());
    pen.println("Green apples weight is in unit "
                       + greenApplesBulk.getWeightUnit());
    pen.println("Red apples price is " + redApplesBulk.getPrice());
    pen.println("Green apples price is " + greenApplesBulk.getPrice());
    pen.println(redApplesBulk.toString());
    pen.println(greenApplesBulk.toString());
    pen.println("Red apples bulk item amount is "
                       + redApplesBulk.getBulkItemAmount());
    pen.println("Green apples bulk item amount is "
                       + greenApplesBulk.getBulkItemAmount());
    pen.println("Red apples and green apples comparison is "
                       + redApplesBulk.equals(greenApplesBulk));
    pen.println();

    //BulkContainer Tests
    pen.println("BulkContainer Tests");
    BulkContainer redApplesBox =
        new BulkContainer("box", redApples, Units.POUND, 5);
    BulkContainer redApplesBox2 =
        new BulkContainer("box", redApples, Units.POUND, 5);
    BulkContainer greenApplesBox =
        new BulkContainer("box", greenApples, Units.POUND, 5);
    pen.println(redApplesBox.toString());
    pen.println(greenApplesBox.toString());
    pen.println("Red apples box and green apples box comparison "
                       + redApplesBox.equals(greenApplesBox));
    pen.println("Red apples box and red apples box comparison "
                       + redApplesBox.equals(redApplesBox2));
    pen.println();

    //Package Tests
    pen.println("Package Tests");
    Package cakeMix = new Package("cake mix", new Weight(Units.OUNCE, 12), 399);
    Package brownieMix =
        new Package("brownie mix", new Weight(Units.OUNCE, 12), 399);
    pen.println(cakeMix.toString());
    pen.println("Cake mix and brownie mix comparison "
                       + cakeMix.equals(brownieMix));
    pen.println("Cake mix weight amount " + cakeMix.getWeightAmount());
    pen.println("Cake mix weight unit " + cakeMix.getWeightUnit());
    pen.println("Cake mix price " + cakeMix.getPrice());
    pen.println("Cake mix name " + cakeMix.getName());
    pen.println();

    //NonFood Tests
    pen.println("NonFood Tests");
    NonFood kitchenKnife =
        new NonFood("kitchen knife", new Weight(Units.OUNCE, 2), 499);
    NonFood kitchenFork =
        new NonFood("kitchen fork", new Weight(Units.OUNCE, 2), 499);
    pen.println(kitchenKnife.toString());
    pen.println("Kitchen knife and kitchen fork comparison "
                       + kitchenKnife.equals(kitchenFork));
    pen.println("Kitchen knife weight amount "
                       + kitchenKnife.getWeightAmount());
    pen.println("Kitchen knife weight unit "
                       + kitchenKnife.getWeightUnit());
    pen.println("Kitchen knife price " + kitchenKnife.getPrice());
    pen.println("Kitchen knife name " + kitchenKnife.getName());
    pen.println();

    //ManyPackage Tests
    pen.println("ManyPackages Tests");
    ManyPackages manyCakeMix = new ManyPackages(cakeMix, 5);
    ManyPackages manyBrownieMix = new ManyPackages(brownieMix, 5);
    pen.println("Many cake mix price " + manyCakeMix.getPrice());
    pen.println(manyCakeMix.toString());
    pen.println("Many cake mix and many brownie mix comparison "
                       + manyCakeMix.equals(manyBrownieMix));
    pen.println("Many cake mix count " + manyCakeMix.getCount());
    pen.println("Many brownie mix count " + manyCakeMix.getCount());
    pen.println("Many mix weight amount " + manyCakeMix.getWeightAmount());
    pen.println("Many Cake mix weight unit " + manyCakeMix.getWeightUnit());
    pen.println("Many cake mix name " + manyCakeMix.getName());
    pen.println("Many cake package type " + manyCakeMix.getType().toString());
    pen.println();

    /*Test 2: Normal Usage*/
    // The store has 20 pounds of bananas, priced at 50 cents per pound
    BulkFood bananas = new BulkFood("bananas", Units.POUND, 50, 20);
    pen.println(bananas.name + " " + bananas.pricePerUnit + " "
                       + bananas.supply + " " + bananas.unit);

    // The store has 200 grams of saffron, priced at 1000 cents per gram
    BulkFood saffron = new BulkFood("saffron", Units.GRAM, 1000, 200);
    pen.println(saffron.name + " " + saffron.pricePerUnit + " "
                       + saffron.supply + " " + saffron.unit);

    //The customer adds three pounds of bananas to the cart
    BulkItem bananas2 = new BulkItem(bananas, Units.POUND, 3);
    pen.println(bananas2.toString());

    // The customer adds a jar of 3 grams of saffron to the cart
    BulkContainer saffronJar = new BulkContainer("jar", saffron, Units.GRAM, 3);
    pen.println(saffronJar.toString());

    // The customer adds a bag of 1 gram of saffron to the cart
    BulkContainer saffronBag = new BulkContainer("bag", saffron, Units.GRAM, 1);
    pen.println(saffronBag.toString());

    // The customer adds a box of oreos to the cart
    Package oreoBox = new Package("oreos", new Weight(Units.OUNCE, 12), 399);
    pen.println(oreoBox.toString());

    // The customer adds a can opener to the cart, priced $3.489.
    NonFood canOpener =
        new NonFood("can opener", new Weight(Units.OUNCE, 2), 349);
    pen.println(canOpener.toString());

    // The customer adds five 6oz packages of macncheez to the cart, each 
    // priced at 77 cents.
    ManyPackages macNCheez =
        new ManyPackages(new Package("macncheez", new Weight(Units.OUNCE, 6),
                                     77), 5);
    pen.println(macNCheez.toString());
  } // main(String)
}// class
