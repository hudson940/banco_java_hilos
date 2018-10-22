/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udg.banco;

import static com.udg.banco.MainWindow.clientes;
import java.awt.Container;
import java.awt.Dimension;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author anderson
 */
public class Cajera extends JLabel {
    
    private int clientesAtendidos;
    private int energia;
    private int saldo;
    private boolean estaOcupada;
    private Random random;
    Container pane;
    
    public Cajera(Container pane){
        this.pane = pane;
        this.estaOcupada = false;
        this.energia = 100;
        this.random = new Random();
        this.setText("Atendidos: ");
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-mujer-de-negocios-48.png"))); 
        setPreferredSize(new Dimension(130,40));      
        
    }
    
    public static void setTimeout(Runnable runnable, int delay){
    
    }
    
    public void atender(Cliente cliente){
        this.estaOcupada = true;
        new Thread(() -> {
        try {
            Thread.sleep(random.nextInt(2000-500)+500);
            cliente.end();
            cliente.setVisible(false);
            clientes.remove(cliente);
            pane.remove(cliente);
            System.out.println("atendiendo cliente con espera de" + cliente.timeAwaiting);
            this.setText("Atendidos: "+this.clientesAtendidos);
            this.estaOcupada = false;
        }
        catch (Exception e){
            System.err.println(e);
        }
         }).start();
        
       
       
        
    }
    
    public boolean getEstaOcupada(){
        return this.estaOcupada;
    }
    
    public void start(){
        new Thread(() -> {
                try {                   
                    while (true) {
                        Thread.sleep(random.nextInt(2000-500)+500);
                        Cliente cliente = clientes.get(clientes.size()-1);
                        cliente.end();
                        cliente.setVisible(false);
                        clientes.remove(cliente);
                        pane.remove(cliente);
                        System.out.println("atendiendo cliente con espera de" + cliente.timeAwaiting);
                        this.setText("Atendidos: "+this.clientesAtendidos++);
                            
                            
                            
                        
                    }                  
                } catch (Exception exception) {

                }
            }).start();
    }
    
    
    
}
