/**
 * Classe qui definit un produit. Il est composer d'un String "libelle" sont nom et d'un int "prix"
 */
public class Produit {
        String libelle;
        int prix;

    public String getLibelle(){
        return libelle;
    }

    public void setLibelle(String libelle){
        this.libelle= libelle;
    }

    public int getPrix(){
        return prix;
    }

    public void setPrix(int prix){
        this.prix= prix;
    }
}