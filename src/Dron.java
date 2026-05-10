public abstract class Dron {
    private String codigo;
    private String modelo;
    private double distanciaKm;
    private double pesoPaquete;
    private double horasVuelo;
    protected double costoBase;

    public Dron(String codigo,
                String modelo,
                double distanciaKm,
                double pesoPaquete,
                double horasVuelo,
                double costoBase){
        setCodigo(codigo);
        setModelo(modelo);
        setDistanciaKm(distanciaKm);
        setPesoPaquete(pesoPaquete);
        setHorasVuelo(horasVuelo);
        this.costoBase = costoBase;
    }

    public void setCodigo(String codigo) {
        if (codigo.isEmpty()){
            System.out.println("Codigo no puede estar vacio");
        } else {
            this.codigo = codigo;
        }
    }

    public void setModelo(String modelo) {
        if (modelo.isEmpty()){
            System.out.println("Modelo no puede estar vacio");
        } else {
            this.modelo = modelo;
        }
    }

    public void setDistanciaKm(double distanciaKm) {
        if (distanciaKm > 0){
            this.distanciaKm = distanciaKm;
        } else {
            System.out.println("La distancia debe ser mayor a 0");
        }
    }

    public void setPesoPaquete(double pesoPaquete) {
        if (pesoPaquete > 0){
            this.pesoPaquete = pesoPaquete;
        } else {
            System.out.println("El peso del paquete debe ser mayor a 0");
        }
    }

    public void setHorasVuelo(double horasVuelo) {
        if (horasVuelo > 0){
            this.horasVuelo = horasVuelo;
        } else {
            System.out.println("Las horas de vuelo deben ser mayor a 0");
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public double getPesoPaquete() {
        return pesoPaquete;
    }

    public double getHorasVuelo() {
        return horasVuelo;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public abstract double calcularCostoEntrega();

    public abstract boolean validarDatos();

    public void mostrarInformacion(){
        System.out.println("Codigo: "+getCodigo());
        System.out.println("Modelo: "+getModelo());
        System.out.println("Distancia: "+getDistanciaKm());
        System.out.println("Peso paquete: "+getPesoPaquete());
        System.out.println("Horas vuelo: "+getHorasVuelo());
        System.out.println("Costo base: "+getCostoBase());
    }
}