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
	 * La commande 't' a pour rôle de lire le contenu du fichier un_fichier
	 * et de le placer dans le tampon, en détruisant le contenu
	 * courant de celui-ci. Le fichier doit exister.
	 */
	public void commandeT(String nomFichier) {
		//TODO Vérifier le nombre de caractère par ligne et le
		//nombre de ligne du fichier. 
		// TODO lire et ouvrir le fichier
	}
	
	/**
	 * La commande 'f' est La commande de sauvegarde, elle doit transférer
	 * le tampon dans un fichier. On doit entrer le nom du fichier dans lequel
	 * on veut le sauvegarder.
	 */
	public void commandeF(String nomFichier) {
		//TODO Développer avec l'aide de la leçon
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
	 * La commande 'e' permet d'effacer la ou les lignes mentionnées.
	 */
	public void commandeE(int[] numeroLigne) {
		//TODO vérifier que les lignes existent
	}
	
	/**
	 * La commande 'a' permet d'insérer du text après la ligne mentionner
	 */
	public void commandeA(int[] numeroLigne, String texteAAjouter) {
		//TODO Vérifier que la ligne existe
		// Vérifier que le nombre 
	}
	
	/**
	 * La commande 'i' insert la le texte avant la ligne référencée.
	 */
	public void commandeI(int[] numeroLigne, String texteAAjouter) {
		//TODO Vérifier que la ligne existe
		// Verifier que le texte rentre dans les critères
	}
	
	/**
	 * La commande 'm' modifie la ligne
	 */
	public void commandeM(int[] numeroLigne) {
		//TODO une entrée de texte
		//Vérifier que la ligne existe
		//Vérifier que le nombre de caractère est valide
	}
	
	/**
	 * La commande 'c' permet de copier un groupe de ligne à 
	 * un autre endroit du texte.
	 */
	public void commandeC(int[] numeroLigne, int emplacement) {
		//TODO Vérifier que les lignes existent.
	}
	
	/**
	 * La commande 'd' permet de couper un groupe de ligne
	 * et de le déporter sur un autre endroit.
	 */
	public void commandeD(int[] numeroLigne, int emplacement) {
		//TODO Vérifier que les lignes existent.
	}
	
	/**
	 * La commande 'r' permet de  rechercher une chaîne de caractère
	 * dans le texte entier ou dans une partie.
	 */
	public void commmandeR(int[] numeroLigne, String chaineCaractere) {
	}
	
	/**
	 * La commande 's' permet de substituer une chaîne de caractère
	 * par une autre dans le tampon.
	 */
	public void commandeS(int[] numeroLigne, String chaineARemplacer, String chaineRemplacente) {
		
	}
}
