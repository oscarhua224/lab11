package ejercicio3;

public class EncenderTVCommand implements Command {

    private Televisor televisor;

    public EncenderTVCommand(Televisor televisor) {
        this.televisor = televisor;
    }

    @Override
    public void execute() {
        televisor.encender();
    }
}