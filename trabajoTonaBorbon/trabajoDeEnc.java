import java.util.Scanner;

public class Main {

    static final int MAX = 100;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int option;

        do {

            // Main menu
            System.out.println("\n1. Encrypt");
            System.out.println("2. Decrypt");
            System.out.println("3. Exit");
            System.out.print("Option: ");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                case 1:

                    // Read phrase and convert to lowercase
                    System.out.print("Phrase: ");
                    String phrase = sc.nextLine();
                    phrase = phrase.toLowerCase();

                    if (phrase.length() > MAX)
                        System.out.println("Too long");
                    else
                        encrypt(phrase);

                    break;

                case 2:

                    // Read ciphertext and convert to lowercase
                    System.out.print("Ciphertext: ");
                    String ciphertext = sc.nextLine();
                    ciphertext = ciphertext.toLowerCase();

                    if (ciphertext.length() > MAX)
                        System.out.println("Too long");
                    else
                        decrypt(ciphertext);

                    break;

                case 3:

                    System.out.println("End");
                    break;

                default:

                    System.out.println("Invalid option");
            }

        } while (option != 3); // Continue until the user chooses to exit

        sc.close();
    }

    static void encrypt(String phrase) {

        // Convert phrase to character array
        char[] characters = phrase.toCharArray();

        int size = characters.length;

        char[] block1 = new char[size];
        char[] block2 = new char[size];

        int j = 0;
        int k = 0;

        // Separate characters into blocks
        for (int i = 0; i < size; i++) {

            if (i % 2 == 0) {

                block1[j] = characters[i];
                j++;

            } else {

                block2[k] = characters[i];
                k++;
            }
        }

        System.out.println("\n--- RESULTS ---");

        System.out.println("Original phrase: " + phrase);
        System.out.println("Size: " + size);

        System.out.print("Block 1: ");

        for (int i = 0; i < j; i++)
            System.out.print(block1[i]);

        System.out.print("\nBlock 2: ");

        for (int i = 0; i < k; i++)
            System.out.print(block2[i]);

        // Merge blocks
        char[] ciphertext = new char[size];

        int index = 0;

        for (int i = 0; i < j; i++) {

            ciphertext[index] = block1[i];
            index++;
        }

        for (int i = 0; i < k; i++) {

            ciphertext[index] = block2[i];
            index++;
        }

        System.out.print("\nEncrypted phrase: ");

        for (int i = 0; i < size; i++)
            System.out.print(ciphertext[i]);

        System.out.println();
    }

    static void decrypt(String ciphertextText) {

        // Convert ciphertext to character array
        char[] ciphertext = ciphertextText.toCharArray();

        int size = ciphertext.length;

        char[] original = new char[size];

        // Calculate sizes
        int block1Size;

        if (size % 2 == 0)
            block1Size = size / 2;
        else
            block1Size = (size / 2) + 1;

        int block2Size = size / 2;

        char[] block1 = new char[block1Size];
        char[] block2 = new char[block2Size];

        // Separate blocks
        int index = 0;

        for (int i = 0; i < block1Size; i++) {

            block1[i] = ciphertext[index];
            index++;
        }

        for (int i = 0; i < block2Size; i++) {

            block2[i] = ciphertext[index];
            index++;
        }

        int j = 0;
        int k = 0;

        // Reconstruct original phrase
        for (int i = 0; i < size; i++) {

            if (i % 2 == 0) {

                original[i] = block1[j];
                j++;

            } else {

                original[i] = block2[k];
                k++;
            }
        }

        System.out.println("\n--- RESULTS ---");

        System.out.println("Ciphertext: " + ciphertextText);
        System.out.println("Size: " + size);

        System.out.print("Block 1: ");

        for (int i = 0; i < block1Size; i++)
            System.out.print(block1[i]);

        System.out.print("\nBlock 2: ");

        for (int i = 0; i < block2Size; i++)
            System.out.print(block2[i]);

        System.out.print("\nDecrypted phrase: ");

        for (int i = 0; i < size; i++)
            System.out.print(original[i]);

        System.out.println();
    }
}