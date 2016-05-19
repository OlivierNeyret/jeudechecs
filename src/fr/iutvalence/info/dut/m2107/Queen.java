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
			if (plateau.getPieceAtPosition(new Position(x+i,y)).getColor()!=couleur && colA && 
				!(plateau.emulateDeplacement(this, new Position(x+i,y)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x+i,y));
				if (plateau.getPieceAtPosition(new Position(x+i,y)).getType() != Type.NONE)
					colA=false;
			}
			if (plateau.getPieceAtPosition(new Position(x-i,y)).getColor()!=couleur && colB && 
					!(plateau.emulateDeplacement(this, new Position(x-i,y)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x-i,y));
				if (plateau.getPieceAtPosition(new Position(x-i,y)).getType() != Type.NONE)
					colB=false;
			}
			if (plateau.getPieceAtPosition(new Position(x,y+i)).getColor()!=couleur && rowA && 
					!(plateau.emulateDeplacement(this, new Position(x,y+i)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x,y+i));
				if (plateau.getPieceAtPosition(new Position(x,y+i)).getType() != Type.NONE)
					rowA=false;
			}
			if (plateau.getPieceAtPosition(new Position(x,y-i)).getColor()!=couleur && rowB && 
					!(plateau.emulateDeplacement(this, new Position(x,y-i)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x,y-i));
				if (plateau.getPieceAtPosition(new Position(x,y-i)).getType() != Type.NONE)
					rowB=false;
			}
			
			if (plateau.getPieceAtPosition(new Position(x+i,y+i)).getColor()!=couleur && diagA && 
					!(plateau.emulateDeplacement(this, new Position(x+i,y+i)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x+i,y+i));
				if (plateau.getPieceAtPosition(new Position(x+i,y+i)).getType() != Type.NONE)
					diagA=false;
			}
			if (plateau.getPieceAtPosition(new Position(x+i,y-i)).getColor()!=couleur && diagB && 
					!(plateau.emulateDeplacement(this, new Position(x+i,y-i)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x+i,y-i));
				if (plateau.getPieceAtPosition(new Position(x+i,y-i)).getType() != Type.NONE)
					diagB=false;
			}
			if (plateau.getPieceAtPosition(new Position(x-i,y-i)).getColor()!=couleur && diagC && 
					!(plateau.emulateDeplacement(this, new Position(x-i,y-i)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x-i,y-i));
				if (plateau.getPieceAtPosition(new Position(x-i,y-i)).getType() != Type.NONE)
					diagC=false;
			}
			if (plateau.getPieceAtPosition(new Position(x-i,y+i)).getColor()!=couleur && diagD && 
					!(plateau.emulateDeplacement(this, new Position(x-i,y+i)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x-i,y+i));
				if (plateau.getPieceAtPosition(new Position(x-i,y+i)).getType() != Type.NONE)
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