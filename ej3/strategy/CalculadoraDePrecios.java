package ejercicio4.strategy;

public class CalculadoraDePrecios {
    private EstrategiaDescuento estrategia;

    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularPrecio(double precio) {

        if (estrategia == null) {
            throw new IllegalStateException(
                    "Debe seleccionar una estrategia de descuento."
            );
        }

        return estrategia.aplicarDescuento(precio);
    }
}
