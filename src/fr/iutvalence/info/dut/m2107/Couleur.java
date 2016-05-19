package fr.iutvalence.info.dut.m2107;

/**
 * toutes les couleurs possibles des pieces
 * @author pasquiop
 *
 */
public enum Couleur
{
	/**
	 * represente la couleur banche
	 */
	Blanc,
	/**
	 * represente la couleur noire
	 */
	Noir,
	/**
	 * pour les non-pieces
	 */
	None;

	/**
	 * @param couleur est la couleur que lon veut inverser
	 * @return l'inverse de la couleur passee en param
	 */
	public Couleur Invertcolor()
	{
		if (this == Couleur.Blanc)
			return Couleur.Noir;
		else 
			return Couleur.Blanc;
	}
}
