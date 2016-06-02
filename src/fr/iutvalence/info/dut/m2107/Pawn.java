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
	 */
	public Pawn(PieceColor couleur)
	{
		super(couleur, PieceType.PAWN);
	}
	
	public ArrayList<Position> deplacement(Board board, boolean check) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		int x = board.getCoordonateOfPiece(this).getOrdonate();
		int y = board.getCoordonateOfPiece(this).getAbscissa();
		PieceColor couleur=this.getColor();
		
		
		if (check)
		{
			if (couleur==PieceColor.BLACK)
			{
				try
				{
					if (board.getPieceAtPosition(new Position(x+1,y+1)).getColor()==PieceColor.WHITE){
						deplacement.add(new Position(x+1,y+1));
					}
					if (board.getPieceAtPosition(new Position(x-1,y+1)).getColor()==PieceColor.WHITE){
						deplacement.add(new Position(x-1,y+1));
					}
				} catch (PositionOutOfBoardException e1)
				{
				}
				
				try
				{
					if (board.getPieceAtPosition(new Position(x,y+1)).getType() == PieceType.NONE && 
							!(board.emulateMove(this, new Position(x,y+1)).isCheck(board.getCoordonateOfPiece(board.getKing(couleur)), couleur)))
					{
						deplacement.add(new Position(x,y+1));
						if (y == 1)
						{
							if (board.getPieceAtPosition(new Position(x,y+2)).getType() == PieceType.NONE && 
								!(board.emulateMove(this, new Position(x,y+2)).isCheck(board.getCoordonateOfPiece(board.getKing(couleur)), couleur)))
							{
								deplacement.add(new Position(x,y+2));
							}
						}
					}
				} catch (PositionOutOfBoardException e)
				{
				}
			}
			else if(couleur==PieceColor.WHITE)
			{
				try
				{
					if (board.getPieceAtPosition(new Position(x+1,y-1)).getColor()==PieceColor.BLACK){
						deplacement.add(new Position(x+1,y-1));
					}
					if (board.getPieceAtPosition(new Position(x-1,y-1)).getColor()==PieceColor.BLACK){
						deplacement.add(new Position(x-1,y-1));
					}
				} catch (PositionOutOfBoardException e1)
				{
				}
				
				try
				{
					if (board.getPieceAtPosition(new Position(x,y-1)).getType() == PieceType.NONE && 
							!(board.emulateMove(this, new Position(x,y-1)).isCheck(board.getCoordonateOfPiece(board.getKing(couleur)), couleur)))
					{
						deplacement.add(new Position(x,y-1));
						if (y == 6)
						{
							if (board.getPieceAtPosition(new Position(x,y-2)).getType() == PieceType.NONE && 
								!(board.emulateMove(this, new Position(x,y-2)).isCheck(board.getCoordonateOfPiece(board.getKing(couleur)), couleur)))
							{
								deplacement.add(new Position(x,y-2));
							}
						}
					}
				} catch (PositionOutOfBoardException e)
				{
				}
			}
		}
		else{
			if (couleur==PieceColor.BLACK)
			{
				try
				{
					if (board.getPieceAtPosition(new Position(x-1,y+1)).getColor()==PieceColor.WHITE){
						deplacement.add(new Position(x-1,y+1));
					}
					if (board.getPieceAtPosition(new Position(x-1,y-1)).getColor()==PieceColor.WHITE){
						deplacement.add(new Position(x-1,y-1));
					}
				} catch (PositionOutOfBoardException e1)
				{
				}
				
				
				try
				{
					if (board.getPieceAtPosition(new Position(x,y+1)).getType() == PieceType.NONE)
					{
						deplacement.add(new Position(x,y+1));
						if (y == 1)
						{
							if (board.getPieceAtPosition(new Position(x,y+2)).getType() == PieceType.NONE)
							{
								deplacement.add(new Position(x,y+2));
							}
						}
					}
				} catch (PositionOutOfBoardException e)
				{
				}
			}
			else if(couleur==PieceColor.WHITE)
			{
				try
				{
					if (board.getPieceAtPosition(new Position(x+1,y-1)).getColor()==PieceColor.BLACK){
						deplacement.add(new Position(x+1,y-1));
					}
					if (board.getPieceAtPosition(new Position(x-1,y-1)).getColor()==PieceColor.BLACK){
						deplacement.add(new Position(x-1,y-1));
					}
				} catch (PositionOutOfBoardException e1)
				{
				}
				
				try
				{
					if (board.getPieceAtPosition(new Position(x,y-1)).getType() == PieceType.NONE)
					{
						deplacement.add(new Position(x,y-1));
						if (y == 6)
						{
							if (board.getPieceAtPosition(new Position(x,y-2)).getType() == PieceType.NONE)
							{
								deplacement.add(new Position(x, y-2));
							}
						}
					}
				} catch (PositionOutOfBoardException e)
				{
				}
			}
		}
		return deplacement;
	}
}
