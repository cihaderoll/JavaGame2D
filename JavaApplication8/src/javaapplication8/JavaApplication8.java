
package javaapplication8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.*;


public class JavaApplication8 implements ActionListener, KeyListener {

    public static JavaApplication8 javaapplication;
    public Render render;
    public final int width =400;
    public ArrayList<Rectangle> targetLeft;
    public ArrayList<Rectangle> targetRight;
    public ArrayList<Egg> egg;
    public ArrayList<Background> image;
    public ArrayList<Cat> cat;
    public int direct[];
    public Random rand;
    public Graphics gr;
    public boolean throwing = false;
    public int tick=0;
    public int xMotion =180;
    public final static int height = 600;
    public int move =0;
    public int i=0;
    public int score=0;
    public int Bx = 0;
    public int randSure;
    public int sure =100;
    
    int index=0;
    ImageIcon eggs = new ImageIcon("C:\\Users\\cihad\\Desktop\\dersler\\Yeni klasör\\java\\JavaApplication8\\src\\realegg.png");
    ImageIcon b = new ImageIcon("C:\\Users\\cihad\\Desktop\\dersler\\Yeni klasör\\java\\JavaApplication8\\src\\BackgrounImage.png");
    ImageIcon resim = new ImageIcon("C:\\Users\\cihad\\Desktop\\dersler\\Yeni klasör\\java\\JavaApplication8\\src\\realchicken.png");
    ImageIcon catt = new ImageIcon("C:\\Users\\cihad\\Desktop\\dersler\\Yeni klasör\\java\\JavaApplication8\\src\\cat3.png");
    
    
    public JavaApplication8() {
        JFrame jframe = new JFrame();
        Timer timer = new Timer(5, this);
        render = new Render();
        rand = new Random();
        
        targetLeft = new ArrayList<Rectangle>();
        targetRight = new ArrayList<Rectangle>();
        egg = new ArrayList<Egg>();
        image = new ArrayList<Background>();
        cat = new ArrayList<Cat>();

        
        jframe.add(render);
        jframe.addKeyListener(this);
        jframe.setSize(width, height);
        jframe.setVisible(true);
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        addBackground();
        addBackground();
        
       
        
        addTargetLeft();
        addTargetRight();
        addTargetLeft();
        addTargetRight();
        addTargetLeft();
        addTargetRight();
        addTargetLeft();
        addTargetRight();
        addTargetLeft();
        addTargetRight();
        addTargetLeft();
        addTargetRight();
        addTargetLeft();
        addTargetRight();
        addTargetLeft();
        addTargetRight();
        
        addCat();
        
        
        timer.start();
        
    }
    
    public void addTargetLeft(){
        int space = 50 + rand.nextInt(400);
        int widthTarget = 20;
        int heightTarget = 20;
        targetLeft.add(new Rectangle(0, width+space+targetLeft.size()*100, widthTarget, heightTarget));
        //space = 50 + rand.nextInt(400);
        //target.add(new Rectangle(width-40, width+space+target.size()*100, widthTarget, heightTarget));
    }
    
    public void addTargetRight(){
        int space = 50 + rand.nextInt(400);
        int widthTarget = 20;
        int heightTarget = 20;
        //targetRight.add(new Rectangle(0, width+space+target.size()*100, widthTarget, heightTarget));
        //space = 50 + rand.nextInt(400);
        targetRight.add(new Rectangle(width-40, width+space+targetRight.size()*100, widthTarget, heightTarget));
    }
    public void addBackground(){
        
        image.add(new Background(index));
        index++;
    }
    
    
    public void paintBackground(Graphics g, Background b){
        
        g.drawImage(b.i.getImage(), 0, (b.By)*height+move, width, height, render);
        
    }
    
    public void paintTarget(Graphics g, Rectangle r){
        g.setColor(Color.black);
        g.fillRect(r.x, r.y, r.width, r.height);
    }
    
    public void addEgg(int dir){
        egg.add(new Egg(dir));
    }
    
    public void addCat(){
        cat.add(new Cat());
    }
    
    public void paintEgg(Graphics g, Egg e){
        g.setColor(Color.blue);
        g.drawImage(eggs.getImage(), e.r.x, e.r.y, e.r.width, e.r.height, null);
    }
    
    public void paintCat(Graphics g, Cat c){
        g.setColor(Color.yellow);
        //g.fillRect(c.r.x, c.r.y, c.r.width, c.r.height);
        g.drawImage(catt.getImage(), c.r.x, c.r.y, c.r.width, c.r.height, null);
    }
    
    
    void repaint(Graphics g){
        //background
        //g.setColor(Color.green);
        //g.fillRect(0, 0, width, height);
        //bird
        g.setColor(Color.red);
        g.fillRect(180, 100, 20, 20);
        //background
        for(Background imagess : image ){
            paintBackground(g, imagess);
        }
        //bird
        g.drawImage(resim.getImage(), 180, 90, 50, 50, null);
        //target
        for(Rectangle targetss : targetLeft){
            paintTarget(g, targetss);
        }
        for(Rectangle targetss : targetRight){
            paintTarget(g, targetss);
        }
        //egg
        for(Egg eggs : egg){
            paintEgg(g, eggs);
        }
        //cat
        for(Cat cats : cat){
            paintCat(g, cats);
        }
        //score
        g.setColor(Color.white);
        g.drawString("Score : "+score, 150, 20);
        //bitti
        if(score >= 10){
            g.setColor(Color.white);
            g.drawString("Oyun Bitti", 150, 300);
        }
        
         
        
       
        
        
        //addBackground();
        //addBackground();
        
        //addTarget();
        //addTarget();
        //addTarget();
        //addTarget();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        double speed = 1;
        move -= speed;
        randSure = 50 + rand.nextInt(350);
        if(randSure == sure){
            addCat();
            
        }
        
        for(int i=0; i<targetLeft.size(); i++){
            Rectangle targets = targetLeft.get(i);
            targets.y -=speed;
        }
        
        for(int i=0; i<targetRight.size(); i++){
            Rectangle targets = targetRight.get(i);
            targets.y -=speed;
        }
        
        for(int i=0; i<cat.size(); i++){
            Cat cats = cat.get(i);
            cats.r.y -=speed;
        }
        
        
        
        for(int i=0; i<targetLeft.size(); i++){
            Rectangle targets = targetLeft.get(i);
            if(targets.y<0){
                System.out.println("TargetLeft: "+ targetLeft.size());
                targetLeft.remove(targets);
                
                    addTargetLeft();
        
                
            }
        }
        
        
        for(int i=0; i<targetRight.size(); i++){
            Rectangle targets = targetRight.get(i);
            if(targets.y<0){
                System.out.println("TargetRight: "+ targetRight.size());
                targetRight.remove(targets);
                
                    addTargetRight();
                
            }
        }
        
        
        
        for(Egg eggs : egg){
            if(eggs.direct == 1){
                eggs.r.x -= 10;
               
            }
            else if(eggs.direct == 2){
                eggs.r.x += 10;
            }
        }
        for(Egg eggs : egg){
            for(int i=0; i<targetLeft.size(); i++){
                Rectangle targets = targetLeft.get(i);
                if(eggs.r.intersects(targets)){
                    
                    targetLeft.remove(targets);
                    score+=1;
                }
            }
        }
        
        for(Egg eggs : egg){
            for(int i=0; i<targetRight.size(); i++){
                Rectangle targets = targetRight.get(i);
                if(eggs.r.intersects(targets)){
                    
                    targetRight.remove(targets);
                    score+=1;
                }
            }
        }
        
        for(int i=0; i<image.size(); i++){
            Background bg = image.get(i);
            if(((bg.By)*height+move)+600 <0){
                System.out.println(image.size());
                image.remove(bg);
                addBackground();
            }
        }
        
        for(int i=0; i<egg.size(); i++){
            Egg eggs = egg.get(i);
            if(eggs.r.x <0 || eggs.r.x>400){
                egg.remove(eggs);
            }
        }
        
        
        render.repaint();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            throwing = true;
            addEgg(2);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            throwing = true;
            addEgg(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public static void main(String[] args){
        javaapplication = new JavaApplication8();
    }

    
    
    
}
