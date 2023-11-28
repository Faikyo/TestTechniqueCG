package vue;

import java.util.Scanner;

import modele.Personnage;

public class Ihm {

    private Scanner sc;

    public Ihm() {
        this.sc = new Scanner(System.in); // Initialiser le scanner dans le constructeur
    }

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
        boolean saisiePos=false;
        int[] coordonnees = new int[2]; // Tableau pour stocker les coordonnées x et y


        while (!saisiePos) {
            try {
                System.out.print("\n Entrez la coordonnée x du personnage : ");
                coordonnees[0] = Integer.parseInt(sc.nextLine()); // Lecture de la coordonnée x

                System.out.print("\n Entrez la coordonnée y du personnage : ");
                coordonnees[1] = Integer.parseInt(sc.nextLine()); // Lecture de la coordonnée y

                saisiePos = true; // Si la saisie est valide, sortir de la boucle
            } catch (NumberFormatException e) {
                System.out.println("\n Saisie invalide. Veuillez entrer des entiers pour les coordonnées.");
            }
        }

        return coordonnees;
    
        
    }

    public String demandedeplacement(){

        String deplacements = "";

        boolean saisieValide = false;
        while (!saisieValide) {
            try {

                System.out.print("\n Entrez la séquence de déplacements (Nord-N, Ouest-O, Sud-S, Est-E) : \n" );
                deplacements = sc.nextLine().toUpperCase(); // Convertir en majuscules pour simplifier la saisie

                // Vérifier si la saisie contient uniquement les lettres N, O, S, E
                if (deplacements.matches("[NOSE]+")) {
                    saisieValide = true;
                } else {
                    throw new IllegalArgumentException("\n Saisie invalide. Utilisez uniquement les lettres N, O, S, E.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return deplacements;
    }

    public void positionImpossible(){
        System.out.print("\n Position impossible du Personnage \n");
    }

    public void quit() {
        sc.close();
        System.out.println("\n L'aventure à prit fin.");
    }

    public void affichagePosPerso(Personnage p){
        System.out.println("\n La position du personnnage est : ("+p.getPosition()[0]+","+p.getPosition()[1]+")");
    }
}
