package TP7;

import TP6.*;
import TP4.Vecteur3D;

/**
 * Write a description of class carré here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cochon extends Objet
{
    // instance variables - replace the example below with your own
    private int x;

    Transformation m_transformationBase;

    /**
     * Constructor for objects of class carré
     */
    
    
    public Cochon(Noeud _parent)
    {
        super(_parent);

        String textureCube = "/TP6/res/blanc.png";

        // on instancie un transformation de base et quatre carrés qui seront déclarés 
        // comme enfants (graphe de scène) de cette transformation
        Vecteur3D transformationBase = new Vecteur3D(0.0f,0.0f,0.0f);
        m_transformationBase = new Translation(_parent,transformationBase);
        
        

                                            
        int matriceCochon2[][] =   {{0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                    {0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 1, 2, 1, 0},
                                    {0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 1, 2, 1, 0},
                                    {0, 0, 0, 0, 1, 2, 1, 0, 0, 0, 0, 1, 2, 1, 0},
                                    {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};  
                                    
        int matriceCochon3[][] =   {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}; 
                                    
        int matriceCochon4[][] =   {{0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                    {0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {2, 1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {2, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};                            
                                    

        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceCochon2[i][j]!=0){
                    switch (matriceCochon2[i][j]){
                        case 1 : textureCube = "/TP6/res/pink.png";
                        break;
                        case 2 : textureCube = "/TP6/res/pink2.png";
                        break;
                        
                    }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*i, 2*j, 0.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    if (textureCube == "/TP6/res/pink.png")
                      new TextureCochon1(translation1, textureCube);
                    else 
                      new TextureCochon2(translation1, textureCube);

                }
            }
        }


        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceCochon2[i][j]!=0){                                              
                    switch (matriceCochon2[i][j]){                                          
                        case 1 : textureCube = "/TP6/res/pink.png";
                        break;
                        case 2 : textureCube = "/TP6/res/pink2.png";
                        break;

                    }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*i, 2*j, 2.0f); 
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    if (textureCube == "/TP6/res/pink.png")
                      new TextureCochon1(translation1, textureCube);
                    else 
                      new TextureCochon2(translation1, textureCube);

                }
            }
        }
        
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceCochon2[i][j]!=0){												 
                    switch (matriceCochon2[i][j]){											
                        case 1 : textureCube = "/TP6/res/pink.png";
                        break;
                        case 2 : textureCube = "/TP6/res/pink2.png";
                        break;

                    }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*i, 2*j, 6.0f);  
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    if (textureCube == "/TP6/res/pink.png")
                      new TextureCochon1(translation1, textureCube);
                    else 
                      new TextureCochon2(translation1, textureCube);

                }
            }
        }
        
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceCochon2[i][j]!=0){												
                    switch (matriceCochon2[i][j]){											 
                        case 1 : textureCube = "/TP6/res/pink.png";
                        break;
                        case 2 : textureCube = "/TP6/res/pink2.png";
                        break;


                    }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*i, 2*j, 8.0f);   
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    if (textureCube == "/TP6/res/pink.png")
                      new TextureCochon1(translation1, textureCube);
                    else 
                      new TextureCochon2(translation1, textureCube);

                }
            }
        }
        
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceCochon3[i][j]!=0){                                           
                    switch (matriceCochon3[i][j]){                                           
                        case 1 : textureCube = "/TP6/res/pink.png";
                        break;
                        case 2 : textureCube = "/TP6/res/pink2.png";
                        break;


                    }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*i, 2*j, -2.0f); 
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    if (textureCube == "/TP6/res/pink.png")
                      new TextureCochon1(translation1, textureCube);
                    else 
                      new TextureCochon2(translation1, textureCube);

                }
            }
        }
    
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceCochon3[i][j]!=0){                                   
                    switch (matriceCochon3[i][j]){                                          
                        case 1 : textureCube = "/TP6/res/pink.png";
                        break;
                        case 2 : textureCube = "/TP6/res/pink2.png";
                        break;

                    }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*i, 2*j, 10.0f); 
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    if (textureCube == "/TP6/res/pink.png")
                      new TextureCochon1(translation1, textureCube);
                    else 
                      new TextureCochon2(translation1, textureCube);

                }
            }
        }
        
        
                            
        for(int i=0; i<15;  i++){
            for(int j=0;j<15;j++){
                if (matriceCochon4[i][j]!=0){                                                
                    switch (matriceCochon4[i][j]){                                          
                        case 1 : textureCube = "/TP6/res/pink.png";
                        break;
                        case 2 : textureCube = "/TP6/res/pink2.png";
                        break;

                    }
                    Vecteur3D vecteur1 = new Vecteur3D(15-2*i, 2*j, 4.0f);
                    Transformation translation1 = new Translation(_parent,vecteur1);
                    if (textureCube == "/TP6/res/pink.png")
                      new TextureCochon1(translation1, textureCube);
                    else 
                      new TextureCochon2(translation1, textureCube);

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

