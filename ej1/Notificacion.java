import java.util.ArrayList;
import java.util.List;

public class Notificacion {

    private List<Observer> observadores = new ArrayList<>();

    public void suscribir(Observer observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void desuscribir(Observer observador) {
        observadores.remove(observador);
    }

    public void notificar(String mensaje) {
        for (Observer observador : observadores) {
            observador.update(mensaje);
        }
    }
}
