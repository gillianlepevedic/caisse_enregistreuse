import java.util.Scanner;

public class LectureClavier {
    private Scanner clavier;//Ouvre STDIN et pour les nombres réel il faut utiliser un point
    
    public LectureClavier(Scanner entrer) {
        clavier = entrer;
    }

    public int demandeEntier(){
        boolean ok=false;
        int entier=0;

        while (! ok){//Tant qu'il a pa lu un entier il sort pas
            try {//Si la commande nextInt ne marche pas Alors il fait se qu'il y a dans catch 
                entier = clavier.nextInt();//Si c'est un entier tout va bien sinon une erreur
                ok = true;//Il a reussie a lire un entier
            } 
            catch (java.util.InputMismatchException e) {//Si l'entrer n'est pas un entier alors il fait ca
                System.out.print("Erreur : Chiffre incorrect \nDonnez un nombre entier :") ;
                clavier.nextLine();//Vide le clavier ca evite les erreur si on a tapez n'importe quoi
            }  
        }

        return entier;//Retourne l'entier taper au clavier
    }

    public int demandeEntierPositif(){
        boolean ok=false;
        int entierP=0;

        while (! ok){//Tant qu'il a pa lu un entier il sort pas
            entierP= demandeEntier();

            if (entierP >=0){
                ok = true;//Il a reussie a lire un entier positif
            }else{
                System.out.print("Erreur : Chiffre incorrect \nDonnez un nombre entier positif :") ;
            }
        }

        return entierP;//Retourne l'entier taper au clavier
    }

    public int demandeEntierInterval(int min, int max){
        boolean ok=false;
        int entierInter=0;

        while (! ok){//Tant qu'il a pa lu un entier dans l'interval il sort pas
            entierInter= demandeEntier();

            if (entierInter >=min && entierInter <= max){//si le nombres n'est pas comprit dans l'inteval il recommence
                ok = true;//Il a reussie a lire un entier dans l'interval
            }else{
                System.out.print("Erreur : Chiffre incorrect \nDonnezun nombres plus petit ou egal a " + max + " et plus grand ou egal a " + min + " :") ;
            }
        }

        return entierInter;//Retourne l'entier taper au clavier
    }

    public float demandeFloat(){
        boolean ok=false;
        float reel=0;

        while (! ok){//Tant qu'il a pa lu un réel il sort pas
            try {//Si la commande nextFloat ne marche pas Alors il fait se qu'il y a dans catch 
                reel = clavier.nextFloat();//Si c'est un réel tout va bien sinon une erreur
                ok = true;//Il a reussie a lire un réel
            } 
            catch (java.util.InputMismatchException e) {//Si l'entrer n'est pas un réel alors il fait ca
                System.out.print("Erreur : Chiffre incorrect \nDonnez un nombre reel :") ;
                clavier.nextLine();//Vide le clavier ca evite les erreur si on a tapez n'importe quoi
            }  
        }

        return reel;//Retourne le réel taper au clavier
    }
    
    public String demandeMot(){
        String mot = "";

        mot= demandeRegex("[A-Za-z_]+", "lettres min ,maj et underscore");//demande soit une/des lettres min ou maj ou underscore

        return mot;//Renvoie une chaine avec des lettres et des underscore
    }

	public String demandeRegex(String autoriserRegex, String autoriserFR){
        boolean ok=false;
        String operateur = "";

        while (! ok){//Tant qu'il a pa lu un quelque chose qui match avec le Regex il sort pas
            try {//Si la commande next ne marche pas Alors il fait se qu'il y a dans catch 
                operateur = clavier.next(autoriserRegex);//Si la lecture au clavier est match avec un regex alors pas de probleme sinon erreur
                ok = true;
            } 
            catch (java.util.InputMismatchException e) {//Si ca match pas
				System.out.print("Erreur : Operateur incorrect \nVous devez utiliser seulement ( " + autoriserFR + " ) :") ;//Affiche un message d'erreur personaliser 
																															//en fonction de se qu'on a mits en paramtres
                clavier.nextLine();//Vide le clavier ca evite les erreur si on a tapez n'importe quoi
            }  
        }

        return operateur;//Renvoie une chaine corespondant au Regex envoyer
    }


}