package ejercicio4.observer;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Observador> observadores = new ArrayList<>();

    public void suscribir(Observador observador) {

        if (!observadores.contains(observador)) {
            observadores.add(observador);
            System.out.println("Cliente suscrito correctamente.");
        }
    }

    public void desuscribir(Observador observador) {

        if (observadores.remove(observador)) {
            System.out.println("Suscripción cancelada.");
        }
    }

    public void notificar(String mensaje) {

        for (Observador observador : observadores) {
            observador.actualizar(mensaje);
        }
    }
}