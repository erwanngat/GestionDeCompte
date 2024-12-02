import java.util.Scanner;

public class Main {
    private static GestionDeComptes gestionDeComptes = new GestionDeComptes();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quitter = false;

        while (!quitter) {
            afficherMenu();
            int choix = demanderChoixUtilisateur();

            switch (choix) {
                case 1:
                    ajouterCompteCourant();
                    break;
                case 2:
                    ajouterCompteEpargne();
                    break;
                case 3:
                    crediterCompte();
                    break;
                case 4:
                    debiterCompte();
                    break;
                case 5:
                    effectuerVirement();
                    break;
                case 6:
                    afficherComptes();
                    break;
                case 7:
                    trierComptes();
                    break;
                case 8:
                    quitter = true;
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Choix invalide, essayez à nouveau.");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Créer un compte courant");
        System.out.println("2. Créer un compte épargne");
        System.out.println("3. Créditer un compte");
        System.out.println("4. Débiter un compte");
        System.out.println("5. Effectuer un virement");
        System.out.println("6. Afficher la liste des comptes");
        System.out.println("7. Trier les comptes");
        System.out.println("8. Quitter");
        System.out.print("Choisissez une option : ");
    }

    private static int demanderChoixUtilisateur() {
        return scanner.nextInt();
    }

    private static void ajouterCompteCourant() {
        scanner.nextLine();
        System.out.print("Nom du propriétaire : ");
        String proprietaire = scanner.nextLine();
        System.out.print("Découvert autorisé : ");
        double decouvertAutorise = scanner.nextDouble();

        CompteCourant compteCourant = new CompteCourant(proprietaire, decouvertAutorise);
        gestionDeComptes.ajouterCompte(compteCourant);
        System.out.println("Compte courant ajouté !");
    }

    private static void ajouterCompteEpargne() {
        scanner.nextLine();
        System.out.print("Nom du propriétaire : ");
        String proprietaire = scanner.nextLine();
        System.out.print("Taux d'abondement (%): ");
        double tauxAbondement = scanner.nextDouble();

        CompteEpargne compteEpargne = new CompteEpargne(proprietaire, tauxAbondement);
        gestionDeComptes.ajouterCompte(compteEpargne);
        System.out.println("Compte épargne ajouté !");
    }

    private static void crediterCompte() {
        scanner.nextLine();
        System.out.print("Nom du propriétaire du compte à créditer : ");
        String proprietaire = scanner.nextLine();
        Compte compte = gestionDeComptes.trouverCompteParProprietaire(proprietaire);
        
        while (compte == null) {
            System.out.println("Compte non trouvé. Veuillez saisir un nom valide.");
            System.out.print("Nom du propriétaire du compte à créditer : ");
            proprietaire = scanner.nextLine();
            compte = gestionDeComptes.trouverCompteParProprietaire(proprietaire);
        }
        System.out.print("Montant à créditer : ");
        double montant = scanner.nextDouble();
        compte.crediter(montant);
        System.out.println("Compte crédité de " + montant + " €.");
    }

    private static void debiterCompte() {
        scanner.nextLine();
        System.out.print("Nom du propriétaire du compte à débiter : ");
        String proprietaire = scanner.nextLine();
        
        Compte compte = gestionDeComptes.trouverCompteParProprietaire(proprietaire);
        while (compte == null) {
            System.out.println("Compte non trouvé. Veuillez saisir un nom valide.");
            System.out.print("Nom du propriétaire du compte à débiter : ");
            proprietaire = scanner.nextLine();
            compte = gestionDeComptes.trouverCompteParProprietaire(proprietaire);
        }
    
        System.out.print("Montant à débiter : ");
        double montant = scanner.nextDouble();
        compte.debiter(montant);
        System.out.println("Compte débité de " + montant + " €.");
    }

    private static void effectuerVirement() {
        scanner.nextLine();
        System.out.print("Nom du propriétaire du compte source : ");
        String proprietaireSource = scanner.nextLine();
        Compte compteSource = gestionDeComptes.trouverCompteParProprietaire(proprietaireSource);
        
        while (compteSource == null) {
            System.out.println("Compte source non trouvé. Veuillez saisir un nom valide.");
            System.out.print("Nom du propriétaire du compte source : ");
            proprietaireSource = scanner.nextLine();
            compteSource = gestionDeComptes.trouverCompteParProprietaire(proprietaireSource);
        }

        System.out.print("Nom du propriétaire du compte destination : ");
        String proprietaireDest = scanner.nextLine();
        Compte compteDest = gestionDeComptes.trouverCompteParProprietaire(proprietaireDest);
        while (compteDest == null) {
            System.out.println("Compte destination non trouvé. Veuillez saisir un nom valide.");
            System.out.print("Nom du propriétaire du compte destination : ");
            proprietaireDest = scanner.nextLine();
            compteDest = gestionDeComptes.trouverCompteParProprietaire(proprietaireDest);
        }
        
        System.out.print("Montant du virement : ");
        double montant = scanner.nextDouble();
    
        compteSource.debiter(montant);
        compteDest.crediter(montant);
        System.out.println("Virement de " + montant + " € effectué.");
    }

    private static void afficherComptes() {
        gestionDeComptes.afficherComptes();
    }

    private static void trierComptes() {
        gestionDeComptes.trierComptes();
        System.out.println("Comptes triés par solde.");
    }
}
