package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacement: se deplace en ligne droite d'autant de cases que voulues (sauf obstacle)
 * @author lucianor
 *
 */
public class Rook extends Piece {

	/**
	 * Cree une tour de la couleur donnee
	 * @param couleur
	 */
	public Rook(Color couleur)
	{
		super(couleur, Type.ROOK);
	}

	public ArrayList<Position> deplacement(Board plateau) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		int x = plateau.getCoordonateOfPiece(this).getOrdonate();
		int y = plateau.getCoordonateOfPiece(this).getAbscissa();
		Color couleur=this.getColor();
		
		boolean rowA=true;
		boolean rowB=true;
		boolean colA=true;
		boolean colB=true;
		
		for (int i=0;i<=7;i++)
		{
			try
			{
				if (plateau.getPieceAtPosition(new Position(x+i,y)).getColor()!=couleur && colA && 
						!(plateau.emulateDeplacement(this, new Position(x+i,y)).isCHeck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
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
							!(plateau.emulateDeplacement(this, new Position(x-i,y)).isCHeck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
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
							!(plateau.emulateDeplacement(this, new Position(x,y+i)).isCHeck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
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
							!(plateau.emulateDeplacement(this, new Position(x,y-i)).isCHeck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
					{
						deplacement.add(new Position(x,y-i));
						if (plateau.getPieceAtPosition(new Position(x,y-i)).getType() != Type.NONE)
							rowB=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					rowB=false;
				}		
		}
		return deplacement;
	}

	public Type getType() {
		// TODO - implement Tour.recupererType
		throw new UnsupportedOperationException();
	}

}