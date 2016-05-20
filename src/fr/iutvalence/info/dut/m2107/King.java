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
	public King(Color color)
	{
		super(color, Type.KING);
	}

	
	public ArrayList<Position> deplacement(Board board,boolean check) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		if (!check) {
			try
			{
				if (board.getPieceAtPosition(new Position(board.getCoordonateOfPiece(this).getOrdonate()+1,board.getCoordonateOfPiece(this).getAbscissa()+1)).getColor()!=this.getColor())					
					deplacement.add(new Position(board.getCoordonateOfPiece(this).getOrdonate()+1,board.getCoordonateOfPiece(this).getAbscissa()+1));
			} catch (PositionOutOfBoardException e)
			{
			}
			try
			{
				if (board.getPieceAtPosition(new Position(board.getCoordonateOfPiece(this).getOrdonate()+1,board.getCoordonateOfPiece(this).getAbscissa()-1)).getColor()!=this.getColor())
					deplacement.add(new Position(board.getCoordonateOfPiece(this).getOrdonate()+1,board.getCoordonateOfPiece(this).getAbscissa()-1));
			} catch (PositionOutOfBoardException e)
			{	
			}
			try
			{
				if (board.getPieceAtPosition(new Position(board.getCoordonateOfPiece(this).getOrdonate()-1,board.getCoordonateOfPiece(this).getAbscissa()+1)).getColor()!=this.getColor())
					deplacement.add(new Position(board.getCoordonateOfPiece(this).getOrdonate()-1,board.getCoordonateOfPiece(this).getAbscissa()+1));
			} catch (PositionOutOfBoardException e)
			{
			}
			try
			{
				if (board.getPieceAtPosition(new Position(board.getCoordonateOfPiece(this).getOrdonate()-1,board.getCoordonateOfPiece(this).getAbscissa()-1)).getColor()!=this.getColor())
					deplacement.add(new Position(board.getCoordonateOfPiece(this).getOrdonate()-1,board.getCoordonateOfPiece(this).getAbscissa()-1));
			} catch (PositionOutOfBoardException e)
			{
			}
			
			int j=1;
			for (int i =0;i<=1;i++)
			{
				try
				{
					if (board.getPieceAtPosition(new Position(board.getCoordonateOfPiece(this).getOrdonate()+i,board.getCoordonateOfPiece(this).getAbscissa()+j)).getColor()!=this.getColor())
						deplacement.add(new Position(board.getCoordonateOfPiece(this).getOrdonate()+i,board.getCoordonateOfPiece(this).getAbscissa()+j));
				} catch (PositionOutOfBoardException e)
				{
				}
				try
				{
					if (board.getPieceAtPosition(new Position(board.getCoordonateOfPiece(this).getOrdonate()-i,board.getCoordonateOfPiece(this).getAbscissa()-j)).getColor()!=this.getColor())
						deplacement.add(new Position(board.getCoordonateOfPiece(this).getOrdonate()-i,board.getCoordonateOfPiece(this).getAbscissa()-j));
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
				if (board.getPieceAtPosition(new Position(board.getCoordonateOfPiece(this).getOrdonate()+1,board.getCoordonateOfPiece(this).getAbscissa()+1)).getColor()!=this.getColor() && 
					board.isCheck(new Position(board.getCoordonateOfPiece(this).getOrdonate()+1,board.getCoordonateOfPiece(this).getAbscissa()+1),this.getColor()))
					deplacement.add(new Position(board.getCoordonateOfPiece(this).getOrdonate()+1,board.getCoordonateOfPiece(this).getAbscissa()+1));
			} catch (PositionOutOfBoardException e)
			{
			}
			try
			{
				if (board.getPieceAtPosition(new Position(board.getCoordonateOfPiece(this).getOrdonate()+1,board.getCoordonateOfPiece(this).getAbscissa()-1)).getColor()!=this.getColor() && 
					board.isCheck(new Position(board.getCoordonateOfPiece(this).getOrdonate()+1,board.getCoordonateOfPiece(this).getAbscissa()-1),this.getColor()))
					deplacement.add(new Position(board.getCoordonateOfPiece(this).getOrdonate()+1,board.getCoordonateOfPiece(this).getAbscissa()-1));
			} catch (PositionOutOfBoardException e)
			{	
			}
			try
			{
				if (board.getPieceAtPosition(new Position(board.getCoordonateOfPiece(this).getOrdonate()-1,board.getCoordonateOfPiece(this).getAbscissa()+1)).getColor()!=this.getColor() && 
					board.isCheck(new Position(board.getCoordonateOfPiece(this).getOrdonate()-1,board.getCoordonateOfPiece(this).getAbscissa()+1),this.getColor()))
					deplacement.add(new Position(board.getCoordonateOfPiece(this).getOrdonate()-1,board.getCoordonateOfPiece(this).getAbscissa()+1));
			} catch (PositionOutOfBoardException e)
			{
			}
			try
			{
				if (board.getPieceAtPosition(new Position(board.getCoordonateOfPiece(this).getOrdonate()-1,board.getCoordonateOfPiece(this).getAbscissa()-1)).getColor()!=this.getColor() && 
					board.isCheck(new Position(board.getCoordonateOfPiece(this).getOrdonate()-1,board.getCoordonateOfPiece(this).getAbscissa()-1),this.getColor()))
					deplacement.add(new Position(board.getCoordonateOfPiece(this).getOrdonate()-1,board.getCoordonateOfPiece(this).getAbscissa()-1));
			} catch (PositionOutOfBoardException e)
			{
			}
			
			int j=1;
			for (int i =0;i<=1;i++)
			{
				try
				{
					if (board.getPieceAtPosition(new Position(board.getCoordonateOfPiece(this).getOrdonate()+i,board.getCoordonateOfPiece(this).getAbscissa()+j)).getColor()!=this.getColor() && 
						board.isCheck(new Position(board.getCoordonateOfPiece(this).getOrdonate()+i,board.getCoordonateOfPiece(this).getAbscissa()+j),this.getColor()))
						deplacement.add(new Position(board.getCoordonateOfPiece(this).getOrdonate()+i,board.getCoordonateOfPiece(this).getAbscissa()+j));
				} catch (PositionOutOfBoardException e)
				{
				}
				try
				{
					if (board.getPieceAtPosition(new Position(board.getCoordonateOfPiece(this).getOrdonate()-i,board.getCoordonateOfPiece(this).getAbscissa()-j)).getColor()!=this.getColor() && 
						board.isCheck(new Position(board.getCoordonateOfPiece(this).getOrdonate()+i,board.getCoordonateOfPiece(this).getAbscissa()+j),this.getColor()))
						deplacement.add(new Position(board.getCoordonateOfPiece(this).getOrdonate()-i,board.getCoordonateOfPiece(this).getAbscissa()-j));
				} catch (PositionOutOfBoardException e)
				{
				}
				j=j-1;
			}
		}
		return deplacement;
	}
}