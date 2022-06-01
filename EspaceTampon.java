/*
 * FichierTexte.java 	      30 mai 2022
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
	/***/
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
            fichier = new File(nomFichier+numero+".txt");
            fichier.renameTo(fichier);
        } 
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
     * @throws FileNotFoundException
     */
    public static void lireFichierEntier(File fichier) throws FileNotFoundException {
    	Scanner lecture = new Scanner(fichier);
    	while(lecture.hasNextLine()) {
    		System.out.println( lecture.nextLine()); 
    		//TODO changer le sysout pour qu'il apparaisse dans l'interface plutot que dans la console
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
     * @return
     */
    public static boolean ligneExiste(int ligne) {
		return false;//bouchon
    	//TODO ecrire la methode
    }
    /**
     * supprime une ligne mentionné du fichier courant
     * @param fichier
     * @param ligne
     * @throws IOException 
     */
    public static void suppression1Ligne(int ligne) throws IOException {
    	Scanner lecture = new Scanner(fichier);
    	File fichierbis = new File(nomFichier+"bis.txt");
    	
    	if(!ligneExiste(ligne)) {
    		throw new IOException("la ligne que vous souhaité supprimer n'existe pas");
    	
    	}
    	for(int indice = 0; indice<ligne ; indice++) {
    		
    		//TODO ecrire ici dans fichier bis avec la methode qui permettra d'ecrire
    	}

    }
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
    	FileWriter fw = new FileWriter(fichier);
    	BufferedWriter ecrire = new BufferedWriter(fw);
    	for(int indice = 1 ; indice < ligne ; indice++) {
    		ecrire.newLine();
    	}
    	for(int caractere = 0;caractere<75;caractere++) {
    		ecritFinal += aEcrire.charAt(caractere);
    	}
    	ecrire.write(ecritFinal);
	    //TODO a finir il ya des soucis ici
    }

}

