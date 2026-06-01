import java.util.Scanner;
public interface trabajoFunciones {
    public static void main (String[] args)
    {
        // Trabajo realizado por Borbon Izaguirre.
        // primera funcion que te imprime todos los numeros de 1 en uno hasta el numero pasado como parametro:
        firstRecursiveFunction(10); // Llamar a la funcion con el numero hasta el cual imprimir


        System.out.println("Ingresa un numero para sacar su factorial");
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();
        int resultado = sacarFactorial(n);
        System.out.println("El factorial de " + n + " es: " + resultado);

        System.out.println("Ingresa un numero para sacar su suma de numeros naturales hasta ese numero");
        int n2 = cin.nextInt();

        System.out.println(numerosNaturalesHastaN(n2));

            System.out.println("Ingresa un numero para sacar su numero de la serie de fibonachi");
            int n3 = cin.nextInt();
            numerosFibonachi(n3);

            System.out.println("Ingresa un numero para buscar en el arreglo");
            int n4 = cin.nextInt();
            int[] arreglo = {15, 266, 115, 8, 10, 6, 7, 59, 9, 4};
            int index = buscarElementoEnArreglo(n4, arreglo, 0);
            if (index == -1)
            {
                System.out.println("El numero " + n4 + " no se encuentra en el arreglo");
            }
            else
            {
                System.out.println("El numero " + n4 + " se encuentra en el index " + index);
            }

    }

public static void firstRecursiveFunction(int n)
    {
        if (n < 1)
        {
            System.out.println("\n");
        }
        else
        {
            System.out.println(n);
            firstRecursiveFunction(n - 1); // llamar a la funcion con el numero decrementado en 1
        }
    }

// funcion recursiva para sacar el factorial del numero pasado como parametro 
public static int sacarFactorial(int n)
    {
        if (n < 0)
        {
            System.out.println("El numero es negativo, no se puede sacar su factorial");
            return -1;
        }
        else if (n == 0 || n == 1)
        {
            return 1;
        }
        else
        {
            return n * sacarFactorial(n - 1); 
        }
    }

    // funcionRecursiva para ir sumando 1+2+3  etc hasta el numero digitado como parametro
    public static int numerosNaturalesHastaN(int n)
    {
        if (n < 0)
        {
            System.out.println("El numero es negativo, no se puede sacar la suma de numeros naturales hasta ese numero");
            return -1;
        }
        else if (n == 0)
        {
            System.out.println("La suma de numeros naturales hasta " + n + " es: " + 0);
            return 0;
        }
        else 
        {
            int resultado = n + numerosNaturalesHastaN(n - 1); 
            
                System.out.println("La suma de numeros naturales hasta " + n + " es: " + resultado);
        
            return resultado; // a este return solo llegara cuando n sea igual a 1
        }
    }

 public static void numerosFibonachi(int indexUser) 
{
    if (indexUser < 0) 
    {
        System.out.println("El index no puede ser negativo");
    } 
    else if (indexUser == 0) 
    {
        System.out.println("El numero de la serie de fibonachi en el index 0 es: 0");
    } 
    else 
    {
        int resultado = calcularFibonacciRecursivo(indexUser);
        System.out.println("El numero de la serie de fibonachi en el index " + indexUser + " es: " + resultado);
    }
}

private static int calcularFibonacciRecursivo(int n) 
{
    if (n == 0) 
    {
        return 0;
    } 
    else if (n == 1) 
    {
        return 1;
    } 
    else 
    {
        return calcularFibonacciRecursivo(n - 1) + calcularFibonacciRecursivo(n - 2);
    }
}

        public static int buscarElementoEnArreglo(int elemento, int[] array, int index)
        {
            if (index >= array.length)
            {
                return -1; // Si el index es mayor o igual al tamaño del arreglo, el elemento no se encuentra
            }
            else if (array[index] == elemento)
            {
                return index;
            }
            else
            {
                return buscarElementoEnArreglo(elemento, array, index + 1); // seguir buscando en el siguiente index
            }
        } 
}