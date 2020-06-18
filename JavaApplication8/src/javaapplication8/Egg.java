/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Egg extends Rectangle  {
    int direct =0;
    public Rectangle r;
    
    public Egg(int dir){
        
        r = new Rectangle(180, 100, 20, 20);
       
        direct = dir;
    }
    
}
