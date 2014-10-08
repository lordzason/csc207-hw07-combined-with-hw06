package edu.grinnell.csc207.chenzhi17.layout;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * A few simple experiments with our utilities.
 */
public class MathExpt
{
  public static void main(String[] args)
    throws Exception
  {
    PrintWriter pen = new PrintWriter(System.out, true);

    // Print some square roots.
    for (int i = 2; i < 10; i++)
      {
        double root = MathUtils.squareRoot(i);
        

        
        pen.println("The square root of " + i + " seems to be " + root);
        pen.println(root + "^2 = " + (root * root));
      } // for i
    
    Integer rootInteger = Integer.valueOf(4);
    pen.println(MathUtils.squareRoot(rootInteger));
    BigInteger rootBigInteger = BigInteger.valueOf(4);
    pen.println(MathUtils.squareRoot(rootBigInteger));
    float rootFloat = 4;
    pen.println(MathUtils.squareRoot(rootFloat));
    double rootDouble = 4;
    pen.println(MathUtils.squareRoot(rootDouble));
    BigDecimal rootBigDecimal = BigDecimal.valueOf(4);
    pen.println(MathUtils.squareRoot(rootBigDecimal));
    Double rootBigDouble = Double.valueOf(4);
    pen.println(MathUtils.squareRoot(rootBigDouble));
    
        
    // We're done. Clean up.
    pen.close();
  } // main(String[])
} // class MathExpt
