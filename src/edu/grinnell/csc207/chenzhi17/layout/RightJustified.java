/**
 * Consulted Eileen Fordham
 * 
 * Removing white spaces:
 * http://stackoverflow.com/questions/5455794/removing-whitespace-from-strings-in-java
 * http://www.tutorialspoint.com/java/java_string_replaceall.htm
 * 
 */

package edu.grinnell.csc207.chenzhi17.layout;

public class RightJustified
    implements TextBlock
{
  /*Fields*/
  TextBlock block;
  int height;
  int desiredWidth;
  int textWidth;

  /*Constructor*/
  public RightJustified(TextBlock textBlock, int desiredWidth) throws Exception
  {
    if (desiredWidth < textBlock.width())
      {
        throw new Exception(
                            "Invalid width entered: Cannot be less than width of underlying text block.");
      }
    this.block = textBlock;
    this.height = textBlock.height();
    this.desiredWidth = desiredWidth;
    this.textWidth = textBlock.width();
  } // RightJustified(Textblock, int)

  /*Methods*/
  @Override
  public String row(int i)
    throws Exception
  {
    if (i < 0 || i > this.height)
      {
        throw new Exception("Cannot get row outside of bounds.");
      }// if
    String newText = this.block.row(i).toString().replaceAll(" ", "");
    int diff = this.desiredWidth - newText.length();
    String buffer = "";
    for (int j = 0; j < diff; j++)
      {
        buffer = buffer.concat(" ");
      } // for
    return newText + buffer;

  }// row(int)

  @Override
  public int height()
  {
    return this.height;
  }// height()

  @Override
  public int width()
  {
    return this.desiredWidth;
  }// width()

}// class
