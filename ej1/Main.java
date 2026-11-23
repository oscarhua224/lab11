public class Main {
    public static void main(String[] args) {
        //crear el sistema de notificaciones
        Notificacion notificacion = new Notificacion();

        //usuarios
        Usuario usuario1 = new Usuario("Ana");
        Usuario usuario2 = new Usuario("Luis");
        Usuario usuario3 = new Usuario("Carlos");


        //suscribir
        notificacion.suscribir(usuario1);
        notificacion.suscribir(usuario2);
        notificacion.suscribir(usuario3);

        // Primera notificación
        System.out.println("=== PRIMERA NOTIFICACIÓN ===");
        notificacion.notificar("Nueva promoción del 20%");

        //cancelar suscribcion
        notificacion.desuscribir(usuario2);

        // Segunda notificación
        System.out.println("\n=== SEGUNDA NOTIFICACIÓN ===");
        notificacion.notificar("Nuevo producto disponible");

        //nuevo usuario
        Usuario usuario4 = new Usuario("María");
        notificacion.suscribir(usuario4);

        // Tercera notificación
        System.out.println("\n=== TERCERA NOTIFICACIÓN ===");
        notificacion.notificar("Descuento especial del 50%");
    }
}
