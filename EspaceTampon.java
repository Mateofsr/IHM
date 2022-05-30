/*
 * Tampon.java                                             18/05/2022
 * INF01 S2 pas de copy right ni de droit d'auteur
 */
package sae4.traitementtext;

import sae4.traitementtext.*;
import java.util.ArrayList;
import java.lang.StringBuilder;

/**
 * Espace où le texte sera affiché, l'utilisateur ne pourra pas directement
 * modifier le texte qu'il y aura affiché mais pourra interagir avec par
 * l'espace de commande dédier au-dessus.
 * @author mateo.faussurier emmanuel.gomes-soares
 *
 */
public class EspaceTampon {
	
	public String[] texte;
	
	private final int CARACTERES_MAX = 75;
	
	private final int LIGNES_MAX = 100;
	
	private int nbLignes;
	
	private int nbCaracteres;
	
	public int numeroLigne;
	
	/**
	 * pas de paramètre
	 * @return true si le nombre de ligne dans le tampon respecte la limite
	 * 		   false sinon.
	 */
	public boolean nbLignesOk() {
		//TODO calculer le nombre de ligne
		return nbLignes <= LIGNES_MAX;
	}
	
	/**
	 * 
	 * @return true si le nombre de caractères de la ligne respecte
	 * 		   CARACTERES_MAX, false sinon
	 */
	public boolean nbCaracteresOk() {
		return texte[numeroLigne].length() <= CARACTERES_MAX;
	}
}
