package ar.edu.unju.escmi.tp4.ejercicio5;

import java.time.LocalDate;

public class Producto {

    private String descripcion;
    private double precio;
    private LocalDate fechaVencimiento;

    public Producto(String descripcion, double precio, LocalDate fechaVencimiento) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return  "Descripcion: " + descripcion + "\n" +
                "Precio: " + precio + "\n" +
                "Vencimiento: " + fechaVencimiento + "\n";
    }

}