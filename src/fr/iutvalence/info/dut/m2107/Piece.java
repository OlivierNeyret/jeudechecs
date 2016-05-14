package fr.iutvalence.info.dut.m2107;

/**
 * piece est une classe abstraite qui est represent�e par une abscisse et une ordonnee
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
	public Position[] deplacement()
	{
		// TODO - implement Piece.deplacement
		throw new UnsupportedOperationException();
	}

	/**
	 * renvoie la couleur de la piece
	 * @return noir ou blanc selon la couleur de la piece
	 */
	public Couleur getCouleur()
	{
		return this.couleur;
	}
	
	/**
	 * Redefinition de toString
	 * Renvoie une lettre correspondant au type de la piece
	 * La couleur n est pas distingable (pour l instant)
	 */
	public String toString()
	{
		switch (this.type)
		{
		  case Tour:
		    return "T"; 
		  case Cavalier:
			    return "C";
		  case Fou:
			    return "F";
		  case Reine:
			    return "R";
		  case Roi:
			    return "K";
		  case Pion:
			    return "P";	
		  default:
		    return "O";             
		}
	}
}
