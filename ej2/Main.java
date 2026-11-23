package ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Producto> productos = new ArrayList<>();

        CalculadoraDePrecios calculadora =
                new CalculadoraDePrecios();

        System.out.println("=== SISTEMA DE DESCUENTOS ===");

        //registrar productos
        int cantidad = leerEnteroPositivo(
                scanner, "Ingrese la cantidad de productos: ");

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nProducto " + (i + 1));

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine().trim();

            while (nombre.isEmpty()) {
                System.out.print("Ingrese un nombre válido: ");
                nombre = scanner.nextLine().trim();
            }

            double precio = leerPrecio(
                    scanner, "Precio: S/ ");

            productos.add(new Producto(nombre, precio));
        }

        int opcion;

        do {

            System.out.println("\n=== MENÚ DE DESCUENTOS ===");
            System.out.println("1. Sin descuento");
            System.out.println("2. Descuento fijo del 10%");
            System.out.println("3. Descuento del 30% por productos iguales");
            System.out.println("4. Descuento del 50% al producto más barato");
            System.out.println("5. Salir");

            opcion = leerEntero(
                    scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    calculadora.setEstrategia(
                            new SinDescuento());
                    break;
                case 2:
                    calculadora.setEstrategia(
                            new DescuentoFijo());
                    break;
                case 3:
                    calculadora.setEstrategia(
                            new DescuentoPorcentual());
                    break;
                case 4:
                    calculadora.setEstrategia(
                            new DescuentoPorcentualAcumulado());
                    break;
                case 5:
                    System.out.println("Programa terminado");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }

            if (opcion >= 1 && opcion <= 4) {

                double precioFinal =
                        calculadora.calcularPrecio(productos);

                System.out.printf(
                        "Precio final: S/ %.2f%n", precioFinal);
            }

        } while (opcion != 5);
        scanner.close();
    }

    private static int leerEntero(
            Scanner scanner, String mensaje) {

        while (true) {
            System.out.print(mensaje);

            try {
                return Integer.parseInt(
                        scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    private static int leerEnteroPositivo(
            Scanner scanner, String mensaje) {

        while (true) {
            int numero = leerEntero(scanner, mensaje);

            if (numero > 0) {
                return numero;
            }

            System.out.println("El número debe ser mayor que cero.");
        }
    }

    private static double leerPrecio(
            Scanner scanner, String mensaje) {

        while (true) {
            System.out.print(mensaje);

            try {
                double precio = Double.parseDouble(
                        scanner.nextLine().trim());

                if (Double.isFinite(precio) && precio >= 0) {
                    return precio;
                }

            } catch (NumberFormatException e) {
                // Se mostrara un mensaje y se solicitara nuevamente
            }
            System.out.println(
                    "Ingrese un precio válido mayor o igual a cero.");
        }
    }
}