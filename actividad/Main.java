import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Televisor tv = new Televisor();
        ControlRemoto control = new ControlRemoto();

        int opcion = 0;

        do {
            System.out.println("\n=== CONTROL REMOTO ===");
            System.out.println("1. Encender televisor");
            System.out.println("2. Apagar televisor");
            System.out.println("3. Subir volumen");
            System.out.println("4. Bajar volumen");
            System.out.println("5. Cambiar canal");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Ingrese un número válido.");
                scanner.nextLine();
                continue;
            }

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    control.setCommand(
                            new EncenderTVCommand(tv));
                    break;
                case 2:
                    control.setCommand(
                            new ApagarTVCommand(tv));
                    break;
                case 3:
                    control.setCommand(
                            new SubirVolumenCommand(tv));
                    break;
                case 4:
                    control.setCommand(
                            new BajarVolumenCommand(tv));
                    break;
                case 5:
                    System.out.print("Ingrese el nuevo canal: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Canal no válido.");
                        scanner.nextLine();
                        continue;
                    }

                    int canal = scanner.nextInt();

                    control.setCommand(
                            new CambiarCanalCommand(tv, canal));
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }

            if (opcion >= 1 && opcion <= 5) {
                control.pressButton();
            }
        } while (opcion != 6);
        scanner.close();
    }
}
