package TP7;

import TP6.*;
import TP4.Vecteur3D;

/**
 * Write a description of class carré here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bouclier extends Objet
{
    // instance variables - replace the example below with your own
    private int x;

    Transformation m_transformationBase;

    /**
     * Constructor for objects of class carré
     */
    public Bouclier(Noeud _parent)
    {
        super(_parent);

        String textureCube = "/TP6/res/blanc.png";

        // on instancie un transformation de base et quatre carrés qui seront déclarés 
        // comme enfants (graphe de scène) de cette transformation
        Vecteur3D transformationBase = new Vecteur3D(0.0f,0.0f,0.0f);
        m_transformationBase = new Translation(_parent,transformationBase);

        int matriceBouclier[][] =  {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 1, 1, 2, 3, 3, 2, 1, 1, 0, 0, 0, 0, 0},
                                    {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                    {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                    {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0},
                                    {1, 3, 2, 2, 2, 3, 5, 2, 2, 2, 3, 1, 0, 0, 0},
                                    {1, 3, 2, 2, 2, 5, 3, 2, 2, 2, 3, 1, 0, 0, 0},
                                    {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0},
                                    {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                    {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                    {0, 0, 1, 1, 2, 3, 3, 2, 1, 1, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceBouclier[i][j]!=0){
                    switch (matriceBouclier[i][j]){
                        case 1 : textureCube = "/TP6/res/black.png";
                        break;
                        case 2 : textureCube = "/TP6/res/marron.png";
                        break;
                        case 3 : textureCube = "/TP6/res/gris.png";
                        break;
                        case 4 : textureCube = "/TP6/res/grisfonce.png";
                        break;
                        case 5 : textureCube = "/TP6/res/white.png";
                        break;

                    }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*i, 2*j, 0.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    if (textureCube == "/TP6/res/black.png")
                      new TextureBouclier1(translation1, textureCube);
                    else if (textureCube == "/TP6/res/marron.png")
                      new TextureBouclier2(translation1, textureCube);
                    else if (textureCube == "/TP6/res/gris.png")
                      new TextureBouclier3(translation1, textureCube);
                    else if (textureCube == "/TP6/res/grisfonce.png")
                      new TextureBouclier4(translation1, textureCube);
                    else if (textureCube == "/TP6/res/white.png")
                      new TextureBouclier5(translation1, textureCube);

                }
            }
        }
		//---------------------------------------------------------------------------------------------------------------------


	
	int matriceBouclier2[][] =  {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},     // ici renomer la matrice 
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 1, 1, 2, 3, 3, 2, 1, 1, 0, 0, 0, 0, 0},
                                    {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                    {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                    {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0},
                                    {1, 3, 2, 2, 2, 3, 5, 2, 2, 2, 3, 1, 0, 0, 0},
                                    {1, 3, 2, 2, 2, 5, 3, 2, 2, 2, 3, 1, 0, 0, 0},
                                    {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0},
                                    {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                    {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0},
                                    {0, 0, 1, 1, 2, 3, 3, 2, 1, 1, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceBouclier2[i][j]!=0){												// ici changer le nom aussi 
                    switch (matriceBouclier2[i][j]){											// ici changer le nom aussi 
                        case 1 : textureCube = "/TP6/res/black.png";
                        break;
                        case 2 : textureCube = "/TP6/res/marron.png";
                        break;
                        case 3 : textureCube = "/TP6/res/gris.png";
                        break;
                        case 4 : textureCube = "/TP6/res/grisfonce.png";
                        break;
                        case 5 : textureCube = "/TP6/res/white.png";
                        break;

                    }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*i, 2*j, 2.0f);   // ICI ON EST PASSE A 1.0f  , 
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    if (textureCube == "/TP6/res/black.png")
                      new TextureBouclier1(translation1, textureCube);
                    else if (textureCube == "/TP6/res/marron.png")
                      new TextureBouclier2(translation1, textureCube);
                    else if (textureCube == "/TP6/res/gris.png")
                      new TextureBouclier3(translation1, textureCube);
                    else if (textureCube == "/TP6/res/grisfonce.png")
                      new TextureBouclier4(translation1, textureCube);
                    else if (textureCube == "/TP6/res/white.png")
                      new TextureBouclier5(translation1, textureCube);
                }
            }
        }
		//--------------------------------------------------------------------------------------------------------------------- c'est la partie a copier coller pour rajouter une couche
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

