public interface iGaraje {
    double calcularIngresos();
    int calcularOcupacionPorTipoVehiculo(Class<? extends Vehiculo> tipoVehiculo);
}
