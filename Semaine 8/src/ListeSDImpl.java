import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeSDImpl<E> implements ListeSD<E>,Iterable<E> {

	private Noeud tete, queue;
	private HashMap<E, Noeud> mapElementNoeud;

	public ListeSDImpl () {
		mapElementNoeud = new HashMap<>();
		tete=new Noeud();
		queue=new Noeud();
		tete.suivant=queue;
		queue.precedent=tete;
	}

	public int taille () {
		return mapElementNoeud.size();
	}

	public boolean estVide () {
		return mapElementNoeud.isEmpty();
	
	}

	public boolean contient (E element) {
		return mapElementNoeud.containsKey(element);
	}

	public E premier() {
		return tete.suivant.element;
	}

	public E dernier() {
		return queue.precedent.element;
	}

	public E donnerPrecedent (E element) {
		if (!mapElementNoeud.containsKey(element))
			return null;
		return mapElementNoeud.get(element).precedent.element;
	}

	public E donnerSuivant (E element) {
		if (!mapElementNoeud.containsKey(element))
			return null;
		return mapElementNoeud.get(element).suivant.element;
	}

	public boolean insererEnTete (E element){
		if (mapElementNoeud.containsKey(element))
			return false;
		Noeud noeud = new Noeud(tete, element, tete.suivant);
		tete.suivant.precedent= noeud;
		tete.suivant=noeud;
		mapElementNoeud.put(element, noeud);
		return true;
	}

	public boolean insererEnQueue (E element) {
		if (mapElementNoeud.containsKey(element))
			return false;
		Noeud noeud = new Noeud(queue.precedent, element, queue);
		queue.precedent.suivant=noeud;
		queue.precedent=noeud;
		mapElementNoeud.put(element, noeud);
		return true;
	}

	public boolean insererApres (E element, E elementAInserer) {
		if (mapElementNoeud.containsKey(elementAInserer))
			return false;
		if (!mapElementNoeud.containsKey(element))
			return false;
		Noeud noeudAvant=mapElementNoeud.get(element);
		Noeud noeudApres=mapElementNoeud.get(element).suivant;
		Noeud noeud = new Noeud(noeudAvant, elementAInserer, noeudApres);
		noeudAvant.suivant=noeud;
		noeudApres.precedent=noeud;
		mapElementNoeud.put(elementAInserer, noeud);
		return true;
	}

	public boolean insererAvant (E element, E elementAInserer) {
		if (mapElementNoeud.containsKey(elementAInserer))
			return false;
		if (!mapElementNoeud.containsKey(element))
			return false;
		Noeud noeudApres=mapElementNoeud.get(element);
		Noeud noeudAvant=mapElementNoeud.get(element).precedent;
		Noeud noeud = new Noeud(noeudAvant, elementAInserer, noeudApres);
		noeudAvant.suivant=noeud;
		noeudApres.precedent=noeud;
		mapElementNoeud.put(elementAInserer, noeud);
		return true;
	}


	public boolean supprimer (E element) {
		if (!mapElementNoeud.containsKey(element))
			return false;
		mapElementNoeud.get(element).precedent.suivant=mapElementNoeud.get(element).suivant;
		mapElementNoeud.get(element).suivant.precedent=mapElementNoeud.get(element).precedent;
		mapElementNoeud.remove(element);
		return true;
	}

	
	public boolean permuter (E element1, E element2) {
		//TODO
		if (!mapElementNoeud.containsKey(element1)||!mapElementNoeud.containsKey(element2))
			return false;

		mapElementNoeud.get(element1).element=element2;
		mapElementNoeud.get(element2).element=element1;
		return true;

		// REMARQUE : CE SONT LES VALEURS QUI SONT PERMUTEES, PAS LES NOEUDS!!!
		// Il est donc inutile de revoir le chainage
		// N'oubliez pas de modifier les noeuds associes dans le map

	}

	public Iterator<E> iterator() {
		//TODO
		return null;
		// il faut renvoyer un objet de type Iterator :
		//return new IterateurImpl();
		// completez la classe interne IterateurImpl !
	}

	public String toString () {
		String aRenvoyer = "";
		int num = 1;
		Noeud baladeur = tete.suivant;
		while (baladeur != queue) {
			aRenvoyer += num + " - " + baladeur.element + "\n";
			baladeur = baladeur.suivant;
			num++;
		}
		return aRenvoyer;   
	}



	// Classe interne Noeud
	private class Noeud{
		private E element;
		private Noeud suivant;
		private Noeud precedent;

		private Noeud() {
			this(null, null, null);
		}

		private Noeud(E element) {
			this(null, element, null);
		}

		private Noeud(Noeud precedent, E element, Noeud suivant) {
			this.element = element;
			this.suivant = suivant;
			this.precedent = precedent;
		}
	}

	

	// Classe interne IterateurImpl
	private class IterateurImpl implements Iterator{

		private Noeud noeudCourant;

		private IterateurImpl() {
			//TODO

		}

		public boolean hasNext() {
			//TODO
			return false;

		}

		// renvoie l element qui se trouve dans le noeud courant
		// le noeud courant passe au noeud suivant
		public E next() {
			//TODO
			return null;

		}

		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();			
		}
	}

	// pour les tests
	public ListeSDImpl(E[] tableACopier) {
		mapElementNoeud = new HashMap<E, Noeud>();
		tete = new Noeud();   // sentinelle de tete
		queue = new Noeud();  // sentinelle de queue
		Noeud prec = tete;
		for (int i = 0; i < tableACopier.length; i++) {
			Noeud nouveauNoeud = new Noeud(tableACopier[i]);
			mapElementNoeud.put(tableACopier[i], nouveauNoeud);
			nouveauNoeud.precedent = prec;
			prec.suivant = nouveauNoeud;
			prec = nouveauNoeud;
		}
		prec.suivant = queue;
		queue.precedent = prec;
	}

	// pour les tests
	public String teteQueue(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = tete.suivant;
			int cpt=0;
			while (baladeur != queue) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
				baladeur = baladeur.suivant;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

	// pour les tests
	public String queueTete(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = queue.precedent;
			int cpt=0;
			while (baladeur != tete) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
				baladeur = baladeur.precedent;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

}
