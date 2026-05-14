public class functions {
    


    public static int size(String text){
         int count = 0;

        while (true) 
        {
            try {
                text.charAt(count);
                count++;
            } catch (Exception e) {
                break;
            }
        }
        return count;
    }

    // size pero del array de caracteres
    
    public static int size(char[] text){
         int count = 0;

        while (true) 
        {
            try {
                char temporalVariable = text[count];
                count++;
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }

    public static char[] cutArraySubDomain(String text){

        // si el array de caracteres tiene www o . o .com al final se corta todo eso para devolver el dominio limpio, sin subdominio ni extension, sin usar substring ni split ni nada, solo con un array de caracteres y un loop

        for (int i = 0; i < size(text); i++) {
            if (text.charAt(i) == 'w' && text.charAt(i+1) == 'w' && text.charAt(i+2) == 'w' && text.charAt(i+3) == '.') {

                // cortar el array desde el indice 4 hasta el final
                char[] cutArray = new char[size(text) - 4];
                for (int j = 0; j < size(cutArray); j++) {
                    cutArray[j] = text.charAt(j + 4);
                }
                return cutArray;
                
            }

        }
        


        return null;
    }

    public static char[] cutArrayExtension(String text)
    {
        for (int i = 0; i < size(text); i++) {
            if (text.charAt(i) == '.' && text.charAt(i+1) == 'c' && text.charAt(i+2) == 'o' && text.charAt(i+3) == 'm') {

                // cortar el array desde el indice 0 hasta el indice i
                char[] cutArray = new char[i];
                for (int j = 0; j < size(cutArray); j++) {
                    cutArray[j] = text.charAt(j);
                }
                return cutArray;
                
            }

        }
        return null;
     }

     
    }

