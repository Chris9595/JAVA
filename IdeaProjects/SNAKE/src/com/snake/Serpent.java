import javax.swing.JPanel;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;

public class Serpent extends JPanel { //Constructeur
    public int longueur;
    Graphics g;
    public boolean jouer = true;
    public int nbDePommes = 3;
    Scanner sc;
    ArrayList<Anneau> corps = new ArrayList<Anneau>();
    // La classe ArrayList implémente un tableau d’objets qui peut grandir ou rétrécir à la demande
    // De plus, ces tableaux acceptent tous les types de données, même le null
    ArrayList<Pomme> pommes = new ArrayList<Pomme>();

    public int direction = 4;

    public Serpent(Graphics g, int longueur) {
        this.g = g;
        this.longueur = longueur;
        sc = new Scanner(System.in);
    }

    public void jouer() {
        creationSerpent();

        while (jouer == true) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, Fenetre.LargeurFen, Fenetre.HauteurFen);

            createPommes();
            dessinePommes();
            dessineSerpent();

            sleep(200);

            move();
            checkCollision();
        }
    }

    // Methode pour accelerer le temps de jeu
    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void createPommes() {
        int randX, randY;
        Boolean creation = true;

        while (pommes.size() < nbDePommes) {
            creation = true;
            // 2 variable, hauteur et largeur dans lesquelles seront tirées au hasard les 2 positions x et y
            int widthFen = ((Fenetre.LargeurFen - 20) / 10) - 2; // on divise par 10 pour s'assurer que la pomme n'apparaît pas partout
            int heightFen = ((Fenetre.HauteurFen - 20) / 10) - 2; // idem

            randX = (int) ((Math.random() * (widthFen)) + 3);
            randY = (int) ((Math.random() * (heightFen)) + 3);

            // Une fois les 2 positions tirées

            randX = (randX * 10); // on remultiplie par 10 pour retrouver la valeur de départ
            randY = (randY * 10); // idem

            for (int i = 0; i < corps.size(); i++) {
                Anneau siExiste = corps.get(i);

                // Comparaison entre positions anneaux et positions pommes tirées juste avant en random
                if (randX == siExiste.posX && randY == siExiste.posY) {
                    creation = false; // si position est égale à la position de mon anneau actuel, alors c'est false
                }
            }
            if (creation == true) { // sinon c'est vrai et je poursuis avec la création de la nouvelle pomme
                pommes.add(new Pomme(randX, randY, Color.GREEN));
            }
        }
    }

    public void creationSerpent() {
        for (int j = 0; j < this.longueur; j++) {
            int hauteur;
            hauteur = ((int) Fenetre.HauteurFen / 2) / 10;
            if (j == 0) {
                corps.add(new Anneau(Fenetre.LargeurFen / 2 + ((j) * 10), hauteur, Color.RED));
            } else if (j > 0)
                corps.add(new Anneau(Fenetre.LargeurFen / 2 + ((j) * 10), hauteur, Color.YELLOW));
        }
    }

    public void dessinePommes() {
        for (int x = 0; x < pommes.size(); x++) {
            Pomme p = pommes.get(x);

            g.setColor(p.couleur);
            g.fillOval(p.posX, p.posY, 10, 10);
        }
    }

    public void dessineSerpent() {
        for (int i = 0; i < corps.size(); i++) {
            Anneau a;
            a = corps.get(i);

            g.setColor(a.couleur);
            g.fillOval(a.posX, a.posY, 10, 10);
            showScore();
        }
    }

    public void showScore() {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        g.drawString(Integer.toString(corps.size()), 10, Fenetre.HauteurFen-10);
    }

    public void checkCollision() {

        // Collision avec pomme
        for(int i = 0; i < pommes.size(); i++) {
            Pomme checkPomme = pommes.get(i);
            Anneau checkSerpent = corps.get(0);
            Anneau lastPosition = corps.get(corps.size()-1);

            // Comparer la position tete de serpent avec la position pomme
            if(checkPomme.posX == checkSerpent.posX && checkPomme.posY == checkSerpent.posY) {
                pommes.remove(i); // position de la pomme detectee enlevée et il ajoutera une nouvelle pomme
                corps.add(new Anneau(200+((lastPosition.posX)+10), 0, Color.YELLOW));
            }
        }

        // Collision avec Serpent
        for(int i = 1; i < corps.size(); i++) {
            Anneau corpsSerpent = corps.get(i);
            Anneau teteSerpent = corps.get(0);

            if(teteSerpent.posX == corpsSerpent.posX && teteSerpent.posY == corpsSerpent.posY)
                jouer = false;
        }

        // Si depasse fenetre
        Anneau teteSerpent = corps.get(0);
        if(teteSerpent.posX < 10)
            jouer = false;
        if(teteSerpent.posX > (Fenetre.LargeurFen-20))
            jouer = false;
        if(teteSerpent.posY < 30)
            jouer = false;
        if(teteSerpent.posY > (Fenetre.HauteurFen-20))
            jouer = false;
    }

    public void move() {
        int px, py;

        for (int i = corps.size() - 1; i > 0; i--) {
            Anneau a;
            a = corps.get(i - 1);
            px = a.posX;
            py = a.posY;
            a = corps.get(i);
            a.posX = px;
            a.posY = py;
        }
        Anneau b1 = corps.get(0);

        if (direction == 1)
            b1.posY -= 10;

        if (direction == 2)
            b1.posX += 10;

        if (direction == 3)
            b1.posY += 10;

        if (direction == 4)
            b1.posX -= 10;
    }
}