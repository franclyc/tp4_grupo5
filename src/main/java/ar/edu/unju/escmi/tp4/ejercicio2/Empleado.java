package ar.edu.unju.escmi.tp2.ejercicio2;

public class Empleado {

    private int dni;
    private String nombre;
    private String apellido;
    private double sueldo;
    private char categoria;

    public Empleado(int dni, String nombre, String apellido, double sueldo, char categoria) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.categoria = categoria;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getSueldo() {
        return sueldo;
    }

    public char getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "DNI: " + dni +
               " - Nombre: " + nombre +
               " - Apellido: " + apellido +
               " - Sueldo: " + sueldo +
               " - Categoria: " + categoria;
    }
}