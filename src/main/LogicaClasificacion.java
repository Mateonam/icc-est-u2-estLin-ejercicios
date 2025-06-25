package main;
import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
        Stack<Character> cadenaInicial = new Stack<>();
        String cadenaFinal = "";
        for (int i = 0; i < texto.length(); i++) {
            cadenaInicial.push(texto.charAt(i));

        }

        while (!cadenaInicial.isEmpty()) {
            cadenaFinal += cadenaInicial.pop();
        }

        return cadenaFinal;
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
       Stack<Character> stack = new Stack<>();

        for (char c : expresion.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char top = stack.pop(); 
                if (!esPar(top, c)) return false; 
            }
        }
        return stack.isEmpty();
    }

    private boolean esPar(char apertura, char cierre) {
        return  (apertura == '(' && cierre == ')') ||
                (apertura == '[' && cierre == ']') ||
                (apertura == '{' && cierre == '}');
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> aux = new Stack<>();
            while (!pila.isEmpty()) {
                int temp = pila.pop();
                while (!aux.isEmpty() && aux.peek() < temp) {
                    pila.push(aux.pop());
                }
                aux.push(temp);
            }
            Stack<Integer> resultado = new Stack<>();
            while (!aux.isEmpty()) {
                resultado.push(aux.pop());
            }
            return resultado;
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();
        
        
        for (int i = 0; i < original.size(); i++) {
            int num = original.get(i);
            if (num % 2 == 0) {
                pares.add(num); 
            } else {
                impares.add(num); 
            }
        }
        
        
        List<Integer> resultado = new ArrayList<>();
        resultado.addAll(pares);
        resultado.addAll(impares);
        
        return resultado;

    }
}
