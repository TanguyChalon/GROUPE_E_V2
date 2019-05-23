package TP7;

import TP6.*;
import TP4.Vecteur3D;

/**
 * Write a description of class carré here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Arbre extends Objet
{
    // instance variables - replace the example below with your own
    private int x;

    Transformation m_transformationBase;

    /**
     * Constructor for objects of class carré
     */
    public Arbre(Noeud _parent)
    {
        super(_parent);

        String textureCube = "/TP6/res/blanc.png";

        // on instancie un transformation de base et quatre carrés qui seront déclarés 
        // comme enfants (graphe de scène) de cette transformation
        Vecteur3D transformationBase = new Vecteur3D(0.0f,0.0f,0.0f);
        m_transformationBase = new Translation(_parent,transformationBase);

        int matriceArbre[][] =     {{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0}, 
                                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                                    {0, 0, 0, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 0, 0},
                                    {0, 0, 0, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0}};
                                    
        int matriceArbre2[][] =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
                                    
        int matriceArbre3[][] =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
                                    
        int matriceArbre4[][] =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceArbre[i][j]!=0){
                    switch (matriceArbre[i][j]){
                        case 1 : textureCube = "/TP6/res/leaf.png";
                        break;
                        case 2 : textureCube = "/TP6/res/wood.png";
                        break;
                                            }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*j, 2*-i+25, 0.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    if (textureCube == "/TP6/res/leaf.png")
                      new TextureFeuille(translation1, textureCube);
                    else 
                      new TextureTronc(translation1, textureCube);
                    
                }
            }
        }
        
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceArbre[i][j]!=0){
                    switch (matriceArbre[i][j]){
                        case 1 : textureCube = "/TP6/res/leaf.png";
                        break;
                        case 2 : textureCube = "/TP6/res/wood.png";
                        break;
                                            }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*j, 2*-i+25, 2.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    if (textureCube == "/TP6/res/leaf.png")
                      new TextureFeuille(translation1, textureCube);
                    else 
                      new TextureTronc(translation1, textureCube);
                }
            }
        }
        
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceArbre2[i][j]!=0){
                    switch (matriceArbre2[i][j]){
                        case 1 : textureCube = "/TP6/res/leaf.png";
                        break;
                        case 2 : textureCube = "/TP6/res/wood.png";
                        break;
                                            }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*j, 2*-i+25, -2.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    TextureFeuille cube = new TextureFeuille(translation1, textureCube);
                }
            }
        }
        
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceArbre2[i][j]!=0){
                    switch (matriceArbre2[i][j]){
                        case 1 : textureCube = "/TP6/res/leaf.png";
                        break;
                        case 2 : textureCube = "/TP6/res/wood.png";
                        break;
                                            }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*j, 2*-i+25, 4.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    TextureFeuille cube = new TextureFeuille(translation1, textureCube);
                }
            }
        }
        
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceArbre2[i][j]!=0){
                    switch (matriceArbre2[i][j]){
                        case 1 : textureCube = "/TP6/res/leaf.png";
                        break;
                        case 2 : textureCube = "/TP6/res/wood.png";
                        break;
                                            }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*j, 2*-i+25, -4.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    TextureFeuille cube = new TextureFeuille(translation1, textureCube);
                }
            }
        }
        
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceArbre2[i][j]!=0){
                    switch (matriceArbre2[i][j]){
                        case 1 : textureCube = "/TP6/res/leaf.png";
                        break;
                        case 2 : textureCube = "/TP6/res/wood.png";
                        break;
                                            }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*j, 2*-i+25, 6.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    TextureFeuille cube = new TextureFeuille(translation1, textureCube);
                }
            }
        }
        
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceArbre2[i][j]!=0){
                    switch (matriceArbre3[i][j]){
                        case 1 : textureCube = "/TP6/res/leaf.png";
                        break;
                        case 2 : textureCube = "/TP6/res/wood.png";
                        break;
                                            }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*j, 2*-i+25, -6.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    TextureFeuille cube = new TextureFeuille(translation1, textureCube);
                }
            }
        }
        
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceArbre3[i][j]!=0){
                    switch (matriceArbre3[i][j]){
                        case 1 : textureCube = "/TP6/res/leaf.png";
                        break;
                        case 2 : textureCube = "/TP6/res/wood.png";
                        break;
                                            }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*j, 2*-i+25, 8.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    TextureFeuille cube = new TextureFeuille(translation1, textureCube);
                }
            }
        }
        
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceArbre4[i][j]!=0){
                    switch (matriceArbre4[i][j]){
                        case 1 : textureCube = "/TP6/res/leaf.png";
                        break;
                        case 2 : textureCube = "/TP6/res/wood.png";
                        break;
                                            }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*j, 2*-i+25, -8.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    TextureFeuille cube = new TextureFeuille(translation1, textureCube);
                }
            }
        }
        
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceArbre4[i][j]!=0){
                    switch (matriceArbre4[i][j]){
                        case 1 : textureCube = "/TP6/res/leaf.png";
                        break;
                        case 2 : textureCube = "/TP6/res/wood.png";
                        break;
                                            }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*j, 2*-i+25, 10.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    TextureFeuille cube = new TextureFeuille(translation1, textureCube);
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

