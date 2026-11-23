import java.util.List;

public class CalculadoraDePrecios {
    private EstrategiaDescuento estrategia;

    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularPrecio(List<Producto> productos) {
        if (estrategia == null) {
            throw new IllegalStateException(
                    "Debe seleccionar una estrategia de descuento."
            );
        }
        return estrategia.aplicarDescuento(productos);
    }
}
