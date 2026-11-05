
import java.util.Scanner;

public class java {

    // Metodo para ordenar utilizando QuickSort
    public static void ordenar(int[] arreglo, int inicio, int fin) {

        if (inicio < fin) {

            int pivote = particionar(arreglo, inicio, fin);

            ordenar(arreglo, inicio, pivote - 1);

            ordenar(arreglo, pivote + 1, fin);
        }
    }

    // Metodo para realizar la particion
    public static int particionar(int[] arreglo, int inicio, int fin) {

        int pivote = arreglo[fin];

        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {

            if (arreglo[j] <= pivote) {

                i++;

                int temporal = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temporal;
            }
        }

        int temporal = arreglo[i + 1];
        arreglo[i + 1] = arreglo[fin];
        arreglo[fin] = temporal;

        return i + 1;
    }

    // Metodo para mostrar el arreglo
    public static void mostrarArreglo(int[] arreglo) {

        for (int numero : arreglo) {
            System.out.print(numero + " ");
        }

        System.out.println();
    }

    // Metodo principal
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Cuantos numeros deseas ingresar? ");
        int cantidad = entrada.nextInt();

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor que cero.");
            entrada.close();
            return;
        }

        int[] numeros = new int[cantidad];

        System.out.println("\nIngresa los numeros:");

        for (int i = 0; i < cantidad; i++) {

            System.out.print("Numero " + (i + 1) + ": ");
            numeros[i] = entrada.nextInt();
        }

        System.out.println("\nArreglo original:");
        mostrarArreglo(numeros);

        ordenar(numeros, 0, numeros.length - 1);

        System.out.println("\nArreglo ordenado con QuickSort:");
        mostrarArreglo(numeros);

        entrada.close();
    }
}
