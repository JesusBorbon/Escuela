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

        char[] URL = new char[size(text)];

        // llenar el array manualmente con los caracteres guardados en la variable text.
        fillArray(text, URL);

        URL = cutArraySubDomain(URL); // cortar subdominio con todo y el punto
        URL = cutArrayExtension(URL); // cortar extension con el punto
   

        char[] password = new char[7]; // siempre va a ser de 7 chars el password generado.

        String passwordString = size(URL) + "";
        password[0] = passwordString.charAt(0);

        if (size(URL) % 2 == 0) {
            password[1] = 't'; // si es par
        } else {
            password[1] = 'c'; // impar
        }

        password[2] = URL[size(URL) -1]; // el tercer char es el ultimo char del dominio

        char[] vocales = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i< size(vocales); i++) {
            if (URL[size(URL) -1] == vocales[i]) { // si el ultimo char del dominio es vocal el cuarto char es $ sino es %
                password[3] = '$'; 
                break;
            }
            else {
                password[3] = '%'; 
                break;
            }
        }

        password[4] = URL[0]; // el quinto char es el primer char del dominio
        password[5] = URL[1]; // el sexto char es el segundo char del dominio
        password[6] = URL[2]; // el septimo char es el tercer char del dominio


        System.out.println("Tu password generado es: ");
        for (int i = 0; i < size(password); i++) {
            System.out.print(password[i]);
        }

        System.out.println("");

    }

}
