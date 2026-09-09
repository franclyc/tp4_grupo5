package ar.edu.unju.escmi.tp4.ejercicio6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<Libro> libros=new ArrayList<>();
        int opcion;
        do {
            System.out.println("\n***** MENU DE LIBROS *****");
            System.out.println("1 - Alta de Libro");
            System.out.println("2 - Mostrar libros");
            System.out.println("3 - Buscar y mostrar un libro");
            System.out.println("4 - Ordenar libros");
            System.out.println("5 - Modificar datos de un libro");
            System.out.println("6 - Eliminar un libro");
            System.out.println("7 - Salir");
            System.out.print("Elija una opcion: ");
            opcion=scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1: {
                    Libro libro=new Libro();
                    int isbn;
                    System.out.print("Ingrese el ISBN: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("El ISBN solo puede contener numeros.");
                        scanner.nextLine();
                        System.out.print("Ingrese nuevamente el ISBN: ");}
                    isbn=scanner.nextInt();
                    scanner.nextLine();
                    libro.setIsbn(isbn);
                    String titulo;
                    System.out.print("Ingrese el titulo: ");
                    titulo=scanner.nextLine();
                    libro.setTitulo(titulo);
                    int cantidadPaginas;
                    System.out.print("Ingrese la cantidad de paginas: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("La cantidad de paginas solo puede contener numeros.");
                        scanner.nextLine();
                        System.out.print("Ingrese nuevamente la cantidad de paginas: ");}
                    cantidadPaginas=scanner.nextInt();
                    scanner.nextLine();
                    libro.setCantidadPaginas(cantidadPaginas);
                    String autor;
                    do {
                        System.out.print("Ingrese el autor: ");
                        autor=scanner.nextLine();
                        if (!autor.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                            System.out.println("El autor unicamente puede contener letras.");
                        }
                    } while (!autor.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));
                    libro.setAutor(autor);
                    libros.add(libro);
                    System.out.println("Libro creado correctamente.");
                break;
                }
                case 2: {
                    if (libros.isEmpty()) {
                        System.out.println("No hay libros guardados.");
                    } else {
                        libros.stream().forEach(libro -> {
                            libro.mostrarDatos();
                            System.out.println("--------------------------------------");
                        });
                    }
                    break;
                }
                case 3: {
                    int isbnBuscado;
                    System.out.print("Ingrese el ISBN que desea buscar: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("El ISBN solo puede contener numeros.");
                        scanner.nextLine();
                        System.out.print("Ingrese nuevamente el ISBN: ");}
                    isbnBuscado=scanner.nextInt();
                    scanner.nextLine();
                    boolean encontrado=false;
                    for (Libro libro:libros) {
                        if (libro.getIsbn()==isbnBuscado) {
                            libro.mostrarDatos();
                            encontrado=true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Libro no encontrado");
                    }
                    break;
                }
                case 4: {
                    if (libros.isEmpty()) {
                        System.out.println("No hay libros guardados.");
                    } else {
                        Collections.sort(libros);
                        System.out.println("Libros ordenados por titulo correctamente.");
                    }
                    break;
                }
                case 5: {
                    int isbnModificar;
                    System.out.print("Ingrese el ISBN del libro que desea modificar: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("El ISBN solo puede contener numeros.");
                        scanner.nextLine();
                        System.out.print("Ingrese nuevamente el ISBN: ");}
                    isbnModificar=scanner.nextInt();
                    scanner.nextLine();
                    Libro libroEncontrado=null;
                    for (Libro libro:libros) {
                        if (libro.getIsbn()==isbnModificar) {
                            libroEncontrado=libro;
                            break;
                        }
                    }
                    if (libroEncontrado!=null) {
                        System.out.println("Datos actuales del libro:");
                        libroEncontrado.mostrarDatos();
                        String nuevoTitulo;
                        System.out.print("Ingrese el nuevo titulo: ");
                        nuevoTitulo=scanner.nextLine();
                        libroEncontrado.setTitulo(nuevoTitulo);
                        int nuevaCantidadPaginas;
                        System.out.print("Ingrese la nueva cantidad de paginas: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("La cantidad de paginas solo puede contener numeros.");
                            scanner.nextLine();
                            System.out.print("Ingrese nuevamente la cantidad de paginas: ");}
                        nuevaCantidadPaginas=scanner.nextInt();
                        scanner.nextLine();
                        libroEncontrado.setCantidadPaginas(nuevaCantidadPaginas);
                        String nuevoAutor;
                        do {
                            System.out.print("Ingrese el nuevo autor: ");
                            nuevoAutor=scanner.nextLine();
                            if (!nuevoAutor.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                                System.out.println("El autor unicamente puede contener letras.");
                            }
                        } while (!nuevoAutor.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));
                        libroEncontrado.setAutor(nuevoAutor);
                        System.out.println("Libro modificado correctamente.");
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;
                }
                case 6: {
                    int isbnEliminar;
                    System.out.print("Ingrese el ISBN del libro que desea eliminar: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("El ISBN solo puede contener numeros.");
                        scanner.nextLine();
                        System.out.print("Ingrese nuevamente el ISBN: ");}
                    isbnEliminar=scanner.nextInt();
                    scanner.nextLine();
                    Libro libroAEliminar=null;
                    for (Libro libro:libros) {
                        if (libro.getIsbn()==isbnEliminar) {
                            libroAEliminar=libro;
                            break;
                        }
                    }
                    if (libroAEliminar!=null) {
                        libros.remove(libroAEliminar);
                        System.out.println("Libro eliminado correctamente.");
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;
                }
                case 7: {
                    System.out.println("Programa finalizado.");
                    break;
                }
                default: {
                    System.out.println("Opcion no valida. Ingrese un numero del 1 al 7.");
                }
            }
        } while (opcion!=7);
        scanner.close();
    }
}