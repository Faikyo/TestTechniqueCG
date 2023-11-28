package modele;

public class Personnage {

    private int[] position;

    public char perso = 'X';

    public Personnage(){

    }

    public void creerPersonnage(int[] coordonnees){
        position=coordonnees;
    }

    public int[] getPosition(){
        return position;
    }

    public void setPosition(int[] nouvellePosition){
        position=nouvellePosition;
    }

    public void seDeplace(char deplacement){
        if(deplacement ==  'N'){
            position[1]--;
        }
        else if(deplacement ==  'S'){
            position[1]++;
        }
        else if(deplacement ==  'O'){
            position[0]--;
        }
        else if(deplacement ==  'E'){
            position[0]++;
        }
     
    }
}
