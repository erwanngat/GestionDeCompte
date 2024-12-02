public class Operation {
    private double montant;
    private Mouvement type;

    public Operation() {
        this.montant = 0;
        this.type = Mouvement.CREDIT;
    }

    public Operation(double montant, Mouvement type) {
        this.montant = montant;
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public Mouvement getType() {
        return type;
    }
}
