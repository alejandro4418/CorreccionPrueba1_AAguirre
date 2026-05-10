public class DronEmergencia extends Dron{
    private double recargoUrgencia;
    private int nivelPrioridad;

    public DronEmergencia() {
        super("DE-000", "Emergente", 5.0, 2.0, 1.0, 8.00);
        this.recargoUrgencia = 10.0;
        this.nivelPrioridad = 2;
    }

    public DronEmergencia(String codigo,
                          String modelo,
                          double distanciaKm,
                          double pesoPaquete,
                          double horasVuelo,
                          double recargoUrgencia,
                          int nivelPrioridad){
        super(codigo, modelo, distanciaKm, pesoPaquete, horasVuelo, 8.00);
        setRecargoUrgencia(recargoUrgencia);
        setNivelPrioridad(nivelPrioridad);
    }

    public void setRecargoUrgencia(double recargoUrgencia) {
        if (recargoUrgencia > 0){
            this.recargoUrgencia = recargoUrgencia;
        } else {
            System.out.println("El recargo debe ser mayor a 0");
        }
    }

    public void setNivelPrioridad(int nivelPrioridad) {
        if (nivelPrioridad > 0 && nivelPrioridad <= 3){
            this.nivelPrioridad = nivelPrioridad;
        } else {
            System.out.println("El nivel debe ser 1, 2 o 3");
        }
    }

    public double getRecargoUrgencia() {
        return recargoUrgencia;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    @Override
    public boolean validarDatos(){
        return getPesoPaquete() <= 10 && getHorasVuelo() <= 3 && getNivelPrioridad() > 0 && getNivelPrioridad() <= 3;
    }

    @Override
    public double calcularCostoEntrega(){
        if (validarDatos()){
            return getCostoBase() + (getDistanciaKm() * 1) + getRecargoUrgencia();
        }
        return 0;
    }

    public void mostrarInformacion(){
        System.out.println("--- Dron Emergencia ---");
        super.mostrarInformacion();
        System.out.println("Recargo urgencia: "+getRecargoUrgencia());
        System.out.println("Nivel prioridad: "+getNivelPrioridad());
        System.out.println("Costo de entrega: "+calcularCostoEntrega()+"\n");
    }
}
