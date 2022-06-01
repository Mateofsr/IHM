/*
 * FichierTexte.java 	      30 mai 2022
 * IUT de Rodez,Info1 2021-2022 pas de copyright
 */
package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/** TODO commenter la responsabilité de cette classe
 * @author 33766
 *
 */
public class EspaceTampon {

    /** TODO commenter le rôle de cette méthode (SRP)
     * @param nomFichier
     */
    public static void suppressionFichier(String nomFichier) {
        File fichier = new File(nomFichier+".txt"); 
        
        if(fichier.exists()) { 
             fichier.delete();
        } else { 
            System.out.println("le fichier n'existe pas"); 
        } 
    }
    
    /** TODO commenter le rôle de cette méthode (SRP)
     * @param nomFichier
     * @throws IOException
     */
    public static void creationFichier(String nomFichier) throws IOException {
        int numero = 0;
        File fichier = new File(nomFichier+".txt");
        while(fichier.exists()) {
            numero++;
            fichier = new File(nomFichier+numero+"txt");
            fichier.renameTo(fichier);
        } 
    }

    /** TODO commenter le rôle de cette méthode (SRP)
     * @param nomFichier
     * @throws IOException 
     */
    public static void ouvrirFichier(String nomFichier) throws IOException {
        File fichier = new File(nomFichier+"txt");
        if(fichier.exists()) {
            FileReader lire = new FileReader(nomFichier+".txt");
            BufferedReader lireFichier = new BufferedReader(lire);
            while(lireFichier.readLine()!=null) {
                //afficher dans l'interface le texte
            }
        }else {
            throw new FileNotFoundException("fichier introuvable");
        }
    }
}

