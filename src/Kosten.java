public class Kosten {
    private double kost;
    private String naam;

    public Kosten(String naam, double kost) {
        this.naam = naam;
        this.kost = kost;
    }

    public String getNaam() {
        return naam;
    }

    public double getKost() {
        return kost;
    }

    public void setKost(double kost) {
        this.kost = kost;
    }
}
