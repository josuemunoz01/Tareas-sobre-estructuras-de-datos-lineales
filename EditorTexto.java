import java.util.Scanner;
import java.util.Stack;

public class EditorTexto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> texto = new Stack<>(); // Pila principal
        Stack<String> deshechos = new Stack<>(); // Pila de deshacer

        while (true) {
            String entrada = scanner.nextLine().trim();
            
            if (entrada.equals("SALIR")) {
                break;
            } else if (entrada.equals("DESHACER")) {
                if (!texto.isEmpty()) {
                    deshechos.push(texto.pop());
                } else {
                    System.out.println("Nada que deshacer.");
                }
            } else if (entrada.equals("REHACER")) {
                if (!deshechos.isEmpty()) {
                    texto.push(deshechos.pop());
                } else {
                    System.out.println("Nada que rehacer.");
                }
            } else if (entrada.equals("MOSTRAR")) {
                if (texto.isEmpty()) {
                    System.out.println("(Texto vacío)");
                } else {
                    for (String linea : texto) {
                        System.out.println(linea);
                    }
                }
            } else { // Agregar nueva línea de texto
                texto.push(entrada);
                deshechos.clear(); // Se invalida la posibilidad de rehacer acciones previas
            }
        }

        scanner.close();
    }
}
