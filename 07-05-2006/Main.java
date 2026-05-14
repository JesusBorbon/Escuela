
import java.util.Scanner;

public class Main {

    static char[][] asientos = new char[9][10];
    static int ventasTotal = 0;
    static Scanner leer = new Scanner(System.in);

    static final int precioFilaA = 1000;
    static final int precioFilaB = 750;
    static final int precioFilaC = 500;
    static final int precioFilaDI = 300;

    public static void main(String[] args) {
        inicializarAsientos();
        int opcion = 0;
        while (true) {
            try {
                opcionesMenu();
                opcion = asignarEntero(5);
                mostrarMenu(opcion);

            } catch (Exception e) {
                System.err.println("Err: " + e.getMessage());
                leer.nextLine();
            }
        }

    }

    public static void mostrarMenu(int opcion) throws Exception {
        switch (opcion) {
            case 1 ->
                asignarAsiento();
            case 2 ->
                eliminarAsiento();
            case 3 ->
                mostrarAsientos();
            case 4 ->
                mostrarTotalVendido();
            case 5 -> {
                System.out.println("Saliendo, hasta la proxima");
                System.exit(0);
            }
            default ->
                throw new NumberFormatException();
        }
    }

    public static void opcionesMenu() {
        System.out.println("1. Asignar asiento");
        System.out.println("2. Cancelar asiento");
        System.out.println("3. Mostrar Mapa");
        System.out.println("4. Mostrar total vendido");
        System.out.println("5. Salir");
        System.out.println("Selecciona una opcion:");
    }

    public static void eliminarAsiento() throws Exception {

        System.out.println("Selecciona la fila que deseas liberar:");
        char valor = leer.next().charAt(0);
        int filaAsignada = obtenerIndiceFila(valor);

        System.out.println("Selecciona el asiento que deseas liberar:");

        int asientoAsignado = asignarEntero(10);
        System.out.println("Esta segur@ de su eleccion? si/no el precio es: " + obtenerPrecioFila(valor));
        String confirmacion = leer.next();

        if (confirmacion.equalsIgnoreCase("no")) {
            System.out.println("Operacion cancelada");
            return;
        } else {
            if (asientos[filaAsignada][asientoAsignado - 1] == 'L') {
                throw new Exception("Ese asiento ya esta liberado");
            }
            asientos[filaAsignada][asientoAsignado - 1] = 'L';
            ventasTotal -= obtenerPrecioFila(valor);
            System.out.println("asiento liberado correctamente");
        }
    }

    public static void asignarAsiento() throws Exception {

        System.out.println("Selecciona la fila que deseas ocupar:");
        char valor = leer.next().charAt(0);
        int filaAsignada = obtenerIndiceFila(valor);
        System.out.println("Selecciona el asiento que deseas ocupar:");

        int asientoAsignado = asignarEntero(10);
        System.out.println("Esta segur@ de su eleccion? si/no el precio es: " + obtenerPrecioFila(valor));
        String confirmacion = leer.next();

        if (confirmacion.equalsIgnoreCase("no")) {
            System.out.println("Operacion cancelada");
            return;
        } else {
            if (asientos[filaAsignada][asientoAsignado - 1] == 'O') {
                throw new Exception("Ese asiento ya esta ocupado");
            }
            asientos[filaAsignada][asientoAsignado - 1] = 'O';
            ventasTotal += obtenerPrecioFila(valor);
            System.out.println("Asiento asignado correctamente");
        }
    }

    public static int asignarEntero(int limite) throws Exception {
        if (!leer.hasNextInt()) {
            leer.next();
            throw new Exception("Tiene que usar un numero valido");
        }
        int variableTemp = leer.nextInt();
        leer.nextLine();

        if (variableTemp < 1 || variableTemp > limite) {
            throw new Exception("La opcion esta fuera de los limites (1-" + limite + ")");
        }

        return variableTemp;
    }

    public static int obtenerPrecioFila(char valor) throws Exception {
        return switch (valor) {
            case 'A' ->
                precioFilaA;
            case 'B' ->
                precioFilaB;
            case 'C' ->
                precioFilaC;
            case 'D' ->
                precioFilaDI;
            case 'E' ->
                precioFilaDI;
            case 'F' ->
                precioFilaDI;
            case 'J' ->
                precioFilaDI;
            case 'H' ->
                precioFilaDI;
            case 'I' ->
                precioFilaDI;
            default ->
                throw new Exception("Fila no valida.");
        };

    }

    public static int obtenerIndiceFila(char valor) throws Exception {
        return switch (valor) {
            case 'A' ->
                0;
            case 'B' ->
                1;
            case 'C' ->
                2;
            case 'D' ->
                3;
            case 'E' ->
                4;
            case 'F' ->
                5;
            case 'J' ->
                6;
            case 'H' ->
                7;
            case 'I' ->
                8;
            default ->
                throw new Exception("Fila no valida.");
        };
    }

    public static void mostrarTotalVendido() {
        System.out.println("Ventas totales del dia: $" + ventasTotal);
    }

    public static void inicializarAsientos() {
        for (int i = 0; i < asientos.length; i++) {

            for (int j = 0; j < asientos[i].length; j++) {
                asientos[i][j] = 'L';

            }
        }
    }

    static char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'J', 'H', 'I'};

    public static void mostrarAsientos() {
        System.out.print("   ");
        for (int d = 1; d <= 10; d++) {
            System.out.print(d + " ");
        }
        System.out.println();

        for (int i = 0; i < asientos.length; i++) {
            System.out.print(letras[i] + " |");
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println();
        }
        mostrarPrecios();
    }

    public static void mostrarPrecios() {
        System.out.println("el precio de la fila A es: " + precioFilaA);
        System.out.println("el precio de la fila B es: " + precioFilaB);
        System.out.println("el precio de la fila C es: " + precioFilaC);
        System.out.println("el precio de la fila D-I es: " + precioFilaDI);
    }
}
