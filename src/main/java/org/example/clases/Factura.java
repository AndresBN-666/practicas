package org.example.clases;

public class Factura {
    private String cliente;
    private Double monto;
    private Double impuesto;


    public Factura(String cliente, Double monto, Double impuesto) {
        if (monto < 0 || impuesto < 0) {
            throw new IllegalArgumentException("Monto e impuesto deben ser positivos.");
        }
        this.cliente = cliente;
        this.monto = monto;
        this.impuesto = impuesto;
    }

    public double calcularTotal(){
        return monto + (monto * impuesto /100);
    }

    public double calcularTotal(Double monto, Double impuesto){
        return monto + (monto * impuesto /100);

    }
}
