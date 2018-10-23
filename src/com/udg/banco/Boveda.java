/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udg.banco;

/**
 *
 * @author anderson
 */
public class Boveda {
    
    private static int saldo = 50000;

    public static void addSaldo(int deposito) {
        Boveda.saldo += deposito;
    }
    
    public static void retirarSaldo(int retiro) {
        if(saldo<retiro) System.out.println("saldo menos retiro: "+ (saldo-retiro));
        else
        Boveda.saldo -= retiro;
    }
    

    public static int getSaldo() {
        return saldo;
    }
    
    
    
}
