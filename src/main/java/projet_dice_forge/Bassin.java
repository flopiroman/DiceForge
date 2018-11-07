package main.java.projet_dice_forge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Cette classe représente un bassin contenant des listes de faces.
 */

public class Bassin {

    //C'est la liste des face présentent dans le bassin.
    private ArrayList<Face> ListFace;
    //C'est le cout qu'il faut payer pour acheter une face dans le bassin.
    private int coutBassin;

    /**
     * Création d'un nouveau bassin avec son coût.
     * @param coutBassin
     */
    public Bassin(int coutBassin) {
        ListFace = new ArrayList<>();
        setCout(coutBassin);
    }
    public Bassin(int cout, List<Face> Face){
        ListFace = new ArrayList<>();
        Face.forEach(p -> ListFace.add(p));
        setCout(cout);

    }
    /**
     *Renvoi le coût du bassin.
     */
    public int getCout() {
        return coutBassin;
    }

    /**
     * Affecte le cout du bassin.
     * @param coutBassin
     */
    public void setCout(int coutBassin) {
        this.coutBassin = coutBassin;
    }

    /**
     * Permet d'ajouter une face au bassin.
     * @param Face
     * @param quantitéFace
     */
    public void AjouterFaceBassin(Face Face, int quantitéFace) {
        for (int i = 0; i < quantitéFace; i++) {
            ListFace.add(i, Face);
        }
    }

    /**
     * Permet d'afficher les faces présentent dans le bassin.
     */
    public void AfficherBassin() {
        System.out.println("Bassin:");
        for (int i = 0; i < this.ListFace.size(); i++) {
            Face face = this.ListFace.get(i);
            System.out.println(face.getNb() + face.getTypeDeRessource());
        }
    }

    /**
     * Permet d'enlever une face du bassin.
     * @param FaceJoueur
     */

    public void EnleverFaceBassin(Face FaceJoueur) {
        for (int i = 0; i < this.ListFace.size(); i++) {
            Face face = this.ListFace.get(i);
            if ((FaceJoueur.getNb() == face.getNb())&&(FaceJoueur.getTypeDeRessource()==face.getTypeDeRessource())) {
                this.ListFace.remove(i);
                break;
            }
        }
    }

    public void AcheterFace(Face face, Joueur joueur){
        this.EnleverFaceBassin(face);
        PlateauDuJoueur plateau =joueur.getPlateauDuJoueur();
        plateau.setOr(plateau.getOr() - this.getCout());
    }

    public Face FaceAleaBassin(){
        int nbFaceBassin = this.ListFace.size();

        Random r = new Random(nbFaceBassin);
        int indice = r.nextInt(1);
        Face face = this.ListFace.get(indice);
        //Face face = new Face(4,"or");
        EnleverFaceBassin(face);
        return face;
    }
    public int TailleBassin(){
       return this.ListFace.size();
    }
    public ArrayList<Face> getListFace(){
        return this.ListFace;
    }
}






