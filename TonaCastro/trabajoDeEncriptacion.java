
import java.util.Scanner;
public class trabajoDeEncriptacion {

  
    public static void main(String[] args) {
        System.out.println("Ingresa tu mensaje para encriptar");
        Scanner cin = new Scanner(System.in);
        String mensaje = cin.nextLine();

        char[] encryptedMessage = encryptMessage(mensaje);

        System.out.println("Tu mensaje encriptado es: " + new String(encryptedMessage));

    }

    public static char[] encryptMessage(String message)
    {
        message.toLowerCase();

        char[] encryptedMessage = new char[message.length()]; 
        encryptedMessage = message.toCharArray(); // convert the message to a char array to manipulate it

        char[] guide = encryptedMessage.clone(); 

        // odd numbersArray jumping by 1 position:

        /*
        hola mundo
        block 1: = hl ud 
        block 2: oamno

        encrypted message:
        hl udoamno
        
        */
        for (int i = 0; i < encryptedMessage.length; i++)
        {
            if (i % 2 == 0)
            {
                encryptedMessage[i] = guide[i/2]; // if i is even, take the character from the first block (block 1) which is located at index i/2 in the guide array
            }
            else
            {
                encryptedMessage[i] = guide[(encryptedMessage.length/2) + (i/2)];
            }
        }


        
        return encryptedMessage;
    }

}