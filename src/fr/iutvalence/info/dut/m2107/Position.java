package fr.iutvalence.info.dut.m2107;

/**
 * Classe qui definit une position par des coordonnees
 * @author Xavier
 *
 */
public class Position
{

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
	 * @throws PositionOutOfBoardException Si la piece est en dehors de l'echiquier
	 */
	public Position(int ordonate, int abscissa) throws PositionOutOfBoardException
	{
		if (abscissa<=7 && ordonate<=7 && abscissa>=0 && ordonate>=0)
		{
			this.abscissa = abscissa;
			this.ordonate = ordonate;
		}
		else throw new PositionOutOfBoardException();
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
	
	/**
	 * Renvoie une coordonnee sous la forme (ligne,colonne)
	 */
	public String toString()
	{
		return "(" + this.ordonate + "," + this.abscissa + ")";
	}

}