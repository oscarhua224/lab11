package ejercicio4;

import ejercicio4.command.GestorComandos;
import ejercicio4.command.RealizarCompraCommand;
import ejercicio4.modelo.ProcesadorCompras;
import ejercicio4.modelo.Producto;
import ejercicio4.observer.Cliente;
import ejercicio4.observer.Tienda;
import ejercicio4.strategy.CalculadoraDePrecios;
import ejercicio4.strategy.SinDescuento;
import ejercicio4.strategy.Descuento10;
import ejercicio4.strategy.Descuento20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. Crear los productos
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto("Mouse", 80));
        productos.add(new Producto("Teclado", 150));
        productos.add(new Producto("Audífonos", 120));

        // 2. Crear la tienda y los clientes (Observer)
        Tienda tienda = new Tienda();

        Cliente ana = new Cliente("Ana");
        Cliente carlos = new Cliente("Carlos");
        Cliente maria = new Cliente("María");

        // 3. Crear la calculadora (Strategy)
        CalculadoraDePrecios calculadora =
                new CalculadoraDePrecios();

        calculadora.setEstrategia(new SinDescuento());

        // 4. Crear el procesador de compras (Receiver)
        ProcesadorCompras procesador =
                new ProcesadorCompras(calculadora, tienda);

        // 5. Crear el gestor de comandos (Invoker)
        GestorComandos gestor = new GestorComandos();

        int opcion = 0;

        do {
            System.out.println("\n=== SISTEMA DE TIENDA ===");
            System.out.println("1. Ver productos");
            System.out.println("2. Seleccionar descuento");
            System.out.println("3. Suscribir clientes");
            System.out.println("4. Cancelar suscripción");
            System.out.println("5. Realizar compra");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ingrese un número válido.");
                scanner.nextLine();
                continue;
            }

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("\n=== PRODUCTOS ===");

                    for (Producto producto : productos) {
                        System.out.printf(
                                "%s - S/ %.2f%n",
                                producto.getNombre(),
                                producto.getPrecio()
                        );
                    }
                    break;

                case 2:
                    System.out.println("\n=== DESCUENTOS ===");
                    System.out.println("1. Sin descuento");
                    System.out.println("2. Descuento del 10%");
                    System.out.println("3. Descuento del 20%");
                    System.out.print("Seleccione: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Descuento no válido.");
                        scanner.nextLine();
                        break;
                    }

                    int descuento = scanner.nextInt();

                    switch (descuento) {
                        case 1:
                            calculadora.setEstrategia(
                                    new SinDescuento()
                            );
                            break;

                        case 2:
                            calculadora.setEstrategia(
                                    new Descuento10()
                            );
                            break;

                        case 3:
                            calculadora.setEstrategia(
                                    new Descuento20()
                            );
                            break;

                        default:
                            System.out.println(
                                    "Opción de descuento no válida."
                            );
                            break;
                    }

                    if (descuento >= 1 && descuento <= 3) {
                        System.out.println(
                                "Estrategia actualizada correctamente."
                        );
                    }
                    break;

                case 3:
                    System.out.println("\n=== SUSCRIBIR CLIENTES ===");
                    System.out.println("1. Ana");
                    System.out.println("2. Carlos");
                    System.out.println("3. María");
                    System.out.print("Seleccione: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Cliente no válido.");
                        scanner.nextLine();
                        break;
                    }

                    int clienteSuscribir = scanner.nextInt();

                    switch (clienteSuscribir) {
                        case 1:
                            tienda.suscribir(ana);
                            break;
                        case 2:
                            tienda.suscribir(carlos);
                            break;
                        case 3:
                            tienda.suscribir(maria);
                            break;
                        default:
                            System.out.println("Cliente no válido.");
                    }
                    break;

                case 4:
                    System.out.println("\n=== CANCELAR SUSCRIPCIÓN ===");
                    System.out.println("1. Ana");
                    System.out.println("2. Carlos");
                    System.out.println("3. María");
                    System.out.print("Seleccione: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Cliente no válido.");
                        scanner.nextLine();
                        break;
                    }

                    int clienteEliminar = scanner.nextInt();

                    switch (clienteEliminar) {
                        case 1:
                            tienda.desuscribir(ana);
                            break;
                        case 2:
                            tienda.desuscribir(carlos);
                            break;
                        case 3:
                            tienda.desuscribir(maria);
                            break;
                        default:
                            System.out.println("Cliente no válido.");
                    }
                    break;

                case 5:
                    RealizarCompraCommand comandoCompra =
                            new RealizarCompraCommand(
                                    procesador,
                                    productos
                            );

                    gestor.setComando(comandoCompra);
                    gestor.ejecutarComando();
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 6);

        scanner.close();
    }
}