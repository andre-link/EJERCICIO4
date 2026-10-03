public class Sonido extends Equipo {
    private double potencia;

    public Sonido(int code, String brand, String model, double dailyCost, double potencia) {
        super(code, brand, model, dailyCost);
        this.potencia = potencia;
    }

    @Override
    protected double calculateExtraCost(int days) {
        return 100.0 * potencia * days; // Adicional de Q100 por cada kilovatio por cada día[cite: 1, 2]
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Tipo: Sonido | Potencia: " + potencia + " kW";
    }
}