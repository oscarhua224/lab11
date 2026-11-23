public class Televisor {
    private boolean encendido = false;
    private int volumen = 10;
    private int canal = 1;

    public void encender() {
        encendido = true;
        System.out.println("Televisor encendido.");
    }

    public void apagar() {
        encendido = false;
        System.out.println("Televisor apagado.");
    }

    public void subirVolumen() {
        if (encendido && volumen < 100) {
            volumen++;
            System.out.println("Volumen: " + volumen);
        } else {
            System.out.println("No se puede subir el volumen.");
        }
    }

    public void bajarVolumen() {
        if (encendido && volumen > 0) {
            volumen--;
            System.out.println("Volumen: " + volumen);
        } else {
            System.out.println("No se puede bajar el volumen.");
        }
    }

    public void cambiarCanal(int nuevoCanal) {
        if (encendido && nuevoCanal >= 1 && nuevoCanal <= 100) {
            canal = nuevoCanal;
            System.out.println("Canal actual: " + canal);
        } else {
            System.out.println("No se puede cambiar el canal.");
        }
    }
}
