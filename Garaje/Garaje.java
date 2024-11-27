import java.util.ArrayList;

public class Garaje {
    private String departamento;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String email;
    private String nombreAdministrador;
    private int numeroEspacios;
    private ArrayList<Vehiculo> espacios;

    // Constructores
    public Garaje(String departamento, String ciudad, String direccion, String telefono, String email, String nombreAdministrador, int numeroEspacios) {
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.nombreAdministrador = nombreAdministrador;
        this.numeroEspacios = numeroEspacios;
        this.espacios = new ArrayList<>(numeroEspacios);
    }

    // Getters y setters
    public String getDepartamento() {
        return departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public int getNumeroEspacios() {
        return numeroEspacios;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // metodo para calcular ingresos
    public double calcularIngresos() {
        double ingresoTotal = 0;
        // Calcula los ingresos basado en los vehículos estacionados
        // y las tarifas correspondientes
        return ingresoTotal;
    }

    // metodo para buscar un vehículo por matrícula
    public Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo vehiculo : espacios) {
            if (vehiculo != null && vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }
        return null; // Si no se encuentra la matricua
    }

    // metodo para calcular la ocupacion (si tiene espacio o esta lleno) actual del garaje
    public int calcularOcupacion() {
        int ocupados = 0;
        for (Vehiculo vehiculo : espacios) {
            if (vehiculo != null) {
                ocupados++;
            }
        }
        return ocupados;
    }

    // metodo para agregar un vehiculo a algun garaje
    public void agregarVehiculo(Vehiculo vehiculo) throws ExcepcionGaraje {
        if (vehiculo == null) {
            throw new ExcepcionGaraje("El vehículo no puede ser nulo.");
        }
        if (calcularOcupacion() >= numeroEspacios) {
            throw new ExcepcionGaraje("No hay espacios disponibles en este garaje.");
        }
        espacios.add(vehiculo);
    }

    public void verificarCapacidadVehiculo(Vehiculo vehiculo) throws ExcepcionGarajeLleno {
        int maxCamiones = (numeroEspacios < 100) ? 10 : 20; // Máximo de camiones según la capacidad total del garaje
        int maxMotos = (int) (numeroEspacios * 0.2); // 20% de los espacios para motos
        
        int camionesEnGaraje = 0;
        int motosEnGaraje = 0;
    
        // Contamos camiones y motos
        for (Vehiculo v : espacios) {
            if (v instanceof Camion) {
                camionesEnGaraje++;
            } else if (v instanceof Moto) {
                motosEnGaraje++;
            }
        }
    
        // Verificación según las políticas
        if (vehiculo instanceof Camion) {
            if (camionesEnGaraje >= maxCamiones) {
                throw new ExcepcionGarajeLleno("No se pueden agregar más camiones. Límite alcanzado.");
            }
        } else if (vehiculo instanceof Moto) {
            if (motosEnGaraje >= maxMotos) {
                throw new ExcepcionGarajeLleno("No se pueden agregar más motos. Límite alcanzado.");
            }
        }
    }

    // metodo para retirar un vehiculo
    public void retirarVehiculo(String placa) throws ExcepcionGaraje {
        Vehiculo vehiculo = buscarVehiculo(placa);
        if (vehiculo == null) {
            throw new ExcepcionGaraje("El vehículo con la placa " + placa + " no se encuentra en este garaje.");
        }
        espacios.remove(vehiculo);
    }

    // Agregar este método main
    public static void main(String[] args) {
        // Aquí puedes inicializar y probar tu clase
    }

    public int contarVehiculosPorTipo(String tipoVehiculo) {
        int contador = 0;
        for (Vehiculo vehiculo : espacios) {
            if (vehiculo != null) {
                if ((tipoVehiculo.equalsIgnoreCase("Camion") && vehiculo instanceof Camion) ||
                    (tipoVehiculo.equalsIgnoreCase("Moto") && vehiculo instanceof Moto) ||
                    (tipoVehiculo.equalsIgnoreCase("Carro") && vehiculo instanceof Auto)) {
                    contador++;
                }
            }
        }
        return contador;
    }
}


