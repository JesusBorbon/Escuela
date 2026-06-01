package pilas;
public class Main {
    
    public static void main(String[] args) {
        
        Pilas pila = new Pilas(5);
        
        pila.push(78);
        pila.push(20);
        pila.push(10);
        pila.push(38);
        pila.push(90);
        
        System.out.println("Esta lleno? " + pila.isFull());
        System.out.println("El ultimo elemento de la pila es: " + pila.peek());
        System.out.println("Size de la pila " + pila.size());
        
        System.out.println("Eliminando del ultimo elemento");
        pila.pop();
        System.out.println("Eliminando del ultimo elemento");
        pila.pop();
        
        System.out.println("El ultimo elemento de la pila es: " + pila.peek());
        
        System.out.println("Esta vacia?" + pila.isEmpty());
        
        System.out.println("Eliminando del ultimo elemento");
        pila.pop();
        System.out.println("Eliminando del ultimo elemento");
        pila.pop();
        System.out.println("Eliminando del ultimo elemento");
        pila.pop();
        
        System.out.println("Esta vacia?" + pila.isEmpty());
    }
}