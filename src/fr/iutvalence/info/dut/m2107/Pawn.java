package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacements: 	2 cases avant si non deplace
 * 					sinon 1 case avant et prend en 1 case diagonale avant
 * @author pasquiop
 *
 */
public class Pawn extends Piece {

	/**
	 * Cree un pion de la couleur donnee
	 * @param couleur
	 * @param type type du pion
	 */
	public Pawn(Color couleur, Type type)
	{
		super(couleur, type);
	}
	
	public ArrayList<Position> deplacement(Board plateau, boolean check) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		int x = plateau.getCoordonateOfPiece(this).getOrdonate();
		int y = plateau.getCoordonateOfPiece(this).getAbscissa();
		Color couleur=this.getColor();
		
		if (couleur==Color.BLACK)
		{
			
			if (y == 6)
			{
				try
				{
					if (plateau.getPieceAtPosition(new Position(x+2,y)).getType() == Type.NONE && 
						!(plateau.emulateDeplacement(this, new Position(x+2,y)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
					{
						deplacement.add(new Position(x+2,y));
					}
				} catch (PositionOutOfBoardException e)
				{
				}
			}
			try
			{
				if (plateau.getPieceAtPosition(new Position(x+1,y)).getType() == Type.NONE && 
						!(plateau.emulateDeplacement(this, new Position(x+1,y)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x+1,y));
				}
			} catch (PositionOutOfBoardException e)
			{
			}
		}
		else if(couleur==Color.WHITE)
		{
			if (y == 1)
			{
				try
				{
					if (plateau.getPieceAtPosition(new Position(x-2,y)).getType() == Type.NONE && 
						!(plateau.emulateDeplacement(this, new Position(x-2,y)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
					{
						deplacement.add(new Position(x-2,y));
					}
				} catch (PositionOutOfBoardException e)
				{
				}
			}
			try
			{
				if (plateau.getPieceAtPosition(new Position(x-1,y)).getType() == Type.NONE && 
						!(plateau.emulateDeplacement(this, new Position(x-1,y)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x-1,y));
				}
			} catch (PositionOutOfBoardException e)
			{
			}
		}
		else return null;
		return deplacement;
	}
}
