package ejercicio4.strategy;

public class SinDescuento implements EstrategiaDescuento {

    @Override
    public double aplicarDescuento(double precio) {
        return precio;
    }
}