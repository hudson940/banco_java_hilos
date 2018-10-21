/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udg.banco;

import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author anderson
 */
public class Clock extends Timer{
    private final int TURN = 60;
    private final int TURN_HOUR = 12;
    private int hour , minutes ,seconds;
            
    /**
     * Iniciar relog en una hora especifica
     * @param initHour
     * @param initMin
     * @param initSec
     */
    public Clock(int initHour , int initMin ,int initSec, ActionListener al ) {
       super(1000, al);
       this.hour = initHour;
       this.minutes = initMin;
       this.seconds = initSec;
    }
    
    /**
     * Iniciar relog a las 9:00
     * @param al
     */
    public Clock(ActionListener al){
       super(1000, al);
       this.hour = 9;
       this.minutes = 0;
       this.seconds = 0;
    }
    
    public String time(){
        if(this.seconds < TURN) this.seconds++;
        else {
            this.seconds = 0;
            if(this.minutes < TURN) this.minutes++;
            else {
                this.minutes = 0;
                if(this.hour < TURN_HOUR) this.hour++;
                else this.hour = 0;
                
            }
        }
        
        
        return this.to_string();
    }
    
    public String to_string(){
        String sMinutes = (this.minutes<10)?":0"+this.minutes:":"+this.minutes;
        String sSeconds = (this.seconds<10)?":0"+this.seconds:":"+this.seconds;
        return this.hour+sMinutes+sSeconds;
        
    }
    
}
