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
        char[][] carte = c.lectureCarte("chemin/vers/carte.txt");
        int[] coordonnéesDuPersonnage = ihm.demandecoordonées();
        p.creerPersonnage(coordonnéesDuPersonnage);
        String sequanceDeplacement = ihm.demandedeplacement();
        deplacement(sequanceDeplacement,carte,p.getPosition());
        ihm.afficherCarte(carte);
    }

    public void deplacement(String seq, char[][] c, int[] pos){
        char[] caracteres = seq.toCharArray();
        for (char dir : caracteres) {
            if (dir == 'N'){
        
            }
        }
    }
}
