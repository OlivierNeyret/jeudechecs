package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacements: 	1 case toute direction 
 * 					si echec le roi doit etre protege
 * 					si plus de roi partie fini
 * 					si pat egalite
 * @author pasquiop
 *
 */
public class King extends Piece {

	/**
	 * Cree un roi de la couleur donnee
	 * @param color
	 */
	public King(PieceColor color)
	{
		super(color, PieceType.KING);
	}

	
	public ArrayList<Position> deplacement(Board board,boolean check) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		int x = board.getCoordonateOfPiece(this).getOrdonate();
		int y = board.getCoordonateOfPiece(this).getAbscissa();
		PieceColor color=this.getColor();
		
		if (!check) {
			try
			{
				if (board.getPieceAtPosition(new Position(x+1,y+1)).getColor()!=color)					
					deplacement.add(new Position(x+1,y+1));
			} catch (PositionOutOfBoardException e)
			{
			}
			try
			{
				if (board.getPieceAtPosition(new Position(x+1,y-1)).getColor()!=color)
					deplacement.add(new Position(x+1,y-1));
			} catch (PositionOutOfBoardException e)
			{	
			}
			try
			{
				if (board.getPieceAtPosition(new Position(x-1,y+1)).getColor()!=color)
					deplacement.add(new Position(x-1,y+1));
			} catch (PositionOutOfBoardException e)
			{
			}
			try
			{
				if (board.getPieceAtPosition(new Position(x-1,y-1)).getColor()!=color)
					deplacement.add(new Position(x-1,y-1));
			} catch (PositionOutOfBoardException e)
			{
			}
			
			int j=1;
			for (int i =0;i<=1;i++)
			{
				try
				{
					if (board.getPieceAtPosition(new Position(x+i,y+j)).getColor()!=color)
						deplacement.add(new Position(x+i,y+j));
				} catch (PositionOutOfBoardException e)
				{
				}
				try
				{
					if (board.getPieceAtPosition(new Position(x-i,y-j)).getColor()!=color)
						deplacement.add(new Position(x-i,y-j));
				} catch (PositionOutOfBoardException e)
				{
				}
				j=j-1;
			}
		}
		else
			{
			try
			{
				if (board.getPieceAtPosition(new Position(x+1,y+1)).getColor()!=color && 
					!(board.isCheck(new Position(x+1,y+1),color)))
					deplacement.add(new Position(x+1,y+1));
			} catch (PositionOutOfBoardException e)
			{
			}
			try
			{
				if (board.getPieceAtPosition(new Position(x+1,y-1)).getColor()!=color && 
					!(board.isCheck(new Position(x+1,y-1),color)))
					deplacement.add(new Position(x+1,y-1));
			} catch (PositionOutOfBoardException e)
			{	
			}
			try
			{
				if (board.getPieceAtPosition(new Position(x-1,y+1)).getColor()!=color && 
					!(board.isCheck(new Position(x-1,y+1),color)))
					deplacement.add(new Position(x-1,y+1));
			} catch (PositionOutOfBoardException e)
			{
			}
			try
			{
				if (board.getPieceAtPosition(new Position(x-1,y-1)).getColor()!=color && 
					!(board.isCheck(new Position(x-1,y-1),color)))
					deplacement.add(new Position(x-1,y-1));
			} catch (PositionOutOfBoardException e)
			{
			}
			
			int j=1;
			for (int i =0;i<=1;i++)
			{
				try
				{
					if (board.getPieceAtPosition(new Position(x+i,y+j)).getColor()!=color && 
						!(board.isCheck(new Position(x+i,y+j),color)))
						deplacement.add(new Position(x+i,y+j));
				} catch (PositionOutOfBoardException e)
				{
				}
				try
				{
					if (board.getPieceAtPosition(new Position(x-i,y-j)).getColor()!=color && 
						!(board.isCheck(new Position(x+i,y+j),color)))
						deplacement.add(new Position(x-i,y-j));
				} catch (PositionOutOfBoardException e)
				{
				}
				j=j-1;
			}
		}
		return deplacement;
	}
}