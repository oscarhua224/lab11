import java.util.List;

public class SinDescuento implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(List<Producto> productos) {
        double total = 0;

        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
}
