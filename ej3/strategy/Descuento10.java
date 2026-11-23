package ejercicio4.strategy;

public class Descuento10 implements EstrategiaDescuento {

    @Override
    public double aplicarDescuento(double precio) {
        return precio * 0.90;
    }
}