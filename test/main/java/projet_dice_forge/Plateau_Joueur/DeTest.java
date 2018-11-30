package main.java.projet_dice_forge.Plateau_Joueur;


import org.junit.Test;
import static org.junit.Assert.*;



class DeTest {
    De deTesteur= new De();

    @Test
    void ajouterUneFace() {
        deTesteur.ajouterUneFace(new Face(2,"or"),0);
        assertNotNull(deTesteur);
        assertEquals(deTesteur.getface(0).getTypeDeRessource(), "or");
        assertTrue(deTesteur.getface(0).isFaceContainsOr());
        assertEquals(deTesteur.getface(0).getNb(),2);

    }

    /*@Test
    void ajouterToutLesFace() {
    }*/

    @Test
    void lancerLeDe() {
        assertNotNull(deTesteur.lancerLeDe());
    }

    @Test
    void afficherDe() {

    }
}