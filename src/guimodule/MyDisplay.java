package guimodule;

import processing.core.*;
import processing.core.PImage;
import java.lang.*;

public class MyDisplay extends PApplet {
	
	private String URL =  "https://lajollamom.com/wp-content/uploads/2016/12/best-la-jolla-beaches-shores.jpg";
	private PImage backgroundImg;    //get background
	
	public void setup()
	{
		size(1300, 1400);  //size of the applet window
		
		background(200, 200, 200); //rgb colour code to change background colour, max value=255, min=0
		
		backgroundImg = loadImage(URL, "jpg"); //display background
		
		
	}
	
	public void draw()
	{
		int[] color=  sunColorset (second());  //stores the function value
		
		backgroundImg.resize(0, height);  //height and width are instance variables in PApplet  
		image (backgroundImg, 0, 0); //displays the image, (0,0) is the location of top left corner of the image
		
		fill(color[0], color[1], color[2]);  //color of sun
		ellipse (width/4, height/5, width/5, height/5); //(x of center, y of center, width of shape, height of shape)
	}
	
	public int[] sunColorset (float second)
	{
		int[] rgb = new int[3];  //array to store red, green, blue rgb code
		
		float diffFrom30 = Math.abs(second-30); //Difference depicts the brightness of sun.at second=0; bright yellow will appear 
		                                        //at second = 30; black appears
		float ratio =  (diffFrom30/ 30);       //ratio for yellow and red colors
		
		rgb[0] = (int) (ratio*255);
		rgb[1] = (int) (ratio*255);
		rgb[2] = 0;
		
		return rgb;

		}

}
