package fr.iutvalence.info.dut.m2107;

import java.util.ArrayList;

/**
 * Deplacement: se deplace en ligne droite d'autant de cases que voulues (sauf obstacle)
 * @author lucianor
 *
 */
public class Tour extends Piece {

	/**
	 * Cree une tour de la couleur donnee
	 * @param couleur
	 */
	public Tour(Couleur couleur)
	{
		super(couleur, Type.Tour);
	}

	public ArrayList<Position> deplacement(Plateau plateau) {
		ArrayList<Position> deplacement = new ArrayList<Position>();
		boolean rowA=true;
		boolean rowB=true;
		boolean colA=true;
		boolean colB=true;
		
		for (int i=0;i<=7;i++)
		{
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse())).getCouleur()!=this.getCouleur() && colA)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse()));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()+i,plateau.getCoordonateOfPiece(this).getAbscisse())).recupererType() != Type.None)
					colA=false;
			}
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse())).getCouleur()!=this.getCouleur() && colB)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse()));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee()-i,plateau.getCoordonateOfPiece(this).getAbscisse())).recupererType() != Type.None)
					colB=false;
			}
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee(),plateau.getCoordonateOfPiece(this).getAbscisse()+i)).getCouleur()!=this.getCouleur() && rowA)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee(),plateau.getCoordonateOfPiece(this).getAbscisse()+i));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee(),plateau.getCoordonateOfPiece(this).getAbscisse()+i)).recupererType() != Type.None)
					rowA=false;
			}
			if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee(),plateau.getCoordonateOfPiece(this).getAbscisse()-i)).getCouleur()!=this.getCouleur() && rowB)
			{
				deplacement.add(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee(),plateau.getCoordonateOfPiece(this).getAbscisse()-i));
				if (plateau.getPieceAtPosition(new Position(plateau.getCoordonateOfPiece(this).getOrdonnee(),plateau.getCoordonateOfPiece(this).getAbscisse()-i)).recupererType() != Type.None)
					rowB=false;
			}			
		}
		return deplacement;
	}

	public Type recupererType() {
		// TODO - implement Tour.recupererType
		throw new UnsupportedOperationException();
	}

}