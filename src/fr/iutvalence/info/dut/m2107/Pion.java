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
		if (this.getCouleur()==Couleur.Blanc)
		{
			if (plateau.getCoordonateOfPiece(this).getAbscisse() == 6)
			{
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+2,plateau.getCoordonateOfPiece(this).getAbscisse())).recupererType() == Type.None)
				{
					deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+2,plateau.getCoordonateOfPiece(this).getAbscisse()));
				}
			}
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+1,plateau.getCoordonateOfPiece(this).getAbscisse())).recupererType() == Type.None)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+1,plateau.getCoordonateOfPiece(this).getAbscisse()));
			}
		}
		else if(this.getCouleur()==Couleur.Noir)
		{
			if (plateau.getCoordonateOfPiece(this).getAbscisse() == 1)
			{
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-2,plateau.getCoordonateOfPiece(this).getAbscisse())).recupererType() == Type.None)
				{
					deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-2,plateau.getCoordonateOfPiece(this).getAbscisse()));
				}
			}
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-1,plateau.getCoordonateOfPiece(this).getAbscisse())).recupererType() == Type.None)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-1,plateau.getCoordonateOfPiece(this).getAbscisse()));
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
