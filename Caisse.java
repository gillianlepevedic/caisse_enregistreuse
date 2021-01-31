import java.util.Locale;
import java.util.Scanner;

/**
 * Classe principale 
 * point d'entree du programme
 */
public class Caisse {
    public static void main(String[] arg){
		//Initialise les variable utile
        int choix = -1;
        Ticket leTicket = new Ticket();
		leTicket.initialiser();//initialise pour pas remetres a chaque fois des valeurs 
		//Ouvre le port STDIN et pour les float utilise un "." grace a "Local.US"
		Scanner clavier = new Scanner(System.in).useLocale(Locale.US);
			while(choix != 0){
				choix = afficherMenu(clavier);
				switch(choix) { 
					case 0: 
						System.out.println("Fin programme");//Fin du programme
						break; 
					case 1: 
						System.out.println("Affichet tout");
						leTicket.afficherTout();
					break; 
					case 2: 
						System.out.println("Ajouter un produit");
						demandeNouveauProduit(clavier, leTicket);
						break; 
					case 3: 
						System.out.println("Afficher un produit");
						demandeAffiche1Produit(clavier, leTicket);
						break;
					case 4: 
						System.out.println("Supression un produit");
						suppression1Produit(clavier, leTicket);
						break; 
					default: System.out.println("Erreur : Choix inconnue"); //Normalement arrive jamais 
				}
			}
		
    }
	/**
	 * Cette fonction affiche le menu et lit au clavier le choix
	 * @param clavier Il sert a envoyer le Scanner pour lire au STDIN dans la fonction 
	 * @return	Retourne le choix de l'action dans le menu.
	 */
    private static int afficherMenu(Scanner clavier){
		//Initialise les variable utile
        LectureClavier clavierGigi = new LectureClavier(clavier);
		int mode = 0;
		//Affiche le menu et demande le choix
		System.out.print("Menu\n0 : Quitter\n1 : Affiche Tout\n2 : Ajouter un produit\n3 : Afficher un produit\n4 : Supression d'un Produit\n");
		mode = clavierGigi.demandeEntierInterval(0, 4);
		//retourne le choix
		return mode;
	}
	/**
	 * Affiche tout les produit. Demande dan selectionner un. Puis il l'affiche.
	 * @param clavier Il sert a envoyer le Scanner pour lire au STDIN dans la fonction
	 * @param leTicket Envoie le ticket pour afficher un produit
	 */
	public static void demandeAffiche1Produit(Scanner clavier, Ticket leTicket){
		//Affiche tout les produit
        leTicket.afficherTout();
        if (leTicket.getNbProd() > 0 ){
			//Initialise les variable utile
            LectureClavier clavierGigi = new LectureClavier(clavier);
			int num = 0;
			//Demande le numero d'un produit
            System.out.print("Donnez numero du produit :");
			num = clavierGigi.demandeEntierInterval(1, leTicket.getNbProd());
			//Affiche un produit
            leTicket.afficherUnProduit(num);
        }else{
            System.out.println("Erreur : Affichage imposible (Pas d'element dans la liste)");
        }
	}
	/**
	 * Demmande le nom du produit. Demande sont prix. Et l'ajoute a au ticket
	 * @param clavier Il sert a envoyer le Scanner pour lire au STDIN dans la fonction
	 * @param leTicket Envoie le ticket pour rajouter des produits
	 */
	public static void demandeNouveauProduit(Scanner clavier, Ticket leTicket) {
		//Initialise les variable utile
		LectureClavier clavierGigi = new LectureClavier(clavier);
		String nomProduit;
		int prix = 0;
		//Demande le nom du produit
        System.out.print("Donnez le nom du produit :");
		nomProduit = clavierGigi.demandeMot();
		//Demande le pric du produit
        System.out.print("Donnez le prix du produit :");
		prix = clavierGigi.demandeEntier();
		//Ajoute le produit au ticket
        leTicket.ajouterProduit(nomProduit, prix);
	}
	/**
	 * Affiche les produit. Demande dans selectionner un. Et le supprime
	 * @param clavier Il sert a envoyer le Scanner pour lire au STDIN dans la fonction
	 * @param leTicket Envoie le ticket pour supprimer un produit
	 */
	public static void suppression1Produit(Scanner clavier, Ticket leTicket) {
        if (leTicket.getNbProd() > 0) {
			//Initialise les variable utile
			LectureClavier clavierGigi = new LectureClavier(clavier);
			int num = 0;
			//Demande le produit a supprimer
            leTicket.afficherTout();
            System.out.print("Donner le produit a suprimer:");
			num = clavierGigi.demandeEntierInterval(1, leTicket.getNbProd());
			//suprime le fichier
			leTicket.supprimeUnProduit(num);
			//Affiche tout pour montrer que le fichier a ete supprimer														
            leTicket.afficherTout();
        } else {
            System.out.println("Erreur : Supression imposible (Pas d'element dans la liste)");
        }

    }
}