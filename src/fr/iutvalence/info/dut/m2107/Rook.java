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

	public ArrayList<Position> deplacement(Board plateau, boolean check) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		int x = plateau.getCoordonateOfPiece(this).getOrdonate();
		int y = plateau.getCoordonateOfPiece(this).getAbscissa();
		Color couleur=this.getColor();
		
		boolean rowA=true;
		boolean rowB=true;
		boolean colA=true;
		boolean colB=true;
		
		if (check) {
			for (int i=0;i<=7;i++)
			{
				try
				{
					if (plateau.getPieceAtPosition(new Position(y,x+i)).getColor()!=couleur && colA && 
							!(plateau.emulateDeplacement(this, new Position(y,x+i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
						{
							deplacement.add(new Position(y,x+i));
							if (plateau.getPieceAtPosition(new Position(y,x+i)).getType() != Type.NONE)
								colA=false;
						}
				} catch (PositionOutOfBoardException e)
				{
					colA=false;
				}
					try
					{
						if (plateau.getPieceAtPosition(new Position(y,x-i)).getColor()!=couleur && colB && 
								!(plateau.emulateDeplacement(this, new Position(y,x-i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
						{
							deplacement.add(new Position(y,x-i));
							if (plateau.getPieceAtPosition(new Position(y,x-i)).getType() != Type.NONE)
								colB=false;
						}
					} catch (PositionOutOfBoardException e)
					{
						colB=false;
					}
					try
					{
						if (plateau.getPieceAtPosition(new Position(y+i,x)).getColor()!=couleur && rowA && 
								!(plateau.emulateDeplacement(this, new Position(y+i,x)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
						{
							deplacement.add(new Position(y+i,x));
							if (plateau.getPieceAtPosition(new Position(y+i,x)).getType() != Type.NONE)
								rowA=false;
						}
					} catch (PositionOutOfBoardException e)
					{
						rowA=false;
					}
					try
					{
						if (plateau.getPieceAtPosition(new Position(y-i,x)).getColor()!=couleur && rowB && 
								!(plateau.emulateDeplacement(this, new Position(y-i,x)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
						{
							deplacement.add(new Position(y-i,x));
							if (plateau.getPieceAtPosition(new Position(y-i,x)).getType() != Type.NONE)
								rowB=false;
						}
					} catch (PositionOutOfBoardException e)
					{
						rowB=false;
					}		
				}
			}
	else{
		for (int i=0;i<=7;i++)
		{
			try
			{
				if (plateau.getPieceAtPosition(new Position(y,x+i)).getColor()!=couleur && colA)
					{
						deplacement.add(new Position(y,x+i));
						if (plateau.getPieceAtPosition(new Position(y,x+i)).getType() != Type.NONE)
							colA=false;
					}
			} catch (PositionOutOfBoardException e)
			{
				colA=false;
			}
				try
				{
					if (plateau.getPieceAtPosition(new Position(y,x-i)).getColor()!=couleur && colB)
					{
						deplacement.add(new Position(y,x-i));
						if (plateau.getPieceAtPosition(new Position(y,x-i)).getType() != Type.NONE)
							colB=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					colB=false;
				}
				try
				{
					if (plateau.getPieceAtPosition(new Position(y+i,x)).getColor()!=couleur && rowA) 
					{
						deplacement.add(new Position(y+i,x));
						if (plateau.getPieceAtPosition(new Position(y+i,x)).getType() != Type.NONE)
							rowA=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					rowA=false;
				}
				try
				{
					if (plateau.getPieceAtPosition(new Position(y-i,x)).getColor()!=couleur && rowB)
					{
						deplacement.add(new Position(y-i,x));
						if (plateau.getPieceAtPosition(new Position(y-i,x)).getType() != Type.NONE)
							rowB=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					rowB=false;
				}		
			}
		}
		return deplacement;
	}
}