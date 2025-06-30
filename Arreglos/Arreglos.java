import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Arreglos {

    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Llenar matriz con números del 1 al 9
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = random.nextInt(9) + 1;
            }
        }

        // Mostrar matriz generada
        System.out.println("Matriz generada:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Pedir número al usuario
        System.out.print("Ingrese un número menor que 45: ");
        int numero = scanner.nextInt();

        if (numero >= 45) {
            System.out.println("El número debe ser menor que 45.");
        } else {
            // Convertir matriz a lista para buscar combinaciones
            List<Integer> listaNumeros = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    listaNumeros.add(matriz[i][j]);
                }
            }

            System.out.println("Buscando combinaciones que sumen " + numero + "...");
            List<Integer> combinacion = new ArrayList<>();
            buscarCombinaciones(listaNumeros, numero, 0, combinacion);
        }

        scanner.close();
    }

    public static void buscarCombinaciones(List<Integer> lista, int objetivo, int inicio, List<Integer> combinacion) {
        int suma = 0;
        for (int num : combinacion) {
            suma += num;
        }

        if (suma == objetivo && !combinacion.isEmpty()) {
            System.out.println(combinacion);
            return;
        }

        if (suma > objetivo) {
            return;
        }

        for (int i = inicio; i < lista.size(); i++) {
            combinacion.add(lista.get(i));
            buscarCombinaciones(lista, objetivo, i + 1, combinacion);
            combinacion.remove(combinacion.size() - 1);
        }
    }
}
