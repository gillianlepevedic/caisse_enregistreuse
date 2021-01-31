import java.util.ArrayList;
import java.util.List;

public class Ticket {
    
        List<Produit> listeproduit = new ArrayList<>();//Liste de produit du ticket
        int nbProd=0;


        public void initialiser(){//Initialisation juste pour pas remmetre a chaque fois des valeur
            this.ajouterProduit("Poulet",5);
            this.ajouterProduit("Frite",2);
            this.ajouterProduit("Eau",1);
            this.ajouterProduit("rosbeef",20);
        }
    
        public void afficherTout(){
            int somme = 0;//Permet de fair la somme du prix des produit du ticket
            System.out.println("");
            for(int i = 0; i<this.getNbProd(); i++){//Parcour tout le ticket
                afficherUnProduit(i+1);//Affiche tout les produit du ticket
                somme += this.getListeProduit().get(i).getprix();//Increment le prix du des produit au fur et a mesur 
            }
            System.out.println("Prix total : " + somme + " euros");
            System.out.println("");
        }

        private void ajouterProduit(String libelle, int prix){
        Produit prod = new Produit();//Crée un nouveau produit
        List<Produit> listeprodtmp;
        prod.setlibelle(libelle);//Attribuer. le bon nom du produit
        prod.setprix(prix);//Attribuer. le bon prix au produit

/*         listeprodtmp = this.getListeProduit();//Creation d'un copie de la liste
        listeproduit.add(prod);//Modification de la copie
        this.setListeProd(listeprodtmp);//Upload de la copie
 */
        this.listeproduit.add(prod);
        
        this.setNbProd(this.getNbProd()+1);//Incrementer le nb de produit dans le ticket 
    }


    private void afficherUnProduit(int num){
        System.out.print("Produit numero " + (num));
        num--;//Decrement de 1 parce que le tableau commance a 0
        System.out.print(" Nom " + this.getListeProduit().get(num).getlibelle());//Affiche le nom du produit grace a son numero de produit
        System.out.println(" Prix " + this.getListeProduit().get(num).getprix() + " euros");//Affiche le prix du produit grace a son numero de produit
    }

    public void demandeNouveauProduit(){
        LectureClavier clavier = new LectureClavier();//Methode qui lits different valeur au clavier

        System.out.print("Donnez le nom du produit :");
        String nomProduit = clavier.demandeMot();//demmandeMot() permet de lire un mots avec min et/ou maj ou/et underscore et recommance si ca convient pas 
        System.out.print("Donnez le prix du produit :");
        int prix = clavier.demandeEntier();//demmandeEniter() permet de lire entier et recommance si ca convient pas 
        this.ajouterProduit(nomProduit,prix);//ajoute le produit au ticket
    }

    public void demandeAffiche1Produit(){
        this.afficherTout();
        if (this.getNbProd() >0){
            LectureClavier clavier = new LectureClavier();//Methode qui lits different valeur au clavier

            System.out.print("Donnez numero du produit :");
            int num = clavier.demandeEntierInterval(1, this.getNbProd());//demmandeEntierInteval() permet de lire comprit entre min et mac et recommance si ca convient pas
            this.afficherUnProduit(num);//affiche le produit demander
        }else{
            System.out.println("Erreur : Affichage imposible (Pas d'element dans la liste)");
        }
    }

    public void suppression1Produit(){
        if (this.getNbProd()>0){
            LectureClavier clavier = new LectureClavier();//Methode qui lits different valeur au clavier

            this.afficherTout();//affiche tout pour voir lequel supprimer
            System.out.print("Donner le produit a suprimer:");
            int num = clavier.demandeEntierInterval(1, this.getNbProd());//demmandeEntierInteval() permet de lire comprit entre min et mac et recommance si ca convient pas


            this.listeproduit.remove(num-1);//suprimme le produit demander
            this.setNbProd(this.getNbProd()-1);//decrement parce que on a suprimer un produit
            this.afficherTout();//re affiche tout pour voir que ca a été supprimer
        }else{
            System.out.println("Erreur : Supression imposible (Pas d'element dans la liste)");
        }

    }


     private List<Produit> getListeProduit(){
        return this.listeproduit;
    }

    private void setListeProd(List<Produit> listeproduit){
        this.listeproduit = listeproduit;
    }

    private int getNbProd(){
        return this.nbProd;
    }

    private void setNbProd(int nbProd){
        this.nbProd = nbProd;
    }




}