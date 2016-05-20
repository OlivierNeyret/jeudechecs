  package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacement: se deplace en L, de deux cases en ligne droite puis de une sur le cote
 * @author lucianor
 *
 */
public class Knight extends Piece
{

	/**
	 * Cree un cavalier de la couleur donnee
	 * @param couleur
	 */
	public Knight(Color couleur)
	{
		super(couleur,Type.KNIGHT);
	}

	public ArrayList<Position> deplacement(Board plateau, boolean check)
	{
		ArrayList<Position> deplacement = new ArrayList<Position>();
		int j=2;
		int x = plateau.getCoordonateOfPiece(this).getOrdonate();
		int y = plateau.getCoordonateOfPiece(this).getAbscissa();
		Color couleur=this.getColor();
		for (int i=1;i<=2;i++)
		{
			try
			{
				if (plateau.getPieceAtPosition(new Position(x+i,y+j)).getColor()!=couleur && 
					!(plateau.emulateDeplacement(this, new Position(x+i,y+j)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{	
					deplacement.add(new Position(x+i,y+j));
				}
			} catch (PositionOutOfBoardException e)
			{
			}
			try
			{
				if (plateau.getPieceAtPosition(new Position(x-j,y+i)).getColor()!=couleur &&
					!(plateau.emulateDeplacement(this, new Position(x-j,y+i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x-j,y+i));
					
				}
			} catch (PositionOutOfBoardException e)
			{
			}
			try
			{
				if (plateau.getPieceAtPosition(new Position(x-i,y-j)).getColor()!=couleur &&
					!(plateau.emulateDeplacement(this, new Position(x-i,y-j)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x-i,y-j));
					
				}
			} catch (PositionOutOfBoardException e)
			{
			}
			try
			{
				if (plateau.getPieceAtPosition(new Position(x+j,y-i)).getColor()!=couleur &&
					!(plateau.emulateDeplacement(this, new Position(x+j,y-i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x+j,y-i));
					
				}
			} catch (PositionOutOfBoardException e)
			{
			}
			j=j-1;
		}
		return deplacement;
	}
}