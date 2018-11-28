package main.java.projet_dice_forge.Bot;

import main.java.projet_dice_forge.Partie_Bassin.Bassin;
import main.java.projet_dice_forge.Partie_Bassin.Temple;
import main.java.projet_dice_forge.Partie_Iles.Carte;
import main.java.projet_dice_forge.Partie_Iles.CarteEffetImmediat;
import main.java.projet_dice_forge.Partie_Iles.CarteEffetPermanent;
import main.java.projet_dice_forge.Partie_Iles.Iles;
import main.java.projet_dice_forge.Plateau_Joueur.De;
import main.java.projet_dice_forge.Plateau_Joueur.Face;
import main.java.projet_dice_forge.Plateau_Joueur.PlateauDuJoueur;

import java.util.List;

import java.util.ArrayList;
import java.util.Random;

public class Joueur {
    protected int id = -1;
    protected De DeClaire;
    protected De DeSombre;
    protected PlateauDuJoueur Plateau;
    protected ArrayList<CarteEffetImmediat> ListeCarteEffetImmediat;
    protected ArrayList<CarteEffetPermanent> ListeCarteEffetPermanent;
    protected int PointDeGloireCarte;

    public Joueur(int Idjoueur){
        this.id=Idjoueur;
        this.DeClaire=new De("claire");
        this.DeSombre=new De("sombre");
        this.Plateau=new PlateauDuJoueur(Idjoueur);
        this.ListeCarteEffetImmediat=new ArrayList<>();
        this.ListeCarteEffetPermanent=new ArrayList<>();
    }

    public Joueur(int Idjoueur, De de1, De de2, PlateauDuJoueur Plateau){
        this.id=Idjoueur;
        this.DeClaire=de1;
        this.DeSombre=de2;
        this.Plateau=Plateau;
        this.ListeCarteEffetImmediat=new ArrayList<>();
        this.ListeCarteEffetPermanent=new ArrayList<>();
    }

    /**
     * Retourne les dés du joueur concerné
     *
     */
    public De getDe(int idDe){
        if(idDe == 1){
            return DeClaire;
        }
        else{
            return DeSombre;
        }
    }
    public  PlateauDuJoueur getPlateauDuJoueur(){
        return Plateau;
    }

    public int getPtGloire() {
        return Plateau.getPointsDeGloire();
    }

    public void reset() {
        resetPlateauDuJoueur();
        resetDe();
    }
///////////////////////////////////////////Partie gère les Cartes du joueur////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<CarteEffetImmediat> getListeCarte() {
        return ListeCarteEffetImmediat;
    }

    public int ChercherCarte(int IdCarte) {
        for (int i = 0; i < ListeCarteEffetImmediat.size(); i++) {
            if (ListeCarteEffetImmediat.get(i).getIdCarte() == IdCarte) {
                return i;
            }
        }
        return -1;
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void resetPlateauDuJoueur() {
        this.Plateau = new PlateauDuJoueur(this.id);
    }

    /**
     * Cette classe reinitialise les dés. On l'utilise quand on veut relancer une partie
     */
    private void resetDe() {
        this.DeClaire = new De("claire");
        this.DeSombre = new De("sombre");
    }

    /**
     * On lance les dés et on attribue au joueur en fonction du résultat du lancé des ressources
     */
    public void lanceDe() {
        Face sombre, claire;
        claire = this.DeClaire.lancerLeDe();
        sombre = this.DeSombre.lancerLeDe();
        sombre.AnalyseFace();
        claire.AnalyseFace();
        if(claire.getPositionGloire()!=-1){
            this.Plateau.ajouterPointDeGloire(claire.getNb()[claire.getPositionGloire()]);
        }
        if(claire.getPostionOr()!=-1) {
            this.Plateau.ajouterOr(claire.getNb()[claire.getPostionOr()]);
        }
        if(claire.getPositionLune()!=-1) {
            this.Plateau.ajoutFragLun(claire.getNb()[claire.getPositionLune()]);
        }
        if(claire.getPositionSoleil()!=-1) {
            this.Plateau.ajoutFragSol(claire.getNb()[claire.getPositionSoleil()]);
        }

        if(sombre.getPositionGloire()!=-1) {
            this.Plateau.ajouterPointDeGloire(sombre.getNb()[sombre.getPositionGloire()]);
        }
        if(sombre.getPostionOr()!=-1) {
            this.Plateau.ajouterOr(sombre.getNb()[sombre.getPostionOr()]);
        }
        if(sombre.getPositionLune()!=-1) {
            this.Plateau.ajoutFragLun(sombre.getNb()[sombre.getPositionLune()]);
        }
        if(sombre.getPositionSoleil()!=-1) {
            this.Plateau.ajoutFragSol(sombre.getNb()[sombre.getPositionSoleil()]);
        }


        System.out.print("Dé 1: " + claire.AfficherFace() );
        System.out.print("Dé 2: " + sombre.AfficherFace() );


    }

    public void acheterFace(Temple temp, Face acheter, Face echange, int idDe) {
        int size = temp.getBassins().size();
        for (int i = 0; i < size; i++) {
            Bassin bas = temp.getBassins().get(i);
            if (bas.faceIsIn(acheter)) {
                this.Plateau.enleverOr(temp.getBassins().get(i).getCout());
            }
        }
        echangerFace(acheter, echange, idDe);
        temp.deleteFace(echange);
    }

    /**
     * On remplace une face du dé d'un joueur donné
     * @param nouvelle représente la nouvelle face à insérer
     * @param ancienne représente la face à remplacer
     * @param idDe renseigne le dé dont on veut modifier l'une des faces
     */
    private void echangerFace(Face nouvelle,Face ancienne,int idDe) {
        int i = 0;
        if(idDe == 1) {
            while(i<6  && !this.DeClaire.getface(i).equals(ancienne)) {
                i++;
            }
            DeClaire.ajouterUneFace(nouvelle,i);
        }
        else if(idDe == 2) {
            while( i<6 && !this.DeSombre.getface(i).equals(ancienne)) {
                i++;
            }
            DeSombre.ajouterUneFace(nouvelle,i);
        }
    }

    
    public int getIdJoueur(){
        return id;
    }

    public int quelEstLeMeilleurBassin(Temple temple){
        Bassin meilleurBassin=temple.getBassin(2);
        int monOr= this.getPlateauDuJoueur().getOr();
        List<Bassin> bassins= temple.getBassins();
        for (int i=0; i==bassins.size(); i++) {
            if(monOr>bassins.get(i).getCout()){
                meilleurBassin=bassins.get(i);
            }
        }
        return meilleurBassin.getCout();
    }
///////////////////////////////////////////////////////////////////////////Partie Carte ///////////////////////////////////////////////////////////////////////////////////////
    public void acheterCarte(Iles iles, Carte carte){
        carte.activerCarte();

        if(carte instanceof CarteEffetImmediat){
            CarteEffetImmediat carteEffetImmediat=(CarteEffetImmediat)carte;
            ListeCarteEffetImmediat.add(carteEffetImmediat);
            iles.enleverCarte(carte);
            ajouterPointDeGloire(carte);
        }
        else if(carte instanceof CarteEffetPermanent){
            CarteEffetPermanent carteEffetPermanent=(CarteEffetPermanent)carte;
            ListeCarteEffetPermanent.add(carteEffetPermanent);
            iles.enleverCarte(carte);
            ajouterPointDeGloire(carte);
        }
    }

    /**
     * Cette méthode nous permet de stocker les points de gloire de chaque carte acheter dans une varriable int
     *
     */
    public void ajouterPointDeGloire(Carte carte){
        setPointDeGloireCarte(getPointDeGloireCarte() + carte.getPointDeGloire());

    }

    public int getPointDeGloireCarte() {
        return PointDeGloireCarte;
    }

    public void setPointDeGloireCarte(int pointDeGloireCarte) {
        PointDeGloireCarte = pointDeGloireCarte;
    }

    /**
     * Cette méthode nous permet d'afficher les identifiants des cartes qui sont achété par le joueur
     */
    public void afficherCarteJoueur(){
        for (Carte carte: ListeCarteEffetImmediat){
            System.out.println(carte.getIdCarte());
        }

    }

    public void activerEffetCarteImmediat(){
        for (CarteEffetImmediat carte: this.getListeCarte()){
            carte.activerEffetCarte(this);
        }
    }

    /**
     * Cette méthode nous permet de lancer seulement un seul dé et d'ajouter ces gains aux joueurs concerné.
     * Ainsi on choisis de manière aléatoire le dée qu'on va lancée.
     */




    public void LanceUnDe(){

    }

    public void faveurMineur(){
        Face sombre, claire;
        Random Alea = new Random();
        int nbAlea= Alea.nextInt(2);

        if (nbAlea == 0) {
            claire = this.DeClaire.lancerLeDe();
            claire.AnalyseFace();

            if(claire.getPositionGloire()!=-1){
                this.Plateau.ajouterPointDeGloire(claire.getNb()[claire.getPositionGloire()]);
            }
            if(claire.getPostionOr()!=-1) {
                this.Plateau.ajouterOr(claire.getNb()[claire.getPostionOr()]);
            }
            System.out.print("Dé 1: " + claire.AfficherFace() );
        }
        else {
            sombre = this.DeSombre.lancerLeDe();
            sombre.AnalyseFace();

            if(sombre.getPositionGloire()!=-1) {
                this.Plateau.ajouterPointDeGloire(sombre.getNb()[sombre.getPositionGloire()]);
            }
            if(sombre.getPostionOr()!=-1) {
                this.Plateau.ajouterPointDeGloire(sombre.getNb()[sombre.getPostionOr()]);
            }
            System.out.print("Dé 2: " + sombre.AfficherFace() );

        }

    }

    public void faveurMineurChoix(int choixDée){
        Face sombre, claire;

        if (choixDée == 0) {
            sombre = this.DeSombre.lancerLeDe();
            sombre.AnalyseFace();

            if(sombre.getPositionGloire()!=-1) {
                this.Plateau.ajouterPointDeGloire(sombre.getNb()[sombre.getPositionGloire()]);
            }
            if(sombre.getPostionOr()!=-1) {
                this.Plateau.ajouterPointDeGloire(sombre.getNb()[sombre.getPostionOr()]);
            }
            System.out.print("Dé 2: " + sombre.AfficherFace() );
        }
        else {
            claire = this.DeClaire.lancerLeDe();
            claire.AnalyseFace();

            if(claire.getPositionGloire()!=-1){
                this.Plateau.ajouterPointDeGloire(claire.getNb()[claire.getPositionGloire()]);
            }
            if(claire.getPostionOr()!=-1) {
                this.Plateau.ajouterOr(claire.getNb()[claire.getPostionOr()]);
            }
            System.out.print("Dé 1: " + claire.AfficherFace() );




        }

    }







}
