package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacement : piece pouvant se deplacer en diagonal, d'autant de cases que voulues (sauf obstacle)
 * @author lucianor
 *
 */
public class Bishop extends Piece {


	/**
	 * Cree un fou de la couleur donnee
	 * @param couleur
	 */
	public Bishop(Color couleur)
	{
		super(couleur, Type.BISHOP);
	}

	public ArrayList<Position> deplacement(Board plateau) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		boolean diagA=true;
		boolean diagB=true;
		boolean diagC=true;
		boolean diagD=true;
		
		int x = plateau.getCoordonateOfPiece(this).getOrdonate();
		int y = plateau.getCoordonateOfPiece(this).getAbscissa();
		Color couleur=this.getColor();
		
		for (int i=1;i<=7;i++)
		{
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
}