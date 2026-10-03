import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);

        System.out.println(inventario.registrarEquipo(new Proyector(101, "Epson", "PowerLite", 150.0, 3200, true)));
        System.out.println(inventario.registrarEquipo(new Proyector(102, "Sony", "VPL-VW", 120.0, 2500, false)));
        System.out.println(inventario.registrarEquipo(new Camara(201, "Canon", "EOS R5", 250.0, 2160)));
        System.out.println(inventario.registrarEquipo(new Camara(202, "Sony", "Alpha 7", 200.0, 1080)));
        System.out.println(inventario.registrarEquipo(new Sonido(301, "Bose", "S1 Pro", 180.0, 1.5)));
        System.out.println(inventario.registrarEquipo(new Sonido(302, "JBL", "PartyBox", 200.0, 2.0)));

        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\n----- Menú -----");
            System.out.println("1. Cotizar equipo");
            System.out.println("2. Confirmar alquiler");
            System.out.println("3. Registrar devolución");
            System.out.println("4. Reporte general");
            System.out.println("5. Consultar equipo");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese código del equipo: ");
                        int codCotizar = Integer.parseInt(scanner.nextLine());
                        System.out.print("Ingrese cantidad de días: ");
                        int diasCotizar = Integer.parseInt(scanner.nextLine());
                        if (diasCotizar <= 0) {
                            System.out.println("Los días de alquiler deben ser enteros positivos.");
                            break;
                        }
                        System.out.println(inventario.cotizar(codCotizar, diasCotizar));
                        break;
                    case 2:
                        System.out.print("Ingrese código del equipo a alquilar: ");
                        int codAlquilar = Integer.parseInt(scanner.nextLine());
                        System.out.print("Ingrese cantidad de días: ");
                        int diasAlquilar = Integer.parseInt(scanner.nextLine());
                        if (diasAlquilar <= 0) {
                            System.out.println("Los días de alquiler deben ser enteros positivos.");
                            break;
                        }
                        System.out.println(inventario.cotizar(codAlquilar, diasAlquilar));
                        System.out.print("¿Desea confirmar el alquiler? (s/n): ");
                        String conf = scanner.nextLine();
                        if (conf.equalsIgnoreCase("s")) {
                            System.out.println(inventario.confirmarAlquiler(codAlquilar, diasAlquilar));
                        } else {
                            System.out.println("Operación cancelada. El estado se mantiene igual.");
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese código del equipo a devolver: ");
                        int codDevolver = Integer.parseInt(scanner.nextLine());
                        System.out.println(inventario.devolverEquipo(codDevolver));
                        break;
                    case 4:
                        System.out.println(inventario.reporteGeneral());
                        break;
                    case 5:
                        System.out.print("Ingrese código del equipo: ");
                        int codConsultar = Integer.parseInt(scanner.nextLine());
                        Equipo e = inventario.consultarEquipo(codConsultar);
                        if (e != null) {
                            System.out.println(e.toString());
                        } else {
                            System.out.println("Un código inexistente produce este mensaje claro.");
                        }
                        break;
                    case 6:
                        System.out.println("Saliendo..................");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Entrada inválida. Asegurese de ingresar el dato correctamente.");
            }
        }
        scanner.close();
    }
}