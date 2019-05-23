package TP7;

import TP6.*;
import TP4.Vecteur3D;

/**
 * Write a description of class carr� here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Terrain extends Objet
{
    // instance variables - replace the example below with your own
    private int x;

    Transformation m_transformationBase;

    /**
     * Constructor for objects of class carr�
     */
    
    
    public Terrain(Noeud _parent)
    {
        super(_parent);

        String textureCube = "/TP6/res/blanc.png";

        // on instancie un transformation de base et quatre carr�s qui seront d�clar�s 
        // comme enfants (graphe de sc�ne) de cette transformation
        Vecteur3D transformationBase = new Vecteur3D(0.0f,0.0f,0.0f);
        m_transformationBase = new Translation(_parent,transformationBase);
        
        
                            
        textureCube = "/TP6/res/grass.png";
        
        for(int i=0; i<100;  i++){
            for(int j=0;j<50;j++){
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*i, 2*j, 0.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    TextureTerrain cube = new TextureTerrain(translation1, textureCube);
            }
        }

    }

    /**
     * La m�thode dessine dessine les quatre carr�s que nous avons in
     * instanci� dans le constructeur
     *
     */

    public void dessine()
    {
        // ici il faut dessiner quelquechose. Le quelque chose en question est intanci� 
        // dans le construteur de la classe carr� 
        m_transformationBase.affiche();
    }
}

