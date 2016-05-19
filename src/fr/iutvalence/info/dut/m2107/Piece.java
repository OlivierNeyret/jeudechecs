package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * piece est une classe abstraite qui est represent�e par une abscisse et une ordonnee
 * @author pasquiop
 *
 */
public abstract class Piece
{
	private final Color color;

	private final Type type;
	
	
	
	//TODO comment
	/**
	 * Cree
	 * @param color
	 * @param type
	 */
	public Piece(Color color, Type type)
	{
		this.color = color;
		this.type = type;
	}

	/**
	 * recupere le type de la piece
	 * @return retourne le type de la piece
	 */
	public Type getType()
	{
		// TODO - implement Piece.recupererType
		throw new UnsupportedOperationException();
	}
	
	
	/**
	 * nous permet de voir les deplacements possibles de la piece
	 * @param board Le plateau de jeu
	 * @return un tableau de tout les deplacements possibles
	 */
	public ArrayList<Position> deplacement(Board board)
	{
		// TODO - implement Piece.deplacement
		throw new UnsupportedOperationException();
	}

	/**
	 * renvoie la couleur de la piece
	 * @return noir ou blanc selon la couleur de la piece
	 */
	public Color getColor()
	{
		return this.color;
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
		  case ROOK:
		    return "R"; 
		  case KNIGHT:
			    return "K";
		  case BISHOP:
			    return "B";
		  case QUEEN:
			    return "Q";
		  case KING:
			    return "K";
		  case PAWN:
			    return "P";	
		  default:
		    return "O";             
		}
	}
}
