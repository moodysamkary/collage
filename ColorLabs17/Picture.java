import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  public static void main(String[] args)
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
  }

  public void grey()
  {
	  Pixel[] pixels= this.getPixels();
	  int grey;
	  for(Pixel p:pixels)
	  {
		  grey=(p.getRed()+p.getGreen()+p.getBlue())/3;
		  p.setRed(grey);
		  p.setGreen(grey);
		  p.setBlue(grey);
	  }
  }
    public void copy(Picture sourcePicture)
  {
	  Pixel sourcePixel=null;
	  Pixel targetPixel=null;

	  for(int sourceX=0, targetX=3851; sourceX<sourcePicture.getWidth();sourceX++, targetX++)
	  {
		  for(int sourceY=0, targetY=754; sourceY<sourcePicture.getHeight();sourceY++, targetY++)
		  {
			  sourcePixel=sourcePicture.getPixel(sourceX,sourceY);
			  targetPixel=this.getPixel(targetX,targetY);
			  targetPixel.setColor(sourcePixel.getColor());
		  }
	  }
  }
  /**
  *Method to mirror around a vertical line in the middle
  *Of the picture based on the width
  */
  public void mirrorVertical()
  {
	  int width=this.getWidth();
	  int mirrorPoint=width/2;

	  Pixel leftPixel=null;
	  Pixel rightPixel=null;

	  //loop throuhgout all the rows
	  for(int y=0; y<getHeight(); y++)
	  {
		  //loop from 0 to the middle(mirror point)
		  for(int x=0; x<mirrorPoint; x++)
		  {
			  leftPixel=getPixel(x,y);
			  rightPixel=getPixel(width-1-x,y);
			  rightPixel.setColor(leftPixel.getColor());
		  }
	  }
  }
  public void mirrorTemple()
  {
	  int width=555;
	  int mirrorPoint=width/2;

	  Pixel leftPixel=null;
	  Pixel rightPixel=null;

	  for(int y=20; y<100; y++)
	  {
		  for(int x=15; x<mirrorPoint; x++)
		  {
			  leftPixel=getPixel(x,y);
			  rightPixel=getPixel(width-1-x,y);
			  rightPixel.setColor(leftPixel.getColor());
		  }
	  }
  }
  public void mirrorHorizontal()
  {
      int height=this.getHeight();
      int mirrorPoint=height/2;
      
      Pixel leftPixel=null;
      Pixel rightPixel=null;
      
      for(int x=0; x<this.getWidth(); x++)
      {
          for(int y=0; y<mirrorPoint; y++)
          {
              leftPixel=getPixel(x,y);
              rightPixel=getPixel(x,height-1-y);
              rightPixel.setColor(leftPixel.getColor());
            }
        }
    }
    public void copySmaller(Picture flowerPicture)
    {
        Pixel sourcePixel=null;
        Pixel targetPixel=null;
        
        for(int sourceX=0, targetX=2620; sourceX<flowerPicture.getWidth();sourceX=sourceX+2, targetX++)
	  {
		  for(int sourceY=0, targetY=757; sourceY<flowerPicture.getHeight();sourceY=sourceY+2, targetY++)
		  {
			  sourcePixel=flowerPicture.getPixel(sourceX,sourceY);
			  targetPixel=this.getPixel(targetX,targetY);
			  targetPixel.setColor(sourcePixel.getColor());
		  }
	  }
}
public void maxBlue()
{
     Pixel[] pixels;
     pixels = this.getPixels();
        
        int r = 0, g = 0, b = 0;
                
        //maxBlue()
        for (Pixel spot : pixels)
        {
            spot.setBlue(255);
        }
    }
    public void maxRed()
    {
     Pixel[] pixels;
     pixels = this.getPixels();
        
        int r = 0, g = 0, b = 0;
        
        //maxRed()
        for (Pixel spot : pixels)
        {
            spot.setRed(255);
        }
    }
    public void maxGreen()
    {
     Pixel[] pixels;
     pixels = this.getPixels();
        
        int r = 0, g = 0, b = 0;
        
        //maxGreen()
        for (Pixel spot : pixels)
        {
            spot.setGreen(255);
        }
    }
    public void negate()
    {
        Pixel[] pixels;
        pixels = this.getPixels();
        
        int r = 0, g = 0, b = 0;
        
        //negate()
        for (Pixel spot : pixels)
        {
            r = spot.getRed();
            g = spot.getGreen();
            b = spot.getBlue();
            
            r = 255 - r;
            g = 255 - g;
            b = 255 - b;
            
            spot.setRed(r);
            spot.setGreen(g);
            spot.setBlue(b);
        }
    }
    public void swap3()
    {
        Pixel[] pixels = this.getPixels();
        //swap3
        int r = 0, g = 0, b = 0;
        for (Pixel spot : pixels)
        {
            r = spot.getRed();
            g = spot.getGreen();
            b = spot.getBlue();
            
            spot.setRed(b);
            spot.setGreen(r);
            spot.setBlue(g);
        }
    }
} // this } is the end of class Picture, put all new methods before this
