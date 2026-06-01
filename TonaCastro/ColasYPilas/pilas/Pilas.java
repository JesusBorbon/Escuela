package pilas;
public class Pilas { // este trabajo es para practicar el uso de pilas
    
    private int[] pila;
    private int capacidad;
    private int tope;
    
    public Pilas(int size) {
        pila = new int [size];
        capacidad = size;
        tope = -1;
    }
    
    public void mostrarPila() {
        System.out.print("Estado de la pila: [");
        for (int i = 0; i <= tope; i++) {
            System.out.print(pila[i]);
            if (i < tope) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public int pop() {
        if(isEmpty()) {
            System.out.println("La pila esta vacia");
            System.exit(1);
        }
        int elemento = pila[tope--];
        mostrarPila();
        return elemento;
    }
    
    public boolean isEmpty(){
        return tope == -1;
    }
    
    public boolean isFull(){
        return tope == capacidad -1;
    }
    
    public int size() {
        return tope+1;
    }
    
    public void push(int element) {
        if(isFull()) {
            System.out.println("La pila esta llena");
            System.exit(1);
        }
        pila[++tope] = element;
        mostrarPila();
    }
    
    public int peek() {
        if(isEmpty()) {
            System.out.println("La pila esta vacia");
            System.exit(1);
        }
        return pila[tope];
    }
}