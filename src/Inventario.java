import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Equipo> equipos;
    private double ingresosTotales;

    public Inventario() {
        this.equipos = new ArrayList<>();
        this.ingresosTotales = 0.0;
    }

    public String registrarEquipo(Equipo equipo) {
        if (consultarEquipo(equipo.getCode()) != null) {
            return "Error: Ya existe un equipo con el código " + equipo.getCode();
        }
        equipos.add(equipo);
        return "Equipo registrado exitosamente.";
    }

    public Equipo consultarEquipo(int codigo) {
        for (Equipo e : equipos) {
            if (e.getCode() == codigo) {
                return e;
            }
        }
        return null;
    }

    public String cotizar(int codigo, int dias) {
        Equipo e = consultarEquipo(codigo);
        if (e == null) {
            return "Equipo no encontrado.";
        }
        return "--- Cotización ---\n" +
               e.toString() + "\n" +
               "Días de alquiler: " + dias + "\n" +
               String.format("Costo total: Q%.2f\n", e.calculateCost(dias)) +
               "------------------";
    }

    public String confirmarAlquiler(int codigo, int dias) {
        Equipo e = consultarEquipo(codigo);
        if (e == null) {
            return "Equipo no encontrado.";
        }
        if (!e.isAvailable()) {
            return "Error: El equipo no se puede alquilar porque está ocupado.";
        }
        
        double costo = e.calculateCost(dias);
        e.setAvailable(false);
        ingresosTotales += costo;
        return String.format("Alquiler confirmado. Total cobrado: Q%.2f", costo);
    }

    public String devolverEquipo(int codigo) {
        Equipo e = consultarEquipo(codigo);
        if (e == null) {
            return "Equipo no encontrado.";
        }
        if (e.isAvailable()) {
            return "Error: No se puede devolver un equipo que ya está disponible.";
        }
        e.setAvailable(true);
        return "Devolución registrada exitosamente.";
    }

    public String reporteGeneral() {
        int totalProyectores = 0, dispProyectores = 0, alqProyectores = 0;
        int totalCamaras = 0, dispCamaras = 0, alqCamaras = 0;
        int totalSonido = 0, dispSonido = 0, alqSonido = 0;

        for (Equipo e : equipos) {
            if (e instanceof Proyector) {
                totalProyectores++;
                if (e.isAvailable()) dispProyectores++; else alqProyectores++;
            } else if (e instanceof Camara) {
                totalCamaras++;
                if (e.isAvailable()) dispCamaras++; else alqCamaras++;
            } else if (e instanceof Sonido) {
                totalSonido++;
                if (e.isAvailable()) dispSonido++; else alqSonido++;
            }
        }

        return "\n--- Reporte de Fin de Jornada ---\n" +
               "Proyectores: " + totalProyectores + " (Disponibles: " + dispProyectores + " | Alquilados: " + alqProyectores + ")\n" +
               "Cámaras: " + totalCamaras + " (Disponibles: " + dispCamaras + " | Alquilados: " + alqCamaras + ")\n" +
               "Equipos de Sonido: " + totalSonido + " (Disponibles: " + dispSonido + " | Alquilados: " + alqSonido + ")\n" +
               String.format("Dinero acumulado por alquileres: Q%.2f\n", ingresosTotales) +
               "---------------------------------";
    }
}