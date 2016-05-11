package fr.iutvalence.info.dut.m2107;

/**
 * Classe qui definit une position par des coordonnees
 * @author Xavier
 *
 */
public class Position {

	/**
	 * Absisse 
	 */
	private final int abscisse;
	
	/**
	 * Ordonnee 
	 */
	private final int ordonnee;

	
	/**
	 * Cree une position a partir des coordonnees donnees
	 * @param abscisse l'abscisse du position
	 * @param ordonnee l'ordonnee du position
	 */
	public Position(int abscisse, int ordonnee)
	{
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}


	/**
	 * @return renvoie l'abscisse de la position
	 */
	public int getAbscisse()
	{
		return this.abscisse;
	}


	/**
	 * @return renvoie l'ordonnee de la position
	 */
	public int getOrdonnee()
	{
		return this.ordonnee;
	}

}