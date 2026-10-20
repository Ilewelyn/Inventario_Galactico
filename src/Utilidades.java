public class Utilidades {

    // Intercambia de posicion dos elementos dentro de un arreglo generico.
    public static <T> void intercambiar(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Cuenta cuantas veces aparece "elemento" dentro del arreglo.
    public static <T> int contar(T[] arr, T elemento) {
        int contador = 0;
        for (T actual : arr) {
            if (actual.equals(elemento)) {
                contador++;
            }
        }
        return contador;
    }

    // Devuelve el elemento mayor del arreglo, usando su orden natural.
    public static <T extends Comparable<T>> T maximo(T[] arr) {
        T mayor = arr[0];
        for (T actual : arr) {
            if (actual.compareTo(mayor) > 0) {
                mayor = actual;
            }
        }
        return mayor;
    }
}
