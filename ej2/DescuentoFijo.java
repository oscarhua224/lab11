package ejercicio2;

import java.util.List;

public class DescuentoFijo implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(List<Producto> productos) {
        double total = 0;

        for (Producto producto : productos) {
            total += producto.getPrecio();
        }

        double descuento = total * 0.10;

        return total - descuento;
    }
}