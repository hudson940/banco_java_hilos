/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udg.banco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author anderson
 */
public class Cliente extends JLabel {

    public int timeAwaiting;
    boolean isLost;
    Clock clock;
    private int position;
    private String transaccion;
    private int valor;

    public Cliente(int position) {
        super();
        // asignar aleatoriamente la transacción a realizar
        if (new Random().nextBoolean()) {
            transaccion = "Deposito";
        } else {
            transaccion = "Retiro";
        }

        // asigna aleatroriamente el valor de la transacción
        valor = new Random().nextInt(35000 - 5000) + 5000;

        this.position = position;
        isLost = false;
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-jajaja-40.png")));
        clock = new Clock(0, 0, 0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                timeAwaiting++;
                if (timeAwaiting > 60 && timeAwaiting < 210) {
                    setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-aburrido-48.png")));
                } else if (timeAwaiting > 210) {
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

    public String getTransaccion() {
        return transaccion;
    }

    public int getValor() {
        return valor;
    }

    public boolean getIsLost() {
        return isLost;
    }

    public void end() {
        clock.stop();
    }

    public int getPosition() {
        return this.position;
    }

}
