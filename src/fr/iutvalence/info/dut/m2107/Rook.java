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
	public Rook(PieceColor couleur)
	{
		super(couleur, PieceType.ROOK);
	}

	public ArrayList<Position> deplacement(Board plateau, boolean check) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		int x = plateau.getCoordonateOfPiece(this).getOrdonate();
		int y = plateau.getCoordonateOfPiece(this).getAbscissa();
		PieceColor couleur=this.getColor();
		
		boolean rowA=true;
		boolean rowB=true;
		boolean colA=true;
		boolean colB=true;
		
		if (check) {
			for (int i=1;i<=7;i++)
			{
				try
				{
					if (colA && !(plateau.emulateDeplacement(this, new Position(x+i,y)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
					{
						if(plateau.getPieceAtPosition(new Position(x+i,y)).getColor()!=couleur){
								deplacement.add(new Position(x+i,y));
							if (plateau.getPieceAtPosition(new Position(x+i,y)).getType() != PieceType.NONE)
								colA=false;
						}
						else colA=false;
					}
							
				} catch (PositionOutOfBoardException e)
				{
					colA=false;
				}
				try
				{
					if (colB && !(plateau.emulateDeplacement(this, new Position(x-i,y)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
					{
						if (plateau.getPieceAtPosition(new Position(x-i,y)).getColor()!=couleur){
							deplacement.add(new Position(x-i,y));
							if (plateau.getPieceAtPosition(new Position(x-i,y)).getType() != PieceType.NONE)
								colB=false;
						}
						else colB=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					colB=false;
				}
				try
				{
					if (rowA && !(plateau.emulateDeplacement(this, new Position(x,y+i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
					{
						if(plateau.getPieceAtPosition(new Position(x,y+i)).getColor()!=couleur){
							deplacement.add(new Position(x,y+i));
							if (plateau.getPieceAtPosition(new Position(x,y+i)).getType() != PieceType.NONE)
								rowA=false;
						}
						else rowA=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					rowA=false;
				}
				try
				{
					if (rowB && !(plateau.emulateDeplacement(this, new Position(x,y-i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
					{
						if (plateau.getPieceAtPosition(new Position(x,y-i)).getColor()!=couleur){
							deplacement.add(new Position(x,y-i));
							if (plateau.getPieceAtPosition(new Position(x,y-i)).getType() != PieceType.NONE)
								rowB=false;
						}
						else rowB=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					rowB=false;
				}		
			}
		}
	else{
		for (int i=1;i<=7;i++)
		{
			try
			{
				if (colA)
				{
					if(plateau.getPieceAtPosition(new Position(x+i,y)).getColor()!=couleur){
							deplacement.add(new Position(x+i,y));
							
							if (plateau.getPieceAtPosition(new Position(x+i,y)).getType() != PieceType.NONE)
								colA=false;
						}
					else colA=false;
					}
				
			} catch (PositionOutOfBoardException e)
			{
				colA=false;
			}
				try
				{
					if (colB)
					{
						if (plateau.getPieceAtPosition(new Position(x-i,y)).getColor()!=couleur){
							deplacement.add(new Position(x-i,y));
							if (plateau.getPieceAtPosition(new Position(x-i,y)).getType() != PieceType.NONE)
								colB=false;
						}
						else colB=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					colB=false;
				}
				try
				{
					if (rowA) 
					{
						if(plateau.getPieceAtPosition(new Position(x,y+i)).getColor()!=couleur){
							deplacement.add(new Position(x,y+i));
							if (plateau.getPieceAtPosition(new Position(x,y+i)).getType() != PieceType.NONE)
								rowA=false;
						}
						else rowA=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					rowA=false;
				}
				try
				{
					if (rowB)
					{
						if (plateau.getPieceAtPosition(new Position(x,y-i)).getColor()!=couleur){
							deplacement.add(new Position(x,y-i));
							if (plateau.getPieceAtPosition(new Position(x,y-i)).getType() != PieceType.NONE)
								rowB=false;
						}
						else rowB=false;
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