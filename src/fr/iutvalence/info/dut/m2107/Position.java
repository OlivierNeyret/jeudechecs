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
	private final int abscissa;
	
	/**
	 * Ordonnee 
	 */
	private final int ordonate;

	
	/**
	 * Cree une position a partir des coordonnees donnees
	 * @param abscissa l'abscisse du position
	 * @param ordonate l'ordonnee du position
	 */
	public Position(int abscissa, int ordonate)
	{
		this.abscissa = abscissa;
		this.ordonate = ordonate;
	}


	/**
	 * @return renvoie l'abscisse de la position
	 */
	public int getAbscissa()
	{
		return this.abscissa;
	}


	/**
	 * @return renvoie l'ordonnee de la position
	 */
	public int getOrdonate()
	{
		return this.ordonate;
	}

}