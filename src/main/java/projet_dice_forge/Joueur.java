package main.java.projet_dice_forge;

public class Joueur {
    protected int id = -1;
    protected De DeClaire;
    protected De DeSombre;
    protected PlateauDuJoueur Plateau;

    public Joueur(int Idjoueur){
        this.id=Idjoueur;
        this.DeClaire=new De();
        this.DeSombre=new De();
        this.Plateau=new PlateauDuJoueur(Idjoueur);
    }

    public Joueur(int Idjoueur, De de1, De de2, PlateauDuJoueur Plateau){
        this.id=Idjoueur;
        this.DeClaire=de1;
        this.DeSombre=de2;
        this.Plateau=Plateau;
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

    private void resetPlateauDuJoueur() {
        this.Plateau = new PlateauDuJoueur(this.id);
    }

    private void resetDe() {
        this.DeClaire = new De();
        this.DeSombre = new De();
    }

    public void acheterFace(Face face) {
        this.Plateau.enleverOr(face.getNb());
    }

    public void echangerFace(Face nouvelle,Face ancienne,int idDe) {
        int i = 0;
        if(idDe == 1) {
            while(this.DeClaire.getface(i) != ancienne) {
                i++;
            }
            DeClaire.ajouterUneFace(nouvelle,i);
        }
        else if(idDe == 2) {
            while(this.DeSombre.getface(i) != ancienne) {
                i++;
            }
            DeSombre.ajouterUneFace(nouvelle,i);
        }
    }


    /**
     * Retourne l'identifiant du joueur
     */
    public int getIdJoueur(){
        return id;
    }
}
