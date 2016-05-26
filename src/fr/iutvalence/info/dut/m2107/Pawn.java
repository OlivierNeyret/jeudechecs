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
		int y = plateau.getCoordonateOfPiece(this).getOrdonate();
		int x = plateau.getCoordonateOfPiece(this).getAbscissa();
		Color couleur=this.getColor();
		
		
		if (check)
		{
			if (couleur==Color.BLACK)
			{
				
				if (x == 1)
				{
					try
					{
						if (plateau.getPieceAtPosition(new Position(y,x+2)).getType() == Type.NONE && 
							!(plateau.emulateDeplacement(this, new Position(y,x+2)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
						{
							deplacement.add(new Position(y,x+2));
						}
					} catch (PositionOutOfBoardException e)
					{
					}
				}
				try
				{
					if (plateau.getPieceAtPosition(new Position(y,x+1)).getType() == Type.NONE && 
							!(plateau.emulateDeplacement(this, new Position(y,x+1)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
					{
						deplacement.add(new Position(y,x+1));
					}
				} catch (PositionOutOfBoardException e)
				{
				}
			}
			else if(couleur==Color.WHITE)
			{
				System.out.println(10);
				if (x == 6)
				{
					try
					{
						if (plateau.getPieceAtPosition(new Position(y,x-2)).getType() == Type.NONE && 
							!(plateau.emulateDeplacement(this, new Position(y,x-2)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
						{
							deplacement.add(new Position(y,x-2));
						}
					} catch (PositionOutOfBoardException e)
					{
					}
				}
				try
				{
					if (plateau.getPieceAtPosition(new Position(y,x-1)).getType() == Type.NONE && 
							!(plateau.emulateDeplacement(this, new Position(y,x-1)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
					{
						deplacement.add(new Position(y,x-1));
					}
				} catch (PositionOutOfBoardException e)
				{
				}
			}
		}
		else{
			if (couleur==Color.BLACK)
			{
				
				if (x == 1)
				{
					try
					{
						if (plateau.getPieceAtPosition(new Position(y,x+2)).getType() == Type.NONE)
						{
							deplacement.add(new Position(y,x+2));
						}
					} catch (PositionOutOfBoardException e)
					{
					}
				}
				try
				{
					if (plateau.getPieceAtPosition(new Position(y,x+1)).getType() == Type.NONE)
					{
						deplacement.add(new Position(y,x+1));
					}
				} catch (PositionOutOfBoardException e)
				{
				}
			}
			else if(couleur==Color.WHITE)
			{
				if (x == 6)
				{
					System.out.println(1);
					try
					{
						if (plateau.getPieceAtPosition(new Position(y,x-2)).getType() == Type.NONE)
						{
							System.out.println(2);
							deplacement.add(new Position(y, x-2));
						}
					} catch (PositionOutOfBoardException e)
					{
					}
				}
				try
				{
					if (plateau.getPieceAtPosition(new Position(y,x-1)).getType() == Type.NONE)
					{
						deplacement.add(new Position(y,x-1));
					}
				} catch (PositionOutOfBoardException e)
				{
				}
			}
		}
		return deplacement;
	}
}
