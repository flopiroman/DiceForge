package main.java.projet_dice_forge;

import org.omg.PortableInterceptor.ObjectReferenceFactory;
import java.util.ArrayList;
import java.util.List;

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
     * @param Face
     */
    public void EnleverFaceBassin(Face Face) {
        for (int i = 0; i < this.ListFace.size(); i++) {
            Face face = this.ListFace.get(i);
            if ((Face.getNb() == face.getNb())&&(Face.getTypeDeRessource()==face.getTypeDeRessource())) {
                this.ListFace.remove(i);
                break;
            }

        }
    }
}