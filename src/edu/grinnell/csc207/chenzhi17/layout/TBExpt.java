package edu.grinnell.csc207.chenzhi17.layout;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.2 of September 2014
 */
public class TBExpt
{
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args)
    throws Exception
  {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    pen.println("\nIntroductory Testing\n");
    TextBlock block = new TextLine("Hello");
    // Print out the block
    TBUtils.print(pen, block);

    TextBlock block1 = new TextLine("Goodbye.");
    TBUtils.print(pen, block1);

    VComposition vTextBlock =
        new VComposition(new BoxedBlock(block), new BoxedBlock(block1));
    TBUtils.print(pen, vTextBlock);

    HComposition hTextBlock = new HComposition(new BoxedBlock(block), block1);
    TBUtils.print(pen, hTextBlock);

    HComposition hTextBlock1 = new HComposition(block1, new BoxedBlock(block));
    TBUtils.print(pen, hTextBlock1);

    //Grid test
    pen.println("\nGrid Testing\n");
    TBUtils.print(pen, new BoxedBlock(new Grid(7, 3, '*')));

    //TruncatedBlock test
    pen.println("\nTruncated Block Testing\n");
    TextBlock truncatedBlock =
        new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock truncatedBlock2 = new TruncatedBlock(truncatedBlock, 3);
    TBUtils.print(pen, truncatedBlock);
    TBUtils.print(pen, truncatedBlock2);

    //CenteredBlock test 1
    pen.println("\nCentered Block Testing 1\n");
    TextBlock centeredBlock =
        new VComposition(new TextLine("Hello"), new TextLine("Goodbye"));
    TextBlock centeredBlock2 =
        new BoxedBlock(new CenteredBlock(centeredBlock, 11));
    TBUtils.print(pen, centeredBlock2);

    //CenteredBlock test 2
    pen.println("\nCentered Block Testing 2\n");
    TextBlock top = new CenteredBlock(new TextLine("Hello"), 11);
    TextBlock bottom = new CenteredBlock(new TextLine("Goodbye"), 11);
    TextBlock centeredBlock3 = new BoxedBlock(new VComposition(top, bottom));
    TBUtils.print(pen, centeredBlock3);

    //RightJustified test 1
    pen.println("\nRight Justified Testing 1\n");
    TextBlock rJ1 = new RightJustified(new TextLine("Hello"), 11);
    TextBlock rJ2 = new RightJustified(new TextLine("Goodbye"), 11);
    TextBlock rightJustified1 = new BoxedBlock(new VComposition(rJ1, rJ2));
    TBUtils.print(pen, rightJustified1);

    //RightJustified test 2
    pen.println("\nRight Justified Testing 2\n");
    TextBlock top1 = new CenteredBlock(new TextLine("Hello"), 11);
    TextBlock bottom1 = new CenteredBlock(new TextLine("Goodbye"), 11);
    TextBlock vTogether1 = new VComposition(top1, bottom1);
    TextBlock rightJustified2 =
        new BoxedBlock(new RightJustified(vTogether1, 11));
    TBUtils.print(pen, rightJustified2);

    //BlockPair test
    pen.println("\nBlock Pair Testing\n");
    TextBlock blockPair =
        new BoxedBlock(new BlockPair(vTogether1));
    TBUtils.print(pen, blockPair);
    
    //Mutable text block tests
    pen.println("\nMutable Text Block Testing\n");
    TextLine tb1 = new TextLine("Hello");
    TextLine tb2 = new TextLine("World");
    TextBlock compound = new BoxedBlock(new CenteredBlock(new BoxedBlock(
        new CenteredBlock(new VComposition(tb1, tb2), 7)), 15));
    pen.println("ORIGINAL");
    TBUtils.print(pen, compound);
    tb2.setContents("Someone");
    pen.println("UPDATED");
    TBUtils.print(pen, compound);
    tb2.setContents("Nice to meet you,");
    pen.println("RE-UPDATED");
    TBUtils.print(pen, compound);
    
    /*Sam's Exploration Code*/
    TextLine line1 = new TextLine("Hello");
    TBUtils.print(pen, line1);
    TextLine line2 = new TextLine("Sam");
    TBUtils.print(pen, line2);
    TextBlock tb11 = new VComposition(line1,line2);
    TBUtils.print(pen, tb11);
    TextBlock tb12 = new BoxedBlock(tb11);
    TBUtils.print(pen, tb12);
    TextBlock tb13 = new CenteredBlock(tb12,11);
    TBUtils.print(pen, tb13);
    TextBlock tb14 = new BoxedBlock(tb13);
    TBUtils.print(pen, tb14);
    line1.setContents("Hi!");
    TBUtils.print(pen, tb14);
    
    
    // Clean up after ourselves.
    pen.close();
  } // main(String[])
} // class TBExpt
