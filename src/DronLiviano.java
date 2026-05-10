public class DronLiviano extends Dron{
    private double limiteHoras;

    public DronLiviano() {
        super("DL-000", "LivianoX", 5.0, 2.0, 1.0, 3.00);
        this.limiteHoras = 2.0;
    }

    public DronLiviano(String codigo,
                       String modelo,
                       double distanciaKm,
                       double pesoPaquete,
                       double horasVuelo){
        super(codigo, modelo, distanciaKm, pesoPaquete, horasVuelo, 3.00);
        this.limiteHoras = 2.00;
    }

    public double getLimiteHoras() {
        return limiteHoras;
    }

    public void setLimiteHoras(double limiteHoras) {
        if (limiteHoras <= 2){
            this.limiteHoras = limiteHoras;
        } else {
            System.out.println("Limite de horas debe ser menor o igual a 2");
        }
    }

    @Override
    public boolean validarDatos(){
        return getPesoPaquete() <= 5 && getHorasVuelo() <= 2 && getDistanciaKm() <= 20;
    }

    @Override
    public double calcularCostoEntrega(){
        if (validarDatos()){
            return getCostoBase() + (getDistanciaKm() * 0.50);
        }
        return 0;
    }

    public void mostrarInformacion(){
        System.out.println("--- Dron Liviano ---");
        super.mostrarInformacion();
        System.out.println("Limite de peso: 5 kg");
        System.out.println("Limite de horas: "+getLimiteHoras()+" horas");
        System.out.println("Costo de entrega: "+calcularCostoEntrega()+"\n");
    }
}
