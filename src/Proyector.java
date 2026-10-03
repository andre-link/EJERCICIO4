public class Proyector extends Equipo {
    private int lumenes;
    private boolean inalambrico;

    public Proyector(int code, String brand, String model, double dailyCost, int lumenes, boolean inalambrico) {
        super(code, brand, model, dailyCost);
        this.lumenes = lumenes;
        this.inalambrico = inalambrico;
    }

    @Override
    protected double calculateExtraCost(int days) {
        if (inalambrico) {
            return 50.0 * days; 
        }
        return 0.0;
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Tipo: Proyector | Lúmenes: " + lumenes + 
               " | Inalámbrico: " + (inalambrico ? "Sí" : "No");
    }
}