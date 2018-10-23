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
 * Clase de cajera que extende de JLabel
 */
public class Cajera extends JLabel {

    private int clientesAtendidos;
    private int energia;
    private int saldo;
    private boolean estaOcupada;
    private Random random;
    Container pane;
    private int position;

    public Cajera(Container pane, int position) {
        this.position = position;
        this.pane = pane;
        this.estaOcupada = false;
        this.energia = 100;
        this.random = new Random();
        setPreferredSize(new Dimension(300, 80));
        this.setText(labelText());
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-mujer-de-negocios-48.png")));

    }

    public static void setTimeout(Runnable runnable, int delay) {

    }

    public boolean getEstaOcupada() {
        return this.estaOcupada;
    }

    public void start(JTextArea txtTransaccion) {
        new Thread(() -> {
            try {

                while (true) {
                    // mover el último cliente de la fila hacia la cajera
                    clientes.get(clientes.size() - 1).setBounds(650, position, 150, 50);
                    // genera un numero aleatorio entre 500ms y 2 Minutos
                    int rand = random.nextInt(2000 - 500) + 500;
                    // espera el tiempo de la transacción
                    Thread.sleep(rand);
                    // asigna el cliente para la trasacción al ultimo de la fila 
                    Cliente cliente = clientes.get(clientes.size() - 1);
                    // finaliza el cronometro del cliente
                    cliente.end();
                    // lo hace invisible 
                    cliente.setVisible(false);
                    // lo remueve del arraylist
                    clientes.remove(cliente);
                    // lo remueve del panel
                    pane.remove(cliente);
                    // resta 30 puntos a la ubicacion de la fila de clientes en el panel
                    MainWindow.posicionInicial += 30;
                    // identifica que transacción va a realizar
                    switch (cliente.getTransaccion()) {
                        case "Deposito":
                            saldo += cliente.getValor();
                        case "Retiro":
                            if (cliente.getValor() < saldo) {
                                saldo -= cliente.getValor();
                            } else {
                                Boveda.retirarSaldo(cliente.getValor());
                            }
                    }
                    // imprime en pantalla la transacción
                    txtTransaccion.append("Cliente atendido despues de " + cliente.timeAwaiting + " Sec.\n"
                            + "Transacción: " + cliente.getTransaccion() + "\n"
                            + "Valor: " + cliente.getValor() + "\n"
                    );
                    // valida si supera el tope de efectivo en caja y lo envia a la boveda
                    if (saldo > 9000) {
                        Boveda.addSaldo(saldo - 500);
                        saldo = 500;
                    }
                    // calcula el gasto de energia y lo resta de la energia de la cajera
                    if (rand < 1000) {
                        energia -= 10;
                    } else if (rand > 1000 && rand < 1500) {
                        energia -= 20;
                    } else if (rand > 1500) {
                        energia -= 30;
                    }
                    // si la energia es menor de 30 toma un descanso de 2 Segundos y recarga
                    if (energia <= 30) {
                        this.setText("<html>Recargado<br>Energia</html>");
                        // espera 2 segundos
                        Thread.sleep(2000);
                        energia = 100;
                    }
                    // agrega uno al contador de clientes atendidos
                    this.clientesAtendidos++;
                    // actualiza la información de caja
                    this.setText(labelText());

                }
            } catch (Exception exception) {
                start(txtTransaccion);
            }
        }).start();
    }

    private String labelText() {
        return "<html>Atendidos: "
                + clientesAtendidos + "<br> E ="
                + energia + "%<br> Saldo:" + saldo + "</html>";
    }

}
