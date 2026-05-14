import java.util.Scanner;
public class unidimensional extends functions{

    static Scanner cin = new Scanner(System.in);
    public static void main(String[] args)
    {
      
        System.out.println("Ingresa tu texto para generar password a partir de la pagina, no olvides agregar wwww como subdominio y la extension .com al final: ");

        System.out.println("Ejemplo: www.facebook.com");

        System.out.println("Ingresa tu texto: ");

        String text = cin.nextLine();
        
        // guardar cada caracter manualmente en un array

        char [] cleanDomain = cutArraySubDomain(text);
        System.out.println("El dominio limpio es: ");
        for (int i = 0; i < size(cleanDomain); i++) {
            System.out.print(cleanDomain[i]);
        }
        System.out.println("");

        cleanDomain = cutArrayExtension(text);
        System.out.println("El dominio limpio sin extension es: ");
        for (int i = 0; i < size(cleanDomain); i++) {
            System.out.print(cleanDomain[i]);
        }
        System.out.println("");

    }





}