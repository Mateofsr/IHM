 * FichierTexte.java          30 mai 2022
 * IUT de Rodez,Info1 2021-2022 pas de copyright
 */
package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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

	public static File fichierbis = new File(nomFichier+"bis.txt");
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
		File fichierbis = new File(nomFichier+".txt");
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
			//TODO creer fichier bis

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
		ecrire.close();
		lecture.close();
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
		lecture.close();
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
	public static void suppression1Ligne(int ligne) throws IOException {

		Scanner lecture = new Scanner(fichierbis);
		FileWriter wesh = new FileWriter(fichierbis);
		BufferedWriter ecrire = new BufferedWriter(wesh);
		int indice = 0;
		if(!ligneExiste(ligne)) {
			lecture.close();
			ecrire.close();
			throw new IOException("la ligne que vous souhaité supprimer n'existe pas");
		}
		while(lecture.hasNextLine()) {
			indice++;
			if(indice == ligne) {
				lecture.nextLine();
			}
			ecrire.write(lecture.nextLine());
			ecrire.newLine();
		}
		lecture.nextLine();
		ecrire.close();
		lecture.close();
	}

	/** 
	 * Supprime plusieur ligne entre la ligneA et la ligneB
	 * @param nomFichier
	 * @param ligneA
	 * @param ligneB
	 * @throws IOException 
	 */
	public static void suppressionPlusieurLigne(int ligneA , int ligneB) throws IOException {
		if(!ligneExiste(ligneB)&& !ligneExiste(ligneA)) {
			throw new IllegalArgumentException("aucune des ligne séléctionnez n'existe");
		}

		Scanner lecture = new Scanner(fichierbis);
		FileWriter wesh = new FileWriter(fichierbis);
		BufferedWriter ecrire = new BufferedWriter(wesh);
		int indice = 1;

		while(lecture.hasNextLine()) {
			if((indice>= ligneA && indice <= ligneB) ||(indice>= ligneB && indice <= ligneA)){
				lecture.nextLine();
			}else {
				ecrire.write(lecture.nextLine());
				ecrire.newLine();
			}
			indice++;
		}
		ecrire.close();
		lecture.close();

	}
	/**
	 * methode qui permet d'ecrire une ligne de texte avant la ligne en paramétre
	 * @param ligne
	 * @throws IOException 
	 */
	public static void ecrireLigneAvant(int ligne) throws IOException {
		String ecritFinal="";
		Scanner lire = new Scanner(fichierbis);
		FileWriter fw = new FileWriter(fichierbis);
		BufferedWriter ecrire = new BufferedWriter(fw);
		if(ligne <= 0) {
			lire.close();
			ecrire.close();
			throw new IllegalArgumentException("Il n'existe pas de ligne négative");

		}else if( ligne == 1) {
			for(int caractere = 0;caractere<75 && caractere < aEcrire.length();caractere++) {
				ecritFinal += aEcrire.charAt(caractere);
			}
		}else {
			for(int indice = 1 ; indice < ligne ; indice++) {
				ecrire.write(lire.nextLine());
				ecrire.newLine();
			}
			for(int caractere = 0;caractere<75;caractere++) {
				ecritFinal += aEcrire.charAt(caractere);
			}
		}
		lire.close();
		ecrire.write(ecritFinal);
		ecrire.close();

	}

	public static void ecrireLigneApres(int ligne) throws IOException {
		if(!ligneExiste(ligne)) {
			throw new IllegalArgumentException("la ligne n'existe pas ");
		}
		String ecritFinal="";
		Scanner lire = new Scanner(fichierbis);
		FileWriter fw = new FileWriter(fichierbis);
		BufferedWriter ecrire = new BufferedWriter(fw);
		if( ligne == 1) {
			for(int caractere = 0;caractere<75 && caractere < aEcrire.length();caractere++) {
				ecritFinal += aEcrire.charAt(caractere);
			}
		}else {
			for(int indice = 0 ; indice < ligne ; indice++) {
				ecrire.write(lire.nextLine());
				ecrire.newLine();
			}
			for(int caractere = 0;caractere<75;caractere++) {
				ecritFinal += aEcrire.charAt(caractere);
			}
		}
		lire.close();
		ecrire.write(ecritFinal);
		ecrire.close();

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
		fermeture();;
	}

	public static void modifier(int ligne) throws IOException {
		if(!ligneExiste(ligne)) {
			throw new IllegalArgumentException("la ligne n'existe pas ");
		}
		String ecritFinal="";
		Scanner lire = new Scanner(fichierbis);
		FileWriter fw = new FileWriter(fichierbis);
		BufferedWriter ecrire = new BufferedWriter(fw);
		if( ligne == 1) {
			for(int caractere = 0;caractere<75 && caractere < aEcrire.length();caractere++) {
				ecritFinal += aEcrire.charAt(caractere);
			}
		}else {
			for(int indice = 0 ; indice < ligne ; indice++) {
				ecrire.write(lire.nextLine());
				ecrire.newLine();
			}
			for(int caractere = 0;caractere<75;caractere++) {
				ecritFinal += aEcrire.charAt(caractere);
			}
		}
		lire.close();
		ecrire.write(ecritFinal);
		ecrire.close();

	}

	public static void copie(int ligneDebut , int ligneFin, int emplacementCopie) throws IOException {
		if(!ligneExiste(ligneDebut) || !ligneExiste(emplacementCopie)|| !ligneExiste(ligneFin)) {
			throw new IllegalArgumentException("les ligne n'existe pas");
		}
		int ligne = 1;
		ArrayList<String> sauvegarde = new ArrayList<String>();
		Scanner lire = new Scanner(fichierbis);
		FileWriter fw = new FileWriter(fichierbis);
		BufferedWriter ecrire = new BufferedWriter(fw);
		if(ligneFin<ligneDebut) {
			ligneFin = ligneDebut;
			ligneDebut = ligneFin;	
		}
		while(!lire.hasNextLine()) {
			ecrire.write(lire.nextLine());
			ecrire.newLine();
			while(ligne>= ligneDebut && ligne<= ligneFin) {
				sauvegarde.add(lire.next());
			}
			
			ligne++;
		}
		lire.useRadix(0);
		ligne = 0;
		while(!lire.hasNextLine()) {
			if(ligne == emplacementCopie) {
				for(int i=0;i<sauvegarde.size();i++) {
					ecrire.write(sauvegarde.get(i));
					ecrire.newLine();
				}
			}else {
				ecrire.write(lire.nextLine());
				ecrire.newLine();
			}
		}
	}
	public static void copie(int ligne , int emplacementCopie) throws IOException {

		if(!ligneExiste(ligne)|| !ligneExiste(emplacementCopie)) {
			throw new IllegalArgumentException("impossible de copier vers une ligne qui n'existe pas");
		}
		int indice = 1;
		String sauvegarde="";
		Scanner lire = new Scanner(fichierbis);
		FileWriter fw = new FileWriter(fichierbis);
		BufferedWriter ecrire = new BufferedWriter(fw);
		while(lire.hasNextLine()) {
			ecrire.write(lire.nextLine());
			ecrire.newLine();
			if(indice == ligne) {
				sauvegarde = lire.next();	
			}
			indice++;
		}
		indice = 1;
		while(lire.hasNextLine()) {
			if(indice == emplacementCopie) {
				ecrire.write(sauvegarde);
				ecrire.newLine();
				lire.nextLine();
			}else {


				ecrire.write(lire.nextLine());
				ecrire.newLine();
			}
		}
		ecrire.close();
		lire.close();
	}
	public static void deplacement(int ligneADeplacer , int ligne) throws IOException {
		if(!ligneExiste(ligneADeplacer)|| ! ligneExiste(ligne)) {
			throw new IllegalArgumentException("les ligne référencé n'existepas");
		}
		copie(ligneADeplacer,ligne);                                                                             
		suppression1Ligne(ligneADeplacer);
	}
	public static void deplacement(int ligneADeplacerA,int ligneADeplacerB,int ligne) throws IOException {
		copie(ligneADeplacerA, ligneADeplacerB, ligne);
		suppressionPlusieurLigne(ligneADeplacerA, ligneADeplacerB);
		
	}
	public static void fermeture() {
		fichierbis.delete();
	}


	public static void main (String[]args) throws IOException {


	}
}
