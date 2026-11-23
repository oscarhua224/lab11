package ejercicio4.observer;

public class Cliente implements Observador {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void actualizar(String mensaje) {
        System.out.println(
                nombre + " recibió una notificación: " + mensaje
        );
    }
}
