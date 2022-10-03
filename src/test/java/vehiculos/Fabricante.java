package vehiculos;
import java.util.HashMap;
import java.util.Map;

public class Fabricante {
    private String nombre;
    private Pais pais;
    private static HashMap<Fabricante, Integer> ventasPorFabrica = new HashMap<>();

    public Fabricante(String nombre, Pais pais){
        this.nombre = nombre;
        this.pais = pais;
        ventasPorFabrica.put(this, 0);
    }

    public void agregarVenta(){
        ventasPorFabrica.put(this, ventasPorFabrica.get(this)+1);
        pais.agregarVenta();
    }

    public static Fabricante fabricaMayorVentas(){
        Map.Entry<Fabricante, Integer> maxEntry = null;

        for (Map.Entry<Fabricante, Integer> entry : ventasPorFabrica.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public static HashMap<Fabricante, Integer> getVentasPorFabrica() {
        return ventasPorFabrica;
    }

    public static void setVentasPorFabrica(HashMap<Fabricante, Integer> ventasPorFabrica) {
        Fabricante.ventasPorFabrica = ventasPorFabrica;
    }
}
