/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vex;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Zakki
 */
    public class Display extends JFrame {
    public Display(int width,int height,Vex vex){
    JFrame frame =new JFrame("Rain");
    frame.setPreferredSize(new Dimension(width,height));
    frame.setMaximumSize(new Dimension(width,height));
    frame.setMinimumSize(new Dimension(width,height));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.add(vex);
    frame.setVisible(true);
    vex.start();
    }
}
