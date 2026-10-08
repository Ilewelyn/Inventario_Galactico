
//Misión 2: La caja sellada.

public class Caja<T extends Comparable<T>> {
    private final Object[] elementos;
    private int cantidad;

    public Caja(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0");
        }
        this.elementos = new Object[capacidad];
        this.cantidad = 0;
    }

    public void agregar(T elemento) {
        if (cantidad == elementos.length) {
            throw new IllegalStateException(
                "La caja está llena (capacidad máxima: " + elementos.length + ")");
        }
        elementos[cantidad++] = elemento;
    }

    @SuppressWarnings("unchecked")
    public T obtenerMayor() {
        validarNoVacia();
        T mayor = (T) elementos[0];
        for (int i = 1; i < cantidad; i++) {
            T actual = (T) elementos[i];
            if (actual.compareTo(mayor) > 0) {
                mayor = actual;
            }
        }
        return mayor;
    }

    @SuppressWarnings("unchecked")
    public T obtenerMenor() {
        validarNoVacia();
        T menor = (T) elementos[0];
        for (int i = 1; i < cantidad; i++) {
            T actual = (T) elementos[i];
            if (actual.compareTo(menor) < 0) {
                menor = actual;
            }
        }
        return menor;
    }

    private void validarNoVacia() {
        if (cantidad == 0) {
            throw new IllegalStateException("La caja está vacía");
        }
    }
}
