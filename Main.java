import controleur.Controleur;
import vue.Ihm;

public class Main {
    public static void main(String[] args) {
        Ihm ihm = new Ihm();
        Controleur c = new Controleur(ihm);

        c.play();


    }
}
