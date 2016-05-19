package fr.iutvalence.info.dut.m2107;

/**
 * toutes les couleurs possibles des pieces
 * @author pasquiop
 *
 */
public enum Color
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
	 * @param couleur est la couleur que lon veut inverser
	 * @return l'inverse de la couleur passee en param
	 */
	public Color Invertcolor()
	{
		if (this == Color.WHITE)
			return Color.BLACK;
		else 
			return Color.WHITE;
	}
}
