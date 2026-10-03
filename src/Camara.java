public class Camara extends Equipo {
    private int resolution;

    public Camara(int code, String brand, String model, double dailyCost, int resolution) {
        super(code, brand, model, dailyCost);
        this.resolution = resolution;
    }

    @Override
    protected double calculateExtraCost(int days) {
        if (resolution > 1080) {
            return 75.0; 
        }
        return 0.0;
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Tipo: Cámara | Resolución: " + resolution + "p";
    }
}