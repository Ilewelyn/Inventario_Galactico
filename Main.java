import java.util.Arrays;


//Misión 4: Despegue 

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings({"unchecked", "rawtypes"})
        Par<String, Integer>[] productos = new Par[] {
            new Par<>("Agua", 120),
            new Par<>("Combustible", 500),
            new Par<>("Alimentos", 300),
            new Par<>("Repuestos", 80)
        };

        // Se guardan las cantidades en una Caja y se obtiene la mayor
        Caja<Integer> cantidades = new Caja<>(productos.length);
        for (Par<String, Integer> p : productos) {
            cantidades.agregar(p.getValor());
        }
        Integer mayorCantidad = cantidades.obtenerMayor();

        // Con Utilidades se obtiene el arreglo de cantidades y su máximo 
        Integer[] arregloCantidades = new Integer[productos.length];
        for (int i = 0; i < productos.length; i++) {
            arregloCantidades[i] = productos[i].getValor();
        }
        Integer maximo = Utilidades.maximo(arregloCantidades);

        // Se localiza el producto cuya cantidad coincide con el máximo
        for (Par<String, Integer> p : productos) {
            if (p.getValor().equals(mayorCantidad) && mayorCantidad.equals(maximo)) {
                System.out.println("Producto con mayor cantidad: " + p);
            }
        }

        // ---------- Pruebas Misión 1 ----------
        Par<String, Integer> p1 = new Par<>("Oxigeno", 10);
        Par<Integer, String> p2 = new Par<>(1, "Caja A");
        System.out.println("\n[Misión 1] " + p1 + " | " + p2);

        // ---------- Pruebas Misión 2 ----------
        System.out.println("\n[Misión 2]");
        Caja<Integer> c1 = new Caja<>(4);
        c1.agregar(5); c1.agregar(2); c1.agregar(9); c1.agregar(1);
        System.out.println("2.1 Mayor=" + c1.obtenerMayor() + ", Menor=" + c1.obtenerMenor());

        Caja<String> c2 = new Caja<>(4);
        c2.agregar("luna"); c2.agregar("marte"); c2.agregar("venus");
        System.out.println("2.2 Mayor=" + c2.obtenerMayor() + ", Menor=" + c2.obtenerMenor());

        Caja<Double> c3 = new Caja<>(4);
        c3.agregar(3.5); c3.agregar(1.2);
        System.out.println("2.3 Mayor=" + c3.obtenerMayor());

        try {
            c1.agregar(7);
        } catch (IllegalStateException e) {
            System.out.println("2.4 " + e.getMessage());
        }
        try {
            new Caja<Integer>(3).obtenerMayor();
        } catch (IllegalStateException e) {
            System.out.println("2.5 " + e.getMessage());
        }

        // ---------- Pruebas Misión 3 ----------
        System.out.println("\n[Misión 3]");
        Integer[] a = {1, 2, 3};
        Utilidades.intercambiar(a, 0, 2);
        System.out.println("intercambiar Integer: " + Arrays.toString(a));

        String[] s = {"a", "b"};
        Utilidades.intercambiar(s, 0, 1);
        System.out.println("intercambiar String: " + Arrays.toString(s));

        System.out.println("contar Integer: " + Utilidades.contar(new Integer[]{1, 2, 2, 3, 2}, 2));
        System.out.println("contar String: " + Utilidades.contar(new String[]{"sol", "luna", "sol"}, "sol"));
        System.out.println("maximo Integer: " + Utilidades.maximo(new Integer[]{4, 9, 2}));
        System.out.println("maximo String: " + Utilidades.maximo(new String[]{"pera", "manzana", "uva"}));
    }
}
