
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String text = "www.google.com";
        String textoLimpio = limpiarTexto(text);
        ArrayList arrayCharacters = obtenerArregloDeCaracteres(textoLimpio);
        System.err.println(text);
        System.out.println(crearPassword(arrayCharacters));
    }

    public static String limpiarTexto(String text) {
        String newText = "";
        newText = text.replaceAll("www.", "");
        newText = newText.replace(".com", "");
        return newText;
    }

    public static int obtenerLongitud(ArrayList text) {
        int cantidadCaracteres = 0;
        for (int i = 0; i < text.size(); i++) {
            cantidadCaracteres++;
        }
        return cantidadCaracteres;
    }

    public static ArrayList obtenerArregloDeCaracteres(String text) {
        ArrayList<Character> cantidadCaracteres = new ArrayList<>();
        for (char character : text.toCharArray()) {
            cantidadCaracteres.add(character);
        }
        return cantidadCaracteres;
    }

    public static String crearPassword(ArrayList caracteres) {
        String newText = "";
        newText = newText + obtenerLongitud(caracteres);
        newText = newText + obtenerParoImpar(caracteres);
        newText = newText + caracteres.get(caracteres.size() - 1);
        newText = newText + obtenerVocaloConsonante(caracteres);
        newText = newText + conseguirLosUltimosCaracteres(caracteres);
        return newText;
    }

    public static char obtenerParoImpar(ArrayList<Character> caracteres) {
        char resultado;
        if (obtenerLongitud(caracteres) % 2 == 0) {
            resultado = 't';
        } else {
            resultado = 's';
        }
        return resultado;
    }

    public static char obtenerVocaloConsonante(ArrayList<Character> caracteres) {
        return switch (caracteres.get(caracteres.size() - 1)) {
            case 'A', 'E', 'I', 'O', 'U' ->
                '$';
            default ->
                '%';
        };
    }

    public static String conseguirLosUltimosCaracteres(ArrayList<Character> caracteres) {
        String newText = "";
        newText = newText + caracteres.get(0);
        newText = newText + caracteres.get(1);
        newText = newText + caracteres.get(2);

        return newText;
    }
}
