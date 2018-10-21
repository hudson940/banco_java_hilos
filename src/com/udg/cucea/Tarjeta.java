package com.udg.cucea;

public class Tarjeta {
   private String    numeroTarjeta;
   private String    fecha_venc;
   private int       tipodePlastico;
   private boolean   estaSiendoProcesada;
   private boolean   estaRepetida;

    public Tarjeta(String numeroTarjeta, String fecha_venc, int tipodePlastico, boolean estaSiendoProcesada, boolean estaRepetida) {
        this.numeroTarjeta = numeroTarjeta;
        this.fecha_venc = fecha_venc;
        this.tipodePlastico = tipodePlastico;
        this.estaSiendoProcesada = estaSiendoProcesada;
        this.estaRepetida = estaRepetida;
    }
   
    /**
     * @return the numeroTarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * @param numeroTarjeta the numeroTarjeta to set
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * @return the fecha_venc
     */
    public String getFecha_venc() {
        return fecha_venc;
    }

    /**
     * @param fecha_venc the fecha_venc to set
     */
    public void setFecha_venc(String fecha_venc) {
        this.fecha_venc = fecha_venc;
    }

    /**
     * @return the tipodePlastico
     */
    public int getTipodePlastico() {
        return tipodePlastico;
    }

    /**
     * @param tipodePlastico the tipodePlastico to set
     */
    public void setTipodePlastico(int tipodePlastico) {
        this.tipodePlastico = tipodePlastico;
    }

    /**
     * @return the estaSiendoProcesada
     */
    public boolean isEstaSiendoProcesada() {
        return estaSiendoProcesada;
    }

    /**
     * @param estaSiendoProcesada the estaSiendoProcesada to set
     */
    public void setEstaSiendoProcesada(boolean estaSiendoProcesada) {
        this.estaSiendoProcesada = estaSiendoProcesada;
    }

    /**
     * @return the estaRepetida
     */
    public boolean isEstaRepetida() {
        return estaRepetida;
    }

    /**
     * @param estaRepetida the estaRepetida to set
     */
    public void setEstaRepetida(boolean estaRepetida) {
        this.estaRepetida = estaRepetida;
    }
   
   
}
