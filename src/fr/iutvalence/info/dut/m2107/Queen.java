package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacements : les quatre diagonales d autant de case que voulues, 
 * idem pour avant, arriere et lateral.
 * @author jacobjul
 */
public class Queen extends Piece {

	/**
	 * Cree une reine de la couleur donnee
	 * @param couleur
	 */
	public Queen(Color couleur)
	{
		super(couleur, Type.QUEEN);
	}

	public ArrayList<Position> deplacement(Board plateau) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		int x = plateau.getCoordonateOfPiece(this).getOrdonate();
		int y = plateau.getCoordonateOfPiece(this).getAbscissa();
		Color couleur=this.getColor();
		
		boolean diagA=true;
		boolean diagB=true;
		boolean diagC=true;
		boolean diagD=true;
		boolean rowA=true;
		boolean rowB=true;
		boolean colA=true;
		boolean colB=true;
		
		for (int i=1;i<=7;i++)
		{
			try
			{
				if (plateau.getPieceAtPosition(new Position(x+i,y)).getColor()!=couleur && colA && 
					!(plateau.emulateDeplacement(this, new Position(x+i,y)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x+i,y));
					if (plateau.getPieceAtPosition(new Position(x+i,y)).getType() != Type.NONE)
						colA=false;
				}
			} catch (PositionOutOfBoardException e)
			{
				colA=false;
			}
			try
			{
				if (plateau.getPieceAtPosition(new Position(x-i,y)).getColor()!=couleur && colB && 
						!(plateau.emulateDeplacement(this, new Position(x-i,y)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x-i,y));
					if (plateau.getPieceAtPosition(new Position(x-i,y)).getType() != Type.NONE)
						colB=false;
				}
			} catch (PositionOutOfBoardException e)
			{
				colB=false;
			}
			try
			{
				if (plateau.getPieceAtPosition(new Position(x,y+i)).getColor()!=couleur && rowA && 
						!(plateau.emulateDeplacement(this, new Position(x,y+i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x,y+i));
					if (plateau.getPieceAtPosition(new Position(x,y+i)).getType() != Type.NONE)
						rowA=false;
				}
			} catch (PositionOutOfBoardException e)
			{
				rowA=false;
			}
			try
			{
				if (plateau.getPieceAtPosition(new Position(x,y-i)).getColor()!=couleur && rowB && 
						!(plateau.emulateDeplacement(this, new Position(x,y-i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x,y-i));
					if (plateau.getPieceAtPosition(new Position(x,y-i)).getType() != Type.NONE)
						rowB=false;
				}
			} catch (PositionOutOfBoardException e)
			{
				rowB=false;
			}
			
			try
			{
				if (plateau.getPieceAtPosition(new Position(x+i,y+i)).getColor()!=couleur && diagA && 
						!(plateau.emulateDeplacement(this, new Position(x+i,y+i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x+i,y+i));
					if (plateau.getPieceAtPosition(new Position(x+i,y+i)).getType() != Type.NONE)
						diagA=false;
				}
			} catch (PositionOutOfBoardException e)
			{
				diagA=false;
			}
			try
			{
				if (plateau.getPieceAtPosition(new Position(x+i,y-i)).getColor()!=couleur && diagB && 
						!(plateau.emulateDeplacement(this, new Position(x+i,y-i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x+i,y-i));
					if (plateau.getPieceAtPosition(new Position(x+i,y-i)).getType() != Type.NONE)
						diagB=false;
				}
			} catch (PositionOutOfBoardException e)
			{
				diagB=false;
			}
			try
			{
				if (plateau.getPieceAtPosition(new Position(x-i,y-i)).getColor()!=couleur && diagC && 
						!(plateau.emulateDeplacement(this, new Position(x-i,y-i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x-i,y-i));
					if (plateau.getPieceAtPosition(new Position(x-i,y-i)).getType() != Type.NONE)
						diagC=false;
				}
			} catch (PositionOutOfBoardException e)
			{
				diagC=false;
			}
			try
			{
				if (plateau.getPieceAtPosition(new Position(x-i,y+i)).getColor()!=couleur && diagD && 
						!(plateau.emulateDeplacement(this, new Position(x-i,y+i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x-i,y+i));
					if (plateau.getPieceAtPosition(new Position(x-i,y+i)).getType() != Type.NONE)
						diagD=false;
				}
			} catch (PositionOutOfBoardException e)
			{
				diagD=false;
			}
			
		}
		return deplacement;
	}

	public Type getType() {
		// TODO - implement Reine.recupererType
		throw new UnsupportedOperationException();
	}

}