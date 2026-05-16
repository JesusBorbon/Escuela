public class functions {
    


    public static int size(String text){
         int count = 0;

        while (true) 
        {
            try {
                text.charAt(count); // forzando a que salga del rango para romper el ciclo
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
                char temporalVariable = text[count]; // ya que salga del rango se va a lanzar una excepcion y se va a romper el ciclo
                count++;
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }

    public static char[] cutArraySubDomain(char[] Domain){ 
        for (int i = 0; i < size(Domain); i++) {
            if (Domain[i] == 'w' && Domain[i+1] == 'w' && Domain[i+2] == 'w' && Domain[i+3] == '.') {

                // si encuentra el www. se corta el array desde el indice 4 hasta el final del array, para eliminar el subdominio
                char[] cutArray = new char[size(Domain) - 4];
                for (int j = 0; j < size(cutArray); j++) {
                    cutArray[j] = Domain[j + 4];
                }
                return cutArray;
                
            }

        }

        return null;
    }

    public static char[] cutArrayExtension(char[] Domain)
    {
        for (int i = 0; i < size(Domain); i++) { 
            if (Domain[i] == '.' && Domain[i+1] == 'c' && Domain[i+2] == 'o' && Domain[i+3] == 'm') {

                // cortar el array desde el indice 0 hasta el indice i
                char[] cutArray = new char[i]; // cuando encuentre el .com se corta el array desde el indice 0 hasta el indice del punto, para eliminar la extension
                for (int j = 0; j < size(cutArray); j++) {
                    cutArray[j] = Domain[j];
                }
                return cutArray;
                
            }

        }
        return null;
     }

     public static void fillArray(String text, char[] URL)

     {
        for (int i = 0; i < size(text); i++) {
            URL[i] = text.charAt(i);
        }
     }
     
    }

