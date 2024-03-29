
package main.java.projet_dice_forge.effet_test.EffetImmediat;
import main.java.projet_dice_forge.Bot.Bot;
import main.java.projet_dice_forge.Bot.Emeline;

import main.java.projet_dice_forge.Gestion_du_Jeu.Jeu;
import main.java.projet_dice_forge.Partie_Iles.Iles;


import main.java.projet_dice_forge.Plateau_Joueur.Face;
import main.java.projet_dice_forge.Ressource.Ressource;
import main.java.projet_dice_forge.effet.EffetImmediat.LesSatyres;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class TestLesSatyres {
    @Test
    public void TestLesSatyres() {

        LesSatyres lesSatyres = new LesSatyres();
        Ressource[] ressources = lesSatyres.getPrix();

        assertEquals(ressources[0].getTypeRessource(), "FragementLunaire");
        assertEquals(ressources[0].getNbRessources(), 3);
        assertEquals(lesSatyres.getPointDeGloire().getNbRessources(), 6);
    }

    @Test
    public void activerEffetCarte(){
        Bot joueur1 = new Emeline(1);
        Bot joueur2 = new Emeline(2);

        Bot listJoueurs[]={joueur1,joueur2};
        Jeu jeu = new Jeu(2,listJoueurs);
        LesSatyres lesSatyres = new LesSatyres();
        Iles ile = new Iles();
        ile.ajouterCarte(lesSatyres);
        assertTrue(!lesSatyres.isActiverOuPas());

        joueur1.acheterCarte(ile,lesSatyres);
        assertTrue(lesSatyres.isActiverOuPas());
        joueur1.activerEffetCarteImmRealJoueur();
        assertFalse(lesSatyres.isActiverOuPas());

        ArrayList<Face> faces = lesSatyres.getListeFaceAppliquer();
        ArrayList<Ressource> ressources = new ArrayList<>();
        for(Face face : faces){
            ressources.addAll(face.getRessource());
        }

        int num = 0;
        for(Ressource res : ressources){
            if(res.getTypeRessource().equals("Gloire")){
                num += res.getNbRessources();
            }
        }

        assertEquals((num+6),joueur1.getPtGloire());
    }

    /**
     * on vérifie si les faces choisis sont conforme donc si les faces appliquées au joueur sont bien présent dans la liste de face
     * qui représente les faces obtenues par les dé de tout les joueurs
     */
    public void faceConfirme(){

        //a faire

    }
}
