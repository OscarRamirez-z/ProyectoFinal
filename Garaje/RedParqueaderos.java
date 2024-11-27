
import java.util.ArrayList;
import java.util.List;

public class RedParqueaderos {
    private List<Garaje> garajes;
    
    public RedParqueaderos() {
        this.garajes = new ArrayList<>();
    }
    
    // Agregar un nuevo garaje a la red
    public void agregarGaraje(Garaje garaje) {
        garajes.add(garaje);
    }
    
    // Buscar un garaje por dirección
    public Garaje buscarGaraje(String direccion) throws ExcepcionGarajeNoEncontrado {
        for (Garaje garaje : garajes) {
            if (garaje.getDireccion().equalsIgnoreCase(direccion)) {
                return garaje;
            }
        }
        throw new ExcepcionGarajeNoEncontrado("No se encontró ningún garaje en la dirección: " + direccion);
    }
    
    // Obtener todos los garajes
    public List<Garaje> getGarajes() {
        return garajes;
    }
    
    // Mostrar recaudo mensual de todos los garajes
    public void mostrarRecaudoMensual() {
        double recaudoTotal = 0;
        for (Garaje garaje : garajes) {
            recaudoTotal += garaje.calcularIngresos();
            System.out.println("Garaje en " + garaje.getDireccion() + 
                             ": $" + garaje.calcularIngresos());
        }
        System.out.println("Recaudo total de la red: $" + recaudoTotal);
    }
} 