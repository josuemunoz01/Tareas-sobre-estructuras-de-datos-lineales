import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SistemaAtencion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> fila = new LinkedList<>(); // Cola para manejar la fila de clientes

        while (true) {
            String entrada = scanner.nextLine().trim();
            
            if (entrada.equals("SALIR")) {
                break;
            } else if (entrada.startsWith("LLEGAR ")) {
                String nombre = entrada.substring(7); // Extrae el nombre
                fila.offer(nombre);
            } else if (entrada.equals("ATENDER")) {
                if (!fila.isEmpty()) {
                    System.out.println("Atendiendo a: " + fila.poll());
                } else {
                    System.out.println("No hay clientes en la fila.");
                }
            } else if (entrada.equals("MOSTRAR")) {
                if (fila.isEmpty()) {
                    System.out.println("Fila vacía");
                } else {
                    System.out.println("Fila actual: " + String.join(", ", fila));
                }
            } else {
                System.out.println("Comando no reconocido.");
            }
        }

        scanner.close();
    }
}
