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
				
				//Deplacements en ligne/colonne
				try
				{
					if (colA && !(plateau.emulateMove(this, new Position(x+i,y)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
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
					if (colB && !(plateau.emulateMove(this, new Position(x-i,y)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
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
					if (rowA && !(plateau.emulateMove(this, new Position(x,y+i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
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
					if (rowB && !(plateau.emulateMove(this, new Position(x,y-i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
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
				
				//Deplacements en diagonale
				try
				{
					if (diagA && !(plateau.emulateMove(this, new Position(x+i,y+i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
					{
						if(plateau.getPieceAtPosition(new Position(x+i,y+i)).getColor()!=couleur){
							deplacement.add(new Position(x+i,y+i));
							if (plateau.getPieceAtPosition(new Position(x+i,y+i)).getType() != PieceType.NONE)
								diagA=false;
						}
						else diagA=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					diagA=false;
				}
				try
				{
					if (diagB && !(plateau.emulateMove(this, new Position(x+i,y-i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
					{
						if(plateau.getPieceAtPosition(new Position(x+i,y-i)).getColor()!=couleur){
							deplacement.add(new Position(x+i,y-i));
							if (plateau.getPieceAtPosition(new Position(x+i,y-i)).getType() != PieceType.NONE)
								diagB=false;
						}
						else diagB=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					diagB=false;
				}
				try
				{
					if (diagC && !(plateau.emulateMove(this, new Position(x-i,y-i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
					{
						if(plateau.getPieceAtPosition(new Position(x-i,y-i)).getColor()!=couleur){
							deplacement.add(new Position(x-i,y-i));
							if (plateau.getPieceAtPosition(new Position(x-i,y-i)).getType() != PieceType.NONE)
								diagC=false;
						}
						else diagC=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					diagC=false;
				}
				try
				{
					if (diagD && !(plateau.emulateMove(this, new Position(x-i,y+i)).isCheck(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
					{
						if(plateau.getPieceAtPosition(new Position(x-i,y+i)).getColor()!=couleur){
							deplacement.add(new Position(x-i,y+i));
							if (plateau.getPieceAtPosition(new Position(x-i,y+i)).getType() != PieceType.NONE)
								diagD=false;
						}
						else diagD=false;
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
				//Deplacements en ligne/colonne
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
				
				//Deplacements en diagonale
				try
				{
					if (diagA)
					{
						if(plateau.getPieceAtPosition(new Position(x+i,y+i)).getColor()!=couleur){
							deplacement.add(new Position(x+i,y+i));
							if (plateau.getPieceAtPosition(new Position(x+i,y+i)).getType() != PieceType.NONE)
								diagA=false;
						}
						else diagA=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					diagA=false;
				}
				try
				{
					if (diagB)
					{
						if(plateau.getPieceAtPosition(new Position(x+i,y-i)).getColor()!=couleur){
							deplacement.add(new Position(x+i,y-i));
							if (plateau.getPieceAtPosition(new Position(x+i,y-i)).getType() != PieceType.NONE)
								diagB=false;
						}
						else diagB=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					diagB=false;
				}
				try
				{
					if (diagC)
					{
						if(plateau.getPieceAtPosition(new Position(x-i,y-i)).getColor()!=couleur){
							deplacement.add(new Position(x-i,y-i));
							if (plateau.getPieceAtPosition(new Position(x-i,y-i)).getType() != PieceType.NONE)
								diagC=false;
						}
						else diagC=false;
					}
				} catch (PositionOutOfBoardException e)
				{
					diagC=false;
				}
				try
				{
					if (diagD)
					{
						if(plateau.getPieceAtPosition(new Position(x-i,y+i)).getColor()!=couleur){
							deplacement.add(new Position(x-i,y+i));
							if (plateau.getPieceAtPosition(new Position(x-i,y+i)).getType() != PieceType.NONE)
								diagD=false;
						}
						else diagD=false;
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