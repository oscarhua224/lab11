package ejercicio3;

public class CambiarCanalCommand implements Command {
    private Televisor televisor;
    private int nuevoCanal;

    public CambiarCanalCommand(Televisor televisor, int nuevoCanal) {
        this.televisor = televisor;
        this.nuevoCanal = nuevoCanal;
    }

    @Override
    public void execute() {
        televisor.cambiarCanal(nuevoCanal);
    }
}