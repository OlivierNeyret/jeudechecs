package fr.iutvalence.info.dut.m2107;

/**
 * piece est une classe abstraite qui est representée par une abscisse et une ordonnee
 * @author pasquiop
 *
 */
public abstract class Piece
{
	private final Couleur couleur;

	private final Type type;
	
	
	
	//TODO comment
	/**
	 * Cree
	 * @param couleur
	 * @param type
	 */
	public Piece(Couleur couleur, Type type)
	{
		this.couleur = couleur;
		this.type = type;
	}

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
	 * nous permet de voir les deplacements possibles de la piece
	 * @return un tableau de tout les deplacements possibles
	 */
	public Deplacement[] deplacement()
	{
		// TODO - implement Piece.deplacement
		throw new UnsupportedOperationException();
	}

}