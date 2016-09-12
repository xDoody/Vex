/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vex;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Random;

/**
 *
 * @author Zakki
 */
public class Drop extends GameObject {
    int WIDTH;
    int HEIGHT;
    Random rand;
    BufferedImage img;
    ImageObserver io;
    AlphaComposite ac;
    float opacity;
    public Drop(float x, float y, ID id,int WIDTH,int HEIGHT,Random rand,float f,BufferedImage img,ImageObserver io) {
        super(x, y, id);
        this.WIDTH=WIDTH;
        this.HEIGHT=HEIGHT;
        this.rand = rand;
        this.img=img;
        this.io=io;
        setVelY(f);

        opacity=0.5f;
        ac= AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
    }

    @Override
    public void tick() {
        if(velY!=0)
            velY=(float) (velY+0.0008);
        //velY=(float) (velY+0.007);
        y=y+this.getVelY();
        if(y>HEIGHT && y!=0){

            y=rand.nextInt(10)+1;
            x=rand.nextInt(WIDTH)+1;
            velY=rand.nextFloat();
        }
        if(x>WIDTH || x<0)
        {
            x=rand.nextInt(WIDTH)+1;
        }

    }

    @Override
    public void render(Graphics2D g) {

    g.setComposite(ac);
    g.drawImage(img, (int)x,(int) y, io);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,32,32);
    }
    
}
