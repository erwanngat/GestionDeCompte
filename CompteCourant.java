public class CompteCourant extends Compte {
    private double decouvertAutorise;

    public CompteCourant(String proprietaire, double decouvertAutorise) {
        super(proprietaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public double calculBenefice() {
        return 0;
    }

    @Override
    public void information() {
        super.information();
        System.out.println("Découvert autorisé : " + decouvertAutorise);
    }
}
