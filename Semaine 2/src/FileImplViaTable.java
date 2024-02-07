import java.util.Arrays;

// implementation de l'interface File via une table circulaire

/**
 * @author 
 *
 */

public class FileImplViaTable<E> implements File<E>{

	private Object[] table;  // ne modifiez pas cet identifiant, la classe test l'utilise					
	private int indiceTete;  // ne modifiez pas cet identifiant, la classe test l'utilise			
	private int taille;		// ne modifiez pas cet identifiant, la classe test l'utilise	
	// N'ajoutez pas d'autres attributs, la classe test risquerait de ne pas fonctionner
	

	public FileImplViaTable(){
		table = new Object[4];
		taille = 0;
		indiceTete = 0;
	}
	

	public boolean estVide(){
		return taille == 0;
	}


	public int taille(){
		return taille;
	}

	public E premier()throws FileVideException{
		if (estVide())
			throw new FileVideException();
		return (E) table[indiceTete];
	}


	public E defile() throws FileVideException{
		E temp = premier();
		if (taille>indiceTete)
			indiceTete++;
		else  {
			indiceTete=0;
		}
		taille--;
		return temp;
	}


	public void enfile(E element){
		Object[] tempTable;
		int index=indiceTete+taille;
		int x=0;
		if (index>=table.length) {
			if (taille<table.length) {
				x=index-table.length;
			} else {
				tempTable = new Object[table.length*2];
				int i=0;
				int j=0;
				while (i!=indiceTete) {
					if (j==0) {
						tempTable[j] = table[indiceTete];
						i=indiceTete;
					} else {
						tempTable[j] = table[i];
					}
					if (i<table.length-1) {
						i++;
					} else {
						i=0;
					}
					j++;
				}
				table=tempTable;
				x=j;
				indiceTete=0;
			}
		} else {
			x=taille;
		}
		table[x]=element;
		taille++;
	}

} 
