/**
 * Consulted Eileen Fordham
 */

package edu.grinnell.csc207.chenzhi17.layout;

public class CenteredBlock
    implements TextBlock
{
  /*Fields*/
  int height;
  //int textWidth;
  int desiredWidth;
  TextBlock input;

  /*Constructor*/
  public CenteredBlock(TextBlock textBlock, int desiredWidth) throws Exception
  {
    if (desiredWidth < textBlock.width())
      {
        throw new Exception(
                            "Invalid width entered: Cannot be less than width of underlying text block.");
      }

    this.height = textBlock.height();
    //this.textWidth = textBlock.width();
    this.desiredWidth = desiredWidth;
    input = textBlock;

  }

  /*Methods*/
  @Override
  public String row(int i)
    throws Exception
  {
    if (i < 0 || i > this.input.height())
      {
        throw new Exception("The row is out of bounds.");
      }

    String text = input.row(i);
    int textLength = text.length();
    if (this.desiredWidth < textLength)
      {
        throw new Exception("The desired width is less than the size of your text");
      }
    int difference = ((this.desiredWidth - textLength) / 2);
    String buffer = "";
    for (int j = 0; j < difference; j++)
      {
        buffer = buffer.concat(" ");
      }
    return (buffer + text + buffer);
  }

  @Override
  public int height()
  {
    return this.height;
  }

  @Override
  public int width()
  {
    return this.desiredWidth;
  }

}
