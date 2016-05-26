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
	public Pawn(PieceColor couleur, PieceType type)
	{
		super(couleur, type);
	}
	
	public ArrayList<Position> deplacement(Board board, boolean check) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		int y = board.getCoordonateOfPiece(this).getOrdonate();
		int x = board.getCoordonateOfPiece(this).getAbscissa();
		PieceColor couleur=this.getColor();
		
		
		if (check)
		{
			if (couleur==PieceColor.BLACK)
			{
				try
				{
					if (board.getPieceAtPosition(new Position(y-1,x+1)).getColor()==PieceColor.WHITE){
						deplacement.add(new Position(y+1,x+1));
					}
					if (board.getPieceAtPosition(new Position(y-1,x-1)).getColor()!=PieceColor.WHITE){
						deplacement.add(new Position(y+1,x-1));
					}
				} catch (PositionOutOfBoardException e1)
				{
				}
				if (x == 1)
				{
					try
					{
						if (board.getPieceAtPosition(new Position(y,x+2)).getType() == PieceType.NONE && 
							!(board.emulateDeplacement(this, new Position(y,x+2)).isCheck(board.getCoordonateOfPiece(board.getKing(couleur)), couleur)))
						{
							deplacement.add(new Position(y,x+2));
						}
					} catch (PositionOutOfBoardException e)
					{
					}
				}
				try
				{
					if (board.getPieceAtPosition(new Position(y,x+1)).getType() == PieceType.NONE && 
							!(board.emulateDeplacement(this, new Position(y,x+1)).isCheck(board.getCoordonateOfPiece(board.getKing(couleur)), couleur)))
					{
						deplacement.add(new Position(y,x+1));
					}
				} catch (PositionOutOfBoardException e)
				{
				}
			}
			else if(couleur==PieceColor.WHITE)
			{
				try
				{
					if (board.getPieceAtPosition(new Position(y+1,x-1)).getColor()==PieceColor.BLACK){
						deplacement.add(new Position(y-1,x-1));
					}
					if (board.getPieceAtPosition(new Position(y+1,x+1)).getColor()==PieceColor.BLACK){
						deplacement.add(new Position(y-1,x+1));
					}
				} catch (PositionOutOfBoardException e1)
				{
				}
				if (x == 6)
				{
					try
					{
						if (board.getPieceAtPosition(new Position(y,x-2)).getType() == PieceType.NONE && 
							!(board.emulateDeplacement(this, new Position(y,x-2)).isCheck(board.getCoordonateOfPiece(board.getKing(couleur)), couleur)))
						{
							deplacement.add(new Position(y,x-2));
						}
					} catch (PositionOutOfBoardException e)
					{
					}
				}
				try
				{
					if (board.getPieceAtPosition(new Position(y,x-1)).getType() == PieceType.NONE && 
							!(board.emulateDeplacement(this, new Position(y,x-1)).isCheck(board.getCoordonateOfPiece(board.getKing(couleur)), couleur)))
					{
						deplacement.add(new Position(y,x-1));
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
					if (board.getPieceAtPosition(new Position(y+1,x+1)).getColor()!=PieceColor.BLACK){
						deplacement.add(new Position(y+1,x+1));
					}
					if (board.getPieceAtPosition(new Position(y+1,x-1)).getColor()!=PieceColor.BLACK){
						deplacement.add(new Position(y+1,x-1));
					}
				} catch (PositionOutOfBoardException e1)
				{
				}
				
				if (x == 1)
				{
					try
					{
						if (board.getPieceAtPosition(new Position(y,x+2)).getType() == PieceType.NONE)
						{
							deplacement.add(new Position(y,x+2));
						}
					} catch (PositionOutOfBoardException e)
					{
					}
				}
				try
				{
					if (board.getPieceAtPosition(new Position(y,x+1)).getType() == PieceType.NONE)
					{
						deplacement.add(new Position(y,x+1));
					}
				} catch (PositionOutOfBoardException e)
				{
				}
			}
			else if(couleur==PieceColor.WHITE)
			{
				try
				{
					if (board.getPieceAtPosition(new Position(y+1,x-1)).getColor()==PieceColor.BLACK){
						deplacement.add(new Position(y-1,x-1));
					}
					if (board.getPieceAtPosition(new Position(y+1,x+1)).getColor()==PieceColor.BLACK){
						deplacement.add(new Position(y-1,x+1));
					}
				} catch (PositionOutOfBoardException e1)
				{
				}
				if (x == 6)
				{
					System.out.println(1);
					try
					{
						if (board.getPieceAtPosition(new Position(y,x-2)).getType() == PieceType.NONE)
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
					if (board.getPieceAtPosition(new Position(y,x-1)).getType() == PieceType.NONE)
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
