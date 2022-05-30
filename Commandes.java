/*
 * Commandes.java                                             18/05/2022
 * INF01 S2 pas de copy right ni de droit d'auteur
 */
package sae4.traitementtext;

/**
 * Classe qui regroupe l'ensemble des commandes que pourra effectuer
 * l'utilisateurdans l'espace de commande.
 * @author mateo.faussurier
 *
 */
public class Commandes {

	/**
	 * La commande 't' a pour r�le de lire le contenu du fichier un_fichier
	 * et de le placer dans le tampon, en d�truisant le contenu
	 * courant de celui-ci. Le fichier doit exister.
	 */
	public void commandeT(String nomFichier) {
		//TODO V�rifier le nombre de caract�re par ligne et le
		//nombre de ligne du fichier. 
		// TODO lire et ouvrir le fichier
	}
	
	/**
	 * La commande 'f' est La commande de sauvegarde, elle doit transf�rer
	 * le tampon dans un fichier. On doit entrer le nom du fichier dans lequel
	 * on veut le sauvegarder.
	 */
	public void commandeF(String nomFichier) {
		//TODO D�velopper avec l'aide de la le�on
	}
	
	/**
	 * La commande 'q' pour quitter
	 */
	public void commandeQ() {
		//TODO un exit pour sortir de la fenetre
		
	}
	
	/**
	 * la commande '?' pour ouvrir l'aide
	 */
	public void commandeAide() {
		//TODO ouvrir la fenetre d'aide
	}
	
	/**
	 * La commande 'e' permet d'effacer la ou les lignes mentionn�es.
	 */
	public void commandeE(int[] numeroLigne) {
		//TODO v�rifier que les lignes existent
	}
	
	/**
	 * La commande 'a' permet d'ins�rer du text apr�s la ligne mentionner
	 */
	public void commandeA(int[] numeroLigne, String texteAAjouter) {
		//TODO V�rifier que la ligne existe
		// V�rifier que le nombre 
	}
	
	/**
	 * La commande 'i' insert la le texte avant la ligne r�f�renc�e.
	 */
	public void commandeI(int[] numeroLigne, String texteAAjouter) {
		//TODO V�rifier que la ligne existe
		// Verifier que le texte rentre dans les crit�res
	}
	
	/**
	 * La commande 'm' modifie la ligne
	 */
	public void commandeM(int[] numeroLigne) {
		//TODO une entr�e de texte
		//V�rifier que la ligne existe
		//V�rifier que le nombre de caract�re est valide
	}
	
	/**
	 * La commande 'c' permet de copier un groupe de ligne � 
	 * un autre endroit du texte.
	 */
	public void commandeC(int[] numeroLigne, int emplacement) {
		//TODO V�rifier que les lignes existent.
	}
	
	/**
	 * La commande 'd' permet de couper un groupe de ligne
	 * et de le d�porter sur un autre endroit.
	 */
	public void commandeD(int[] numeroLigne, int emplacement) {
		//TODO V�rifier que les lignes existent.
	}
	
	/**
	 * La commande 'r' permet de  rechercher une cha�ne de caract�re
	 * dans le texte entier ou dans une partie.
	 */
	public void commmandeR(int[] numeroLigne, String chaineCaractere) {
	}
	
	/**
	 * La commande 's' permet de substituer une cha�ne de caract�re
	 * par une autre dans le tampon.
	 */
	public void commandeS(int[] numeroLigne, String chaineARemplacer, String chaineRemplacente) {
		
	}
}
