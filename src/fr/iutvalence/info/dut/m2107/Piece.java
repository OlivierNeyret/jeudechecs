package fr.iutvalence.info.dut.m2107;

/**
 * piece est une classe abstraite qui est representée par une abscisse et une ordonnee
 * @author pasquiop
 *
 */
public abstract class Piece
{
	private Couleur couleur;

	/**
	 * recupere le type de la piece
	 * @return retourne le type de la piece
	 */
	public Type recupererType()
	{
		// TODO - implement Piece.recupererType
		throw new UnsupportedOperationException();
	}
	
	/**
	 * on défini une couleur (noir/blanc) pour la piece
	 * @param a est la couleur de la piece 
	 */
	
	public Piece(Couleur a)
	{
		this.couleur = a;
	}
	
	/**
	 * nous permet de voir les deplacements possibles de la piece
	 * @return un tableau de tout les deplacements possibles
	 */
	public Deplacement[] deplacement()
	{
		// TODO - implement Piece.deplacement
		throw new UnsupportedOperationException();
	}

}