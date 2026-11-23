import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class DescuentoPorcentual implements EstrategiaDescuento {
    @Override
    public double aplicarDescuento(List<Producto> productos) {
        double total = 0;

        Map<String, Integer> cantidades = new HashMap<>();
        Map<String, Double> subtotales = new HashMap<>();

        for (Producto producto : productos) {
            String nombre = producto.getNombre();
            double precio = producto.getPrecio();

            cantidades.put(nombre,
                    cantidades.getOrDefault(nombre, 0) + 1);

            subtotales.put(nombre,
                    subtotales.getOrDefault(nombre, 0.0) + precio);
        }

        for (String nombre : cantidades.keySet()) {
            double subtotal = subtotales.get(nombre);

            if (cantidades.get(nombre) >= 2) {
                total += subtotal * 0.70;
            } else {
                total += subtotal;
            }
        }
        return total;
    }
}
