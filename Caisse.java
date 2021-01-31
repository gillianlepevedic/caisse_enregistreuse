
/**
 * classe principale
 * point d'entree
 */
public class Caisse {
    public static void main(String[] arg){
        int choix = -1;
        Ticket leTicket = new Ticket();
        leTicket.initialiser();//initialise pour pas remetres a chauqe fois des valeur 

        while(choix != 0){
            choix = afficherMenu();
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
					demandeNouveauProduit(leTicket);
					break; 
				case 3: 
                    System.out.println("Afficher un produit");
                    demandeAffiche1Produit(leTicket);
                    break;
                case 4: 
                    System.out.println("Supression un produit");
                    suppression1Produit(leTicket);
					break; 
				default: System.out.println("Erreur : Choix inconnue"); //Normalement arrive jamais 
            }
        }
    }

    private static int afficherMenu(){
        LectureClavier clavier = new LectureClavier();//Methode qui lits different valeur au clavier
		int mode;
		System.out.print("Menu\n0 : Quitter\n1 : Affiche Tout\n2 : Ajouter un produit\n3 : Afficher un produit\n4 : Supression d'un Produit\n");
		mode = clavier.demandeEntierInterval(0,4);//demmandeEntierInteval() permet de lire comprit entre min et mac et recommance si ca convient pas

		return mode;//retourne le choix
	}

	public static void demandeAffiche1Produit(Ticket leTicket){
        leTicket.afficherTout();
        if (leTicket.getNbProd() > 0 ){
            LectureClavier clavier = new LectureClavier();//Methode qui lits different valeur au clavier

            System.out.print("Donnez numero du produit :");
            int num = clavier.demandeEntierInterval(1, leTicket.getNbProd());//demmandeEntierInteval() permet de lire comprit entre min et mac et recommance si ca convient pas
            leTicket.afficherUnProduit(num);//affiche le produit demander
        }else{
            System.out.println("Erreur : Affichage imposible (Pas d'element dans la liste)");
        }
	}

	public static void demandeNouveauProduit(Ticket leTicket) {
        LectureClavier clavier = new LectureClavier();// Methode qui lits different valeur au clavier

        System.out.print("Donnez le nom du produit :");
        String nomProduit = clavier.demandeMot();// demmandeMot() permet de lire un mots avec min et/ou maj ou/et
                                                 // underscore et recommance si ca convient pas
        System.out.print("Donnez le prix du produit :");
        int prix = clavier.demandeEntier();// demmandeEniter() permet de lire entier et recommance si ca convient pas
        leTicket.ajouterProduit(nomProduit, prix);// ajoute le produit au ticket
	}
	
	public static void suppression1Produit(Ticket leTicket) {
        if (leTicket.getNbProd() > 0) {
            LectureClavier clavier = new LectureClavier();// Methode qui lits different valeur au clavier

            leTicket.afficherTout();// affiche tout pour voir lequel supprimer
            System.out.print("Donner le produit a suprimer:");
            int num = clavier.demandeEntierInterval(1, leTicket.getNbProd());// demmandeEntierInteval() permet de lire comprit
																	// entre min et mac et recommance si ca convient pas
			leTicket.supprimeUnProduit(num);														
            leTicket.afficherTout();// re affiche tout pour voir que ca a été supprimer
        } else {
            System.out.println("Erreur : Supression imposible (Pas d'element dans la liste)");
        }

    }
}