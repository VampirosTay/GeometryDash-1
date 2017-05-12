package Dash;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 * @author Edgar Morales
 *
 */
public class ImageLayer {
	
	Image image;//picture to be used
	double x;//where on the x-axis will be placed
	double y;//where on the y-axis will be placed
	double z;//z is used to make it look like is far away from the camera
	
	int width;//picture's width
	int numberOfImages;//this asks how many pictures the user wants to place
	
//---------- constructor ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public ImageLayer(String filename, double x, double y, double z, int width, int numPictures){
		//TookKit loads the image in another thread, so it takes longer to paint in the Game.java 
		
		image = new ImageIcon(filename).getImage();//ImageIcon loads the image and waits for it to 
	      											//finish loading before painting anything(Developing Games in Java,pg. 36)
		this.x = x;//initializing x coordinate
		this.y = y;//initializing y coordinate
		this.z = z;//initializing the distance from this picture and camera
		this.width = width;//setting the width
		numberOfImages = numPictures;//setting the number of pictures
	}
	
/******************************************************************************************************************************************************************************************************
 * 
 * @param g
 */
	public void draw(Graphics g){
		for(int i = 0; i < numberOfImages; i++){//places 4 continous pictures
			g.drawImage(image, (int)(x - Camera.x/z)+width*i, (int)(y), null);
			//placing the image, adjusting x according to depth, y location, and ImageObserver
		}
	}
}
