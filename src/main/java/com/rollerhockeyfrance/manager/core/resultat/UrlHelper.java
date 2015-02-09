package com.rollerhockeyfrance.manager.core.resultat;

/**
 * Classe utilitaire permettant de générer les différentes URL
 * du module de résultats de la FFRS.
 * 
 * @author fabiensaulnier
 */
public class UrlHelper {
	
	// TODO : mettre dans le fichier de config yaml
	private static String BASE_PATH = "http://stat.ffrs.asso.fr/stats";
	
	/**
	 * @param id - Identifiant d'une compétition
	 * @return URL d'un classement
	 */
	public static String classementURL(String id) {
		return BASE_PATH + "/match/classement/" + id;
	}
	
	/**
	 * @param id - Identifiant d'une compétition
	 * @return URL des statistiques de la compétition
	 */
	public static String statistiquesURL(String id) {
		return BASE_PATH + "/match/buteurs/" + id;
	}
	
	/**
	 * @param id - Identifiant d'une compétition
	 * @return URL des statistiques de la compétition
	 */
	public static String matchsURL(String id) {
		return BASE_PATH + "/match/resultats/" + id;
	}

}
