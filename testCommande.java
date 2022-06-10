package sae4.traitementtext;

public class testCommande {

	/** commandes qui ne génèreront pas d'erreurs*/
	private static final String[] COMMANDES_VALIDES = {
			"a 23", "t unFichier", "    e 89, 99", "i 99", "q","  ?  ",
			" m  1", "c 36, 57", "d 100, 1", "c 9, 10, 11",
			"d 2, 11, 3", "f unAutreFichier", "i 66, 77"
	};

	/** sera arrangée automatiquement*/
	private static final String[] COMMANDES_INCORRECTES = {
			"24", "a abd", "z", "1h3", "   ", "100 a", "aide",
			"quitter", "aide ?", "i 2f", "d -6", 
	};

	/** commande avec comme paramètre des nom de fichier */
	private static final String[] COMMANDES_FICHIER = {
			"t nom", "f editeur"
	};

	/**
	 * 
	 * @param args non utilisés
	 */
	public static void main(String[] args) {
		boolean ok = true;

		ok &= testCommandExecute();

		if (ok) {
			System.out.println("Tests reussis");
		} else {
			System.out.println("Tests echoue");
		}
	}

	/**
	 * interprétation des commandes entrées dans l'espace de commande.
	 * @return testOk true si les tests sont réussis, false sinon
	 */
	private static boolean testCommandExecute() {
		boolean testOk = true;
		System.out.println("-------------------Début des tests des commandes"
				+ " valides-------------------");
		for (int i = 0; i < COMMANDES_VALIDES.length; i++) {
			try {
				EspaceCommande.commandExecute(COMMANDES_VALIDES[i]);
				testOk &= true;
			} catch (Exception e) {
				testOk &= false;
			}
		}
		System.out.println("------------------Début des tests des commandes"
				+ " invalides------------------");
		for (int i = 0; i < COMMANDES_VALIDES.length; i++) {
			try {
				EspaceCommande.commandExecute(COMMANDES_INCORRECTES[i]);
				testOk &= false;
			} catch (Exception e) {
				testOk &= true;
			}
		}
		System.out.println("-------------------Début des tests des commandes"
				+ " fichier -------------------");
		for (int i=0; i < COMMANDES_FICHIER.length; i++) {
			try {
				EspaceCommande.commandExecute(COMMANDES_FICHIER[i]);
				testOk &= true;
			} catch (Exception e) {
				testOk &= false;
			}
		}
		System.out.println("-------------------Fin des tests-------------------");
		return testOk;
	}
}
