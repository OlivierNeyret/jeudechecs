package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacements : les quatre diagonales d autant de case que voulues, 
 * idem pour avant, arriere et lateral.
 * @author jacobjul
 */
public class Reine extends Piece {

	/**
	 * Cree une reine de la couleur donnee
	 * @param couleur
	 */
	public Reine(Couleur couleur)
	{
		super(couleur, Type.Reine);
	}

	public ArrayList<Position> deplacement(Plateau plateau) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		int x = plateau.getCoordonateOfPiece(this).getOrdonnee();
		int y = plateau.getCoordonateOfPiece(this).getAbscisse();
		Couleur couleur=this.getCouleur();
		
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
			if (plateau.getPieceAtPosition(new Position(x+i,y)).getCouleur()!=couleur && colA && 
				!(plateau.emulateDeplacement(this, new Position(x+i,y)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x+i,y));
				if (plateau.getPieceAtPosition(new Position(x+i,y)).recupererType() != Type.None)
					colA=false;
			}
			if (plateau.getPieceAtPosition(new Position(x-i,y)).getCouleur()!=couleur && colB && 
					!(plateau.emulateDeplacement(this, new Position(x-i,y)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x-i,y));
				if (plateau.getPieceAtPosition(new Position(x-i,y)).recupererType() != Type.None)
					colB=false;
			}
			if (plateau.getPieceAtPosition(new Position(x,y+i)).getCouleur()!=couleur && rowA && 
					!(plateau.emulateDeplacement(this, new Position(x,y+i)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x,y+i));
				if (plateau.getPieceAtPosition(new Position(x,y+i)).recupererType() != Type.None)
					rowA=false;
			}
			if (plateau.getPieceAtPosition(new Position(x,y-i)).getCouleur()!=couleur && rowB && 
					!(plateau.emulateDeplacement(this, new Position(x,y-i)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x,y-i));
				if (plateau.getPieceAtPosition(new Position(x,y-i)).recupererType() != Type.None)
					rowB=false;
			}
			
			if (plateau.getPieceAtPosition(new Position(x+i,y+i)).getCouleur()!=couleur && diagA && 
					!(plateau.emulateDeplacement(this, new Position(x+i,y+i)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x+i,y+i));
				if (plateau.getPieceAtPosition(new Position(x+i,y+i)).recupererType() != Type.None)
					diagA=false;
			}
			if (plateau.getPieceAtPosition(new Position(x+i,y-i)).getCouleur()!=couleur && diagB && 
					!(plateau.emulateDeplacement(this, new Position(x+i,y-i)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x+i,y-i));
				if (plateau.getPieceAtPosition(new Position(x+i,y-i)).recupererType() != Type.None)
					diagB=false;
			}
			if (plateau.getPieceAtPosition(new Position(x-i,y-i)).getCouleur()!=couleur && diagC && 
					!(plateau.emulateDeplacement(this, new Position(x-i,y-i)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x-i,y-i));
				if (plateau.getPieceAtPosition(new Position(x-i,y-i)).recupererType() != Type.None)
					diagC=false;
			}
			if (plateau.getPieceAtPosition(new Position(x-i,y+i)).getCouleur()!=couleur && diagD && 
					!(plateau.emulateDeplacement(this, new Position(x-i,y+i)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x-i,y+i));
				if (plateau.getPieceAtPosition(new Position(x-i,y+i)).recupererType() != Type.None)
					diagD=false;
			}
			
		}
		return deplacement;
	}

	public Type recupererType() {
		// TODO - implement Reine.recupererType
		throw new UnsupportedOperationException();
	}

}