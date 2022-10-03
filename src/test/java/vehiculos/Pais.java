package vehiculos;
import java.util.HashMap;
import java.util.Map;

public class Pais {
    private String nombre;
    private static HashMap<Pais, Integer> ventasPorPaises = new HashMap<>();

    public Pais(String nombre){
        this.nombre = nombre;
        ventasPorPaises.put(this, 0);
    }

    public void agregarVenta(){
        ventasPorPaises.put(this, ventasPorPaises.get(this)+1);
    }

    public static Pais paisMasVendedor(){
        Map.Entry<Pais, Integer> maxEntry = null;

        for (Map.Entry<Pais, Integer> entry : ventasPorPaises.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }
}
