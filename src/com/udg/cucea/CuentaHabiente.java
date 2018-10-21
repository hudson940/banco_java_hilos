package com.udg.cucea;

import java.util.Date;

public class CuentaHabiente {
    private long    numeroCuenta;
    private String  nip;
    private String  login;
    private String  password;
    private boolean estaHabilitado;
    private float   dinero;
    private Date    fecha_operacion;
    private int     operacion;

    /**
     * @return the numeroCuenta
     */
    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * @return the nip
     */
    public String getNip() {
        return nip;
    }

    /**
     * @param nip the nip to set
     */
    public void setNip(String nip) {
        this.nip = nip;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the estaHabilitado
     */
    public boolean isEstaHabilitado() {
        return estaHabilitado;
    }

    /**
     * @param estaHabilitado the estaHabilitado to set
     */
    public void setEstaHabilitado(boolean estaHabilitado) {
        this.estaHabilitado = estaHabilitado;
    }

    /**
     * @return the dinero
     */
    public float getDinero() {
        return dinero;
    }

    /**
     * @param dinero the dinero to set
     */
    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    /**
     * @return the fecha_operacion
     */
    public Date getFecha_operacion() {
        return fecha_operacion;
    }

    /**
     * @param fecha_operacion the fecha_operacion to set
     */
    public void setFecha_operacion(Date fecha_operacion) {
        this.fecha_operacion = fecha_operacion;
    }

    /**
     * @return the operacion
     */
    public int getOperacion() {
        return operacion;
    }

    /**
     * @param operacion the operacion to set
     */
    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }
   
}
