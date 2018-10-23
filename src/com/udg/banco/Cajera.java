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
import javax.swing.JTextArea;

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
    private int position;
    
    public Cajera(Container pane, int position){
        this.position = position;
        this.pane = pane;
        this.estaOcupada = false;
        this.energia = 100;
        this.random = new Random();
        setPreferredSize(new Dimension(300,80)); 
        this.setText(labelText()); 
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-mujer-de-negocios-48.png"))); 
             
        
    }
    
    public static void setTimeout(Runnable runnable, int delay){
    
    }
      
    public boolean getEstaOcupada(){
        return this.estaOcupada;
    }
    
    public void start(JTextArea txtTransaccion){
        new Thread(() -> {
                try {    
                    
                    while (true) {
                        clientes.get(clientes.size()-1).setBounds(650, position, 150, 50);
                        int rand = random.nextInt(2000-500)+500;
                        Thread.sleep(rand);
                        Cliente cliente = clientes.get(clientes.size()-1);
                        cliente.end();
                        cliente.setVisible(false);
                        clientes.remove(cliente);
                        
                        pane.remove(cliente);
                        MainWindow.posicionInicial += 30;
                        
                        switch(cliente.getTransaccion()){
                            case "Deposito": saldo += cliente.getValor();
                            case "Retiro": 
                                if(cliente.getValor()<saldo)saldo -= cliente.getValor();
                                else {
                                    Boveda.retirarSaldo(cliente.getValor());                                    
                                }
                        }
                        
                        txtTransaccion.append("Cliente atendido despues de " + cliente.timeAwaiting +" Sec.\n"
                                + "Transacción: "+ cliente.getTransaccion() + "\n"
                                + "Valor: "+ cliente.getValor() + "\n"
                        );
                        if(saldo>9000){
                            Boveda.addSaldo(saldo-500);
                            saldo=500;
                        }
                        
                        if(rand<1000) energia -= 10;
                        else if(rand>1000&&rand<1500) energia -=20;
                        else if(rand>1500) energia-=30;
                        if(energia<=30){
                           this.setText("<html>Recargado<br>Energia</html>");
                           Thread.sleep(2000);
                           energia = 100;
                        }
                        this.clientesAtendidos++;
                        this.setText(labelText());
                        
                            
                            
                            
                        
                    }                  
                } catch (Exception exception) {
                    start(txtTransaccion);
                }
            }).start();
    }
    
    private String labelText(){
        return "<html>Atendidos: "+
                clientesAtendidos+"<br> E =" 
                + energia+"%<br> Saldo:"+saldo+"</html>";
    }
    
    
    
}
