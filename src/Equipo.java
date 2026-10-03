public abstract class Equipo {
    private int code;
    private String brand;
    private String model;
    private double dailyCost;
    private boolean available;

    public Equipo(int code, String brand, String model, double dailyCost) {
        this.code = code;
        this.brand = brand;
        this.model = model;
        this.dailyCost = dailyCost;
        this.available = true; 
    }

    public double calculateCost(int days) {
        return (dailyCost * days) + calculateExtraCost(days);
    }

    protected abstract double calculateExtraCost(int days);

    public int getCode() { return code; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getDailyCost() { return dailyCost; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    
    @Override
    public String toString() {
        return "Código: " + code + " | Marca: " + brand + " | Modelo: " + model + 
               " | Tarifa diaria: Q" + dailyCost + " | Disponible: " + (available ? "Sí" : "No");
    }
}