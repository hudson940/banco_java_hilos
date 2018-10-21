package com.udg.cucea;

public class AccionesBancarias extends CuentaHabiente {
    private Tarjeta tarjeta;

    public AccionesBancarias(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
        
    public boolean deposita(float cantidad) {
        boolean exito = false;
        try {
            this.setDinero(this.getDinero() + cantidad);
            exito = true;            
        } catch (Exception es) { exito =  false;  }  
        return exito;          
    }    
    
    public boolean retira(float cantidad) {
        boolean exito = false;
        try {
            float temp = this.getDinero();
            if (temp >= (this.getDinero() - cantidad)) {
                System.out.println("Transaccion completada");            
                this.setDinero(this.getDinero() - cantidad);
                exito = true;            
            }
        } catch (Exception es) { exito =  false;  }  
        return exito;          
    }
    
    public boolean isNIPValida(String nip) {
         return this.getNip().equals(nip);
    }
    
    public boolean isUsuarioValido(String user, String pass) {
         return (this.getLogin().equals(user) && this.getPassword().equals(pass));
    }
    
    public boolean doTransaccion(String numeroCuentaRemota, String numeroCuentaLocal, 
            float monto) {
         boolean exito = false;
         int longitud = numeroCuentaRemota.length();
         if (longitud == 16) {
             if (numeroCuentaRemota.startsWith("4")) {
                 System.out.println("Es Mastercard");
             } else {
                 if (numeroCuentaRemota.startsWith("5")) {
                     System.out.println("Es Visa");
                 } else {
                     if (numeroCuentaRemota.startsWith("3")) {
                         System.out.println("Es American Express");
                     }
                }
                if (retira(monto)) {
                    System.out.println("Adicionando dinero a la cuenta: " + 
                            numeroCuentaRemota + ", la cantidad de: $" + monto);
                    exito = true;
                } else {
                    System.out.println("Credito insuficiente");
                    exito = false;
                }
             }
         }
         return exito;
    }
    
    public void insertarTarjeta() {
        tarjeta.setEstaSiendoProcesada(true);
    }
    
    public void liberarTarjeta() {
        tarjeta.setEstaSiendoProcesada(false);
    }
}
