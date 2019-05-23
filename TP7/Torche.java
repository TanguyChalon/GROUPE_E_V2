package TP7;

import TP6.*;
import TP4.Vecteur3D;

/**
 * Write a description of class carré here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Torche extends Objet
{
    // instance variables - replace the example below with your own
    private int x;

    Transformation m_transformationBase;

    /**
     * Constructor for objects of class carré
     */
    public Torche(Noeud _parent)
    {
        super(_parent);

        String textureCube = "/TP6/res/blanc.png";

        // on instancie un transformation de base et quatre carrés qui seront déclarés 
        // comme enfants (graphe de scène) de cette transformation
        Vecteur3D transformationBase = new Vecteur3D(0.0f,0.0f,0.0f);
        m_transformationBase = new Translation(_parent,transformationBase);

        int matriceBouclier[][] =  {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceBouclier[i][j]!=0){
                    switch (matriceBouclier[i][j]){
                        case 1 : textureCube = "/TP6/res/jaune.png";
                        break;
                        case 2 : textureCube = "/TP6/res/marron.png";
                        break;


                    }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*j, 2*-i+25, 0.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    if (textureCube == "/TP6/res/jaune.png")
                      new TextureTorche1(translation1, textureCube);
                    else
                      new TextureTorche2(translation1, textureCube);
                }
            }
        }
    }

    /**
     * La méthode dessine dessine les quatre carrés que nous avons in
     * instancié dans le constructeur
     *
     */

    public void dessine()
    {
        // ici il faut dessiner quelquechose. Le quelque chose en question est intancié 
        // dans le construteur de la classe carré 
        m_transformationBase.affiche();
    }
}

