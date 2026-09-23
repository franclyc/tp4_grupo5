package ar.edu.unju.escmi.tp2.ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Empleado> empleados = new HashMap<>();

        int opcion;

        do {
            System.out.println("\n--- MENU DE EMPLEADOS ---");
            System.out.println("1 - Alta de empleado");
            System.out.println("2 - Mostrar empleados");
            System.out.println("3 - Eliminar empleado");
            System.out.println("4 - Consultar los datos de un empleado");
            System.out.println("5 - Salir");
            System.out.print("Ingrese una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Debe ingresar un numero de opcion.");
                scanner.nextLine();
                System.out.print("Ingrese una opcion: ");
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Ingrese DNI: ");

                    while (!scanner.hasNextInt()) {
                        System.out.println("El DNI debe ser un numero entero.");
                        scanner.nextLine();
                        System.out.print("Ingrese DNI: ");
                    }

                    int dni = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese apellido: ");
                    String apellido = scanner.nextLine();

                    System.out.print("Ingrese sueldo: ");

                    while (!scanner.hasNextDouble()) {
                        System.out.println("El sueldo debe ser un numero.");
                        scanner.nextLine();
                        System.out.print("Ingrese sueldo: ");
                    }

                    double sueldo = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Ingrese categoria: ");
                    String categoriaIngresada = scanner.nextLine();

                    while (categoriaIngresada.length() != 1) {
                        System.out.println("La categoria debe ser un solo caracter.");
                        System.out.print("Ingrese categoria: ");
                        categoriaIngresada = scanner.nextLine();
                    }

                    char categoria = categoriaIngresada.charAt(0);

                    String clave = dni + String.valueOf(categoria);

                    if (empleados.containsKey(clave)) {

                        System.out.println(
                            "Ya existe un empleado con la clave " + clave + "."
                        );

                    } else {

                        Empleado empleado = new Empleado(
                            dni,
                            nombre,
                            apellido,
                            sueldo,
                            categoria
                        );

                        empleados.put(clave, empleado);

                        System.out.println(
                            "Empleado agregado correctamente."
                        );
                    }

                    break;

                case 2:

                    if (empleados.isEmpty()) {

                        System.out.println("No hay empleados cargados.");

                    } else {

                        Iterator<String> it =
                            empleados.keySet().iterator();

                        while (it.hasNext()) {

                            String claveEmpleado = it.next();

                            System.out.println(
                                "Clave: " + claveEmpleado +
                                " -> " +
                                empleados.get(claveEmpleado)
                            );
                        }
                    }

                    break;

                case 3:

                    System.out.print(
                        "Ingrese la clave del empleado a eliminar: "
                    );

                    String claveEliminar = scanner.nextLine();

                    if (empleados.containsKey(claveEliminar)) {

                        empleados.remove(claveEliminar);

                        System.out.println(
                            "Empleado eliminado correctamente."
                        );

                    } else {

                        System.out.println(
                            "No existe un empleado con esa clave."
                        );
                    }

                    break;

                case 4:

                    System.out.print(
                        "Ingrese la clave del empleado a consultar: "
                    );

                    String claveConsultar = scanner.nextLine();

                    if (empleados.containsKey(claveConsultar)) {

                        Empleado empleado =
                            empleados.get(claveConsultar);

                        System.out.println(
                            "Datos del empleado:"
                        );

                        System.out.println(empleado);

                    } else {

                        System.out.println(
                            "No existe un empleado con esa clave."
                        );
                    }

                    break;

                case 5:

                    System.out.println(
                        "Programa finalizado."
                    );

                    break;

                default:

                    System.out.println(
                        "Opcion no valida."
                    );
            }

        } while (opcion != 5);

        scanner.close();
    }
}