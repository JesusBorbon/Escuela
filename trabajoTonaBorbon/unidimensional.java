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


        // fill the char array with the characters of the string
        fillArray(text, URL);

        URL = cutArraySubDomain(URL);
        // System.out.println("El dominio limpio sin subdominio es: ");
        // for (int i = 0; i < size(URL); i++) {
        //     System.out.print(URL[i]);
        // }
        // System.out.println("");

        URL = cutArrayExtension(URL);
        // System.out.println("El dominio limpio sin extension ni subdominio es: ");
        // for (int i = 0; i < size(URL); i++) {
        //     System.out.print(URL[i]);

        // }
        // System.out.println("");

        char[] password = new char[7];

        password[0] = (char) size(URL); // el primer char es el size convertido a char

        if (size(URL) % 2 == 0) {
            password[1] = 't'; // si es par
        } else {
            password[1] = 'c'; // impar
        }

        password[2] = URL[size(URL) -1]; // el tercer char es el ultimo char del dominio

        char[] vocales = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i< size(vocales); i++) {
            if (URL[size(URL) -1] == vocales[i]) {
                password[3] = '$'; 
                break;
            }
            else {
                password[3] = '%'; // si es consonante
                break;
            }
        }

        password[4] = URL[0]; // el quinto char es el primer char del dominio
        password[5] = URL[1];
        password[6] = URL[2];


        System.out.println("Tu password generado es: ");
        for (int i = 0; i < size(password); i++) {
            System.out.print(password[i]);
        }

        System.out.println("");

    }

}
