package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * piece est une classe abstraite qui est represent�e par une abscisse et une ordonnee
 * @author pasquiop
 *
 */
public abstract class Piece
{
	/**
	 * this is the color of the piece white or black
	 */
	private final PieceColor color;
	
	/**
	 * type of the piece like queen, king, ...
	 */
	private final PieceType type;
	
	/**
	 * Cree une piece avec un type et une couleur
	 * @param color c'est la couleur de la piece
	 * @param type de la peice a creer
	 */
	public Piece(PieceColor color, PieceType type)
	{
		this.color = color;
		this.type = type;
	}

	/**
	 * recupere le type de la piece
	 * @return retourne le type de la piece
	 */
	public PieceType getType()
	{
		return (this.type);
	}
	
	
	/**
	 * nous permet de voir les deplacements possibles de la piece
	 * @param board Le plateau de jeu
	 * @param check Est a false si la fonction est appelee depuis isCheck, on ne veut donc pas verifier si le deplacement mettrait la piece en echec
	 * @return un tableau de tout les deplacements possibles sans verifier l'echec si check est a false
	 */
	public ArrayList<Position> deplacement(Board board, boolean check)
	{
		// TODO - implement Piece.deplacement
		throw new UnsupportedOperationException();
	}
	

	/**
	 * renvoie la couleur de la piece
	 * @return noir ou blanc selon la couleur de la piece
	 */
	public PieceColor getColor()
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
			    return "C";
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
