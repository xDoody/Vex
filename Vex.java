/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vex;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Zakki
 */
public class Vex extends Canvas implements Runnable {

    /**
     * @param args the command line arguments
     */
    boolean running;
    private Thread thread;
    int WIDTH =600;
    int HEIGHT=600;
    int num=1000;
    Random rand = new Random();
    Handler handler;
    BufferedImage img = null;
    BufferedImageOp ime;
    ImageObserver io;
    public Vex(){
        Display display = new Display(WIDTH,HEIGHT,this);
        
        this.handler=new Handler();
        Control1 control = new Control1(WIDTH,HEIGHT,handler,this);
        try{
            img=ImageIO.read(new File("C:\\Users\\Zakki\\Desktop\\droplet.png"));
            ime.filter(img, null);
            io=null;
        }catch(Exception e){}
        addOb(num);
        control.update();
        
    }
    
    public void addOb(int num){
    for(int i =0;i<num;i++){
            int a=rand.nextInt(WIDTH)+1;
            int b=rand.nextInt(HEIGHT)+1;
            float f=rand.nextFloat()-0.004f;
            handler.addObject(new Drop(a,b,ID.Drop,WIDTH,HEIGHT,rand,f,img,io));
        }
    }
    
    public static void main(String[] args) {
        Vex vex = new Vex();
    }
    public synchronized void  start(){
        thread = new Thread(this);
        thread.start();
        running=true;
    }
    public synchronized void stop(){
        try{
            thread.join();
            running=false;
        }
        catch(Exception e){
        }
    
    }
    public void tick(){
        handler.tick();
    }
    @Override
    public void run(){
        
        long lastTime=System.nanoTime();
        double amountOfTicks=60.0;
        double ns=100000000/amountOfTicks;
        double delta=0;
        while(running){
            long now = System.nanoTime();
            delta +=(now-lastTime)/ns;
            lastTime=now;
            while(delta>=1){
                tick();
                delta--;
            }
            if(running)
                render();   
        }
            stop();
    }
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs==null)
        {
            this.createBufferStrategy(3);
            return;
        }
        Graphics2D g = (Graphics2D) bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(g);
        g.dispose();
        bs.show();
}
    
    
    
}
