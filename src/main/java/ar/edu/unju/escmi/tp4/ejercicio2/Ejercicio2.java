package ar.edu.unju.escmi.tp2.ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Map<String, Empleado> empleados = new HashMap<>();

        int opcion;

        do {

            System.out.println("--- MENU EMPLEADOS ---");
            System.out.println("1 - Alta de empleado");
            System.out.println("2 - Mostrar empleados");
            System.out.println("3 - Eliminar empleado");
            System.out.println("4 - Consultar datos de un empleado");
            System.out.println("5 - Salir");
            System.out.print("Ingrese una opcon: ");

            while (!teclado.hasNextInt()) {
                System.out.println("La opcion debe ser un numero");
                teclado.nextLine();
                System.out.print("Ingrese una opcion: ");
            }

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 1:

                    int dni;

                    do {
                        System.out.print("Ingrese DNI: ");

                        while (!teclado.hasNextInt()) {
                            System.out.println("El DNI debe contener solamente numeros");
                            teclado.nextLine();
                            System.out.print("Ingrese DNI: ");
                        }

                        dni = teclado.nextInt();
                        teclado.nextLine();

                        if (dni <= 0) {
                            System.out.println("El DNI debe ser mayor que 0.");
                        }

                    } while (dni <= 0);


                    String nombre;

                    do {
                        System.out.print("Ingrese nombre: ");
                        nombre = teclado.nextLine().trim();

                        if (nombre.isEmpty()) {
                            System.out.println("El nombre no puede estar vacio");
                        }

                    } while (nombre.isEmpty());


                    String apellido;

                    do {
                        System.out.print("Ingrese apellido: ");
                        apellido = teclado.nextLine().trim();

                        if (apellido.isEmpty()) {
                            System.out.println("El apellido no puede estar vacio");
                        }

                    } while (apellido.isEmpty());


                    double sueldo;

                    do {
                        System.out.print("Ingrese sueldo: ");

                        while (!teclado.hasNextDouble()) {
                            System.out.println("El sueldo debe ser numerico");
                            teclado.nextLine();
                            System.out.print("Ingrese sueldo: ");
                        }

                        sueldo = teclado.nextDouble();
                        teclado.nextLine();

                        if (sueldo < 0) {
                            System.out.println("El sueldo no puede ser negativo");
                        }

                    } while (sueldo < 0);


                    char categoria;

                    do {
                        System.out.print("Ingrese categoria: ");

                        String entrada = teclado.nextLine().trim().toUpperCase();

                        if (entrada.length() == 1 &&
                                Character.isLetter(entrada.charAt(0))) {

                            categoria = entrada.charAt(0);

                        } else {

                            categoria = ' ';

                            System.out.println(
                                    "La categori debe ser una sola letra"
                            );
                        }

                    } while (categoria == ' ');


                    String clave = dni + String.valueOf(categoria);


                    if (empleados.containsKey(clave)) {

                        System.out.println(
                                "Ya existe un empleado con esa combinacion de DNI y categoria"
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
                                "Empleado agregado correctamente"
                        );
                    }

                    break;


                case 2:

                    if (empleados.isEmpty()) {

                        System.out.println("No hay empleados cargados");

                    } else {

                        Iterator<String> it =
                                empleados.keySet().iterator();

                        while (it.hasNext()) {

                            String claveEmpleado = it.next();

                            Empleado empleado =
                                    empleados.get(claveEmpleado);

                            System.out.println(
                                    "Clave: " + claveEmpleado
                                    + " -> Valor: " + empleado
                            );
                        }
                    }

                    break;


                case 3:

                    System.out.print(
                            "Ingrese la clave del empleado a eliminar: "
                    );

                    String claveEliminar =
                            teclado.nextLine().trim();

                    if (empleados.containsKey(claveEliminar)) {

                        empleados.remove(claveEliminar);

                        System.out.println(
                                "Empleado eliminado correctamente"
                        );

                    } else {

                        System.out.println(
                                "No existe un empleado con esa clave"
                        );
                    }

                    break;


                case 4:

                    System.out.print(
                            "Ingrese la clave del empleado a consultar: "
                    );

                    String claveConsultar =
                            teclado.nextLine().trim();

                    if (empleados.containsKey(claveConsultar)) {

                        Empleado empleado =
                                empleados.get(claveConsultar);

                        System.out.println(
                                "Datos del empleado:"
                        );

                        System.out.println(empleado);

                    } else {

                        System.out.println(
                                "No existe un empleado con esa clave"
                        );
                    }

                    break;


                case 5:

                    System.out.println(
                            "Programa finalizado"
                    );

                    break;


                default:

                    System.out.println(
                            "Opcion invalida. Ingrese un numero del 1 al 5"
                    );
            }

        } while (opcion != 5);

        teclado.close();
    }
}