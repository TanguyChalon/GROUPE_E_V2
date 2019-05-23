package TP4;

/**
 * Vecteur de dimension 3
 *
 * @Alexis Heloir
 * @2019/03/19
 */
public class Vecteur3D
{
    // les trois dimensions du vecteur
    float m_x,m_y,m_z;
   

    /**
     * Constructor sans param�tre pour le vecteur
     */
    public Vecteur3D()
    {
        m_x = 0.0f;
        m_y = 0.0f;
        m_z = 0.0f; 
    }

    /**
     * Constructur qvec trois param�tres
     * @param _x la composante X
     * @param _y la composante Y
     * @param _z la composante Z
     */
    public Vecteur3D(float _x, float _y, float _z)
    {
        m_x = _x;
        m_y = _y;
        m_z = _z; 
    }

    /**
     * Accesseur pour la composante X
     * @return la composante X
     */
    public float getX(){
        return m_x;
    }

    /**
     * Accesseur pour la composante X
     * @return la composante X
     */
    public float getY(){
        return m_y;
    }

    /**
     * Accesseur pour la composante X
     * @return la composante X
     */
    public float getZ(){
        return m_z;
    }

    public void setX(float _X){
        m_x = _X; 
    }

    public void setY(float _Y){
        m_y = _Y; 
    }  

    public void setZ(float _Z){
        m_z = _Z; 
    }

    public static float produitScalaire (Vecteur3D _v, Vecteur3D _w) { 
        float prodScal= _v.getX() * _w.getX() +  _v.getY() * _w.getY() +  _v.getZ() * _w.getZ();
        return prodScal;
    }
    
    public float norme () { 
        double norme = Math.sqrt((double)m_x*(double)m_x + (double)m_y*(double)m_y + (double)m_z*(double)m_z);
        return (float) norme;
    }

    /**
     * Cette m�thode retourne la norme du vecteur, c'est � 
     * dire la recine carr�e de la somme de carr�s des trois 
     * composantes du vecteur
     * @return    la norme du vecteur
     */
    public float getNorme()
    {
        // la m�thode <b>sqrt</b> du package Math retourne un
        // double : on le transtype en float
        return (float)Math.sqrt(m_x*m_x + m_y*m_y + m_z*m_z);
    }

}