import java.util.ArrayList;
import java.util.List;

public class Ticket {
    List<Produit> listeProduit = new ArrayList<>();// Liste de produit du ticket
    int nbProd = 0;

    public void initialiser() {// Initialisation juste pour pas remmetre a chaque fois des valeur
        this.ajouterProduit("Poulet", 5);
        this.ajouterProduit("Frite", 2);
        this.ajouterProduit("Eau", 1);
        this.ajouterProduit("rosbeef", 20);
    }

    public void ajouterProduit(String libelle, int prix) {
        Produit prod = new Produit();// Crée un nouveau produit
        prod.setlibelle(libelle);// Attribuer. le bon nom du produit
        prod.setprix(prix);// Attribuer. le bon prix au produit

        this.listeProduit.add(prod);

        this.nbProd++;// Incrementer le nb de produit dans le ticket
    }

    public void supprimeUnProduit(int num) {
        this.listeProduit.remove(num - 1);// suprimme le produit demander
        this.nbProd--;// decrement parce que on a suprimer un produit
    }

    public void afficherUnProduit(int num) {
        System.out.print("Produit numero " + (num));
        num--;// Decrement de 1 parce que le tableau commance a 0
        System.out.print(" Nom " + this.listeProduit.get(num).getlibelle());// Affiche le nom du produit grace a son
                                                                            // numero de produit
        System.out.println(" Prix " + this.listeProduit.get(num).getprix() + " euros");// Affiche le prix du produit
                                                                                       // grace a son numero de produit
    }

    public void afficherTout() {
        int somme = 0;// Permet de fair la somme du prix des produit du ticket
        System.out.println("");
        for (int i = 0; i < this.nbProd; i++) {// Parcour tout le ticket
            afficherUnProduit(i + 1);// Affiche tout les produit du ticket
            somme += this.listeProduit.get(i).getprix();// Increment le prix du des produit au fur et a mesur
        }
        System.out.println("Prix total : " + somme + " euros");
        System.out.println("");
    }


    public List<Produit> getListeProduit() {
        return listeProduit;
    }

    public void setListeProduit(List<Produit> listeproduit) {
        this.listeProduit = listeproduit;
    }

    public int getNbProd() {
        return nbProd;
    }

    public void setNbProd(int nbProd) {
        this.nbProd = nbProd;
    }
}