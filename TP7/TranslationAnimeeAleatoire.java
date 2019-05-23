package TP7;

import TP4.Vecteur3D;

import TP6.*;
import java.util.Random;

import org.lwjgl.opengl.GL11;

/**
 * Une rotation dont l'angle de rotation est dynamique.
 * la valur de rotation déclarée dans la classe parente (m_angle)
 * est appliquée toutes les m_intervalleEnMS millisecondes.
 * Cette classe repose sur le singleton Horloge pour gérer sa temporalité
 *
 * @author Alexis Heloir
 * @version 2019/03/26
 */
public class TranslationAnimeeAleatoire extends Translation
{

    private int m_intervalleEnMS; // m_angle est appliqué toutes les m_intervalleEnMS sillisecondes
    private Horloge m_horloge; // singleton utilisé pour récupérer le temps passé entre deux appels à transforme()
    private int m_positionInitial; // utilisé pour sauvegarder la valeur angulaire initiale à appliquer
    private int m_position;
    private Vecteur3D m_positionDepart, m_positionArrivee, m_vecteurAvant, m_vecteurActuel;
    private float m_tempsRelatif;
    private float m_alpha;
      

    public static float NombreAleatoire() 
    {
        // génération d'un nombre 0 ou 1 
        Random r = new Random();
        float NbRandom = r.nextFloat();
        return NbRandom-0.5f;
    }

    /**
     * Le constructeur appelle celui de la classe parente avec un paramètre en plus : l'intevalle en 
     * millisecondes lors duquel l'angle m_angleInitial sera appliqué
     * @param _intervalleEmMS l'intervalle pendant lequel l'angle m_angleInitial sera appliqué
     */
    public TranslationAnimeeAleatoire(Noeud _parent, Vecteur3D _position, int _intervalleEnMS)
    {
        super(_parent, _position);
        m_intervalleEnMS = _intervalleEnMS;
        m_horloge = new Horloge();
        m_coordonnees = _position;
        m_positionDepart = new Vecteur3D();
        m_positionArrivee = new Vecteur3D(0.0f, -200.0f, -400.0f);
        m_vecteurAvant = new Vecteur3D(0.0f, 0.0f, 0.0f);
        m_vecteurActuel = new Vecteur3D(m_positionArrivee.getX(), m_positionArrivee.getY(), m_positionArrivee.getZ());
        m_alpha = 0.0f;
    }
    
       
    /**
     * Cette classe met à jour l'angle m_angle à partir de sa valeur initiale et du temps 
     * écoulé depuis le dernier tick d'horloge. Elle appelle ensuite la transformation de 
     * la classe parente
     */
    public void transforme(){
        long tempsPasse = m_horloge.getTempsPasseDepuisDernierTick();
        m_tempsRelatif += (float)(tempsPasse)/(float)(m_intervalleEnMS); 
        // m_coordonnees.setY(m_coordonnees.getY() + NombreAleatoire());
        // m_coordonnees.setZ(m_coordonnees.getZ() + NombreAleatoire());
        if (m_tempsRelatif < 1.0f){
           m_coordonnees.setY(m_positionDepart.getY() + (m_positionArrivee.getY()-m_positionDepart.getY())*m_tempsRelatif);
           m_coordonnees.setZ(m_positionDepart.getZ() + (m_positionArrivee.getZ()-m_positionDepart.getZ())*m_tempsRelatif);
        }
        else {         
           m_positionDepart = m_positionArrivee;
           m_vecteurAvant = m_vecteurActuel;
           
           // if (m_positionArrivee.getY() == 0.0f)
               m_positionArrivee = new Vecteur3D (0.0f, NombreAleatoire()*50, NombreAleatoire()*50);
               m_vecteurActuel = new Vecteur3D(m_positionArrivee.getX() - m_positionDepart.getX(), m_positionArrivee.getY() - m_positionDepart.getY(), m_positionArrivee.getZ() - m_positionDepart.getZ());
               float scalaire = Vecteur3D.produitScalaire (m_vecteurAvant, m_vecteurActuel);
               scalaire = scalaire / (m_vecteurAvant.norme()*m_vecteurActuel.norme());
               System.out.println(scalaire);
               System.out.println("-------------------");
               double res = Math.acos(scalaire);
               // else
               // m_positionArrivee = new Vecteur3D (0.0f, NombreAleatoire()*1000, NombreAleatoire()*1000);
 
           m_alpha += (float)(res * 180.0f / Math.PI);
           m_alpha = m_alpha % 360.0f;
           System.out.println(m_alpha);
           System.out.println("-------------------");
           

           m_tempsRelatif = 0.0f;
            
           //super._parent.m_angle += 45.0f;
        }
        
        // m_coordonnees.setZ(m_coordonnees.getZ() + 1); 
        //m_coordonnees = m_coordonnees + NombreAleatoire(); // operateur % : reste de la division entière
        super.transforme();
        
        GL11.glRotatef(m_alpha, 1.0f, 0.0f, 0.0f);
        GL11.glTranslatef(0,-12.0f,-2.5f);
       
        // positiondepart.produitscal(positionArrivee);
        // Math.cos(alpha) = Math.scalaire (m_positionDepart , m_positionArrivee);
        
        
    }

    
}
