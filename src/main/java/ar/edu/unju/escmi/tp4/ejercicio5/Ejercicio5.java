package ar.edu.unju.escmi.tp4.ejercicio5;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Producto> productos = new TreeMap<>();
        int op;

        do{
            System.out.println("\n--- Menú de Productos ---");
            System.out.println("1 - Alta de producto");
            System.out.println("2 - Mostrar productos");
            System.out.println("3 - Buscar producto");
            System.out.println("4 - Eliminar producto");
            System.out.println("5 - Salir");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Ingrese clave numérica: ");
                    int clave = sc.nextInt();
                    if (productos.containsKey(clave)) {
                        System.out.println("La clave ya existe");
                        break;
                    }
                    sc.nextLine();
                    System.out.print("Ingrese descripcion: ");
                    String descripcion = sc.nextLine();
                    System.out.print("Ingrese precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Ingrese fecha de vencimiento (YYYY-MM-DD): ");
                    String fechaStr = sc.next();
                    LocalDate fechaVencimiento = LocalDate.parse(fechaStr);

                    productos.put(clave, new Producto(descripcion, precio, fechaVencimiento));
                    System.out.println("Producto agregado correctamente.");
                    break;

                case 2:
                    System.out.println("Productos registrados:");
                    for (Map.Entry<Integer, Producto> entry : productos.entrySet()) {
                        System.out.println("Clave: " + entry.getKey()+ "\n" + entry.getValue());
                    }
                    break;

                case 3:
                    System.out.print("Ingrese clave a buscar: ");
                    int buscarClave = sc.nextInt();
                    if (productos.containsKey(buscarClave)) {
                        System.out.println("Producto encontrado: " + "\n" + productos.get(buscarClave));
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese clave a eliminar: ");
                    int eliminarClave = sc.nextInt();
                    if (productos.containsKey(eliminarClave)) {
                        productos.remove(eliminarClave);
                        System.out.println("Producto eliminado corectamente");
                    } else {
                        System.out.println("Producto no encontrado");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }while(op != 5);
        sc.close();
    }

}