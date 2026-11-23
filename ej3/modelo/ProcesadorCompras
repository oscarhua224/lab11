package ejercicio4.modelo;

import ejercicio4.observer.Tienda;
import ejercicio4.strategy.CalculadoraDePrecios;

import java.util.List;

public class ProcesadorCompras {

    private CalculadoraDePrecios calculadora;
    private Tienda tienda;

    public ProcesadorCompras(
            CalculadoraDePrecios calculadora,
            Tienda tienda) {

        this.calculadora = calculadora;
        this.tienda = tienda;
    }

    public void procesarCompra(List<Producto> productos) {

        if (productos == null || productos.isEmpty()) {
            System.out.println("No hay productos para comprar.");
            return;
        }

        double subtotal = 0;

        for (Producto producto : productos) {
            subtotal += producto.getPrecio();
        }

        double precioFinal =
                calculadora.calcularPrecio(subtotal);

        System.out.println("\n=== RESUMEN DE COMPRA ===");

        for (Producto producto : productos) {
            System.out.printf(
                    "%s - S/ %.2f%n",
                    producto.getNombre(),
                    producto.getPrecio()
            );
        }

        System.out.printf("Subtotal: S/ %.2f%n", subtotal);
        System.out.printf("Precio final: S/ %.2f%n", precioFinal);

        tienda.notificar(
                String.format(
                        "Se realizó una compra por S/ %.2f",
                        precioFinal
                )
        );
    }
}
