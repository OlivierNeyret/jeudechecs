package fr.iutvalence.info.dut.m2107;

/**
 * Classe qui definit un deplacement par les coordonnees d'arrivee de la piece
 * @author Xavier
 *
 */
public class Deplacement {

	/**
	 * Absisse d'arrivee de la piece
	 */
	private final int abscisse;
	
	/**
	 * Ordonnee d'arrivee de la piece
	 */
	private final int ordonnee;

	
	/**
	 * Cree un deplacement a partir des coorodonnees donnees
	 * @param abscisse l'abscisse du deplacement
	 * @param ordonnee l'ordonnee du deplacement
	 */
	public Deplacement(int abscisse, int ordonnee)
	{
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}


	/**
	 * @return renvoie l'abscisse du deplacement
	 */
	public int getAbscisse()
	{
		return this.abscisse;
	}


	/**
	 * @return renvoie l'ordonnee du deplacement
	 */
	public int getOrdonnee()
	{
		return this.ordonnee;
	}

}