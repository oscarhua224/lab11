public class ApagarTVCommand implements Command {
    private Televisor televisor;

    public ApagarTVCommand(Televisor televisor) {
        this.televisor = televisor;
    }

    @Override
    public void execute() {
        televisor.apagar();
    }
}
