package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacement : piece pouvant se deplacer en diagonal, d'autant de cases que voulues (sauf obstacle)
 * @author lucianor
 *
 */
public class Fou extends Piece {


	/**
	 * Cree un fou de la couleur donnee
	 * @param couleur
	 */
	public Fou(Couleur couleur)
	{
		super(couleur, Type.Fou);
	}

	public ArrayList<Position> deplacement(Plateau plateau) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		boolean diagA=true;
		boolean diagB=true;
		boolean diagC=true;
		boolean diagD=true;
		
		int x = plateau.getCoordonateOfPiece(this).getOrdonnee();
		int y = plateau.getCoordonateOfPiece(this).getAbscisse();
		Couleur couleur=this.getCouleur();
		
		for (int i=1;i<=7;i++)
		{
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
		// TODO - implement Fou.recupererType
		throw new UnsupportedOperationException();
	}

}