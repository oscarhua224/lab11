package ejercicio4.command;

public class GestorComandos {
    private Comando comando;

    public void setComando(Comando comando) {
        this.comando = comando;
    }

    public void ejecutarComando() {

        if (comando != null) {
            comando.ejecutar();
        } else {
            System.out.println("No hay ningún comando asignado.");
        }
    }
}