package ar.edu.unju.escmi.tp4.ejercicio4;
import java.util.HashSet;
import java.util.Scanner;
public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        HashSet<Cliente> clientes=new HashSet<>();
        int opcion;
        do {
            System.out.println("\n***** MENU DE CLIENTES *****");
            System.out.println("1 - Crear cliente");
            System.out.println("2 - Mostrar los datos de un cliente");
            System.out.println("3 - Mostrar todos los clientes");
            System.out.println("4 - Mostrar todos los clientes ocasionales y la cantidad");
            System.out.println("5 - Mostrar todos los clientes frecuentes y la cantidad");
            System.out.println("6 - Salir");
            System.out.print("Elija una opcion: ");
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
            case 1: {
                int dni;
                System.out.print("Ingrese el DNI: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("El DNI solo puede contener numeros.");
                    scanner.nextLine();
                    System.out.print("Ingrese nuevamente el DNI: ");}
                dni=scanner.nextInt();
                scanner.nextLine();
                String nombre;
                do {
                    System.out.print("Ingrese el nombre: ");
                    nombre=scanner.nextLine();
                    if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                        System.out.println("El nombre unicamente puede contener letras.");
                    }
                } while (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));
                String tipoCliente;
                do {
                    System.out.print("Ingrese el tipo de cliente "+"(ocasional/frecuente): ");
                    tipoCliente=scanner.nextLine();
                    if (!tipoCliente.equalsIgnoreCase("ocasional")&& !tipoCliente.equalsIgnoreCase("frecuente")) {
                        System.out.println("Solo puede haber clientes ocasionales o frecuentes.");}
                } while (!tipoCliente.equalsIgnoreCase("ocasional")&& !tipoCliente.equalsIgnoreCase("frecuente"));
                Cliente cliente=new Cliente(dni, nombre, tipoCliente);
                clientes.add(cliente);
                System.out.println("Cliente creado correctamente.");
            break;
           }
                case 2: {
                	int dniBuscado;
                	System.out.print("Ingrese el DNI que desea buscar: ");
                	while (!scanner.hasNextInt()) {
                	    System.out.println("El DNI solo puede contener numeros.");
                	    scanner.nextLine();
                	    System.out.print("Ingrese nuevamente el DNI: ");}
                	dniBuscado = scanner.nextInt();
                	scanner.nextLine();
                    long cantidadEncontrada=clientes.stream().filter(cliente ->cliente.getDni() == dniBuscado).count();
                    if (cantidadEncontrada>0) {
                        clientes.stream().filter(cliente ->cliente.getDni()==dniBuscado).forEach(cliente -> {
                    System.out.println("DNI: "+cliente.getDni());
                    System.out.println("Nombre: "+cliente.getNombre());
                    System.out.println("Tipo de cliente: "+cliente.getTipoCliente());
                    });
                    } else {
                    System.out.println("No se encontro el dni");
                    }
                    break;
                }
                case 3: {
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes guardados.");
                    } else {
                        clientes.stream().forEach(cliente->{
                            System.out.println("DNI: "+cliente.getDni());
                            System.out.println("Nombre: "+cliente.getNombre());
                            System.out.println("Tipo de cliente: "+cliente.getTipoCliente());
                            System.out.println("--------------------------------------");
                        });
                    }
                    break;
                }
                case 4: {
                    clientes.stream().filter(cliente ->cliente.getTipoCliente().equalsIgnoreCase("ocasional")).forEach(cliente -> {
                            System.out.println("DNI: "+cliente.getDni());
                            System.out.println("Nombre: "+cliente.getNombre());
                            System.out.println(
                                "Tipo de cliente: "+cliente.getTipoCliente());
                            System.out.println("----------------------------------------");
                        });
                  long cantidadOcasionales = clientes.stream().filter(cliente ->cliente.getTipoCliente().equalsIgnoreCase("ocasional")).count();
                    System.out.println("Cantidad de clientes ocasionales: "+cantidadOcasionales);
                    break;
                }
                case 5: {
                  clientes.stream().filter(cliente ->cliente.getTipoCliente().equalsIgnoreCase("frecuente")).forEach(cliente -> {
                            System.out.println("DNI: "+cliente.getDni());
                            System.out.println("Nombre: " + cliente.getNombre());
                            System.out.println("Tipo de cliente: "+cliente.getTipoCliente());
                            System.out.println("-------------------------------------------");
                        });
                  long cantidadFrecuentes = clientes.stream().filter(cliente->cliente.getTipoCliente().equalsIgnoreCase("frecuente")).count();
                    System.out.println("Cantidad de clientes frecuentes: "+cantidadFrecuentes);
                    break;
                }
                case 6: {
                    System.out.println("Programa finalizado.");
                    break;
                }
                default: {
                    System.out.println("Opcion no valida. Ingrese un numero del 1 al 6.");
                }
            }
        } while (opcion!=6);
        scanner.close();
    }
}