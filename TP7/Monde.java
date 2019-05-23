package TP7;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import org.lwjgl.util.glu.GLU;

import org.lwjgl.input.Keyboard;

import org.lwjgl.BufferUtils;
import java.nio.FloatBuffer;

import TP4.*;
import TP6.*;

import java.io.*;


/**
 * La classe Monde est le noeud primordial à l'origine du graphe
 * de scène. Elle prend en charge les interactions ainsi que l'initialisation
 * du contexte OpenGL
 *
 * @author Alexis Heloir
 * @version 2019/03/21
 */
public class Monde extends Noeud
{
    static final int MS_ENTRE_DEUX_AFFICHAGES = 25; // 25 affichages par secondes

    private boolean m_done = false; // Est ce que l'application doit se terminer?
    private boolean m_fullscreen = false; // Est-ce que l'application doit être plein écran?
    private final String m_windowTitle = "OpenGL et Graphe de scène"; // Titre de l'application
    private boolean m_f1 = false; // A t-on appuyé sur la touche F1?
    private DisplayMode m_displayMode; // propriétés de la fenêtre d'affichage
    

    private boolean m_filter = false; // Est-ce  que l'on applique le mipmapping de texture 

    
    /**
     * Le constructuer de la classe Monde ne prend pas de parmètre : la classe Monde 
     * n'a pas de parent car son instance (souvent unique) est à l'origine du graphe de scène.
     */
    public Monde()
    {
        super(null);
    }
    
    /**
     * La méthode affiche vides les buffers du contexte OpenGL puis appelle de manière 
     * récursive la méthode affiche pour l'ensemble des noeuds enfants. Le graphe de scene est ainsi parcouru.
     */
    public void affiche(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);          // Clear The Screen And The Depth Buffer

        for (int i=0; i<m_enfants.size(); i++ )
        {
            m_enfants.get(i).affiche();
        }        
    }

    /**
     * Méthode responsable de la gestion des interactions avec l'utilisateur --
     * elle gère principalement les interruptions clavier
     */
    private void interactionManagement() {
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {       // Exit if Escape is pressed
            m_done = true;
        }
        if(Display.isCloseRequested()) {                     // Exit if window is closed
            m_done = true;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_F1) && !m_f1) {    // Is F1 Being Pressed?
            m_f1 = true;                                      // Tell Program F1 Is Being Held
            switchMode();                                   // Toggle Fullscreen / Windowed Mode
        }
        if(!Keyboard.isKeyDown(Keyboard.KEY_F1)) {          // Is F1 Being Pressed?
            m_f1 = false;
        }
        if(!Keyboard.isKeyDown(Keyboard.KEY_F)) {          // Is F Being Pressed?
            m_filter = true;
        }        
        if(!Keyboard.isKeyDown(Keyboard.KEY_D)) {          // Is F Being Pressed?
            m_filter = false;
        }        

    }

    /**
     *  Appelé par la méthode interactionManagement() en charge de capturer les
     *  évènments clavier. Cette méthode gère l'attribut sanctionnant le mode plein
     *  écran
     */
    private void switchMode() {
        m_fullscreen = !m_fullscreen;
        try {
            Display.setFullscreen(m_fullscreen);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void start(boolean fullscreen) {
        this.m_fullscreen = fullscreen;
        try {
            initGL();
            prepareScene();
            while (!m_done) {
                Thread.sleep(MS_ENTRE_DEUX_AFFICHAGES);
                interactionManagement();
                affiche();
                Display.update();
            }
            cleanup();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
        
    private void initGL() throws Exception {
        
        createWindow();
      
        if (m_filter){
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_LINEAR); // contre l'aliasage proche
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MIN_FILTER,GL11.GL_LINEAR); // contre l'aliasage lointain
        }else{
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MAG_FILTER,GL11.GL_NEAREST); // contre l'aliasage proche
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D,GL11.GL_TEXTURE_MIN_FILTER,GL11.GL_NEAREST); // contre l'aliasage lointain
        }
        
        GL11.glEnable(GL11.GL_TEXTURE_2D); // Enable Texture Mapping
        GL11.glShadeModel(GL11.GL_SMOOTH); // Enable Smooth Shading
        GL11.glClearColor(0.4f, 0.7f, 1.0f, 0.0f); // Background
        GL11.glClearDepth(1.0); // Depth Buffer Setup
        GL11.glEnable(GL11.GL_DEPTH_TEST); // Enables Depth Testing
        GL11.glDepthFunc(GL11.GL_LEQUAL); // The Type Of Depth Testing To Do

        GL11.glEnable(GL11.GL_CULL_FACE); // Back face culling 
        
        GL11.glMatrixMode(GL11.GL_PROJECTION); // Select The Projection Matrix
        GL11.glLoadIdentity(); // Reset The Projection Matrix

        // Calculate The Aspect Ratio Of The Window
        GLU.gluPerspective(
          45.0f,
          (float) m_displayMode.getWidth() / (float) m_displayMode.getHeight(),
          0.1f,
          500.0f);

        GL11.glMatrixMode(GL11.GL_MODELVIEW); // Select The Modelview Matrix
        
        // GL11.glEnable(GL11.GL_LIGHTING);
        
        // LumiereDirectionelle maLumiere = new LumiereDirectionelle();
        // maLumiere.allumer();
        
    }

    private void prepareScene(){
        Vecteur3D vecteur0 = new Vecteur3D(10.0f, -20.0f,-100.0f);
        Transformation translation0 = new Translation(this, vecteur0);
        
        //--- COCHON ---
        Vecteur3D vecteur6 = new Vecteur3D(0.0f,5.0f, -4.0f);
        Transformation translation6 = new Translation(translation0, vecteur6);        
        Rotation rotationbase6 = new Rotation(translation6, new Vecteur3D (0.0f, 0.0f, 1.0f), 90.0f);
        Rotation rotationbase7 = new Rotation(rotationbase6, new Vecteur3D (1.0f, 0.0f, 0.0f), 220.0f);
        //RotationAnimee rotation10 = new RotationAnimee(rotationbase10, new Vecteur3D(0.0f,1.0f,0.0f), 90.0f, 5000);
        Echelle echellebase7 = new Echelle(rotationbase7, new Vecteur3D(0.4f, 0.4f, 0.4f));
        Cochon monCochon1 = new Cochon(echellebase7);
        
        
        
        //--- COCHON2 ---
        Vecteur3D vecteur9 = new Vecteur3D(-20.0f,4.0f, -4.0f);
        Transformation translation9 = new Translation(translation0, vecteur9);
        Echelle echellebase9 = new Echelle(translation9, new Vecteur3D(0.2f, 0.2f, 0.2f));
        Rotation rotationbase8 = new Rotation(echellebase9, new Vecteur3D (0.0f, 0.0f, 1.0f), 90.0f);
        Rotation rotationbase9 = new Rotation(rotationbase8, new Vecteur3D (1.0f, 0.0f, 0.0f), 310.0f);
        TranslationAnimeeAleatoire translationalea10 = new TranslationAnimeeAleatoire(rotationbase9, new Vecteur3D(0.0f,1.0f, 0.0f),5000);
        //Rotation rotationbase5 = new Rotation(translationalea10, new Vecteur3D (1.0f, 0.0f, 0.0f), 260.0f);
        // TranslationAnimeeAleatoire translationalea11 = new TranslationAnimeeAleatoire(rotationbase5, new Vecteur3D(0.0f,1.0f, 0.0f),5000);
        // Rotation rotationbase4 = new Rotation(translationalea11, new Vecteur3D (1.0f, 0.0f, 0.0f), 200.0f);
        // TranslationAnimeeAleatoire translationalea12 = new TranslationAnimeeAleatoire(rotationbase4, new Vecteur3D(0.0f,1.0f, 0.0f),5000);
        
        Cochon monCochon2 = new Cochon(translationalea10);
        
        
        //--- BOUCLIER ----
        Vecteur3D vecteur11 = new Vecteur3D(-30.0f,8.0f,55.0f);
        Transformation translation11 = new Translation(translation0, vecteur11);        
        RotationAnimee rotation11 = new RotationAnimee(translation11, new Vecteur3D(0.0f,1.0f,0.0f), 90.0f, 5000);
        Echelle echellebase11 = new Echelle(rotation11, new Vecteur3D(0.1f, 0.1f, 0.1f));
        Bouclier monBouclier = new Bouclier(echellebase11);
        
        //--- EPEE ---
        Vecteur3D vecteur12 = new Vecteur3D(-20.0f,8.0f,55.0f);
        Transformation translation12 = new Translation(translation0, vecteur12);   
        RotationAnimee rotation12 = new RotationAnimee(translation12, new Vecteur3D(0.0f,1.0f,0.0f), 90.0f, 5000);
        Echelle echellebase12 = new Echelle(rotation12, new Vecteur3D(0.1f, 0.1f, 0.1f));
        Epee monEpee = new Epee(echellebase12);
        
        //--- FLECHE ---
        Vecteur3D vecteur14 = new Vecteur3D(-10.0f,8.0f,55.0f);
        Transformation translation14 = new Translation(translation0, vecteur14);   
        RotationAnimee rotation14 = new RotationAnimee(translation14, new Vecteur3D(0.0f,1.0f,0.0f), 90.0f, 5000);
        Echelle echellebase14 = new Echelle(rotation14, new Vecteur3D(0.1f, 0.1f, 0.1f));
        Fleche mafleche = new Fleche(echellebase14);
        
        //--- TORCHE ---
        Vecteur3D vecteur13 = new Vecteur3D(-40.0f,8.0f,55.0f);
        Transformation translation13 = new Translation(translation0, vecteur13);   
        RotationAnimee rotation13 = new RotationAnimee(translation13, new Vecteur3D(0.0f,1.0f,0.0f), 90.0f, 5000);
        Echelle echellebase13 = new Echelle(rotation13, new Vecteur3D(0.1f, 0.1f, 0.1f));
        Torche maTorche = new Torche(echellebase13);
        
        //--- TERRAIN ---
        Vecteur3D vecteur15 = new Vecteur3D(30.0f,0.0f,-35.0f);
        Transformation translation15 = new Translation(translation0, vecteur15);   
        Rotation rotationbase15 = new Rotation(translation15, new Vecteur3D (1.0f, 0.0f, 0.0f), 90.0f);
        Terrain monTerrain = new Terrain(rotationbase15);
        
        //--- ARBRE ---
        Vecteur3D vecteur16 = new Vecteur3D(-30.0f,8.0f,-10.0f);
        Transformation translation16 = new Translation(translation0, vecteur16);   
        Rotation rotationbase16 = new Rotation(translation16, new Vecteur3D (0.0f, 1.0f, 0.0f), 90.0f);
        Arbre monArbre = new Arbre(rotationbase16);
        
        //--- ARBRE2 ---
        Vecteur3D vecteur17 = new Vecteur3D(-50.0f,8.0f,20.0f);
        Transformation translation17 = new Translation(translation0, vecteur17);   
        Rotation rotationbase17 = new Rotation(translation17, new Vecteur3D (0.0f, 1.0f, 0.0f), 90.0f);
        Arbre monArbre2 = new Arbre(rotationbase17);
        
        //--- ARBRE3 ---
        Vecteur3D vecteur18 = new Vecteur3D(10.0f,8.0f,50.0f);
        Transformation translation18 = new Translation(translation0, vecteur18);   
        Rotation rotationbase18 = new Rotation(translation18, new Vecteur3D (0.0f, 1.0f, 0.0f), 90.0f);
        Arbre monArbre3 = new Arbre(rotationbase18);
        
        //--- COCHON QUI TOURNE AUTOUR DE L'ARBRE ---
        Vecteur3D vecteur10 = new Vecteur3D(8.0f,0.0f, -2.0f);
        RotationAnimee rotation10 = new RotationAnimee(translation18, new Vecteur3D(0.0f,1.0f,0.0f), 90.0f, 500);
        Transformation translation10 = new Translation(rotation10, vecteur10);        
        Rotation rotationbase10 = new Rotation(translation10, new Vecteur3D (0.0f, 0.0f, 1.0f), 90.0f);
        Rotation rotationbase11 = new Rotation(rotationbase10, new Vecteur3D (1.0f, 0.0f, 0.0f), 90.0f);
        Echelle echellebase10 = new Echelle(rotationbase11, new Vecteur3D(0.3f, 0.3f, 0.3f));
        Cochon monCochon = new Cochon(echellebase10);

    }
    
    private void createWindow() throws Exception {
        Display.setFullscreen(m_fullscreen);
        DisplayMode d[] = Display.getAvailableDisplayModes();
        for (int i = 0; i < d.length; i++) {
            if (d[i].getWidth() == 1280
                && d[i].getHeight() == 720
                && d[i].getBitsPerPixel() == 32) {
                m_displayMode = d[i];
                break;
            }
        }
        Display.setDisplayMode(m_displayMode);
        Display.setTitle(m_windowTitle);
        Display.create();
    }

    
    private static void cleanup() {
        Display.destroy();
    }    

    /**
     * Méthode statique permettant de lancer l'application depuis la ligne de commande
     */
    public static void main(String[] argv) {
        String OS = System.getProperty("os.name").toLowerCase();
        String path = "";
        try{
            if(OS.indexOf("win") >= 0){
                path = Monde.class.getResource("../native/windows").getPath();
                path = java.net.URLDecoder.decode(path, "UTF-8");
            }
            if(OS.indexOf("linux") >= 0){
                path = Monde.class.getResource("../native/linux").getPath();
                path = java.net.URLDecoder.decode(path, "UTF-8");                
            }
            if(OS.indexOf("mac") >= 0){
                path = Monde.class.getResource("../native/macosx").getPath();
                path = java.net.URLDecoder.decode(path, "UTF-8");
            }
            System.setProperty("org.lwjgl.librarypath", path);
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // il est possible de passer l'argument "fullscreen" lors de l'invocation de la fonction 
        //<b>main()</b> pour que la fenètre soit affichée en mode plein écran
        boolean fullscreen = false;
        if(argv.length>0) {
            if(argv[0].equalsIgnoreCase("fullscreen")) {
                fullscreen = true;
            }
        }
        
        Monde monMonde = new Monde();
        monMonde.start(fullscreen);
    }
    
}


