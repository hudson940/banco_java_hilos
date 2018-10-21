/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udg.banco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author L-204
 */
public class MainWindow extends javax.swing.JFrame  implements Observer{

    /**
     * Creates new form MainWindow
     */
    private ObservableDemo weatherUpdate;
    private Clock clock;
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private Timer clientTimer;
   
    public MainWindow() {
        initComponents();
        inicializa();
    }
    
    private void inicializa() {
        
        // inicia clientes
        clientTimer = new Timer(300,  new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Cliente c = new Cliente();
                clientes.add(c);
                getContentPane().add(c);
                c.setBounds(posicionInicial , 100, 40, 50); 
                c.setLocation(posicionInicial -=30, c.getY());
                
                clientsLabel.setText("Clientes: "+clientes.size());
                
            } catch(Exception ex){
                System.out.println(ex.toString());
            }
           
           
        }
        });
        
        
        
        img01.setVisible(false);
        
        // instanciar reloj
        clock = new Clock(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            clockLabel.setText(clock.time());
        }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        clientsLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        img01 = new javax.swing.JLabel();
        img05 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTransacciones = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        clockLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Banco \"La mafia del poder\"");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(180, 10, 480, 60);

        clientsLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clientsLabel.setForeground(new java.awt.Color(153, 153, 255));
        clientsLabel.setText("Clientes: ");
        getContentPane().add(clientsLabel);
        clientsLabel.setBounds(10, 80, 120, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 51));
        jLabel3.setText("Cajera");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(700, 40, 70, 40);

        img01.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-jajaja-40.png"))); // NOI18N
        getContentPane().add(img01);
        img01.setBounds(550, 100, 40, 50);

        img05.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-mujer-de-negocios-48.png"))); // NOI18N
        getContentPane().add(img05);
        img05.setBounds(700, 90, 50, 50);

        txtTransacciones.setColumns(20);
        txtTransacciones.setRows(5);
        jScrollPane1.setViewportView(txtTransacciones);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 310, 790, 170);

        jLabel9.setText("Transacciones");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 280, 110, 30);

        btnInicio.setText("Iniciar Proceso");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        getContentPane().add(btnInicio);
        btnInicio.setBounds(680, 273, 120, 30);
        getContentPane().add(clockLabel);
        clockLabel.setBounds(370, 200, 90, 30);

        setSize(new java.awt.Dimension(828, 538));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int posicionInicial = 580;
     
    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        try {
            //img01.setLocation(posicionInicial, img01.getY());
           // MueveCliente mv = new MueveCliente(img01, txtTransacciones, posicionInicial);
           //mv.start();
           // Thread.sleep(3);
            //posicionInicial = mv.getLimite();
                      
            // iniciar reloj
            new java.util.Timer(false).schedule(new TimerTask() {
            @Override
            public void run() {
                clock.start();
            }
        }, 0);
            // inicia clientes
            new java.util.Timer(false).schedule(new TimerTask() {
            @Override
            public void run() {
                clientTimer.start();
            }
        }, 0);
            
            
        } catch (Exception ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
      ObservableDemo demo = new ObservableDemo("asoleado");
      demo.addObserver(this);
        System.out.println(demo.getWeather());
        System.out.println("1");
        demo.setWeather("lluvioso");
       System.out.println("3");
        System.out.println(demo.getWeather());
    }//GEN-LAST:event_btnInicioActionPerformed

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("2");
        weatherUpdate = (ObservableDemo)o;
        System.out.println(
                "Weather Report Live. Its "+weatherUpdate.getWeather());
    
    }

 

  class     ObservableDemo extends Observable
  {
    private String weather;
    public ObservableDemo(String weather)
    {
        System.out.println("0");
	this.weather = weather;
    }
    
    public String getWeather()
    {
	    return weather;
    }

    public void setWeather(String weather)
    {
	    this.weather = weather;
            setChanged();
            notifyObservers();
            
    }
  }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInicio;
    private javax.swing.JLabel clientsLabel;
    private javax.swing.JLabel clockLabel;
    private javax.swing.JLabel img01;
    private javax.swing.JLabel img05;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtTransacciones;
    // End of variables declaration//GEN-END:variables
}
