public class DronCarga extends Dron{
    private double costoPorKg;

    public DronCarga() {
        super("DC-000", "CargaMax", 5.0, 2.0, 1.0, 6.00);
        this.costoPorKg = 0.5;
    }

    public DronCarga(String codigo,
                     String modelo,
                     double distanciaKm,
                     double pesoPaquete,
                     double horasVuelo,
                     double costoPorKg){
        super(codigo, modelo, distanciaKm, pesoPaquete, horasVuelo, 6.00);
        setCostoPorKg(costoPorKg);
    }

    public double getCostoPorKg() {
        return costoPorKg;
    }

    public void setCostoPorKg(double costoPorKg) {
        if (costoPorKg > 0 && costoPorKg <= 20){
            this.costoPorKg = costoPorKg;
        } else {
            System.out.println("El costo por kilogramo debe ser mayor a cero y menor o igual a 20");
        }
    }

    @Override
    public boolean validarDatos(){
        return getPesoPaquete() <= 30 && getHorasVuelo() <= 5 && getDistanciaKm() <= 50;
    }

    @Override
    public double calcularCostoEntrega(){
        if (validarDatos()){
            return getCostoBase() + (getDistanciaKm() * 0.70) + (getPesoPaquete() * getCostoPorKg());
        }
        return 0;
    }

    public void mostrarInformacion(){
        System.out.println("--- Dron Carga ---");
        super.mostrarInformacion();
        System.out.println("Costo de entrega: "+calcularCostoEntrega()+"\n");
    }
}
