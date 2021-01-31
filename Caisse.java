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
					leTicket.demandeNouveauProduit();
					break; 
				case 3: 
                    System.out.println("Afficher un produit");
                    leTicket.demandeAffiche1Produit();
                    break;
                case 4: 
                    System.out.println("Supression un produit");
                    leTicket.suppression1Produit();
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
}