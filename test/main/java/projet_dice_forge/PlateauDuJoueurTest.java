package main.java.projet_dice_forge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauDuJoueurTest {
    PlateauDuJoueur plateauTest1=new PlateauDuJoueur(1);
    PlateauDuJoueur plateauTest2= new PlateauDuJoueur(2, 5,3);
    @Test
    void getPointsDeGloire() {
        assertEquals(plateauTest1.getPointsDeGloire(),0);
        assertEquals(plateauTest2.getPointsDeGloire(),5);
    }


    @Test
    void setPointsDeGloire() {
        plateauTest1.setPointsDeGloire(1);
        assertEquals(plateauTest1.getPointsDeGloire(),1);
    }

    @Test
    void setJoueur() {
    }

    @Test
    void getIdJoueur() {
    }

    @Test
    void getOr() {
    }

    @Test
    void setOr() {
    }
}