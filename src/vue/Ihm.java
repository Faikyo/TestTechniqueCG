package vue;

import java.util.Scanner;

public class Ihm {

    // On initialise un scanner pour le jeu.
    Scanner sc = new Scanner(System.in);

    public void afficherCarte(char[][] carte){
        if (carte != null) {
            for (char[] ligne : carte) {
                for (char cellule : ligne) {
                    System.out.print(cellule);
                }
                System.out.println(); // Passage à la ligne suivante
            }

        }
    }

    public int[] demandecoordonées(){
        int[] coordonnees = new int[2]; // Tableau pour stocker les coordonnées x et y

        System.out.print("Entrez la coordonnée x du personnage : ");
        coordonnees[0] = sc.nextInt(); // Lecture de la coordonnée x

        System.out.print("Entrez la coordonnée y du personnage : ");
        coordonnees[1] = sc.nextInt(); // Lecture de la coordonnée y

        sc.close();

        return coordonnees;
    }

    public String demandedeplacement(){
        String deplacements = "";

        boolean saisieValide = false;
        while (!saisieValide) {
            try {
                System.out.print("Entrez la séquence de déplacements (Nord-N, Ouest-O, Sud-S, Est-E) : ");
                deplacements = sc.nextLine().toUpperCase(); // Convertir en majuscules pour simplifier la saisie

                // Vérifier si la saisie contient uniquement les lettres N, O, S, E
                if (deplacements.matches("[NOSE]+")) {
                    saisieValide = true;
                } else {
                    throw new IllegalArgumentException("Saisie invalide. Utilisez uniquement les lettres N, O, S, E.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
        return deplacements;
    }
}
