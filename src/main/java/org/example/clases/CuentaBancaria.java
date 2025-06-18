package org.example.clases;

public class CuentaBancaria {
    private String titular;
    private Double saldo;

    public CuentaBancaria(String titular, Double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }
    public void depositar(Double monto) {
        if(monto <= 0) {
            System.out.println("no se puede depositar");
            return;
        }
        saldo += monto;
        System.out.println("Se depositaron " + monto + ". Nuevo saldo: " + saldo);
    }

    public void retirar(Double monto) {
        if(monto <= 0) {
            System.out.println("no se puede retirar");
            return;
        }
        if (saldo < monto){
            System.out.println("Saldo insuficiente");
            return;
        }
        saldo -= monto;
        System.out.println("Se retiraron " + monto + ". Nuevo saldo: " + saldo);

    }
    public void mostrarInformacion() {
        System.out.println("Titular: " + titular + "\nSaldo: " + saldo);
    }

    public Double getSaldo() {
        return saldo;
    }
}
