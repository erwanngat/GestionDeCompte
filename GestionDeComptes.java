import java.util.ArrayList;
import java.util.List;

public class GestionDeComptes {
    private List<Compte> comptes = new ArrayList<>();

    public void ajouterCompte(Compte compte) {
        comptes.add(compte);
    }

    public void afficherComptes() {
        for (Compte compte : comptes) {
            compte.information();
            System.out.println("*******************************************");
        }
    }

    public void trierComptes() {
        comptes.sort((compte1, compte2) -> Double.compare(compte1.calculSolde(), compte2.calculSolde()));
    }

    public Compte trouverCompteParProprietaire(String proprietaire) {
        for (Compte compte : comptes) {
            if (compte.getProprietaire().equalsIgnoreCase(proprietaire)) {
                return compte;
            }
        }
        return null;
    }
}
