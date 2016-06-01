package fr.iutvalence.info.dut.m2107;

/**
 * toutes les couleurs possibles des pieces
 * @author pasquiop
 *
 */
public enum PieceColor
{
	/**
	 * represente la couleur banche
	 */
	WHITE,
	/**
	 * represente la couleur noire
	 */
	BLACK,
	/**
	 * pour les non-pieces
	 */
	NONE;

	/**
	 * Donne la couleur inverse
	 * blanc donne noir
	 * noir donne blanc
	 * none donne none
	 * @return l'inverse de la couleur
	 */
	public PieceColor Invertcolor()
	{
		if (this == PieceColor.WHITE)
			return PieceColor.BLACK;
		else if (this == PieceColor.BLACK)
			return PieceColor.WHITE;
		else
			return PieceColor.NONE;
	}
	
	public String toString()
	{
		if (this == WHITE)
			return "blanc";
		else if (this == BLACK)
			return "noir";
		else
			return "aucun";
	}
}
