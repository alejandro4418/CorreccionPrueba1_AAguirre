//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
void main() {
    Scanner sc = new Scanner(System.in);

    List<Dron> listaDrones = new ArrayList<>();
    System.out.println("========= INFORMACIÓN INICIAL DE DRONES ========");
    Dron d1= new DronLiviano("LIV001", "LivianoX", 12.5, 2.3, 1.5);
    Dron d2 = new DronCarga("CAR001", "CargaMax", 45.0, 20.0, 3.0, 0.5);
    Dron d3 = new DronEmergencia("EMG001", "Emergente", 8.0, 3.0, 1.0, 8.00, 2);

    listaDrones.add(d1);
    listaDrones.add(d2);
    listaDrones.add(d3);

    for (Dron d : listaDrones) {
        d.mostrarInformacion();
    }

    System.out.println("\n========= INGRESO DE NUEVOS DATOS ========");
    System.out.println("¿Qué dron desea actualizar?");
    System.out.println("1. Dron Liviano");
    System.out.println("2. Dron Carga");
    System.out.println("3. Dron Emergencia");
    System.out.print("Opción: ");
    int opcion = sc.nextInt();
    sc.nextLine();

    boolean datosValidos = false;
    Dron dronActualizado = null;

    try {
        switch (opcion) {
            case 1:
                System.out.print("Ingrese nueva distancia (km): ");
                double dist = sc.nextDouble();
                System.out.print("Ingrese nuevo peso del paquete (kg): ");
                double peso = sc.nextDouble();
                System.out.print("Ingrese nuevas horas de vuelo: ");
                double horas = sc.nextDouble();

                dronActualizado = new DronLiviano(
                        d1.getCodigo(), d1.getModelo(),
                        dist, peso, horas
                );

                if (dronActualizado.validarDatos()) {
                    datosValidos = true;
                    System.out.println("Los datos cumplen con las validaciones.");
                } else {
                    System.out.println("ERROR: Los datos no cumplen las validaciones.");
                }
                break;

            case 2:
                System.out.print("Ingrese nueva distancia (km): ");
                dist = sc.nextDouble();
                System.out.print("Ingrese nuevo peso del paquete (kg): ");
                peso = sc.nextDouble();
                System.out.print("Ingrese nuevas horas de vuelo: ");
                horas = sc.nextDouble();
                System.out.print("Ingrese costo por kg: ");
                double costoKg = sc.nextDouble();

                dronActualizado = new DronCarga(
                        d2.getCodigo(), d2.getModelo(),
                        dist, peso, horas, costoKg
                );

                if (dronActualizado.validarDatos()) {
                    datosValidos = true;
                    System.out.println("Los datos cumplen con las validaciones.");
                } else {
                    System.out.println("ERROR: Los datos no cumplen las validaciones.");
                }
                break;

            case 3:
                System.out.print("Ingrese nueva distancia (km): ");
                dist = sc.nextDouble();
                System.out.print("Ingrese nuevo peso del paquete (kg): ");
                peso = sc.nextDouble();
                System.out.print("Ingrese nuevas horas de vuelo: ");
                horas = sc.nextDouble();
                System.out.print("Ingrese recargo de urgencia: ");
                double recargo = sc.nextDouble();
                System.out.print("Ingrese nivel prioridad (1-3): ");
                int prioridad = sc.nextInt();

                dronActualizado = new DronEmergencia(
                        d3.getCodigo(), d3.getModelo(),
                        dist, peso, horas, recargo, prioridad
                );

                if (dronActualizado.validarDatos()) {
                    datosValidos = true;
                    System.out.println("Los datos cumplen con las validaciones.");
                } else {
                    System.out.println("ERROR: Los datos no cumplen las validaciones.");
                }
                break;

            default:
                System.out.println("Opción inválida");
        }

        if (datosValidos) {
            System.out.print("¿Desea guardar los cambios? (s/n): ");
            char respuesta = sc.next().charAt(0);
            if (respuesta == 's' || respuesta == 'S') {
                if (opcion == 1) listaDrones.set(0, dronActualizado);
                else if (opcion == 2) listaDrones.set(1, dronActualizado);
                else if (opcion == 3) listaDrones.set(2, dronActualizado);
                System.out.println("Datos actualizados correctamente.");
            } else {
                System.out.println("No se guardaron los cambios.");
            }
        }

    } catch (Exception e) {
        System.out.println("Error al ingresar datos: " + e.getMessage());
    }

    System.out.println("\n========= DEMOSTRACIÓN DE POLIMORFISMO ========");
    System.out.println("Lista de drones (tipo Dron):");
    for (Dron d : listaDrones) {
        System.out.println("-> " + d.getCodigo() + " | Modelo: " + d.getModelo() +
                " | Costo entrega: " + String.format("%.2f", d.calcularCostoEntrega()));
    }

    System.out.println("\nLlamando al método mostrarInformacion() desde referencia Dron:");
    for (Dron d : listaDrones) {
        d.mostrarInformacion();
        System.out.println();
    }

    Dron d4 = new DronLiviano();
    Dron d5 = new DronCarga();
    Dron d6 = new DronEmergencia();

    d4.mostrarInformacion();
    d5.mostrarInformacion();
    d6.mostrarInformacion();

    System.out.println("\n========= FIN DEL PROGRAMA ========");
    System.out.println("Gracias por usar el sistema de drones.");
    System.out.println("Hasta luego.");

    sc.close();
}

