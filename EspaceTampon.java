 * FichierTexte.java          30 mai 2022
 * IUT de Rodez,Info1 2021-2022 pas de copyright
 */
package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/** TODO commenter la responsabilité de cette classe
 * @author 33766
 *
 */
public class EspaceTampon {

    /**création d'un nom de fichier par défaut*/
    public static String nomFichier="nomParDéfaut";
    /**création d'un fichier par défaut*/
    public static File fichier = new File(nomFichier+".txt");
    /** */
    public static File fichierbis = new File(nomFichier+"bis.txt");
    /***/
    public static File fichierTampon = new File(nomFichier+"tampon.txt");
    public static String aEcrire;

     /** 
     * permet de supprimer le fichier texte courant
     * 
     */
    public static void suppressionFichier() {
        File fichier = new File(nomFichier+".txt"); 
        fichier.delete();
    }
    
    /** 
     * permet de supprimer le fichier texte avec le nom mentionné en paramétre
     * @param nomFichier
     */
    public static void suppressionFichier(String nomFichier) {
        File fichier = new File(nomFichier+".txt"); 
        
        if(fichier.exists()) { 
             fichier.delete();
        } else { 
            System.out.println("le fichier n'existe pas ou le nom mentionné n'est pas le bon"); 
        } 
    }
   
    /** 
     * permet de créer un nouveau fichier texte avec comme nom spécifié en paramétre
     * @param nomFichier
     * @throws IOException
     */
    public static void creationFichier(String nomFichier) throws IOException {
        int numero = 0;
        File fichier = new File(nomFichier+".txt");
        while(fichier.exists()) {
            numero++;
            nomFichier+="("+numero+")";
            fichier = new File(nomFichier+".txt");
            fichier.renameTo(fichier);
        } 
        fichier.createNewFile();
        fichier = new File(nomFichier+"bis.txt");
        
        fichier.renameTo(fichier);
        fichier.createNewFile();
        ouvrirFichier(nomFichier);
    }

    /** 
     * methode qui permette d'ouvrir et d'afficher le fichier texte dont le nom est spécifié en 
     * paramétre sur l'interface graphique
     * @param nomFichier
     * @throws IOException 
     */
    public static void ouvrirFichier(String nomFichier) throws IOException {
        fichier = new File(nomFichier+".txt");
        
        if(fichier.exists()) {
            lireFichierEntier(fichier);

        }else {
            throw new FileNotFoundException("fichier introuvable");
        }
    }
    /** 
     * methode qui permette d'ouvrir et d'afficher le fichier texte courant
     * @throws IOException 
     */
    public static void ouvrirFichier() throws IOException {
        File fichier = new File(nomFichier+".txt");
        
        if(fichier.exists()) {
            lireFichierEntier(fichier);
        }else {
            throw new FileNotFoundException("fichier introuvable");
        }
    }
    /**
     * lit le fichier mentionné en paramétre en entier
     * @param fichier
     * @throws IOException 
     */
    public static void lireFichierEntier(File fichier) throws IOException {
        Scanner lecture = new Scanner(fichier);
        FileWriter writer = new FileWriter(fichier);
        BufferedWriter ecrire = new BufferedWriter(writer);
        while(lecture.hasNextLine()) {
           
             ecrire.write(lecture.nextLine());
             ecrire.newLine();
        }
    }
    /**
     * lit le fichier courant en entier
     * @param fichier
     * @throws FileNotFoundException
     */
    public static void lireFichierEntier() throws FileNotFoundException {
        Scanner lecture = new Scanner(fichier);
        while(lecture.hasNextLine()) {
            System.out.println( lecture.nextLine()); 
            //TODO changer le sysout pour qu'il apparaisse dans l'interface plutot que dans la console
        }
    }
    /**
     * 
     * @param ligne
     * @return true si la ligne existe false sinon
     * @throws FileNotFoundException 
     */
    public static boolean ligneExiste(int ligne) throws FileNotFoundException {
        Scanner lecture = new Scanner(fichier);
        for(int indice =0;indice<ligne;indice++) {
            
            if(!lecture.hasNextLine()) {
                return false;
            }
            lecture.nextLine();
        }
        lecture.close();
        return true;
        
    }
    /**
     * supprime une ligne mentionné du fichier courant
     * @param fichier
     * @param ligne
     * @throws IOException 
     */
    public static void suppression1Ligne(String nomFichier,int ligne) throws IOException {
       
        File fichierASupprimer = new File(nomFichier+"bis.txt");
        File fichiertemp = new File(nomFichier+"temp.txt");
        Scanner lecture = new Scanner(fichiertemp);
        FileWriter wesh = new FileWriter(fichiertemp);
        BufferedWriter ecrire = new BufferedWriter(wesh);
        if(!ligneExiste(ligne)) {
            throw new IOException("la ligne que vous souhaité supprimer n'existe pas");
        
        }
        for(int indice = 0; indice<ligne ; indice++) {
        	ecrire.write(lecture.nextLine());
        	ecrire.newLine();
        
            //TODO ecrire ici dans fichier bis avec la methode qui permettra d'ecrire
        }
        lecture.nextLine();
        while(lecture.hasNextLine()) {
        	ecrire.write(lecture.nextLine());
        }

    }
    
    /** 
     * Supprime plusieur ligne entre la ligneA et la ligneB
     * @param nomFichier
     * @param ligneA
     * @param ligneB
     */
    public static void suppressionPlusieurLigne(String nomFichier , int ligneA , int ligneB) {
        //TODO ecrire la methode aprés suppression 1 ligne
    }
    /**
     * methode qui permet d'ecrire une ligne de texte avant la ligne en paramétre
     * @param ligne
     * @throws IOException 
     */
    public static void ecrireLigneAvant(int ligne) throws IOException {
        String ecritFinal="";
        FileWriter fw = new FileWriter(fichierbis);
        BufferedWriter ecrire = new BufferedWriter(fw);
        if(ligne == 0) {
            for(int caractere = 0;caractere<75 && caractere < aEcrire.length();caractere++) {
                ecritFinal += aEcrire.charAt(caractere);
            }
        }else {
            for(int indice = 1 ; indice < ligne ; indice++) {
                ecrire.newLine();
            }
            for(int caractere = 0;caractere<75;caractere++) {
                ecritFinal += aEcrire.charAt(caractere);
            }
        }
        ecrire.write(ecritFinal);
        ecrire.close();
        //TODO a modifier
    }
    public static void enregistrer(File fichier) throws IOException {
    	Scanner lecture = new Scanner(fichierbis);
    	FileWriter wesh = new FileWriter(fichier);
    	BufferedWriter ecrire = new BufferedWriter(wesh);
    	while(lecture.hasNextLine()) {
    		ecrire.write(lecture.nextLine());
    		ecrire.newLine();
    	}
    	lecture.close();
    	ecrire.close();
    }
    public static void fermeture() {
    	fichierbis.delete();
    }


    public static void main (String[]args) throws IOException {

    	suppression1Ligne(nomFichier, 2);
    }
}
