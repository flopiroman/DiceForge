package main.java.projet_dice_forge.Plateau_Joueur;


import main.java.projet_dice_forge.Ressource.FragementLunaire;
import main.java.projet_dice_forge.Ressource.FragementSolaire;
import main.java.projet_dice_forge.Ressource.Gloire;
import main.java.projet_dice_forge.Ressource.Or;

/**
*Cette classe représente le plateau d'un joueur de Dice Forge.
 */
public class PlateauDuJoueur{

        //l'Identifiant du joueur concerné.
        private int idJoueur;
        //Les points de gloire du joueur concerné.
        private Gloire pointsDeGloire;
        //L'or dont dispose le joueur concerné.
        private Or or;

        private FragementSolaire fragmentSolaire;

        private FragementLunaire fragmentLunaire;

        private int maxOr = 12;

        private int maxFragLun =6;

        private int maxFragSol=6;




    /**
     * Crée un plateau qui rassemble les informations correspondantes à un joueur
     *
     * @param idJoueur identifiant du joueur concerné.
     */



    PlateauDuJoueur(int idJoueur){
        this.pointsDeGloire=new Gloire(0);
        this.idJoueur=idJoueur;
        this.or=new Or(0);
        this.fragmentSolaire=new FragementSolaire(0);
        this.fragmentLunaire=new FragementLunaire(0);

    }

    ////////////////////////////////////////*Traitement Point de gloire *///////////////////////////////////////////////////
    /**
     * Retourne les points de gloire du joueur
     */

    public int getPointsDeGloire() {
        return pointsDeGloire.getRessources();
    }

    public void ajouterOr(int or) {
        this.or.ajoutRessources(or);
    }

    public void enleverOr(int or) {
       this.or.enleverRessources(or);
    }

    public void ajouterPointDeGloire(int ptGloire) {
            this.pointsDeGloire.ajoutRessources(ptGloire);
    }



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////*Traitement Point d'Or *///////////////////////////////////////////////////

    /**
     *getter et setter pour la ressource or
     */
    public int getOr(){
        return or.getRessources();
    }

    public void setOr(int or){
        this.or.setRessources(or);
    }

    public void setMaxOr(int maxOr) {
        this.maxOr = maxOr;
    }

    public int getMaxOr() {
        return maxOr;
    }
    /////////////////////////////////////////////Taitement Joueur/////////////////////////////////////////////////////

    /**
     * permet de définir le joueur concerné
     * @param idJoueur
     */
    public void setJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }


    public int getIdJoueur(){return this.idJoueur;}

    ////////////////////////////////////////*Traitement fragement Lunaire et Solaire *///////////////////////////////////////////////////


    public int getFragmentLunaire() {
        return fragmentLunaire.getRessources();
    }

    public int getFragmentSolaire() {
        return fragmentSolaire.getRessources();
    }

    public void enleverFragmentSolaire(int fragmentSolaire) {
        this.fragmentSolaire.enleverRessources(fragmentSolaire);
    }

    public void enleverFragmentLunaire(int fragmentLunaire) {
        this.fragmentLunaire.enleverRessources(fragmentLunaire);
    }


    public int getMaxFragLun() {
        return maxFragLun;
    }

    public int getMaxFragSol() {
        return maxFragSol;
    }

    public void setMaxFragSol(int maxFragSol) {
        this.maxFragSol = maxFragSol;
    }

    public void setMaxFragLun(int maxFragLun) {
        this.maxFragLun = maxFragLun;
    }

    public void ajouterFragLun(int fragLun){
        this.fragmentLunaire.ajoutRessources(fragLun);
    }

    public void ajouterFragSol(int fragSol){
        this.fragmentSolaire.ajoutRessources(fragSol);
    }


}