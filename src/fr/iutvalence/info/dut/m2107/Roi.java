package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacements: 	1 case toute direction 
 * 					si echec le roi doit etre protege
 * 					si plus de roi partie fini
 * 					si pat egalite
 * @author pasquiop
 *
 */
public class Roi extends Piece {

	/**
	 * Cree un roi de la couleur donnee
	 * @param couleur
	 */
	public Roi(Couleur couleur)
	{
		super(couleur, Type.Roi);
	}

	public ArrayList<Position> deplacement(Plateau plateau) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		
		
		if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+1,plateau.getCoordonateOfPiece(this).getAbscisse()+1)).getCouleur()!=this.getCouleur() && plateau.estEnEchec(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+1,plateau.getCoordonateOfPiece(this).getAbscisse()+1),this.getCouleur()))
			deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+1,plateau.getCoordonateOfPiece(this).getAbscisse()+1));
		if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+1,plateau.getCoordonateOfPiece(this).getAbscisse()-1)).getCouleur()!=this.getCouleur() && plateau.estEnEchec(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+1,plateau.getCoordonateOfPiece(this).getAbscisse()-1),this.getCouleur()))
			deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+1,plateau.getCoordonateOfPiece(this).getAbscisse()-1));
		if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-1,plateau.getCoordonateOfPiece(this).getAbscisse()+1)).getCouleur()!=this.getCouleur() && plateau.estEnEchec(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-1,plateau.getCoordonateOfPiece(this).getAbscisse()+1),this.getCouleur()))
			deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-1,plateau.getCoordonateOfPiece(this).getAbscisse()+1));
		if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-1,plateau.getCoordonateOfPiece(this).getAbscisse()-1)).getCouleur()!=this.getCouleur() && plateau.estEnEchec(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-1,plateau.getCoordonateOfPiece(this).getAbscisse()-1),this.getCouleur()))
			deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-1,plateau.getCoordonateOfPiece(this).getAbscisse()-1));
		
		int j=1;
		for (int i =0;i<=1;i++)
		{
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse()+j)).getCouleur()!=this.getCouleur() && plateau.estEnEchec(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse()+j),this.getCouleur()))
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse()+j));
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse()-j)).getCouleur()!=this.getCouleur() && plateau.estEnEchec(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse()+j),this.getCouleur()))
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse()-j));
			j=j-1;
		}
		
		
		return deplacement;
	}

	public Type recupererType() {
		// TODO - implement Roi.recupererType
		throw new UnsupportedOperationException();
	}

}