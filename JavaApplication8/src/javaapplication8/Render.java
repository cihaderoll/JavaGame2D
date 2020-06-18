/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.awt.Graphics;
import javax.swing.JPanel;

 
public class Render extends JPanel{
    private static final long serialVersionUID =1l;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        JavaApplication8.javaapplication.repaint(g);
    }
    
    
}
