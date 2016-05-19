package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacements: 	2 cases avant si non deplace
 * 					sinon 1 case avant et prend en 1 case diagonale avant
 * @author pasquiop
 *
 */
public class Pion extends Piece {

	/**
	 * Cree un pion de la couleur donnee
	 * @param couleur
	 * @param type type du pion
	 */
	public Pion(Couleur couleur, Type type)
	{
		super(couleur, type);
	}
	
	public ArrayList<Position> deplacement(Plateau plateau) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		int x = plateau.getCoordonateOfPiece(this).getOrdonnee();
		int y = plateau.getCoordonateOfPiece(this).getAbscisse();
		Couleur couleur=this.getCouleur();
		
		if (couleur==Couleur.Blanc)
		{
			if (y == 6)
			{
				if (plateau.getPieceAtPosition(new Position(x+2,y)).recupererType() == Type.None && 
					!(plateau.emulateDeplacement(this, new Position(x+2,y)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x+2,y));
				}
			}
			if (plateau.getPieceAtPosition(new Position(x+1,y)).recupererType() == Type.None && 
					!(plateau.emulateDeplacement(this, new Position(x+1,y)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x+1,y));
			}
		}
		else if(couleur==Couleur.Noir)
		{
			if (y == 1)
			{
				if (plateau.getPieceAtPosition(new Position(x-2,y)).recupererType() == Type.None && 
					!(plateau.emulateDeplacement(this, new Position(x-2,y)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
				{
					deplacement.add(new Position(x-2,y));
				}
			}
			if (plateau.getPieceAtPosition(new Position(x-1,y)).recupererType() == Type.None && 
					!(plateau.emulateDeplacement(this, new Position(x-1,y)).estEnEchec(plateau.getCoordonateOfPiece(plateau.getKing(couleur)), couleur)))
			{
				deplacement.add(new Position(x-1,y));
			}
		}
		else return null;
		return deplacement;
	}

	public Type recupererType() {
		// TODO - implement Pion.recupererType
		throw new UnsupportedOperationException();
	}

}
