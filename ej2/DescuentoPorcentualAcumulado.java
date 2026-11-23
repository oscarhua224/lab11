import java.util.List;

public class DescuentoPorcentualAcumulado implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(List<Producto> productos) {
        double total = 0;
        double precioMinimo = Double.MAX_VALUE;

        for (Producto producto : productos) {
            double precio = producto.getPrecio();

            total += precio;

            if (precio < precioMinimo) {
                precioMinimo = precio;
            }
        }

        if (productos.size() >= 3) {
            double descuento = precioMinimo * 0.50;
            total -= descuento;
        }
        return total;
    }
}
