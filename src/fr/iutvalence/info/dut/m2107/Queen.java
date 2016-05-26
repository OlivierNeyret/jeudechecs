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
	public Queen(PieceColor couleur)
	{
		super(couleur, PieceType.QUEEN);
	}

	public ArrayList<Position> deplacement(Board plateau, boolean check) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		int x = plateau.getCoordonateOfPiece(this).getOrdonate();
		int y = plateau.getCoordonateOfPiece(this).getAbscissa();
		PieceColor couleur=this.getColor();
		
		boolean diagA=true;
		boolean diagB=true;
		boolean diagC=true;
		boolean diagD=true;
		boolean rowA=true;
		boolean rowB=true;
		boolean colA=true;
		boolean colB=true;
		
		if (check){
			for (int i=1;i<=7;i++)
			{
				try
				{
					if (plateau.getPieceAtPosition(new Position(x+i,y)).getColor()!=couleur && colA && 
						!(plateau.emulateDeplacement(this, new Position(x+i,y)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
					{
						deplacement.add(new Position(x+i,y));
						if (plateau.getPieceAtPosition(new Position(x+i,y)).getType() != PieceType.NONE)
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
						if (plateau.getPieceAtPosition(new Position(x-i,y)).getType() != PieceType.NONE)
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
						if (plateau.getPieceAtPosition(new Position(x,y+i)).getType() != PieceType.NONE)
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
						if (plateau.getPieceAtPosition(new Position(x,y-i)).getType() != PieceType.NONE)
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
						if (plateau.getPieceAtPosition(new Position(x+i,y+i)).getType() != PieceType.NONE)
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
						if (plateau.getPieceAtPosition(new Position(x+i,y-i)).getType() != PieceType.NONE)
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
						if (plateau.getPieceAtPosition(new Position(x-i,y-i)).getType() != PieceType.NONE)
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
						if (plateau.getPieceAtPosition(new Position(x-i,y+i)).getType() != PieceType.NONE)
							diagD=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					diagD=false;
				}
				
			}
		}
		else{
			for (int i=1;i<=7;i++)
			{
				try
				{
					if (plateau.getPieceAtPosition(new Position(x+i,y)).getColor()!=couleur && colA)
					{
						deplacement.add(new Position(x+i,y));
						if (plateau.getPieceAtPosition(new Position(x+i,y)).getType() != PieceType.NONE)
							colA=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					colA=false;
				}
				try
				{
					if (plateau.getPieceAtPosition(new Position(x-i,y)).getColor()!=couleur && colB)
					{
						deplacement.add(new Position(x-i,y));
						if (plateau.getPieceAtPosition(new Position(x-i,y)).getType() != PieceType.NONE)
							colB=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					colB=false;
				}
				try
				{
					if (plateau.getPieceAtPosition(new Position(x,y+i)).getColor()!=couleur && rowA)
					{
						deplacement.add(new Position(x,y+i));
						if (plateau.getPieceAtPosition(new Position(x,y+i)).getType() != PieceType.NONE)
							rowA=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					rowA=false;
				}
				try
				{
					if (plateau.getPieceAtPosition(new Position(x,y-i)).getColor()!=couleur && rowB)
					{
						deplacement.add(new Position(x,y-i));
						if (plateau.getPieceAtPosition(new Position(x,y-i)).getType() != PieceType.NONE)
							rowB=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					rowB=false;
				}
				
				try
				{
					if (plateau.getPieceAtPosition(new Position(x+i,y+i)).getColor()!=couleur && diagA)
					{
						deplacement.add(new Position(x+i,y+i));
						if (plateau.getPieceAtPosition(new Position(x+i,y+i)).getType() != PieceType.NONE)
							diagA=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					diagA=false;
				}
				try
				{
					if (plateau.getPieceAtPosition(new Position(x+i,y-i)).getColor()!=couleur && diagB)
					{
						deplacement.add(new Position(x+i,y-i));
						if (plateau.getPieceAtPosition(new Position(x+i,y-i)).getType() != PieceType.NONE)
							diagB=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					diagB=false;
				}
				try
				{
					if (plateau.getPieceAtPosition(new Position(x-i,y-i)).getColor()!=couleur && diagC)
					{
						deplacement.add(new Position(x-i,y-i));
						if (plateau.getPieceAtPosition(new Position(x-i,y-i)).getType() != PieceType.NONE)
							diagC=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					diagC=false;
				}
				try
				{
					if (plateau.getPieceAtPosition(new Position(x-i,y+i)).getColor()!=couleur && diagD)
					{
						deplacement.add(new Position(x-i,y+i));
						if (plateau.getPieceAtPosition(new Position(x-i,y+i)).getType() != PieceType.NONE)
							diagD=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					diagD=false;
				}
				
			}
		}
		return deplacement;
	}
}