package ar.edu.unju.escmi.tp2.ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<String, Empleado> empleados = new HashMap<>();

        int opcion;

        do {

            System.out.println("\n===== MENU DE EMPLEADOS =====");
            System.out.println("1 - Alta de empleado");
            System.out.println("2 - Mostrar empleados");
            System.out.println("3 - Eliminar empleado");
            System.out.println("4 - Consultar los datos de un empleado");
            System.out.println("5 - Salir");

            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("\n===== ALTA DE EMPLEADO =====");

                    System.out.print("Ingrese el DNI: ");
                    int dni = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el apellido: ");
                    String apellido = scanner.nextLine();

                    System.out.print("Ingrese el sueldo: ");
                    double sueldo = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Ingrese la categoria: ");
                    char categoria = scanner.nextLine().charAt(0);

                    String clave = dni + String.valueOf(categoria);

                    if (empleados.containsKey(clave)) {

                        System.out.println(
                                "Ya existe un empleado con esa clave."
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

                    System.out.println("\n===== EMPLEADOS =====");

                    if (empleados.isEmpty()) {

                        System.out.println(
                                "No hay empleados registrados."
                        );

                    } else {

                        Iterator<Map.Entry<String, Empleado>> iterator =
                                empleados.entrySet().iterator();

                        while (iterator.hasNext()) {

                            Map.Entry<String, Empleado> entrada =
                                    iterator.next();

                            System.out.println(
                                    "Clave: " + entrada.getKey()
                            );

                            System.out.println(
                                    "Valor: " + entrada.getValue()
                            );

                            System.out.println("-------------------------");
                        }
                    }

                    break;

                case 3:

                    System.out.println("\n===== ELIMINAR EMPLEADO =====");

                    if (empleados.isEmpty()) {

                        System.out.println(
                                "No hay empleados registrados."
                        );

                    } else {

                        System.out.print("Ingrese la clave del empleado: ");
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
                    }

                    break;

                case 4:

                    System.out.println("\n===== CONSULTAR EMPLEADO =====");

                    if (empleados.isEmpty()) {

                        System.out.println(
                                "No hay empleados registrados."
                        );

                    } else {

                        System.out.print("Ingrese la clave del empleado: ");
                        String claveBuscar = scanner.nextLine();

                        if (empleados.containsKey(claveBuscar)) {

                            Empleado empleadoEncontrado =
                                    empleados.get(claveBuscar);

                            System.out.println(
                                    "Clave: " + claveBuscar
                            );

                            System.out.println(
                                    "Datos: " + empleadoEncontrado
                            );

                        } else {

                            System.out.println(
                                    "No existe un empleado con esa clave."
                            );
                        }
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