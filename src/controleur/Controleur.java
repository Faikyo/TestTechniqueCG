package controleur;

import modele.*;
import vue.Ihm;

public class Controleur {

    Ihm ihm;

    /**
     * Constructeur du Controleur.
     * @param ihm
     */
    public Controleur(Ihm ihm) {
        this.ihm = ihm;
    }

    public void play(){
        Carte c = new Carte();
        Personnage p = new Personnage();
        c.lectureCarte("/home/linux/Documents/Entretien Technique Ciril GROUP/src/carte v2.txt");
        ihm.afficherCarte(c.carte);
        int[] coordonnéesDuPersonnage = ihm.demandecoordonées();
        p.setPosition(coordonnéesDuPersonnage);
        boolean persoPlacé = false;
        persoPlacé= c.placePerso(p);

        while(!persoPlacé){
            ihm.positionImpossible();
            ihm.afficherCarte(c.carte);
            coordonnéesDuPersonnage = ihm.demandecoordonées();
            persoPlacé=c.placePerso(p);
        }
        ihm.afficherCarte(c.carte);
        p.creerPersonnage(coordonnéesDuPersonnage);
        String sequanceDeplacement = ihm.demandedeplacement();
        deplacement(sequanceDeplacement,c,p);
        c.deplacePerso(p);
        ihm.afficherCarte(c.carte);
        ihm.affichagePosPerso(p);
        ihm.quit();


    }

    public void deplacement(String seq, Carte c, Personnage p){
        char[] caracteres = seq.toCharArray();
        int[] pos = p.getPosition();
        c.carte[pos[1]][pos[0]]= ' ';
        for (char dir : caracteres) {
            if (dir == 'N'){
                if(c.carte[pos[1]][pos[0]-1] == ' '){
                    p.seDeplace(dir);

                }
            }
            else if (dir == 'O'){
                if(c.carte[pos[1]-1][pos[0]] == ' '){
                    p.seDeplace(dir);

                }
            }
            else if (dir == 'S'){
                if(c.carte[pos[1]][pos[0]+1] == ' '){
                    p.seDeplace(dir);

                }
            }
            else if (dir == 'E'){
                if(c.carte[pos[1]+1][pos[0]] == ' '){
                    p.seDeplace(dir);

                }
            }
        }
    }
}

