
package javaapplication8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Cat extends Rectangle {
    public Rectangle r;
    //public int height = 600;
    public Random rand2;
    
   

    
    public Cat(){
         rand2 = new Random();
        int cx = 50 + rand2.nextInt(250);
       
        r = new Rectangle(cx,JavaApplication8.height,100,100);
    }
}
