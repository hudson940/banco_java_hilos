/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udg.banco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author anderson
 */
public class Cliente extends JLabel{
    
    public int timeAwaiting;
    boolean isLost;
    Clock clock;
    
    public Cliente(){
        super();
        isLost = false;
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-jajaja-40.png")));
       clock = new Clock(0,0,0, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) { 
                System.out.println(timeAwaiting++);
               if(timeAwaiting>60)
                   setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-aburrido-48.png")));
               else if (timeAwaiting>210){
                   setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-enojado-40.png")));
                   isLost = true;

               }
                   
            }
        
            
        });
        
        new Timer(false).schedule(new TimerTask() {
            @Override
            public void run() {
                clock.start();
            }
        }, 0);
    }
    
    public boolean getIsLost(){
        return isLost;
    }
    
}


