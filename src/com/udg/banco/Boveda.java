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
        if (saldo < retiro) {
            // si el saldo de la boveda es 0 el programa se termina
            //System.exit(0);
            System.out.println("saldo boveda: " + (saldo - retiro));
        } else {
            Boveda.saldo -= retiro;
        }
    }

    public static int getSaldo() {
        return saldo;
    }

}
