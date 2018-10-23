package com.udg.banco;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MueveCliente extends Thread{
    private JLabel componente;
    private JTextArea txtTransaccion;
    private int    limite;

    public MueveCliente(JLabel componente, JTextArea txtTransaccion, int limite) {
        this.componente = componente;
        this.txtTransaccion = txtTransaccion;
        this.limite     = limite;
    }
    
    public int getLimite() {
        return this.limite;
    }
    
    public void run() {
        txtTransaccion.append("Una vez lo hago\n");
        limite = limite + 200;
    }
    
}
