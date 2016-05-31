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
	public Bishop(PieceColor couleur)
	{
		super(couleur, PieceType.BISHOP);
	}

	public ArrayList<Position> deplacement(Board plateau, boolean check) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		boolean diagA=true;
		boolean diagB=true;
		boolean diagC=true;
		boolean diagD=true;
		
		int x = plateau.getCoordonateOfPiece(this).getOrdonate();
		int y = plateau.getCoordonateOfPiece(this).getAbscissa();
		PieceColor couleur=this.getColor();
		
		if (check){
			for (int i=1;i<=7;i++)
			{
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