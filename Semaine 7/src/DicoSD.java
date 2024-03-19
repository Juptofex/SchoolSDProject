import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;

public class DicoSD {
	
	//TODO
	// suivez l'implementation proposee dans l'enonce!
	HashMap<String, LinkedList<String>> mapUrl;

	// Au depart le dico est vide
	public DicoSD() {
		//TODO
		mapUrl = new HashMap<>();
	}

	/**
	 * ajout dans le dico une association sd-url si cette association n'est pas encore presente 
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si cette association n'etait pas encore presente dans le dico, false sinon
	 */
	public boolean ajouter(String sd, String url){
		//TODO
		if (mapUrl.containsKey(sd) && mapUrl.get(sd).contains(url))
			return false;
		if (!mapUrl.containsKey(sd)) {
			mapUrl.put(sd,new LinkedList<>());
		}
		mapUrl.get(sd).add(url);
		return true;
	}
	
	/**
	 * verifie si la structure de donnees se trouve dans le dico
	 * cette structure de donnees doit posseder au moins une url!
	 * @param sd
	 * @return true si sd est present, false sinon
	 */
	public boolean contient(String sd){
		//TODO
		return mapUrl.containsKey(sd);
	}
	
	
	/**
	 * renvoie tous les urls associes a la structure de donnees passee en parametre
	 * @param sd
	 * @return une chaine de caracteres avec les urls selon le format : [urlPile1, urlPile2] ou [] si la structure de donnees n'existe pas
	 */
	public String lesURLs(String sd){
		//TODO
		if (!mapUrl.containsKey(sd))
			return "[]";
		return mapUrl.get(sd).toString();
	}
	
	/**
	 * supprime dans le dico l'association sd-url si celle-ci est presente 
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si l'association etait presente dans le dico, false sinon
	 */
	public boolean supprimer(String sd, String url){
		//TODO
		if (!mapUrl.containsKey(sd))
			return false;
		mapUrl.remove(sd, url);
		return true;
	}
		
}
