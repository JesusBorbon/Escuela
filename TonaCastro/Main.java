import java.util.Scanner;
public class Main{
static final int MAX=100;
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int op;
do{
// Menu principal
System.out.println("\n1. Encriptar");
System.out.println("2. Desencriptar");
System.out.println("3. Salir");
System.out.print("Opcion: ");
op=sc.nextInt();
sc.nextLine();
switch(op){
case 1:
// Leer frase
System.out.print("Frase: ");
String frase=sc.nextLine();
if(frase.length()>MAX)
System.out.println("Muy larga");
else
pendejada1(frase);
break;
case 2:
// Leer criptograma
System.out.print("Criptograma: ");
String cripto=sc.nextLine();
if(cripto.length()>MAX)
System.out.println("Muy largo");
else
pendejada2(cripto);
break;
case 3:
System.out.println("Fin");
break;
default:
System.out.println("Opcion invalida");
}
}while(op!=3);
sc.close();
}
static void pendejada1(String frase){
// Convertir la frase a arreglo de caracteres
char[] caracteres=frase.toCharArray();
int tamaño=caracteres.length;
char[] bloque1=new char[tamaño];
char[] bloque2=new char[tamaño];
int j=0,k=0;
// Separar caracteres en bloques
for(int i=0;i<tamaño;i++){
if(i%2==0){
bloque1[j]=caracteres[i];
j++;
}else{
bloque2[k]=caracteres[i];
k++;
}
}
System.out.println("\n--- RESULTADOS ---");
System.out.println("Frase original: "+frase);
System.out.println("Tamaño de la frase: "+tamaño);
System.out.print("Bloque 1: ");
for(int i=0;i<j;i++)
System.out.print(bloque1[i]);
System.out.print("\nBloque 2: ");
for(int i=0;i<k;i++)
System.out.print(bloque2[i]);
// Unir bloques para crear criptograma
char[] criptograma=new char[tamaño];
int indice=0;
for(int i=0;i<j;i++){
criptograma[indice]=bloque1[i];
indice++;
}
for(int i=0;i<k;i++){
criptograma[indice]=bloque2[i];
indice++;
}
System.out.print("\nFrase encriptada: ");
for(int i=0;i<tamaño;i++)
System.out.print(criptograma[i]);
System.out.println();
}
static void pendejada2(String criptogramaTexto){
// Convertir criptograma a arreglo
char[] criptograma=criptogramaTexto.toCharArray();
int tamaño=criptograma.length;
char[] original=new char[tamaño];
// Calcular tamaños de bloques
int tamañoBloque1;
if(tamaño%2==0)
tamañoBloque1=tamaño/2;
else
tamañoBloque1=(tamaño/2)+1;
int tamañoBloque2=tamaño/2;
char[] bloque1=new char[tamañoBloque1];
char[] bloque2=new char[tamañoBloque2];
// Separar bloques
int indice=0;
for(int i=0;i<tamañoBloque1;i++){
bloque1[i]=criptograma[indice];
indice++;
}
for(int i=0;i<tamañoBloque2;i++){
bloque2[i]=criptograma[indice];
indice++;
}
int j=0,k=0;
// Reconstruir frase original
for(int i=0;i<tamaño;i++){
if(i%2==0){
original[i]=bloque1[j];
j++;
}else{
original[i]=bloque2[k];
k++;
}
}
System.out.println("\n--- RESULTADOS ---");
System.out.println("Criptograma: "+criptogramaTexto);
System.out.println("Tamaño del criptograma: "+tamaño);
System.out.print("Bloque 1: ");
for(int i=0;i<tamañoBloque1;i++)
System.out.print(bloque1[i]);
System.out.print("\nBloque 2: ");
for(int i=0;i<tamañoBloque2;i++)
System.out.print(bloque2[i]);
System.out.print("\nFrase desencriptada: ");
for(int i=0;i<tamaño;i++)
System.out.print(original[i]);
System.out.println();
}
}