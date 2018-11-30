package main.java.projet_dice_forge.Gestion_du_Jeu;
import main.java.projet_dice_forge.Bot.Emeline;
import main.java.projet_dice_forge.Bot.Geraldine;
import main.java.projet_dice_forge.Bot.Bot;

import java.util.Scanner;

public class Scanning {
    private Bot[] joueurs;
    private int numPlayer = 4;
    private String bot = "Emeline(1), Geraldine(2)";

    Scanning(){
        setNumPlayer();
        joueurs = new Bot[numPlayer];
    }

    private void setNumPlayer() {
        System.out.println("Enter the number of player : ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num > 0) {
            this.numPlayer = num;
        }
        else {
            System.out.println("Fuck You");
            System.exit(0);
        }
    }
    private void whoGonnaPlay()
    {
        Integer [] player = new Integer[numPlayer];
        Scanner scan = new Scanner(System.in);
        System.out.println(bot);
        for(int i = 0; i<numPlayer; i++) {
            System.out.println("Enter player number " + (i + 1) + " :");
            player[i] = scan.nextInt();
            switch (player[i]) {
                case 1:
                    joueurs[i] = new Emeline(i+1);
                    break;
                case 2:
                    joueurs[i] = new Geraldine(i+1);
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    Bot[] whoAreThePlayers(){
        whoGonnaPlay();
        return joueurs;
    }

    int getNumPlayer() {
        return this.numPlayer;
    }

    int getNumberOfGame() {
        System.out.println("Enter the number of Game : ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        return num>0 ? num : 0;
    }
}