package ejercicio4.strategy;

public class Descuento20 implements EstrategiaDescuento {

    @Override
    public double aplicarDescuento(double precio) {
        return precio * 0.80;
    }
}