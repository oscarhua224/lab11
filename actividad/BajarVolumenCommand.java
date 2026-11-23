public class BajarVolumenCommand implements Command {
    private Televisor televisor;

    public BajarVolumenCommand(Televisor televisor) {
        this.televisor = televisor;
    }

    @Override
    public void execute() {
        televisor.bajarVolumen();
    }
}
