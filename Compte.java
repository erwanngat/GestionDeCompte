import java.util.ArrayList;
import java.util.List;

public abstract class Compte implements Comparable<Compte> {
    protected List<Operation> operations;
    protected String proprietaire;

    public Compte(String proprietaire) {
        this.proprietaire = proprietaire;
        this.operations = new ArrayList<>();
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void crediter(double montant) {
        operations.add(new Operation(montant, Mouvement.CREDIT));
    }

    public void debiter(double montant) {
        operations.add(new Operation(montant, Mouvement.DEBIT));
    }

    public void crediter(double montant, Compte compteADebiter) {
        this.crediter(montant);
        compteADebiter.debiter(montant);
    }

    public void debiter(double montant, Compte compteACrediter) {
        this.debiter(montant);
        compteACrediter.crediter(montant);
    }

    public double calculSolde() {
        double solde = 0;
        for (Operation op : operations) {
            if (op.getType() == Mouvement.CREDIT) {
                solde += op.getMontant();
            } else {
                solde -= op.getMontant();
            }
        }
        return solde;
    }

    public abstract double calculBenefice();

    public double soldeFinal() {
        return calculSolde() + calculBenefice();
    }

    public void information() {
        System.out.println("Propriétaire : " + proprietaire);
        System.out.println("Solde : " + calculSolde());
        afficherOperations();
    }

    private void afficherOperations() {
        System.out.println("Opérations :");
        for (Operation op : operations) {
            System.out.println(op.getType() + " : " + op.getMontant());
        }
    }

    @Override
    public int compareTo(Compte other) {
        return Double.compare(this.calculSolde(), other.calculSolde());
    }
}
