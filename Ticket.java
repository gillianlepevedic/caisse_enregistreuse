import java.util.ArrayList;
import java.util.List;
/**
 * Class qui definit Un ticket. il est composer de List de "Produit" et un int "nbProd"
 */
public class Ticket {
    List<Produit> listeProduit = new ArrayList<>();// Liste de produit du ticket
    int nbProd = 0;
    /**
     * Initialisation juste pour pas remmetre a chaque fois des valeur
     */
    public void initialiser() {
        this.ajouterProduit("Poulet", 5);
        this.ajouterProduit("Frite", 2);
        this.ajouterProduit("Eau", 1);
        this.ajouterProduit("rosbeef", 20);
    }
    /**
     * Ajoute un produit grace a sont nom et sont prix
     * @param libelle nom du produit
     * @param prix prix du produit
     */
    public void ajouterProduit(String libelle, int prix) {
        //Initialise les variable utile
        Produit prod = new Produit();
        //place les paramttres dans un Produit
        prod.setLibelle(libelle);
        prod.setPrix(prix);
        //Ajoute le produit dans un ticket
        this.listeProduit.add(prod);
        this.nbProd++;
    }
    /**
     * Supprimme un produit grace a sont num de Produit
     * @param num numero de produit
     */
    public void supprimeUnProduit(int num) {
        this.listeProduit.remove(num - 1);// suprimme le produit demander
        this.nbProd--;// decrement parce que on a suprimer un produit
    }
    /**
     * Affiche le produit corespondant au numero
     * @param num umero de produit
     */
    public void afficherUnProduit(int num) {
        System.out.print("Produit numero " + (num));
        num--;// Decrement de 1 parce que le tableau commance a 0
        System.out.print(" Nom " + this.listeProduit.get(num).getLibelle());
        System.out.println(" Prix " + this.listeProduit.get(num).getPrix() + " euros");
    }
    /**
     * Affiche l'integraliter du ticket
     */
    public void afficherTout() {
        //Initialise les variable utile
        int somme = 0;// Permet de fair la somme du prix des produit du ticket
        // Parcour tout le ticket
        System.out.println("");
        for (int i = 0; i < this.nbProd; i++) {
            afficherUnProduit(i + 1);
            somme += this.listeProduit.get(i).getPrix();
        }
        //Affiche la somme du ticket
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