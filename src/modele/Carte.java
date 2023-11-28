package modele;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Carte {

    public int hauteur;
    public int largeur;

    public char[][] carte= null;

    public Carte(){
        
    }

    public void lectureCarte(String cheminCarte){

        try (BufferedReader br = new BufferedReader(new FileReader(new File(cheminCarte)))) {
            String ligne;
            // Déterminer les dimensions de la carte (nombre de lignes et longueur maximale)
            while ((ligne = br.readLine()) != null) {
                hauteur++;
                largeur = Math.max(largeur, ligne.length());
            }

            // Réinitialisation de la position dans le fichier
            br.close(); // Fermeture automatique du flux de lecture
            BufferedReader nouveauLecteur = new BufferedReader(new FileReader(new File(cheminCarte)));

            // Construire la carte en utilisant les dimensions déterminées
            carte = new char[hauteur][largeur];
            int ligneActuelle = 0;
            while ((ligne = nouveauLecteur.readLine()) != null) {
                // Remplir la carte avec les caractères de la ligne
                for (int i = 0; i < largeur; i++) {
                    if (i < ligne.length()) {
                        carte[ligneActuelle][i] = ligne.charAt(i);
                    } 
                }
                ligneActuelle++;
            }
            nouveauLecteur.close(); // Fermeture du nouveau flux de lecture
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean placePerso(Personnage p){
        int[] pos = p.getPosition();
        if(carte[pos[1]][pos[0]] == ' ' ){
            carte[pos[1]][pos[0]] = p.perso;
            return true;
        }
        return false;
    }

    public void deplacePerso(Personnage p){
        int[] pos = p.getPosition();
        carte[pos[1]][pos[0]] = p.perso;
    
    }

}
