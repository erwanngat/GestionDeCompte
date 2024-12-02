public class CompteEpargne extends Compte {
    private double tauxAbondement;

    public CompteEpargne(String proprietaire, double tauxAbondement) {
        super(proprietaire);
        this.tauxAbondement = tauxAbondement;
    }

    @Override
    public double calculBenefice() {
        return calculSolde() * tauxAbondement / 100; 
    }

    @Override
    public void information() {
        super.information();
        System.out.println("Solde final : " + soldeFinal());
        System.out.println("Taux d’abondement : " + String.format("%.2f", tauxAbondement) + " %");
    }
}
