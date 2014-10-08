/**
 * Help from Eileen Fordham on understanding TextBlocks 
 */

package edu.grinnell.csc207.chenzhi17.layout;

public class TruncatedBlock
    implements TextBlock
{
  /*Fields*/
  int width;
  int height;
  TextBlock input;

  /**
   * Create a new truncated block of the specified width.
   */
  public TruncatedBlock(TextBlock tb, int width)
  throws Exception
  {
    if (width <= 0 || width >= tb.width())
      {
        throw new Exception("Entered width is not correct.");
      }// if

    this.width = width;
    this.height = tb.height();
    input = tb;
  } // TruncatedBlock(TextBlock, int)

  /**
   * Get the ith row of the block.
   */
  public String row(int i)
    throws Exception
  {
    if (i < 0)
      {
        throw new Exception("Invalid row " + i);
      } // if the row is invalid
    return this.input.row(i).substring(0, input.row(i).length());
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height()
  {
    return this.height;
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width()
  {
    return this.width;
  } // width()
} // class TruncatedBlock
